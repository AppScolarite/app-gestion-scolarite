package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BRANCHE", schema = "dbo", catalog = "system_scolarite")
@NamedQuery(name = "BrancheEntity.findAll", query = "SELECT c FROM Branche br")
public class BrancheEntity {
    private Integer idBranche;
    private String libelleBranche;
    private Double prerequisNote;
    private String descriptionBranche;
    private Collection<GroupeEntity> groupesByIdBranche;

    @Id
    @Column(name = "id_branche", nullable = false)
    public int getIdBranche() {
        return idBranche;
    }

    public void setIdBranche(int idBranche) {
        this.idBranche = idBranche;
    }

    @Basic
    @Column(name = "libelle_branche", nullable = true, length = 50)
    public String getLibelleBranche() {
        return libelleBranche;
    }

    public void setLibelleBranche(String libelleBranche) {
        this.libelleBranche = libelleBranche;
    }

    @Basic
    @Column(name = "prerequis_note", nullable = true, precision = 0)
    public Double getPrerequisNote() {
        return prerequisNote;
    }

    public void setPrerequisNote(Double prerequisNote) {
        this.prerequisNote = prerequisNote;
    }

    @Basic
    @Column(name = "description_branche", nullable = true, length = 250)
    public String getDescriptionBranche() {
        return descriptionBranche;
    }

    public void setDescriptionBranche(String descriptionBranche) {
        this.descriptionBranche = descriptionBranche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrancheEntity that = (BrancheEntity) o;
        return idBranche == that.idBranche &&
                Objects.equals(libelleBranche, that.libelleBranche) &&
                Objects.equals(prerequisNote, that.prerequisNote) &&
                Objects.equals(descriptionBranche, that.descriptionBranche);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBranche, libelleBranche, prerequisNote, descriptionBranche);
    }

    @OneToMany(mappedBy = "brancheByBranche")
    public Collection<GroupeEntity> getGroupesByIdBranche() {
        return groupesByIdBranche;
    }

    public void setGroupesByIdBranche(Collection<GroupeEntity> groupesByIdBranche) {
        this.groupesByIdBranche = groupesByIdBranche;
    }
}
