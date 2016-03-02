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
@Table(name = "Distillation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distillation.findAll", query = "SELECT d FROM Distillation d"),
    @NamedQuery(name = "Distillation.findById", query = "SELECT d FROM Distillation d WHERE d.id = :id"),
    @NamedQuery(name = "Distillation.findByName", query = "SELECT d FROM Distillation d WHERE d.name = :name"),
    @NamedQuery(name = "Distillation.findByDescription", query = "SELECT d FROM Distillation d WHERE d.description = :description"),
    @NamedQuery(name = "Distillation.findByDistillationDate", query = "SELECT d FROM Distillation d WHERE d.distillationDate = :distillationDate"),
    @NamedQuery(name = "Distillation.findByT1", query = "SELECT d FROM Distillation d WHERE d.t1 = :t1"),
    @NamedQuery(name = "Distillation.findByAlcoholT1", query = "SELECT d FROM Distillation d WHERE d.alcoholT1 = :alcoholT1"),
    @NamedQuery(name = "Distillation.findByT2", query = "SELECT d FROM Distillation d WHERE d.t2 = :t2"),
    @NamedQuery(name = "Distillation.findByAlcoholT2", query = "SELECT d FROM Distillation d WHERE d.alcoholT2 = :alcoholT2")})
public class Distillation implements Serializable {
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
    @Column(name = "DistillationDate")
    @Temporal(TemporalType.DATE)
    private Date distillationDate;
    @Column(name = "t1")
    private Integer t1;
    @Column(name = "alcoholT1")
    private Integer alcoholT1;
    @Column(name = "t2")
    private Integer t2;
    @Column(name = "alcoholT2")
    private Integer alcoholT2;
    @OneToMany(mappedBy = "idDistillation")
    private Collection<Product> productCollection;

    public Distillation() {
    }

    public Distillation(Integer id) {
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

    public Date getDistillationDate() {
        return distillationDate;
    }

    public void setDistillationDate(Date distillationDate) {
        this.distillationDate = distillationDate;
    }

    public Integer getT1() {
        return t1;
    }

    public void setT1(Integer t1) {
        this.t1 = t1;
    }

    public Integer getAlcoholT1() {
        return alcoholT1;
    }

    public void setAlcoholT1(Integer alcoholT1) {
        this.alcoholT1 = alcoholT1;
    }

    public Integer getT2() {
        return t2;
    }

    public void setT2(Integer t2) {
        this.t2 = t2;
    }

    public Integer getAlcoholT2() {
        return alcoholT2;
    }

    public void setAlcoholT2(Integer alcoholT2) {
        this.alcoholT2 = alcoholT2;
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
        if (!(object instanceof Distillation)) {
            return false;
        }
        Distillation other = (Distillation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ProductionControl.Distillation[ id=" + id + " ]";
    }
    
}
