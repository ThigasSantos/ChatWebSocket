package com.example.demo.ws;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ChatGlobal {

    @Inject @Push(channel = "globalChannel")
    private PushContext push;

    private List<Mensagem> mensagens;

    private List<Usuario> usuarios;

    private static int usuariosCount = 0;


    public Usuario addUsuario() {
        Usuario usuario = new Usuario("guest-" + ++usuariosCount);
        if(this.usuarios == null) this.usuarios = new ArrayList<>();
        usuarios.add(usuario);
        return usuario;
    }

    public void sendMensagem(Mensagem m) {
        if(this.mensagens == null) this.mensagens = new ArrayList<>();
        mensagens.add(m);
        push.send(m);
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >
    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    // </editor-fold>

}
