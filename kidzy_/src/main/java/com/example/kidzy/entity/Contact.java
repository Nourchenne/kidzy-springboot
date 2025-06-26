package com.example.kidzy.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private String message;
    private LocalDateTime dateContact;

    public Contact() {
    }

    public Contact(String nom, String email, String message, LocalDateTime dateContact) {
        this.nom = nom;
        this.email = email;
        this.message = message;
        this.dateContact = dateContact;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateContact() {
        return dateContact;
    }

    public void setDateContact(LocalDateTime dateContact) {
        this.dateContact = dateContact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", dateContact=" + dateContact +
                '}';
    }
}
