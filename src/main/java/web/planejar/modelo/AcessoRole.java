/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fssantos
 */
@Entity
@Table(name = "ADM_ACESSO_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoRole.findAll", query = "SELECT a FROM AcessoRole a"),
    @NamedQuery(name = "AcessoRole.findByIdRole", query = "SELECT a FROM AcessoRole a WHERE a.idRole = :idRole"),
    @NamedQuery(name = "AcessoRole.findByNome", query = "SELECT a FROM AcessoRole a WHERE a.nome = :nome")})
public class AcessoRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROLE")
    private Integer idRole;
    @Size(max = 40)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private Collection<AcessoUsuarioRole> acessoUsuarioRoleCollection;

    public AcessoRole() {
    }

    public AcessoRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<AcessoUsuarioRole> getAcessoUsuarioRoleCollection() {
        return acessoUsuarioRoleCollection;
    }

    public void setAcessoUsuarioRoleCollection(Collection<AcessoUsuarioRole> acessoUsuarioRoleCollection) {
        this.acessoUsuarioRoleCollection = acessoUsuarioRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoRole)) {
            return false;
        }
        AcessoRole other = (AcessoRole) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.AcessoRole[ idRole=" + idRole + " ]";
    }
    
}
