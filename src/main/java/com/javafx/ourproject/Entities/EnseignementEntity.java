package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ENSEIGNEMENT", schema = "dbo", catalog = "system_scolarite")
@IdClass(EnseignementEntityPK.class)
public class EnseignementEntity {
    private String professeur;
    private int groupe;
    private int matiere;
    private ProfesseurEntity professeurByProfesseur;
    private GroupeEntity groupeByGroupe;
    private MatiereEntity matiereByMatiere;

    @Id
    @Column(name = "professeur#", nullable = false, length = 20)
    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    @Id
    @Column(name = "groupe#", nullable = false)
    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    @Id
    @Column(name = "matiere#", nullable = false)
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
        EnseignementEntity that = (EnseignementEntity) o;
        return groupe == that.groupe &&
                matiere == that.matiere &&
                Objects.equals(professeur, that.professeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professeur, groupe, matiere);
    }

    @ManyToOne
    @JoinColumn(name = "professeur#", referencedColumnName = "Code_Pro_Nationnal", nullable = false)
    public ProfesseurEntity getProfesseurByProfesseur() {
        return professeurByProfesseur;
    }

    public void setProfesseurByProfesseur(ProfesseurEntity professeurByProfesseur) {
        this.professeurByProfesseur = professeurByProfesseur;
    }

    @ManyToOne
    @JoinColumn(name = "groupe#", referencedColumnName = "id_groupe", nullable = false)
    public GroupeEntity getGroupeByGroupe() {
        return groupeByGroupe;
    }

    public void setGroupeByGroupe(GroupeEntity groupeByGroupe) {
        this.groupeByGroupe = groupeByGroupe;
    }

    @ManyToOne
    @JoinColumn(name = "matiere#", referencedColumnName = "id_matiere", nullable = false)
    public MatiereEntity getMatiereByMatiere() {
        return matiereByMatiere;
    }

    public void setMatiereByMatiere(MatiereEntity matiereByMatiere) {
        this.matiereByMatiere = matiereByMatiere;
    }
}
