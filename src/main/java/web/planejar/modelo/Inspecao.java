/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.planejar.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fssantos
 */
@Entity
@Table(name = "INSP_INSPECAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspecao.findAll", query = "SELECT i FROM Inspecao i"),
    @NamedQuery(name = "Inspecao.findByIdInpecao", query = "SELECT i FROM Inspecao i WHERE i.idInpecao = :idInpecao"),
    @NamedQuery(name = "Inspecao.findByDataInspecao", query = "SELECT i FROM Inspecao i WHERE i.dataInspecao = :dataInspecao")})
public class Inspecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INPECAO")
    private Integer idInpecao;
    @Column(name = "DATA_INSPECAO")
    @Temporal(TemporalType.DATE)
    private Date dataInspecao;
    @JoinColumn(name = "FK_ID_INSPECAONUTRICAO", referencedColumnName = "ID_INSPECAONUTRICAO")
    @ManyToOne(optional = false)
    private InspecaoNutricao fkIdInspecaonutricao;
    @JoinColumn(name = "FK_ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario fkIdFuncionario;
    @JoinColumn(name = "FK_ID_ESCOLA", referencedColumnName = "ID_ESCOLA")
    @ManyToOne(optional = false)
    private Escola fkIdEscola;

    public Inspecao() {
    }

    public Inspecao(Integer idInpecao) {
        this.idInpecao = idInpecao;
    }

    public Integer getIdInpecao() {
        return idInpecao;
    }

    public void setIdInpecao(Integer idInpecao) {
        this.idInpecao = idInpecao;
    }

    public Date getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(Date dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public InspecaoNutricao getFkIdInspecaonutricao() {
        return fkIdInspecaonutricao;
    }

    public void setFkIdInspecaonutricao(InspecaoNutricao fkIdInspecaonutricao) {
        this.fkIdInspecaonutricao = fkIdInspecaonutricao;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInpecao != null ? idInpecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspecao)) {
            return false;
        }
        Inspecao other = (Inspecao) object;
        if ((this.idInpecao == null && other.idInpecao != null) || (this.idInpecao != null && !this.idInpecao.equals(other.idInpecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.Inspecao[ idInpecao=" + idInpecao + " ]";
    }
    
}
