/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ProductionControl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriy.mamishev
 */
@Entity
@Table(name = "Recipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipt.findAll", query = "SELECT r FROM Recipt r"),
    @NamedQuery(name = "Recipt.findById", query = "SELECT r FROM Recipt r WHERE r.id = :id"),
    @NamedQuery(name = "Recipt.findByName", query = "SELECT r FROM Recipt r WHERE r.name = :name"),
    @NamedQuery(name = "Recipt.findByDescription", query = "SELECT r FROM Recipt r WHERE r.description = :description"),
    @NamedQuery(name = "Recipt.findByMainIngredients", query = "SELECT r FROM Recipt r WHERE r.mainIngredients = :mainIngredients"),
    @NamedQuery(name = "Recipt.findByWater", query = "SELECT r FROM Recipt r WHERE r.water = :water")})
public class Recipt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "MainIngredients")
    private String mainIngredients;
    @Column(name = "Water")
    private String water;

    public Recipt() {
    }

    public Recipt(Integer id) {
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

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
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
        if (!(object instanceof Recipt)) {
            return false;
        }
        Recipt other = (Recipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ProductionControl.Recipt[ id=" + id + " ]";
    }
    
}
