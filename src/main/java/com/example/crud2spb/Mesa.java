package com.example.crud2spb;
// Mesa.java



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mesa {
    @Id
    private Long id_mesa;
    private String name_mesa;
    private String estado_mesa;

    
     // Getters
     public Long getId_mesa() {
        return id_mesa;
    }

    public String getName_mesa() {
        return name_mesa;
    }

    public String getEstado_mesa() {
        return estado_mesa;
    }

    // Setters
    public void setId_mesa(Long id_mesa) {
        this.id_mesa = id_mesa;
    }

    public void setName_mesa(String name_mesa) {
        this.name_mesa = name_mesa;
    }

    public void setEstado_mesa(String estado_mesa) {
        this.estado_mesa = estado_mesa;
    }
}


