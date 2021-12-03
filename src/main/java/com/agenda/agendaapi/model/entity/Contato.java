package com.agenda.agendaapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.*;

import javax.persistence.*;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 300, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String email;

    @Column
    private Boolean favorito;

    @Column
    private Date data_ciacao;

    // CONSTRUTORES, GETS AND SETTERS
    public Contato() {
    }

    public Contato(Integer id, String nome, String email, Boolean favorito, Date data_ciacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.favorito = favorito;
        this.data_ciacao = data_ciacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Date getData() {
        return data_ciacao;
    }

    public void setData(Date data) {
        this.data_ciacao = data;
    }
    
}
