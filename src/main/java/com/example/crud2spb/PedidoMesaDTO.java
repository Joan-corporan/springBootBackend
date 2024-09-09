package com.example.crud2spb;

public class PedidoMesaDTO {
    private Long idPedido;
    private Long idMesa;
    private String estadoMesa;
    private String nombreComida;
    private String cantidadComida;
    private String nombreBebida;
    private String cantidadBebida;

    // Constructor
    public PedidoMesaDTO(Long idPedido, Long idMesa, String estadoMesa, String nombreComida, String cantidadComida,
                         String nombreBebida, String cantidadBebida) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.nombreComida = nombreComida;
        this.cantidadComida = cantidadComida;
        this.nombreBebida = nombreBebida;
        this.cantidadBebida = cantidadBebida;
    }

    // Getters y Setters
    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public String getCantidadComida() {
        return cantidadComida;
    }

    public void setCantidadComida(String cantidadComida) {
        this.cantidadComida = cantidadComida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getCantidadBebida() {
        return cantidadBebida;
    }

    public void setCantidadBebida(String cantidadBebida) {
        this.cantidadBebida = cantidadBebida;
    }
}

