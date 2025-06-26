package com.example.kidzy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "babysitters")
public class Babysitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private String mdp;
    private String num;
    private String cin;
    private String adresse;
    private Integer age;
    private String photo;
    private String cinFront;
    private String cinBack;

    public Babysitter() {
    }

    public Babysitter(String nom, String email, String mdp, String num, String cin, String adresse, Integer age, String photo, String cinFront, String cinBack) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.num = num;
        this.cin = cin;
        this.adresse = adresse;
        this.age = age;
        this.photo = photo;
        this.cinFront = cinFront;
        this.cinBack = cinBack;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCinFront() {
        return cinFront;
    }

    public void setCinFront(String cinFront) {
        this.cinFront = cinFront;
    }

    public String getCinBack() {
        return cinBack;
    }

    public void setCinBack(String cinBack) {
        this.cinBack = cinBack;
    }


    @Override
    public String toString() {
        return "Babysitter{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", num='" + num + '\'' +
                ", cin='" + cin + '\'' +
                ", adresse='" + adresse + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", cinFront='" + cinFront + '\'' +
                ", cinBack='" + cinBack + '\'' +
                '}';
    }
}
