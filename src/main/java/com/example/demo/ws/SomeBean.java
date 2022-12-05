package com.example.demo.ws;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class SomeBean implements Serializable {
    @Inject @Push
    private PushContext push;

    @Inject
    ChatGlobal chatGlobal;
    private String conteudo;

    private Usuario usuario;

    public void send(){
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .computeIfAbsent("user", k -> usuario.getUsername());
        Mensagem m = new Mensagem(conteudo, usuario);
        push.send(m);
        chatGlobal.addMensagem(m);
    }

    @PostConstruct
    public void novoUsuario() {
        if(usuario == null) {
            usuario = chatGlobal.addUsuario();
        }
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}

