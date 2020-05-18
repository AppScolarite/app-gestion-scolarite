package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "NIVEAU", schema = "dbo", catalog = "system_scolarite")
public class NiveauEntity {
    private int idNiveau;
    private String libelleNiveau;
    private String descriptionNiveau;
    private Collection<GroupeEntity> groupesByIdNiveau;

    @Id
    @Column(name = "id_niveau", nullable = false)
    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Basic
    @Column(name = "libelle_niveau", nullable = true, length = 50)
    public String getLibelleNiveau() {
        return libelleNiveau;
    }

    public void setLibelleNiveau(String libelleNiveau) {
        this.libelleNiveau = libelleNiveau;
    }

    @Basic
    @Column(name = "description_niveau", nullable = true, length = 250)
    public String getDescriptionNiveau() {
        return descriptionNiveau;
    }

    public void setDescriptionNiveau(String descriptionNiveau) {
        this.descriptionNiveau = descriptionNiveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NiveauEntity that = (NiveauEntity) o;
        return idNiveau == that.idNiveau &&
                Objects.equals(libelleNiveau, that.libelleNiveau) &&
                Objects.equals(descriptionNiveau, that.descriptionNiveau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNiveau, libelleNiveau, descriptionNiveau);
    }

    @OneToMany(mappedBy = "niveauByNiveau")
    public Collection<GroupeEntity> getGroupesByIdNiveau() {
        return groupesByIdNiveau;
    }

    public void setGroupesByIdNiveau(Collection<GroupeEntity> groupesByIdNiveau) {
        this.groupesByIdNiveau = groupesByIdNiveau;
    }
}
