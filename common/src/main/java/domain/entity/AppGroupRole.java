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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahaleem
 */
@Entity
@Table(name = "app_group_role", catalog = "hey_mom_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppGroupRole.findAll", query = "SELECT a FROM AppGroupRole a"),
    @NamedQuery(name = "AppGroupRole.findById", query = "SELECT a FROM AppGroupRole a WHERE a.id = :id"),
    @NamedQuery(name = "AppGroupRole.findByGroupId", query = "SELECT a FROM AppGroupRole a WHERE a.groupId = :groupId"),
    @NamedQuery(name = "AppGroupRole.findByRoleId", query = "SELECT a FROM AppGroupRole a WHERE a.roleId = :roleId")})
public class AppGroupRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id", nullable = false)
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id", nullable = false)
    private int roleId;

    public AppGroupRole() {
    }

    public AppGroupRole(Integer id) {
        this.id = id;
    }

    public AppGroupRole(Integer id, int groupId, int roleId) {
        this.id = id;
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof AppGroupRole)) {
            return false;
        }
        AppGroupRole other = (AppGroupRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.model.AppGroupRole[ id=" + id + " ]";
    }
    
}
