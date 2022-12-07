package com.example.demo.ws;

public class Usuario {

    private String id;
    private String username;


    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String id, String username) {
        this.id = id;
        this.username = username;
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return username;
    }
}
