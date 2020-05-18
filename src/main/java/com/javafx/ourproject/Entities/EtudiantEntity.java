package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ETUDIANT", schema = "dbo", catalog = "system_scolarite")
public class EtudiantEntity {
    private String codeMassar;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateInscription;
    private String email;
    private String telephone;
    private Boolean aDejaRedouble;
    private String sexe;
    private String adresse;
    private Integer inscritParPersonnel;
    private Integer groupe;
    private PersonnelEntity personnelByInscritParPersonnel;
    private GroupeEntity groupeByGroupe;

    @Id
    @Column(name = "code_massar", nullable = false, length = 20)
    public String getCodeMassar() {
        return codeMassar;
    }

    public void setCodeMassar(String codeMassar) {
        this.codeMassar = codeMassar;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 25)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "date_naissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "date_inscription", nullable = true)
    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 15)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "a_deja_redouble", nullable = true)
    public Boolean getaDejaRedouble() {
        return aDejaRedouble;
    }

    public void setaDejaRedouble(Boolean aDejaRedouble) {
        this.aDejaRedouble = aDejaRedouble;
    }

    @Basic
    @Column(name = "sexe", nullable = false, length = 10)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Basic
    @Column(name = "adresse", nullable = true, length = 100)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "inscrit_par_personnel#", nullable = true)
    public Integer getInscritParPersonnel() {
        return inscritParPersonnel;
    }

    public void setInscritParPersonnel(Integer inscritParPersonnel) {
        this.inscritParPersonnel = inscritParPersonnel;
    }

    @Basic
    @Column(name = "groupe#", nullable = true)
    public Integer getGroupe() {
        return groupe;
    }

    public void setGroupe(Integer groupe) {
        this.groupe = groupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtudiantEntity that = (EtudiantEntity) o;
        return Objects.equals(codeMassar, that.codeMassar) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(dateInscription, that.dateInscription) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(aDejaRedouble, that.aDejaRedouble) &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(inscritParPersonnel, that.inscritParPersonnel) &&
                Objects.equals(groupe, that.groupe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeMassar, nom, prenom, dateNaissance, dateInscription, email, telephone, aDejaRedouble, sexe, adresse, inscritParPersonnel, groupe);
    }

    @ManyToOne
    @JoinColumn(name = "inscrit_par_personnel#", referencedColumnName = "id_personnel")
    public PersonnelEntity getPersonnelByInscritParPersonnel() {
        return personnelByInscritParPersonnel;
    }

    public void setPersonnelByInscritParPersonnel(PersonnelEntity personnelByInscritParPersonnel) {
        this.personnelByInscritParPersonnel = personnelByInscritParPersonnel;
    }

    @ManyToOne
    @JoinColumn(name = "groupe#", referencedColumnName = "id_groupe")
    public GroupeEntity getGroupeByGroupe() {
        return groupeByGroupe;
    }

    public void setGroupeByGroupe(GroupeEntity groupeByGroupe) {
        this.groupeByGroupe = groupeByGroupe;
    }
}
