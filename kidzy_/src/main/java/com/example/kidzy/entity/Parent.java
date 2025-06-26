package com.example.kidzy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private String mdp;
    private String num;
    private String adresse;
    private Integer numEnfant;

    public Parent() {
    }

    public Parent(String nom, String email, String mdp, String num, String adresse, Integer numEnfant) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.num = num;
        this.adresse = adresse;
        this.numEnfant = numEnfant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNumEnfant() {
        return numEnfant;
    }

    public void setNumEnfant(Integer numEnfant) {
        this.numEnfant = numEnfant;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", num='" + num + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numEnfant=" + numEnfant +
                '}';
    }


}
