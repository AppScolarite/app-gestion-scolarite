package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PROFESSEUR", schema = "dbo", catalog = "system_scolarite")
public class ProfesseurEntity {
    private String codeProNationnal;
    private String cin;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateCommencementContrat;
    private String typeContrat;
    private String email;
    private String telephone;
    private String sexe;
    private String adresse;
    private String situationFamilliale;
    private Collection<EnseignementEntity> enseignementsByCodeProNationnal;

    @Id
    @Column(name = "Code_Pro_Nationnal", nullable = false, length = 20)
    public String getCodeProNationnal() {
        return codeProNationnal;
    }

    public void setCodeProNationnal(String codeProNationnal) {
        this.codeProNationnal = codeProNationnal;
    }

    @Basic
    @Column(name = "Cin", nullable = true, length = 10)
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "Nom", nullable = true, length = 25)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom", nullable = true, length = 25)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "Date_Naissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "Date_Commencement_Contrat", nullable = true)
    public Date getDateCommencementContrat() {
        return dateCommencementContrat;
    }

    public void setDateCommencementContrat(Date dateCommencementContrat) {
        this.dateCommencementContrat = dateCommencementContrat;
    }

    @Basic
    @Column(name = "Type_Contrat", nullable = true, length = 10)
    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, length = 15)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    @Column(name = "Adresse", nullable = true, length = 100)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "Situation_Familliale", nullable = true, length = 20)
    public String getSituationFamilliale() {
        return situationFamilliale;
    }

    public void setSituationFamilliale(String situationFamilliale) {
        this.situationFamilliale = situationFamilliale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesseurEntity that = (ProfesseurEntity) o;
        return Objects.equals(codeProNationnal, that.codeProNationnal) &&
                Objects.equals(cin, that.cin) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(dateCommencementContrat, that.dateCommencementContrat) &&
                Objects.equals(typeContrat, that.typeContrat) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(situationFamilliale, that.situationFamilliale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeProNationnal, cin, nom, prenom, dateNaissance, dateCommencementContrat, typeContrat, email, telephone, sexe, adresse, situationFamilliale);
    }

    @OneToMany(mappedBy = "professeurByProfesseur")
    public Collection<EnseignementEntity> getEnseignementsByCodeProNationnal() {
        return enseignementsByCodeProNationnal;
    }

    public void setEnseignementsByCodeProNationnal(Collection<EnseignementEntity> enseignementsByCodeProNationnal) {
        this.enseignementsByCodeProNationnal = enseignementsByCodeProNationnal;
    }
}
