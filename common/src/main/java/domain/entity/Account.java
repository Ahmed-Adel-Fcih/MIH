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

import domain.basic.BasicEntity;

/**
 *
 * @author ahaleem
 */
@Entity
@Table(name = "account", catalog = "hey_mom_db", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email", "mobile"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
    @NamedQuery(name = "Account.findByAge", query = "SELECT a FROM Account a WHERE a.age = :age"),
    @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByMobile", query = "SELECT a FROM Account a WHERE a.mobile = :mobile"),
    @NamedQuery(name = "Account.findByHomePhone", query = "SELECT a FROM Account a WHERE a.homePhone = :homePhone"),
    @NamedQuery(name = "Account.findByGroupId", query = "SELECT a FROM Account a WHERE a.groupId = :groupId"),
    @NamedQuery(name = "Account.findByActive", query = "SELECT a FROM Account a WHERE a.active = :active"),
    @NamedQuery(name = "Account.findAllAccountsOfOrganization", query = "SELECT a FROM Account a WHERE a.orgId = ?")})
public class Account implements Serializable   {
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
    @Column(name = "age")
    private Integer age;
    @Size(max = 255)
    @Column(name = "address", length = 255)
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mobile", nullable = false, length = 255)
    private String mobile;
    @Size(max = 255)
    @Column(name = "home_phone", length = 255)
    private String homePhone;
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "avatar", nullable = false, length = 65535)
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private int active;
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Organization orgId;
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Student.class)
    @JoinTable(name = "acc_st",joinColumns = {
    @JoinColumn(name = "acc_id")},inverseJoinColumns = {
    @JoinColumn(name = "st_id")})
    private Collection<Student> students;

    public Account() {
    }

    public Account(Integer id) {
        id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account(String name, String email, String mobile, String avatar, int active,Organization orgId) {
        
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.avatar = avatar;
        this.active = active;
        this.orgId = orgId;
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
    }

    @XmlTransient
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> Students) {
        this.students = Students;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.Account[ id=" + id + " ]";
    }
    
}
