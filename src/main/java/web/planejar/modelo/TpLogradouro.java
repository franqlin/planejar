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
@Table(name = "CORP_TP_LOGRADOURO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TpLogradouro.findAll", query = "SELECT t FROM TpLogradouro t"),
    @NamedQuery(name = "TpLogradouro.findByIdTipologradouro", query = "SELECT t FROM TpLogradouro t WHERE t.idTipologradouro = :idTipologradouro"),
    @NamedQuery(name = "TpLogradouro.findByDescricao", query = "SELECT t FROM TpLogradouro t WHERE t.descricao = :descricao")})
public class TpLogradouro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOLOGRADOURO")
    private Integer idTipologradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdTipoLogradouro")
    private Collection<Endereco> enderecoCollection;

    public TpLogradouro() {
    }

    public TpLogradouro(Integer idTipologradouro) {
        this.idTipologradouro = idTipologradouro;
    }

    public TpLogradouro(Integer idTipologradouro, String descricao) {
        this.idTipologradouro = idTipologradouro;
        this.descricao = descricao;
    }

    public Integer getIdTipologradouro() {
        return idTipologradouro;
    }

    public void setIdTipologradouro(Integer idTipologradouro) {
        this.idTipologradouro = idTipologradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (idTipologradouro != null ? idTipologradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TpLogradouro)) {
            return false;
        }
        TpLogradouro other = (TpLogradouro) object;
        if ((this.idTipologradouro == null && other.idTipologradouro != null) || (this.idTipologradouro != null && !this.idTipologradouro.equals(other.idTipologradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.TpLogradouro[ idTipologradouro=" + idTipologradouro + " ]";
    }
    
}
