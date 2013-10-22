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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fssantos
 */
@Entity
@Table(name = "CORP_REGIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regional.findAll", query = "SELECT r FROM Regional r"),
    @NamedQuery(name = "Regional.findByIdRegional", query = "SELECT r FROM Regional r WHERE r.idRegional = :idRegional"),
    @NamedQuery(name = "Regional.findByNome", query = "SELECT r FROM Regional r WHERE r.nome = :nome")})
public class Regional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REGIONAL")
    private Integer idRegional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdRegional")
    private Collection<Endereco> enderecoCollection;

    public Regional() {
    }

    public Regional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public Regional(Integer idRegional, String nome) {
        this.idRegional = idRegional;
        this.nome = nome;
    }

    public Integer getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegional != null ? idRegional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regional)) {
            return false;
        }
        Regional other = (Regional) object;
        if ((this.idRegional == null && other.idRegional != null) || (this.idRegional != null && !this.idRegional.equals(other.idRegional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Regional[ idRegional=" + idRegional + " ]";
    }
    
}
