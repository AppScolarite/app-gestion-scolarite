package com.javafx.ourproject.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EnseignementEntityPK implements Serializable {
    private String professeur;
    private int groupe;
    private int matiere;

    @Column(name = "professeur#", nullable = false, length = 20)
    @Id
    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    @Column(name = "groupe#", nullable = false)
    @Id
    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    @Column(name = "matiere#", nullable = false)
    @Id
    public int getMatiere() {
        return matiere;
    }

    public void setMatiere(int matiere) {
        this.matiere = matiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnseignementEntityPK that = (EnseignementEntityPK) o;
        return groupe == that.groupe &&
                matiere == that.matiere &&
                Objects.equals(professeur, that.professeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professeur, groupe, matiere);
    }
}
