/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahaleem
 */
@Entity
@Table(name = "st_mo", catalog = "hey_mom_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StMo.findAll", query = "SELECT s FROM StMo s"),
    @NamedQuery(name = "StMo.findById", query = "SELECT s FROM StMo s WHERE s.id =? "),
   /* @NamedQuery(name = "StMo.findAllStudentMointors", query = "SELECT mo_Id FROM s WHERE s.st_id =? "),
    @NamedQuery(name = "StMo.findAllMointorStudents", query = "SELECT st_Id FROM s WHERE s.mo_id =? ")*/
})
public class StMo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "mo_id", referencedColumnName = "id")
    @ManyToOne
    private Mointor moId;
    @JoinColumn(name = "st_id", referencedColumnName = "id")
    @ManyToOne
    private Student stId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stMonId")
    private Collection<Report> reportCollection;

    public StMo() {
    }

    
    public StMo(Student stId,Mointor moId) {
         this.moId = moId;
          this.stId = stId;
    }

    public StMo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mointor getMoId() {
        return moId;
    }

    public void setMoId(Mointor moId) {
        this.moId = moId;
    }

    public Student getStId() {
        return stId;
    }

    public void setStId(Student stId) {
        this.stId = stId;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
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
        if (!(object instanceof StMo)) {
            return false;
        }
        StMo other = (StMo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.StMo[ id=" + id + " ]";
    }
    
}
