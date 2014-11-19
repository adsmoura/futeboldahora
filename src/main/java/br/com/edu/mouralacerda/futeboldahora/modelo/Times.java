/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.edu.mouralacerda.futeboldahora.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phillipe.Roger
 */
@Entity
@Table(name = "times")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Times.findAll", query = "SELECT t FROM Times t"),
    @NamedQuery(name = "Times.findById", query = "SELECT t FROM Times t WHERE t.id = :id"),
    @NamedQuery(name = "Times.findByNome", query = "SELECT t FROM Times t WHERE t.nome = :nome"),
    @NamedQuery(name = "Times.findByCidade", query = "SELECT t FROM Times t WHERE t.cidade = :cidade"),
    @NamedQuery(name = "Times.findByUf", query = "SELECT t FROM Times t WHERE t.uf = :uf")})

public class Times implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UF")
    private String uf;

    public Times() {
    }

    public Times(Integer id) {
        this.id = id;
    }

    public Times(Integer id, String nome, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Times)) {
            return false;
        }
        Times other = (Times) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.edu.mouralacerda.futeboldahora.modelo.Times[ id=" + id + " ]";
    }
    
}
