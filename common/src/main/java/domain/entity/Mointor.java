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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahaleem
 */
@Entity
@Table(name = "mointor", catalog = "hey_mom_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"mobile"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mointor.findAll", query = "SELECT m FROM Mointor m"),
    @NamedQuery(name = "Mointor.findById", query = "SELECT m FROM Mointor m WHERE m.id = :id"),
    @NamedQuery(name = "Mointor.findByName", query = "SELECT m FROM Mointor m WHERE m.name = ?"),
    @NamedQuery(name = "Mointor.findAllMointorsOfOrganization", query = "SELECT m FROM Mointor m WHERE m.orgId = ?"),
    @NamedQuery(name = "Mointor.findByMobile", query = "SELECT m FROM Mointor m WHERE m.mobile = :mobile"),
    @NamedQuery(name = "Mointor.findByHomePhone", query = "SELECT m FROM Mointor m WHERE m.homePhone = :homePhone"),
    @NamedQuery(name = "Mointor.findByPostion", query = "SELECT m FROM Mointor m WHERE m.postion = :postion")})
public class Mointor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Organization orgId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "email", nullable = false, length = 65535)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mobile", nullable = false, length = 255)
    private String mobile;
    @Size(max = 255)
    @Column(name = "home_phone", length = 255)
    private String homePhone;
    @Lob
    @Size(max = 65535)
    @Column(name = "facebook", length = 65535)
    private String facebook;
    @Lob
    @Size(max = 65535)
    @Column(name = "twitter", length = 65535)
    private String twitter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "postion", nullable = false, length = 255)
    private String postion;
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Student.class)
    @JoinTable(name = "st_mo",joinColumns = {
    @JoinColumn(name = "mo_id")},inverseJoinColumns = {
    @JoinColumn(name = "st_id")})
    private Collection<Student> students;

    public Mointor() {
    }

    public Mointor(Integer id) {
        this.id = id;
    }

    public Mointor( String name, Organization orgId, String email, String mobile, String postion) {
        
        this.name = name;
        this.orgId = orgId;
        this.email = email;
        this.mobile = mobile;
        this.postion = postion;
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

  public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    @XmlTransient
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
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
        if (!(object instanceof Mointor)) {
            return false;
        }
        Mointor other = (Mointor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.Mointor[ id=" + id + " ]";
    }
    
}
