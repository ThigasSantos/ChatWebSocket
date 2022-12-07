package com.example.demo.ws;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
public class ClientSession implements Serializable {

    @Inject
    ChatGlobal chatGlobal;
    private String conteudo;
    private Boolean conectado = false;
    private Usuario usuario;
    private HttpSession httpSession = (HttpSession) FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .getSession(true);

    @PostConstruct
    public void novoUsuario() {
        usuario = chatGlobal.addUsuario();
        usuario.setId(httpSession.getId());
    }

    public List<Mensagem> getChatMensagens() {
        if (!conectado) return List.of();
        return chatGlobal.getMensagens();
    }

    public void send(){
        if(conectado)
            chatGlobal.sendMensagem(new Mensagem(conteudo, usuario));

        conteudo = "";
    }

    public void conectar() {
        conectado = !conectado;
    }

    // <editor-fold  defaultstate="collapsed" desc="Getters/Setters" >

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    // </editor-fold>
}