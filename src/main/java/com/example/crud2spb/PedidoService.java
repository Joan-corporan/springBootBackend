package com.example.crud2spb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private EntityManager entityManager;

    public List<PedidoMesaDTO> getJoinData() {
        String queryStr = "SELECT pe.id_pedido, me.id_mesa, me.estado_mesa, " +
            "pro_comida.name_product AS comida_nombre, " +
            "jsonb_extract_path_text(comida.value, 'cantidad') AS cantidad_comida, " +
            "pro_bebida.name_product AS bebida_nombre, " +
            "jsonb_extract_path_text(bebida.value, 'cantidad') AS cantidad_bebida " +
            "FROM pedidos pe " +
            "JOIN mesa me ON pe.mesa_id = me.id_mesa " +
            "LEFT JOIN LATERAL jsonb_array_elements(pe.comida) AS comida ON TRUE " +
            "LEFT JOIN product pro_comida ON " +
            "jsonb_extract_path_text(comida.value, 'id') IS NOT NULL " +
            "AND jsonb_extract_path_text(comida.value, 'id') <> '' " +
            "AND (jsonb_extract_path_text(comida.value, 'id'))::int = pro_comida.id_product " +
            "LEFT JOIN LATERAL jsonb_array_elements(pe.bebida) AS bebida ON TRUE " +
            "LEFT JOIN product pro_bebida ON " +
            "jsonb_extract_path_text(bebida.value, 'id') IS NOT NULL " +
            "AND jsonb_extract_path_text(bebida.value, 'id') <> '' " +
            "AND (jsonb_extract_path_text(bebida.value, 'id'))::int = pro_bebida.id_product " +
            "WHERE me.estado_mesa = 'pedido tomado' " +
            "AND pe.fin IS NULL";

        Query query = entityManager.createNativeQuery(queryStr);

        List<Object[]> results = query.getResultList();

        return results.stream().map(obj -> new PedidoMesaDTO(
            ((Number) obj[0]).longValue(),  // id_pedido
            ((Number) obj[1]).longValue(),  // id_mesa
            (String) obj[2],                // estado_mesa
            (String) obj[3],                // nombre_comida
            (String) obj[4],                // cantidad_comida
            (String) obj[5],                // nombre_bebida
            (String) obj[6]                 // cantidad_bebida
        )).collect(Collectors.toList());
        
    }

    @Transactional
    public boolean finalizarPedido(Long idPedido) {
        // Obtener el mesa_id correspondiente al id_pedido
        String queryMesaId = "SELECT mesa_id FROM pedidos WHERE id_pedido = ? AND fin IS NULL";
        Query queryMesaIdGet = entityManager.createNativeQuery(queryMesaId);
        queryMesaIdGet.setParameter(1, idPedido);
        Object mesaId = queryMesaIdGet.getSingleResult();

        if (mesaId == null) {
            return false; // No se encontró el pedido o ya está finalizado
        }

        // Actualizar la tabla pedidos
        String queryPedidos = "UPDATE pedidos SET fin = now() WHERE id_pedido = ? AND fin IS NULL";
        Query queryPedidosUpdate = entityManager.createNativeQuery(queryPedidos);
        queryPedidosUpdate.setParameter(1, idPedido);
        int updatedRowsPedidos = queryPedidosUpdate.executeUpdate();

        // Actualizar la tabla mesa
        String queryMesa = "UPDATE mesa SET estado_mesa = 'finalizado' WHERE id_mesa = ?";
        Query queryMesaUpdate = entityManager.createNativeQuery(queryMesa);
        queryMesaUpdate.setParameter(1, mesaId);
        int updatedRowsMesa = queryMesaUpdate.executeUpdate();

        return updatedRowsPedidos > 0 && updatedRowsMesa > 0;
    }
}