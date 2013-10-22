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
@Table(name = "CORP_ESCOLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
    @NamedQuery(name = "Escola.findByIdEscola", query = "SELECT e FROM Escola e WHERE e.idEscola = :idEscola"),
    @NamedQuery(name = "Escola.findByNome", query = "SELECT e FROM Escola e WHERE e.nome = :nome"),
    @NamedQuery(name = "Escola.findByNomeDiretor", query = "SELECT e FROM Escola e WHERE e.nomeDiretor = :nomeDiretor")})
public class Escola implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESCOLA")
    private Integer idEscola;
    @Size(max = 250)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 250)
    @Column(name = "NOME_DIRETOR")
    private String nomeDiretor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEscola")
    private Collection<Endereco> enderecoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEscola")
    private Collection<Inspecao> inspecaoCollection;
    @OneToMany(mappedBy = "fkIdEscola")
    private Collection<Contato> contatoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEscola")
    private Collection<Funcionario> funcionarioCollection;

    public Escola() {
    }

    public Escola(Integer idEscola) {
        this.idEscola = idEscola;
    }

    public Integer getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(Integer idEscola) {
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
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
    public Collection<Contato> getContatoCollection() {
        return contatoCollection;
    }

    public void setContatoCollection(Collection<Contato> contatoCollection) {
        this.contatoCollection = contatoCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscola != null ? idEscola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escola)) {
            return false;
        }
        Escola other = (Escola) object;
        if ((this.idEscola == null && other.idEscola != null) || (this.idEscola != null && !this.idEscola.equals(other.idEscola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Escola[ idEscola=" + idEscola + " ]";
    }
    
}
