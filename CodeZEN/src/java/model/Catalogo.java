/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcreddiga
 */
@Entity
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c"),
    @NamedQuery(name = "Catalogo.findByNome", query = "SELECT c FROM Catalogo c WHERE c.nome = :nome"),
    @NamedQuery(name = "Catalogo.findByVeiculoAplicacao", query = "SELECT c FROM Catalogo c WHERE c.veiculoAplicacao = :veiculoAplicacao"),
    @NamedQuery(name = "Catalogo.findByPesoLiquido", query = "SELECT c FROM Catalogo c WHERE c.pesoLiquido = :pesoLiquido"),
    @NamedQuery(name = "Catalogo.findByPesoBruto", query = "SELECT c FROM Catalogo c WHERE c.pesoBruto = :pesoBruto")})
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "veiculo_aplicacao")
    private String veiculoAplicacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_liquido")
    private Double pesoLiquido;
    @Column(name = "peso_bruto")
    private Double pesoBruto;

    public Catalogo() {
    }

    public Catalogo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculoAplicacao() {
        return veiculoAplicacao;
    }

    public void setVeiculoAplicacao(String veiculoAplicacao) {
        this.veiculoAplicacao = veiculoAplicacao;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Catalogo[ nome=" + nome + " ]";
    }
    
}
