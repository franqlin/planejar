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
@Table(name = "CORP_FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByDatanascimento", query = "SELECT f FROM Funcionario f WHERE f.datanascimento = :datanascimento"),
    @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.findByTituloeleitor", query = "SELECT f FROM Funcionario f WHERE f.tituloeleitor = :tituloeleitor"),
    @NamedQuery(name = "Funcionario.findByZonaeleitoral", query = "SELECT f FROM Funcionario f WHERE f.zonaeleitoral = :zonaeleitoral"),
    @NamedQuery(name = "Funcionario.findBySecao", query = "SELECT f FROM Funcionario f WHERE f.secao = :secao"),
    @NamedQuery(name = "Funcionario.findByPis", query = "SELECT f FROM Funcionario f WHERE f.pis = :pis"),
    @NamedQuery(name = "Funcionario.findByCnh", query = "SELECT f FROM Funcionario f WHERE f.cnh = :cnh"),
    @NamedQuery(name = "Funcionario.findByObservacoes", query = "SELECT f FROM Funcionario f WHERE f.observacoes = :observacoes")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    private Integer idFuncionario;
    @Size(max = 50)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Size(max = 11)
    @Column(name = "CPF")
    private String cpf;
    @Size(max = 10)
    @Column(name = "TITULOELEITOR")
    private String tituloeleitor;
    @Size(max = 10)
    @Column(name = "ZONAELEITORAL")
    private String zonaeleitoral;
    @Size(max = 10)
    @Column(name = "SECAO")
    private String secao;
    @Size(max = 10)
    @Column(name = "PIS")
    private String pis;
    @Size(max = 10)
    @Column(name = "CNH")
    private String cnh;
    @Size(max = 250)
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private Collection<Endereco> enderecoCollection;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private Collection<Inspecao> inspecaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<AcessoUsuario> acessoUsuarioCollection;
    @OneToMany(mappedBy = "fkIdFuncionario")
    private Collection<Contato> contatoCollection;
    @JoinColumn(name = "FK_ID_ESCOLA", referencedColumnName = "ID_ESCOLA")
    @ManyToOne(optional = false)
    private Escola fkIdEscola;
    @JoinColumn(name = "FK_ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo fkIdCargo;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTituloeleitor() {
        return tituloeleitor;
    }

    public void setTituloeleitor(String tituloeleitor) {
        this.tituloeleitor = tituloeleitor;
    }

    public String getZonaeleitoral() {
        return zonaeleitoral;
    }

    public void setZonaeleitoral(String zonaeleitoral) {
        this.zonaeleitoral = zonaeleitoral;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @XmlTransient
    public Collection<Inspecao> getInspecaoCollection() {
        return inspecaoCollection;
    }

    public void setInspecaoCollection(Collection<Inspecao> inspecaoCollection) {
        this.inspecaoCollection = inspecaoCollection;
    }

    @XmlTransient
    public Collection<AcessoUsuario> getAcessoUsuarioCollection() {
        return acessoUsuarioCollection;
    }

    public void setAcessoUsuarioCollection(Collection<AcessoUsuario> acessoUsuarioCollection) {
        this.acessoUsuarioCollection = acessoUsuarioCollection;
    }

    @XmlTransient
    public Collection<Contato> getContatoCollection() {
        return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }

    public Escola getFkIdEscola() {
        return fkIdEscola;
    }

    public void setFkIdEscola(Escola fkIdEscola) {
        this.fkIdEscola = fkIdEscola;
    }

    public Cargo getFkIdCargo() {
        return fkIdCargo;
    }

    public void setFkIdCargo(Cargo fkIdCargo) {
        this.fkIdCargo = fkIdCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
