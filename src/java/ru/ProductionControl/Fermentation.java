/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ProductionControl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmitriy.mamishev
 */
@Entity
@Table(name = "Fermentation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fermentation.findAll", query = "SELECT f FROM Fermentation f"),
    @NamedQuery(name = "Fermentation.findById", query = "SELECT f FROM Fermentation f WHERE f.id = :id"),
    @NamedQuery(name = "Fermentation.findByName", query = "SELECT f FROM Fermentation f WHERE f.name = :name"),
    @NamedQuery(name = "Fermentation.findByDescription", query = "SELECT f FROM Fermentation f WHERE f.description = :description"),
    @NamedQuery(name = "Fermentation.findByYeast", query = "SELECT f FROM Fermentation f WHERE f.yeast = :yeast"),
    @NamedQuery(name = "Fermentation.findByFermentationTemp", query = "SELECT f FROM Fermentation f WHERE f.fermentationTemp = :fermentationTemp"),
    @NamedQuery(name = "Fermentation.findByStartFermentationDate", query = "SELECT f FROM Fermentation f WHERE f.startFermentationDate = :startFermentationDate"),
    @NamedQuery(name = "Fermentation.findByEndFermentationDate", query = "SELECT f FROM Fermentation f WHERE f.endFermentationDate = :endFermentationDate"),
    @NamedQuery(name = "Fermentation.findByAlcohol", query = "SELECT f FROM Fermentation f WHERE f.alcohol = :alcohol")})
public class Fermentation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 250)
    @Column(name = "Name")
    private String name;
    @Size(max = 1000)
    @Column(name = "Description")
    private String description;
    @Size(max = 200)
    @Column(name = "Yeast")
    private String yeast;
    @Column(name = "FermentationTemp")
    private Integer fermentationTemp;
    @Column(name = "StartFermentationDate")
    @Temporal(TemporalType.DATE)
    private Date startFermentationDate;
    @Column(name = "EndFermentationDate")
    @Temporal(TemporalType.DATE)
    private Date endFermentationDate;
    @Column(name = "Alcohol")
    private Integer alcohol;
    @OneToMany(mappedBy = "idFermentation")
    private Collection<Product> productCollection;

    public Fermentation() {
    }

    public Fermentation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    public Integer getFermentationTemp() {
        return fermentationTemp;
    }

    public void setFermentationTemp(Integer fermentationTemp) {
        this.fermentationTemp = fermentationTemp;
    }

    public Date getStartFermentationDate() {
        return startFermentationDate;
    }

    public void setStartFermentationDate(Date startFermentationDate) {
        this.startFermentationDate = startFermentationDate;
    }

    public Date getEndFermentationDate() {
        return endFermentationDate;
    }

    public void setEndFermentationDate(Date endFermentationDate) {
        this.endFermentationDate = endFermentationDate;
    }

    public Integer getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Integer alcohol) {
        this.alcohol = alcohol;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fermentation)) {
            return false;
        }
        Fermentation other = (Fermentation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ProductionControl.Fermentation[ id=" + id + " ]";
    }
    
}
