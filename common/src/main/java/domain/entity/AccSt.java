/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahaleem
 */
@Entity
@Table(name = "acc_st", catalog = "hey_mom_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccSt.findAll", query = "SELECT a FROM AccSt a"),
    @NamedQuery(name = "AccSt.findById", query = "SELECT a FROM AccSt a WHERE a.id = :id"),
    /*@NamedQuery(name = "AccSt.findAllAccountStudent", query = "SELECT st_id FROM AccSt a WHERE a.acc_id = ?")*/

    })
public class AccSt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "st_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Student stId;
    @JoinColumn(name = "acc_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Account accId;

    public AccSt() {
    }
    
    public AccSt(Account accId,Student stId) {
            this.stId = stId;
             this.accId = accId;
    }

    public AccSt(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStId() {
        return stId;
    }

    public void setStId(Student stId) {
        this.stId = stId;
    }

    public Account getAccId() {
        return accId;
    }

    public void setAccId(Account accId) {
    this.accId = accId;
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
        if (!(object instanceof AccSt)) {
            return false;
        }
        AccSt other = (AccSt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.AccSt[ id=" + id + " ]";
    }
    
}
