/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.modelo;

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
 * @author fssantos
 */
@Entity
@Table(name = "ADM_ACESSO_USUARIO_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoUsuarioRole.findAll", query = "SELECT a FROM AcessoUsuarioRole a"),
    @NamedQuery(name = "AcessoUsuarioRole.findByIdUsuarioRole", query = "SELECT a FROM AcessoUsuarioRole a WHERE a.idUsuarioRole = :idUsuarioRole")})
public class AcessoUsuarioRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_ROLE")
    private Integer idUsuarioRole;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private AcessoUsuario idUsuario;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(optional = false)
    private AcessoRole idRole;

    public AcessoUsuarioRole() {
    }

    public AcessoUsuarioRole(Integer idUsuarioRole) {
        this.idUsuarioRole = idUsuarioRole;
    }

    public Integer getIdUsuarioRole() {
        return idUsuarioRole;
    }

    public void setIdUsuarioRole(Integer idUsuarioRole) {
        this.idUsuarioRole = idUsuarioRole;
    }

    public AcessoUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(AcessoUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public AcessoRole getIdRole() {
        return idRole;
    }

    public void setIdRole(AcessoRole idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRole != null ? idUsuarioRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoUsuarioRole)) {
            return false;
        }
        AcessoUsuarioRole other = (AcessoUsuarioRole) object;
        if ((this.idUsuarioRole == null && other.idUsuarioRole != null) || (this.idUsuarioRole != null && !this.idUsuarioRole.equals(other.idUsuarioRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.AcessoUsuarioRole[ idUsuarioRole=" + idUsuarioRole + " ]";
    }
    
}
