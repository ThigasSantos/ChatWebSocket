package com.example.demo.ws;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ChatGlobal {

    private List<Mensagem> mensagens;

    private List<Usuario> usuarios;

    private static int usuariosCount = 0;


    public Usuario addUsuario() {
        usuariosCount++;
        Usuario usuario = new Usuario("guest" + usuariosCount);
        if(this.usuarios == null) this.usuarios = new ArrayList<>();
        usuarios.add(usuario);
        return usuario;
    }

    public void addMensagem(Mensagem m) {
        if(this.mensagens == null) this.mensagens = new ArrayList<>();
        mensagens.add(m);
    }

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
}
