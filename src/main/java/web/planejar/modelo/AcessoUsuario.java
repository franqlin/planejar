/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fssantos
 */
@Entity
@Table(name = "ADM_ACESSO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoUsuario.findAll", query = "SELECT a FROM AcessoUsuario a"),
    @NamedQuery(name = "AcessoUsuario.findByIdUsuario", query = "SELECT a FROM AcessoUsuario a WHERE a.idUsuario = :idUsuario"),
    @NamedQuery(name = "AcessoUsuario.findByNomeUsuario", query = "SELECT a FROM AcessoUsuario a WHERE a.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "AcessoUsuario.findBySenha", query = "SELECT a FROM AcessoUsuario a WHERE a.senha = :senha"),
    @NamedQuery(name = "AcessoUsuario.findByAtivo", query = "SELECT a FROM AcessoUsuario a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "AcessoUsuario.findByDataCriacao", query = "SELECT a FROM AcessoUsuario a WHERE a.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "AcessoUsuario.findByDataModificacao", query = "SELECT a FROM AcessoUsuario a WHERE a.dataModificacao = :dataModificacao")})
public class AcessoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Size(max = 40)
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Size(max = 40)
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "ATIVO")
    private Short ativo;
    @Column(name = "DATA_CRIACAO")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "DATA_MODIFICACAO")
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<AcessoUsuarioRole> acessoUsuarioRoleCollection;
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public AcessoUsuario() {
    }

    public AcessoUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Short getAtivo() {
        return ativo;
    }

    public void setAtivo(Short ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @XmlTransient
    public Collection<AcessoUsuarioRole> getAcessoUsuarioRoleCollection() {
        return acessoUsuarioRoleCollection;
    }

    public void setAcessoUsuarioRoleCollection(Collection<AcessoUsuarioRole> acessoUsuarioRoleCollection) {
        this.acessoUsuarioRoleCollection = acessoUsuarioRoleCollection;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoUsuario)) {
            return false;
        }
        AcessoUsuario other = (AcessoUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.AcessoUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
