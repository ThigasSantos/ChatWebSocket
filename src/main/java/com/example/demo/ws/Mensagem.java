package com.example.demo.ws;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensagem implements Serializable {
    private String conteudo;
    private Usuario usuario;
    private String tempo;

    public Mensagem(String conteudo, Usuario usuario) {
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.tempo = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("HH:mm")
        );
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // </editor-fold>
    @Override
    public String toString() {
        return usuario.toString() + "  |  " + conteudo + "   [" + tempo + ']';
    }
}
