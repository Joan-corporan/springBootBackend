package com.example.crud2spb;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    private Long id_pedido;
    private Long mesa_id;
    private String bebida;
    private String comida;
    private String inicio;
    private String fin;
    private String genero;
    private Long camarero_id;
    private Double total_pedido;

    
     public Long getId_pedido() {
        return id_pedido;
    }

    public Long getMesa_id() {
        return mesa_id;
    }

    public String getBebida() {
        return bebida;
    }

    public String getComida() {
        return comida;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public String getGenero() {
        return genero;
    }

    public Long getCamarero_id() {
        return camarero_id;
    }

    public Double getTotal_pedido() {
        return total_pedido;
    }

    // Setters
    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setMesa_id(Long mesa_id) {
        this.mesa_id = mesa_id;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCamarero_id(Long camarero_id) {
        this.camarero_id = camarero_id;
    }

    public void setTotal_pedido(Double total_pedido) {
        this.total_pedido = total_pedido;
    }
}
