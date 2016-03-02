/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ProductionControl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriy.mamishev
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByClassification", query = "SELECT p FROM Product p WHERE p.classification = :classification"),
    @NamedQuery(name = "Product.findByDateCook", query = "SELECT p FROM Product p WHERE p.dateCook = :dateCook"),
    @NamedQuery(name = "Product.findByRatingCurrentDistillation", query = "SELECT p FROM Product p WHERE p.ratingCurrentDistillation = :ratingCurrentDistillation"),
    @NamedQuery(name = "Product.findByStartInfusionDate", query = "SELECT p FROM Product p WHERE p.startInfusionDate = :startInfusionDate"),
    @NamedQuery(name = "Product.findByEndInfusionDate", query = "SELECT p FROM Product p WHERE p.endInfusionDate = :endInfusionDate"),
    @NamedQuery(name = "Product.findByRatingEndProduct", query = "SELECT p FROM Product p WHERE p.ratingEndProduct = :ratingEndProduct"),
    @NamedQuery(name = "Product.findByDescriptionEndProduct", query = "SELECT p FROM Product p WHERE p.descriptionEndProduct = :descriptionEndProduct")})
public class Product implements Serializable {

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
    @Size(max = 50)
    @Column(name = "Classification")
    private String classification;
    @Column(name = "DateCook")
    @Temporal(TemporalType.DATE)
    private Date dateCook;
    @Column(name = "RatingCurrentDistillation")
    private Integer ratingCurrentDistillation;
    @Column(name = "StartInfusionDate")
    @Temporal(TemporalType.DATE)
    private Date startInfusionDate;
    @Column(name = "EndInfusionDate")
    @Temporal(TemporalType.DATE)
    private Date endInfusionDate;
    @Column(name = "RatingEndProduct")
    private Integer ratingEndProduct;
    @Size(max = 1000)
    @Column(name = "DescriptionEndProduct")
    private String descriptionEndProduct;
    @JoinColumn(name = "IdDistillation", referencedColumnName = "Id")
    @ManyToOne
    private Distillation idDistillation;
    @JoinColumn(name = "IdFermentation", referencedColumnName = "Id")
    @ManyToOne
    private Fermentation idFermentation;
    @JoinColumn(name = "IdRecipe", referencedColumnName = "Id")
    @ManyToOne
    private Recipe idRecipe;

    public Product() {
    }

    public Product(ResultSet rs) throws SQLException {
        //sas
        if (rs.getInt("Id") > 0) {
            this.id = rs.getInt("Id");
            this.name = rs.getString("Name");
            this.description = rs.getString("Description");
            this.classification = rs.getString("Classification");
            this.dateCook = rs.getDate("DateCook");
       // this.idRecipe = rs.getObject("IdRecipe", Recipe.class);
            //  this.idFermentation = rs.getObject("IdFermentation",Fermentation.class);
            //  this.idDistillation = rs.getObject("IdDistillation",Distillation.class);
            this.ratingCurrentDistillation = rs.getInt("RatingCurrentDistillation");
            this.startInfusionDate = rs.getDate("StartInfusionDate");
            this.endInfusionDate = rs.getDate("EndInfusionDate");
            this.ratingEndProduct = rs.getInt("RatingEndProduct");
            this.descriptionEndProduct = rs.getString("DescriptionEndProduct");
        } else {
            this.name = "no sql data";
        }
    }

    public Product(Integer id) {
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Date getDateCook() {
        return dateCook;
    }

    public void setDateCook(Date dateCook) {
        this.dateCook = dateCook;
    }

    public Integer getRatingCurrentDistillation() {
        return ratingCurrentDistillation;
    }

    public void setRatingCurrentDistillation(Integer ratingCurrentDistillation) {
        this.ratingCurrentDistillation = ratingCurrentDistillation;
    }

    public Date getStartInfusionDate() {
        return startInfusionDate;
    }

    public void setStartInfusionDate(Date startInfusionDate) {
        this.startInfusionDate = startInfusionDate;
    }

    public Date getEndInfusionDate() {
        return endInfusionDate;
    }

    public void setEndInfusionDate(Date endInfusionDate) {
        this.endInfusionDate = endInfusionDate;
    }

    public Integer getRatingEndProduct() {
        return ratingEndProduct;
    }

    public void setRatingEndProduct(Integer ratingEndProduct) {
        this.ratingEndProduct = ratingEndProduct;
    }

    public String getDescriptionEndProduct() {
        return descriptionEndProduct;
    }

    public void setDescriptionEndProduct(String descriptionEndProduct) {
        this.descriptionEndProduct = descriptionEndProduct;
    }

    public Distillation getIdDistillation() {
        return idDistillation;
    }

    public void setIdDistillation(Distillation idDistillation) {
        this.idDistillation = idDistillation;
    }

    public Fermentation getIdFermentation() {
        return idFermentation;
    }

    public void setIdFermentation(Fermentation idFermentation) {
        this.idFermentation = idFermentation;
    }

    public Recipe getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Recipe idRecipe) {
        this.idRecipe = idRecipe;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ProductionControl.Product[ id=" + id + " ]";
    }

}
