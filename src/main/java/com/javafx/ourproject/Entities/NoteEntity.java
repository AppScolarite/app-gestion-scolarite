package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NOTE", schema = "dbo", catalog = "system_scolarite")
public class NoteEntity {
    private int idNote;
    private Integer matiere;
    private Double valeurNote;
    private MatiereEntity matiereByMatiere;

    @Id
    @Column(name = "id_note", nullable = false)
    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    @Basic
    @Column(name = "matiere#", nullable = true)
    public Integer getMatiere() {
        return matiere;
    }

    public void setMatiere(Integer matiere) {
        this.matiere = matiere;
    }

    @Basic
    @Column(name = "Valeur_Note", nullable = true, precision = 0)
    public Double getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(Double valeurNote) {
        this.valeurNote = valeurNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEntity that = (NoteEntity) o;
        return idNote == that.idNote &&
                Objects.equals(matiere, that.matiere) &&
                Objects.equals(valeurNote, that.valeurNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNote, matiere, valeurNote);
    }

    @ManyToOne
    @JoinColumn(name = "matiere#", referencedColumnName = "id_matiere")
    public MatiereEntity getMatiereByMatiere() {
        return matiereByMatiere;
    }

    public void setMatiereByMatiere(MatiereEntity matiereByMatiere) {
        this.matiereByMatiere = matiereByMatiere;
    }
}
