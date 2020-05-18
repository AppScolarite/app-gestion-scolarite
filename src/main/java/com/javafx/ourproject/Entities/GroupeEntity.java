package com.javafx.ourproject.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "GROUPE", schema = "dbo", catalog = "system_scolarite")
public class GroupeEntity {
    private int idGroupe;
    private Integer branche;
    private Integer niveau;
    private String libelleGrp;
    private Collection<EnseignementEntity> enseignementsByIdGroupe;
    private Collection<EtudiantEntity> etudiantsByIdGroupe;
    private BrancheEntity brancheByBranche;
    private NiveauEntity niveauByNiveau;

    @Id
    @Column(name = "id_groupe", nullable = false)
    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    @Basic
    @Column(name = "branche#", nullable = true)
    public Integer getBranche() {
        return branche;
    }

    public void setBranche(Integer branche) {
        this.branche = branche;
    }

    @Basic
    @Column(name = "niveau#", nullable = true)
    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    @Basic
    @Column(name = "libelle_grp", nullable = true, length = 10)
    public String getLibelleGrp() {
        return libelleGrp;
    }

    public void setLibelleGrp(String libelleGrp) {
        this.libelleGrp = libelleGrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeEntity that = (GroupeEntity) o;
        return idGroupe == that.idGroupe &&
                Objects.equals(branche, that.branche) &&
                Objects.equals(niveau, that.niveau) &&
                Objects.equals(libelleGrp, that.libelleGrp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroupe, branche, niveau, libelleGrp);
    }

    @OneToMany(mappedBy = "groupeByGroupe")
    public Collection<EnseignementEntity> getEnseignementsByIdGroupe() {
        return enseignementsByIdGroupe;
    }

    public void setEnseignementsByIdGroupe(Collection<EnseignementEntity> enseignementsByIdGroupe) {
        this.enseignementsByIdGroupe = enseignementsByIdGroupe;
    }

    @OneToMany(mappedBy = "groupeByGroupe")
    public Collection<EtudiantEntity> getEtudiantsByIdGroupe() {
        return etudiantsByIdGroupe;
    }

    public void setEtudiantsByIdGroupe(Collection<EtudiantEntity> etudiantsByIdGroupe) {
        this.etudiantsByIdGroupe = etudiantsByIdGroupe;
    }

    @ManyToOne
    @JoinColumn(name = "branche#", referencedColumnName = "id_branche")
    public BrancheEntity getBrancheByBranche() {
        return brancheByBranche;
    }

    public void setBrancheByBranche(BrancheEntity brancheByBranche) {
        this.brancheByBranche = brancheByBranche;
    }

    @ManyToOne
    @JoinColumn(name = "niveau#", referencedColumnName = "id_niveau")
    public NiveauEntity getNiveauByNiveau() {
        return niveauByNiveau;
    }

    public void setNiveauByNiveau(NiveauEntity niveauByNiveau) {
        this.niveauByNiveau = niveauByNiveau;
    }
}
