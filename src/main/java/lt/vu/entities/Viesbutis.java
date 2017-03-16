/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Viesbutis")
@NamedQueries({
    @NamedQuery(name = "Viesbutis.findAll", query = "SELECT v FROM Viesbutis v")
    , @NamedQuery(name = "Viesbutis.findByKodas", query = "SELECT v FROM Viesbutis v WHERE v.kodas = :kodas")
    , @NamedQuery(name = "Viesbutis.findByPavadinimas", query = "SELECT v FROM Viesbutis v WHERE v.pavadinimas = :pavadinimas")
    , @NamedQuery(name = "Viesbutis.findByAdresas", query = "SELECT v FROM Viesbutis v WHERE v.adresas = :adresas")})
@Getter @Setter
@EqualsAndHashCode(of = "kodas")
@ToString(of = "kodas")
public class Viesbutis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Kodas")
    private String kodas;
    @Basic(optional = false)
    @Column(name = "Pavadinimas")
    private String pavadinimas;
    @Basic(optional = false)
    @Column(name = "Adresas")
    private String adresas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viesbutis")
    private List<Darbuotojas> darbuotojasList;
    @OneToMany(mappedBy = "viesbutis")
    private List<Suniukas> suniukasList;

//    public Viesbutis() {
//    }
//
//    public Viesbutis(String kodas) {
//        this.kodas = kodas;
//    }
//
//    public Viesbutis(String kodas, String pavadinimas, String adresas) {
//        this.kodas = kodas;
//        this.pavadinimas = pavadinimas;
//        this.adresas = adresas;
//    }
//
//    public String getKodas() {
//        return kodas;
//    }
//
//    public void setKodas(String kodas) {
//        this.kodas = kodas;
//    }
//
//    public String getPavadinimas() {
//        return pavadinimas;
//    }
//
//    public void setPavadinimas(String pavadinimas) {
//        this.pavadinimas = pavadinimas;
//    }
//
//    public String getAdresas() {
//        return adresas;
//    }
//
//    public void setAdresas(String adresas) {
//        this.adresas = adresas;
//    }
//
//    public List<Darbuotojas> getDarbuotojasList() {
//        return darbuotojasList;
//    }
//
//    public void setDarbuotojasList(List<Darbuotojas> darbuotojasList) {
//        this.darbuotojasList = darbuotojasList;
//    }
//
//    public List<Suniukas> getSuniukasList() {
//        return suniukasList;
//    }
//
//    public void setSuniukasList(List<Suniukas> suniukasList) {
//        this.suniukasList = suniukasList;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (kodas != null ? kodas.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Viesbutis)) {
//            return false;
//        }
//        Viesbutis other = (Viesbutis) object;
//        if ((this.kodas == null && other.kodas != null) || (this.kodas != null && !this.kodas.equals(other.kodas))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "lt.vu.entities.Viesbutis[ kodas=" + kodas + " ]";
//    }
    
}
