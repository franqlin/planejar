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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fssantos
 */
@Entity
@Table(name = "CORP_CONTATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c"),
    @NamedQuery(name = "Contato.findByIdContato", query = "SELECT c FROM Contato c WHERE c.idContato = :idContato"),
    @NamedQuery(name = "Contato.findByDescricao", query = "SELECT c FROM Contato c WHERE c.descricao = :descricao")})
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTATO")
    private Integer idContato;
    @Size(max = 10)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "ID_TIPOCONTATO", referencedColumnName = "ID_TIPOCONTATO")
    @ManyToOne(optional = false)
    private TpContato idTipocontato;
    @JoinColumn(name = "FK_ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario fkIdFuncionario;
    @JoinColumn(name = "FK_ID_ESCOLA", referencedColumnName = "ID_ESCOLA")
    @ManyToOne
    private Escola fkIdEscola;
    @JoinColumn(name = "FK_ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa fkIdEmpresa;

    public Contato() {
    }

    public Contato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TpContato getIdTipocontato() {
        return idTipocontato;
    }

    public void setIdTipocontato(TpContato idTipocontato) {
        this.idTipocontato = idTipocontato;
    }

    public Funcionario getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(Funcionario fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public Escola getFkIdEscola() {
        return fkIdEscola;
    }

    public void setFkIdEscola(Escola fkIdEscola) {
        this.fkIdEscola = fkIdEscola;
    }

    public Empresa getFkIdEmpresa() {
        return fkIdEmpresa;
    }

    public void setFkIdEmpresa(Empresa fkIdEmpresa) {
        this.fkIdEmpresa = fkIdEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Contato[ idContato=" + idContato + " ]";
    }
    
}
