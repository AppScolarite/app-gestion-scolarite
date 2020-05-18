package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACTUALITE", schema = "dbo", catalog = "system_scolarite")
public class ActualiteEntity {
    private int idActualite;
    private String sujet;
    private String descriptionActualite;
    private Integer ajouteParPersonnel;
    private PersonnelEntity personnelByAjouteParPersonnel;

    @Id
    @Column(name = "id_actualite", nullable = false)
    public int getIdActualite() {
        return idActualite;
    }

    public void setIdActualite(int idActualite) {
        this.idActualite = idActualite;
    }

    @Basic
    @Column(name = "sujet", nullable = true, length = 25)
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    @Basic
    @Column(name = "description_actualite", nullable = true, length = 250)
    public String getDescriptionActualite() {
        return descriptionActualite;
    }

    public void setDescriptionActualite(String descriptionActualite) {
        this.descriptionActualite = descriptionActualite;
    }

    @Basic
    @Column(name = "ajoute_par_personnel#", nullable = true)
    public Integer getAjouteParPersonnel() {
        return ajouteParPersonnel;
    }

    public void setAjouteParPersonnel(Integer ajouteParPersonnel) {
        this.ajouteParPersonnel = ajouteParPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualiteEntity that = (ActualiteEntity) o;
        return idActualite == that.idActualite &&
                Objects.equals(sujet, that.sujet) &&
                Objects.equals(descriptionActualite, that.descriptionActualite) &&
                Objects.equals(ajouteParPersonnel, that.ajouteParPersonnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActualite, sujet, descriptionActualite, ajouteParPersonnel);
    }

    @ManyToOne
    @JoinColumn(name = "ajoute_par_personnel#", referencedColumnName = "id_personnel")
    public PersonnelEntity getPersonnelByAjouteParPersonnel() {
        return personnelByAjouteParPersonnel;
    }

    public void setPersonnelByAjouteParPersonnel(PersonnelEntity personnelByAjouteParPersonnel) {
        this.personnelByAjouteParPersonnel = personnelByAjouteParPersonnel;
    }
}
