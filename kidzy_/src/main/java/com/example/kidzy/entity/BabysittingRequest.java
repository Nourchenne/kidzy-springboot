package com.example.kidzy.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "babysitting_requests")
public class BabysittingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private String localisation;
    private Integer nombreEnfants;
    private String message;
    private LocalDateTime createdAt;
    public BabysittingRequest() {
    }

    public BabysittingRequest(String nom, String email, String localisation, Integer nombreEnfants, String message, LocalDateTime createdAt) {
        this.nom = nom;
        this.email = email;
        this.localisation = localisation;
        this.nombreEnfants = nombreEnfants;
        this.message = message;
        this.createdAt = createdAt;
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(Integer nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BabysittingRequest{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", localisation='" + localisation + '\'' +
                ", nombreEnfants=" + nombreEnfants +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
