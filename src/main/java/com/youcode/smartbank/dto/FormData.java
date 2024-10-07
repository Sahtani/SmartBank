package com.youcode.smartbank.dto;

import java.time.LocalDate;

public class FormData {

    private String project;
    private String status;
    private double amount;
    private int duration;
    private double monthly;


    private String email;
    private String phone;

    private String civilite;
    private String nom;
    private String prenom;
    private String cin;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private double revenus;
    private boolean creditEnCours;

    // Getters et Setters pour chaque champ
    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public double getMonthly() { return monthly; }
    public void setMonthly(double monthly) { this.monthly = monthly; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCivilite() { return civilite; }
    public void setCivilite(String civilite) { this.civilite = civilite; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public LocalDate getDateEmbauche() { return dateEmbauche; }
    public void setDateEmbauche(LocalDate dateEmbauche) { this.dateEmbauche = dateEmbauche; }

    public double getRevenus() { return revenus; }
    public void setRevenus(double revenus) { this.revenus = revenus; }

    public boolean getCreditEnCours() { return creditEnCours; }
    public void setCreditEnCours(boolean creditEnCours) { this.creditEnCours = creditEnCours; }
}
