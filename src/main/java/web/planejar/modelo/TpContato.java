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
@Table(name = "CORP_TP_CONTATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TpContato.findAll", query = "SELECT t FROM TpContato t"),
    @NamedQuery(name = "TpContato.findByIdTipocontato", query = "SELECT t FROM TpContato t WHERE t.idTipocontato = :idTipocontato"),
    @NamedQuery(name = "TpContato.findByDescricao", query = "SELECT t FROM TpContato t WHERE t.descricao = :descricao")})
public class TpContato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOCONTATO")
    private Integer idTipocontato;
    @Size(max = 20)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipocontato")
    private Collection<Contato> contatoCollection;

    public TpContato() {
    }

    public TpContato(Integer idTipocontato) {
        this.idTipocontato = idTipocontato;
    }

    public Integer getIdTipocontato() {
        return idTipocontato;
    }

    public void setIdTipocontato(Integer idTipocontato) {
        this.idTipocontato = idTipocontato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Contato> getContatoCollection() {
        return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipocontato != null ? idTipocontato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TpContato)) {
            return false;
        }
        TpContato other = (TpContato) object;
        if ((this.idTipocontato == null && other.idTipocontato != null) || (this.idTipocontato != null && !this.idTipocontato.equals(other.idTipocontato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.TpContato[ idTipocontato=" + idTipocontato + " ]";
    }
    
}
