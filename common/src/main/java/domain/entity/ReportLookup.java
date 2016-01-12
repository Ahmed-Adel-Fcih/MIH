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
import javax.persistence.Lob;
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
@Table(name = "report_lookup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportLookup.findAll", query = "SELECT r FROM ReportLookup r"),
    @NamedQuery(name = "ReportLookup.findById", query = "SELECT r FROM ReportLookup r WHERE r.id = :id"),
    @NamedQuery(name = "ReportLookup.findByAttribute1", query = "SELECT r FROM ReportLookup r WHERE r.attribute1 = :attribute1"),
    @NamedQuery(name = "ReportLookup.findByAttribute2", query = "SELECT r FROM ReportLookup r WHERE r.attribute2 = :attribute2"),
    @NamedQuery(name = "ReportLookup.findByAttribute3", query = "SELECT r FROM ReportLookup r WHERE r.attribute3 = :attribute3"),
    @NamedQuery(name = "ReportLookup.findByAttribute4", query = "SELECT r FROM ReportLookup r WHERE r.attribute4 = :attribute4"),
    @NamedQuery(name = "ReportLookup.findByAttribute5", query = "SELECT r FROM ReportLookup r WHERE r.attribute5 = :attribute5"),
    @NamedQuery(name = "ReportLookup.findByAttribute6", query = "SELECT r FROM ReportLookup r WHERE r.attribute6 = :attribute6"),
    @NamedQuery(name = "ReportLookup.findByAttribute8", query = "SELECT r FROM ReportLookup r WHERE r.attribute8 = :attribute8"),
    @NamedQuery(name = "ReportLookup.findByAttribute9", query = "SELECT r FROM ReportLookup r WHERE r.attribute9 = :attribute9"),
    @NamedQuery(name = "ReportLookup.findByAttribute10", query = "SELECT r FROM ReportLookup r WHERE r.attribute10 = :attribute10"),
    @NamedQuery(name = "ReportLookup.findByAttribute11", query = "SELECT r FROM ReportLookup r WHERE r.attribute11 = :attribute11"),
    @NamedQuery(name = "ReportLookup.findByAttribute12", query = "SELECT r FROM ReportLookup r WHERE r.attribute12 = :attribute12"),
    @NamedQuery(name = "ReportLookup.findByAttribute13", query = "SELECT r FROM ReportLookup r WHERE r.attribute13 = :attribute13"),
    @NamedQuery(name = "ReportLookup.findByReportTypeId", query = "SELECT r FROM ReportLookup r WHERE r.reportTypeId = :reportTypeId")})
public class ReportLookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Lob
    @Column(name = "id")
    private Integer id;
     @Lob
    @Column(name = "attribute1")
    private String attribute1;
     @Lob
    @Column(name = "attribute2")
    private String attribute2;
    @Lob
    @Column(name = "attribute3")
    private String attribute3;
    @Lob
    @Column(name = "attribute4")
    private String attribute4;
    @Lob
    @Column(name = "attribute5")
    private String attribute5;
     @Lob
    @Column(name = "attribute6")
    private String attribute6;
     @Lob
    @Column(name = "attribute8")
    private String attribute8;
    @Lob
    @Column(name = "attribute9")
    private String attribute9;
     @Lob
    @Column(name = "attribute10")
    private String attribute10;
    @Lob
    @Column(name = "attribute11")
    private String attribute11;
    @Lob
    @Column(name = "attribute12")
    private String attribute12;
    @Lob
    @Column(name = "attribute13")
    private String attribute13;
    @JoinColumn(name = "report_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ReportType reportTypeId;
    public ReportLookup() {
    }

    public ReportLookup(Integer id) {
        this.id = id;
    }

    public ReportLookup(Integer id, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, String attribute6, String attribute8, String attribute9, String attribute10, String attribute11, String attribute12, String attribute13, int reportTypeId) {
        this.id = id;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.attribute6 = attribute6;
        this.attribute8 = attribute8;
        this.attribute9 = attribute9;
        this.attribute10 = attribute10;
        this.attribute11 = attribute11;
        this.attribute12 = attribute12;
        this.attribute13 = attribute13;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
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
        if (!(object instanceof ReportLookup)) {
            return false;
        }
        ReportLookup other = (ReportLookup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gemi.ReportLookup[ id=" + id + " ]";
    }

    /**
     * @param reportTypeId the reportTypeId to set
     */
    public void setReportTypeId(ReportType reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    /**
     * @return the reportTypeId
     */
    public ReportType getReportTypeId() {
        return reportTypeId;
    }
    
}
