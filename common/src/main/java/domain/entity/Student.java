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
@Table(name = "student", catalog = "hey_mom_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = ?"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = ?"),
    @NamedQuery(name = "Student.findByAge", query = "SELECT s FROM Student s WHERE s.age = :age"),
    @NamedQuery(name = "Student.findByOrganzationId", query = "SELECT s FROM Student s WHERE s.orgId = ?"),
    @NamedQuery(name = "Student.findByMobile", query = "SELECT s FROM Student s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "Student.findByHomePhone", query = "SELECT s FROM Student s WHERE s.homePhone = :homePhone"),
    })
public class Student implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "avatar", nullable = false, length = 65535)
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age", nullable = false)
    private int age;
    @Size(max = 100)
    @Column(name = "mobile", length = 100)
    private String mobile;
    @Size(max = 100)
    @Column(name = "home_phone", length = 100)
    private String homePhone;
  
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Organization orgId;
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Mointor.class)
    @JoinTable(name = "st_mo",joinColumns = {
    @JoinColumn(name = "st_id")},inverseJoinColumns = {
    @JoinColumn(name = "mo_id")})
    private Collection<Mointor> mointors;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Account.class)
    @JoinTable(name = "acc_st",joinColumns = {
    @JoinColumn(name = "st_id")},inverseJoinColumns = {
    @JoinColumn(name = "acc_id")})
    private Collection<Account> accounts;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student( Organization orgId,String name, String avatar, int age) {
        
        this.name = name;
        this.avatar = avatar;
        this.age = age;
        this.orgId=orgId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
    }

    @XmlTransient
    public Collection<Mointor> getMointors() {
        return mointors;
    }

    public void setMointors(Collection<Mointor> mointors) {
        this.mointors = mointors;
    }

    @XmlTransient
    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> Accounts) {
        this.accounts = Accounts;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.Student[ id=" + id + " ]";
    }
    
}
