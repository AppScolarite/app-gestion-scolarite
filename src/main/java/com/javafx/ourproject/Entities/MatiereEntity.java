package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MATIERE", schema = "dbo", catalog = "system_scolarite")
public class MatiereEntity {
    private int idMatiere;
    private String lblMatiere;
    private Date dateAjout;
    private Integer coeff;
    private Collection<EnseignementEntity> enseignementsByIdMatiere;
    private Collection<NoteEntity> notesByIdMatiere;

    @Id
    @Column(name = "id_matiere", nullable = false)
    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    @Basic
    @Column(name = "LBL_Matiere", nullable = true, length = 25)
    public String getLblMatiere() {
        return lblMatiere;
    }

    public void setLblMatiere(String lblMatiere) {
        this.lblMatiere = lblMatiere;
    }

    @Basic
    @Column(name = "Date_Ajout", nullable = true)
    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Basic
    @Column(name = "Coeff", nullable = true)
    public Integer getCoeff() {
        return coeff;
    }

    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatiereEntity that = (MatiereEntity) o;
        return idMatiere == that.idMatiere &&
                Objects.equals(lblMatiere, that.lblMatiere) &&
                Objects.equals(dateAjout, that.dateAjout) &&
                Objects.equals(coeff, that.coeff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatiere, lblMatiere, dateAjout, coeff);
    }

    @OneToMany(mappedBy = "matiereByMatiere")
    public Collection<EnseignementEntity> getEnseignementsByIdMatiere() {
        return enseignementsByIdMatiere;
    }

    public void setEnseignementsByIdMatiere(Collection<EnseignementEntity> enseignementsByIdMatiere) {
        this.enseignementsByIdMatiere = enseignementsByIdMatiere;
    }

    @OneToMany(mappedBy = "matiereByMatiere")
    public Collection<NoteEntity> getNotesByIdMatiere() {
        return notesByIdMatiere;
    }

    public void setNotesByIdMatiere(Collection<NoteEntity> notesByIdMatiere) {
        this.notesByIdMatiere = notesByIdMatiere;
    }
}
