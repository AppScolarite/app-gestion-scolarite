package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PERSONNEL", schema = "dbo", catalog = "system_scolarite")
public class PersonnelEntity {
    private int idPersonnel;
    private String nomPersonnel;
    private String prenomPersonnel;
    private Date dateNaissancePersonnel;
    private byte[] photoPersonnel;
    private String emailPersonnel;
    private String telephonePersonnel;
    private String sexe;
    private String adresse;
    private Collection<ActualiteEntity> actualitesByIdPersonnel;
    private Collection<EtudiantEntity> etudiantsByIdPersonnel;

    @Id
    @Column(name = "id_personnel", nullable = false)
    public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Basic
    @Column(name = "nom_personnel", nullable = true, length = 25)
    public String getNomPersonnel() {
        return nomPersonnel;
    }

    public void setNomPersonnel(String nomPersonnel) {
        this.nomPersonnel = nomPersonnel;
    }

    @Basic
    @Column(name = "prenom_personnel", nullable = true, length = 25)
    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    public void setPrenomPersonnel(String prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    @Basic
    @Column(name = "date_naissance_personnel", nullable = true)
    public Date getDateNaissancePersonnel() {
        return dateNaissancePersonnel;
    }

    public void setDateNaissancePersonnel(Date dateNaissancePersonnel) {
        this.dateNaissancePersonnel = dateNaissancePersonnel;
    }

    @Basic
    @Column(name = "photo_personnel", nullable = true)
    public byte[] getPhotoPersonnel() {
        return photoPersonnel;
    }

    public void setPhotoPersonnel(byte[] photoPersonnel) {
        this.photoPersonnel = photoPersonnel;
    }

    @Basic
    @Column(name = "email_personnel", nullable = true, length = 100)
    public String getEmailPersonnel() {
        return emailPersonnel;
    }

    public void setEmailPersonnel(String emailPersonnel) {
        this.emailPersonnel = emailPersonnel;
    }

    @Basic
    @Column(name = "telephone_personnel", nullable = true, length = 15)
    public String getTelephonePersonnel() {
        return telephonePersonnel;
    }

    public void setTelephonePersonnel(String telephonePersonnel) {
        this.telephonePersonnel = telephonePersonnel;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonnelEntity that = (PersonnelEntity) o;
        return idPersonnel == that.idPersonnel &&
                Objects.equals(nomPersonnel, that.nomPersonnel) &&
                Objects.equals(prenomPersonnel, that.prenomPersonnel) &&
                Objects.equals(dateNaissancePersonnel, that.dateNaissancePersonnel) &&
                Arrays.equals(photoPersonnel, that.photoPersonnel) &&
                Objects.equals(emailPersonnel, that.emailPersonnel) &&
                Objects.equals(telephonePersonnel, that.telephonePersonnel) &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(adresse, that.adresse);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idPersonnel, nomPersonnel, prenomPersonnel, dateNaissancePersonnel, emailPersonnel, telephonePersonnel, sexe, adresse);
        result = 31 * result + Arrays.hashCode(photoPersonnel);
        return result;
    }

    @OneToMany(mappedBy = "personnelByAjouteParPersonnel")
    public Collection<ActualiteEntity> getActualitesByIdPersonnel() {
        return actualitesByIdPersonnel;
    }

    public void setActualitesByIdPersonnel(Collection<ActualiteEntity> actualitesByIdPersonnel) {
        this.actualitesByIdPersonnel = actualitesByIdPersonnel;
    }

    @OneToMany(mappedBy = "personnelByInscritParPersonnel")
    public Collection<EtudiantEntity> getEtudiantsByIdPersonnel() {
        return etudiantsByIdPersonnel;
    }

    public void setEtudiantsByIdPersonnel(Collection<EtudiantEntity> etudiantsByIdPersonnel) {
        this.etudiantsByIdPersonnel = etudiantsByIdPersonnel;
    }
}
