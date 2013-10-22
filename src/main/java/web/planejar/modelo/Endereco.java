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
@Table(name = "CORP_ENDERECO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByIdEndereco", query = "SELECT e FROM Endereco e WHERE e.idEndereco = :idEndereco"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByPontoreferencia", query = "SELECT e FROM Endereco e WHERE e.pontoreferencia = :pontoreferencia")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
    @Size(max = 10)
    @Column(name = "CEP")
    private String cep;
    @Size(max = 10)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Size(max = 10)
    @Column(name = "NUMERO")
    private String numero;
    @Size(max = 50)
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Size(max = 20)
    @Column(name = "PONTOREFERENCIA")
    private String pontoreferencia;
    @JoinColumn(name = "FK_ID_UF", referencedColumnName = "ID_UF")
    @ManyToOne(optional = false)
    private Uf fkIdUf;
    @JoinColumn(name = "FK_ID_TIPO_LOGRADOURO", referencedColumnName = "ID_TIPOLOGRADOURO")
    @ManyToOne(optional = false)
    private TpLogradouro fkIdTipoLogradouro;
    @JoinColumn(name = "FK_ID_TIPO_ENDERECO", referencedColumnName = "ID_TIPOENDERECO")
    @ManyToOne
    private TpEndereco fkIdTipoEndereco;
    @JoinColumn(name = "FK_ID_REGIONAL", referencedColumnName = "ID_REGIONAL")
    @ManyToOne(optional = false)
    private Regional fkIdRegional;
    @JoinColumn(name = "FK_ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario fkIdFuncionario;
    @JoinColumn(name = "FK_ID_ESCOLA", referencedColumnName = "ID_ESCOLA")
    @ManyToOne(optional = false)
    private Escola fkIdEscola;
    @JoinColumn(name = "FK_ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa fkIdEmpresa;
    @JoinColumn(name = "FK_ID_CIDADE", referencedColumnName = "ID_CIDADE")
    @ManyToOne
    private Cidade fkIdCidade;
    @JoinColumn(name = "FK_ID_BAIRRO", referencedColumnName = "ID_BAIRRO")
    @ManyToOne(optional = false)
    private Bairro fkIdBairro;

    public Endereco() {
    }

    public Endereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getPontoreferencia() {
        return pontoreferencia;
    }

    public void setPontoreferencia(String pontoreferencia) {
        this.pontoreferencia = pontoreferencia;
    }

    public Uf getFkIdUf() {
        return fkIdUf;
    }

    public void setFkIdUf(Uf fkIdUf) {
        this.fkIdUf = fkIdUf;
    }

    public TpLogradouro getFkIdTipoLogradouro() {
        return fkIdTipoLogradouro;
    }

    public void setFkIdTipoLogradouro(TpLogradouro fkIdTipoLogradouro) {
        this.fkIdTipoLogradouro = fkIdTipoLogradouro;
    }

    public TpEndereco getFkIdTipoEndereco() {
        return fkIdTipoEndereco;
    }

    public void setFkIdTipoEndereco(TpEndereco fkIdTipoEndereco) {
        this.fkIdTipoEndereco = fkIdTipoEndereco;
    }

    public Regional getFkIdRegional() {
        return fkIdRegional;
    }

    public void setFkIdRegional(Regional fkIdRegional) {
        this.fkIdRegional = fkIdRegional;
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

    public Cidade getFkIdCidade() {
        return fkIdCidade;
    }

    public void setFkIdCidade(Cidade fkIdCidade) {
        this.fkIdCidade = fkIdCidade;
    }

    public Bairro getFkIdBairro() {
        return fkIdBairro;
    }

    public void setFkIdBairro(Bairro fkIdBairro) {
        this.fkIdBairro = fkIdBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Endereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
