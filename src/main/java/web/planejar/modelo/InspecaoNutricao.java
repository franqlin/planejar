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
@Table(name = "INSP_INSPECAO_NUTRICAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InspecaoNutricao.findAll", query = "SELECT i FROM InspecaoNutricao i"),
    @NamedQuery(name = "InspecaoNutricao.findByIdInspecaonutricao", query = "SELECT i FROM InspecaoNutricao i WHERE i.idInspecaonutricao = :idInspecaonutricao"),
    @NamedQuery(name = "InspecaoNutricao.findByObservacao", query = "SELECT i FROM InspecaoNutricao i WHERE i.observacao = :observacao"),
    @NamedQuery(name = "InspecaoNutricao.findByPergunta01", query = "SELECT i FROM InspecaoNutricao i WHERE i.pergunta01 = :pergunta01"),
    @NamedQuery(name = "InspecaoNutricao.findByPergunta02", query = "SELECT i FROM InspecaoNutricao i WHERE i.pergunta02 = :pergunta02")})
public class InspecaoNutricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSPECAONUTRICAO")
    private Integer idInspecaonutricao;
    @Size(max = 250)
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Size(max = 10)
    @Column(name = "PERGUNTA_01")
    private String pergunta01;
    @Size(max = 10)
    @Column(name = "PERGUNTA_02")
    private String pergunta02;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdInspecaonutricao")
    private Collection<Inspecao> inspecaoCollection;

    public InspecaoNutricao() {
    }

    public InspecaoNutricao(Integer idInspecaonutricao) {
        this.idInspecaonutricao = idInspecaonutricao;
    }

    public Integer getIdInspecaonutricao() {
        return idInspecaonutricao;
    }

    public void setIdInspecaonutricao(Integer idInspecaonutricao) {
        this.idInspecaonutricao = idInspecaonutricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPergunta01() {
        return pergunta01;
    }

    public void setPergunta01(String pergunta01) {
        this.pergunta01 = pergunta01;
    }

    public String getPergunta02() {
        return pergunta02;
    }

    public void setPergunta02(String pergunta02) {
        this.pergunta02 = pergunta02;
    }

    @XmlTransient
    public Collection<Inspecao> getInspecaoCollection() {
        return inspecaoCollection;
    }

    public void setInspecaoCollection(Collection<Inspecao> inspecaoCollection) {
        this.inspecaoCollection = inspecaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInspecaonutricao != null ? idInspecaonutricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InspecaoNutricao)) {
            return false;
        }
        InspecaoNutricao other = (InspecaoNutricao) object;
        if ((this.idInspecaonutricao == null && other.idInspecaonutricao != null) || (this.idInspecaonutricao != null && !this.idInspecaonutricao.equals(other.idInspecaonutricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.InspecaoNutricao[ idInspecaonutricao=" + idInspecaonutricao + " ]";
    }
    
}
