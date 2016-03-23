/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hibernate.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author forsell
 */
@Entity
@Table(name = "tbl_discounts", catalog = "leapfrog_academy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d"),
    @NamedQuery(name = "Discount.findByDiscountId", query = "SELECT d FROM Discount d WHERE d.discountId = :discountId"),
    @NamedQuery(name = "Discount.findByDiscountTitle", query = "SELECT d FROM Discount d WHERE d.discountTitle = :discountTitle"),
    @NamedQuery(name = "Discount.findByDiscountAmount", query = "SELECT d FROM Discount d WHERE d.discountAmount = :discountAmount"),
    @NamedQuery(name = "Discount.findByAddedDate", query = "SELECT d FROM Discount d WHERE d.addedDate = :addedDate"),
    @NamedQuery(name = "Discount.findByModifiedDate", query = "SELECT d FROM Discount d WHERE d.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Discount.findByStatus", query = "SELECT d FROM Discount d WHERE d.status = :status")})
public class Discount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discount_id", nullable = false)
    private Integer discountId;
    @Basic(optional = false)
    @Column(name = "discount_title", nullable = false, length = 100)
    private String discountTitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "discount_amount", nullable = false)
    private int discountAmount;
    @Basic(optional = false)
    @Column(name = "added_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "modified_date",nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Discount() {
    }

    public Discount(Integer discountId) {
        this.discountId = discountId;
    }

    public Discount(Integer discountId, String discountTitle, int discountAmount, Date addedDate, boolean status) {
        this.discountId = discountId;
        this.discountTitle = discountTitle;
        this.discountAmount = discountAmount;
        this.addedDate = addedDate;
        this.status = status;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getDiscountTitle() {
        return discountTitle;
    }

    public void setDiscountTitle(String discountTitle) {
        this.discountTitle = discountTitle;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountId != null ? discountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.discountId == null && other.discountId != null) || (this.discountId != null && !this.discountId.equals(other.discountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hibernate.app.entity.Discount[ discountId=" + discountId + " ]";
    }

}
