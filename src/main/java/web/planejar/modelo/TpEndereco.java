/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "CORP_TP_ENDERECO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TpEndereco.findAll", query = "SELECT t FROM TpEndereco t"),
    @NamedQuery(name = "TpEndereco.findByIdTipoendereco", query = "SELECT t FROM TpEndereco t WHERE t.idTipoendereco = :idTipoendereco"),
    @NamedQuery(name = "TpEndereco.findByDescricao", query = "SELECT t FROM TpEndereco t WHERE t.descricao = :descricao")})
public class TpEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOENDERECO")
    private Integer idTipoendereco;
    @Size(max = 20)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "fkIdTipoEndereco")
    private Collection<Endereco> enderecoCollection;

    public TpEndereco() {
    }

    public TpEndereco(Integer idTipoendereco) {
        this.idTipoendereco = idTipoendereco;
    }

    public Integer getIdTipoendereco() {
        return idTipoendereco;
    }

    public void setIdTipoendereco(Integer idTipoendereco) {
        this.idTipoendereco = idTipoendereco;
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
        hash += (idTipoendereco != null ? idTipoendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TpEndereco)) {
            return false;
        }
        TpEndereco other = (TpEndereco) object;
        if ((this.idTipoendereco == null && other.idTipoendereco != null) || (this.idTipoendereco != null && !this.idTipoendereco.equals(other.idTipoendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.TpEndereco[ idTipoendereco=" + idTipoendereco + " ]";
    }
    
}
