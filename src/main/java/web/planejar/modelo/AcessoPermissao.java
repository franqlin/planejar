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
@Table(name = "ADM_ACESSO_PERMISSAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoPermissao.findAll", query = "SELECT a FROM AcessoPermissao a"),
    @NamedQuery(name = "AcessoPermissao.findByIdPermissao", query = "SELECT a FROM AcessoPermissao a WHERE a.idPermissao = :idPermissao"),
    @NamedQuery(name = "AcessoPermissao.findByNome", query = "SELECT a FROM AcessoPermissao a WHERE a.nome = :nome")})
public class AcessoPermissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERMISSAO")
    private Integer idPermissao;
    @Size(max = 10)
    @Column(name = "NOME")
    private String nome;

    public AcessoPermissao() {
    }

    public AcessoPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public Integer getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissao != null ? idPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoPermissao)) {
            return false;
        }
        AcessoPermissao other = (AcessoPermissao) object;
        if ((this.idPermissao == null && other.idPermissao != null) || (this.idPermissao != null && !this.idPermissao.equals(other.idPermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.planejar.modelo.AcessoPermissao[ idPermissao=" + idPermissao + " ]";
    }
    
}
