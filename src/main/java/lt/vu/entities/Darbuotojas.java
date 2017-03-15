/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Darbuotojas")
@NamedQueries({
    @NamedQuery(name = "Darbuotojas.findAll", query = "SELECT d FROM Darbuotojas d")
    , @NamedQuery(name = "Darbuotojas.findById", query = "SELECT d FROM Darbuotojas d WHERE d.id = :id")
    , @NamedQuery(name = "Darbuotojas.findByVardas", query = "SELECT d FROM Darbuotojas d WHERE d.vardas = :vardas")
    , @NamedQuery(name = "Darbuotojas.findByPavarde", query = "SELECT d FROM Darbuotojas d WHERE d.pavarde = :pavarde")
    , @NamedQuery(name = "Darbuotojas.findByPareigos", query = "SELECT d FROM Darbuotojas d WHERE d.pareigos = :pareigos")})
@Getter @Setter
public class Darbuotojas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "Vardas")
    private String vardas;
    @Basic(optional = false)
    @Column(name = "Pavarde")
    private String pavarde;
    @Basic(optional = false)
    @Column(name = "Pareigos")
    private String pareigos;
    @JoinTable(name = "Darbuotoju_Suniuku_Sarasas", joinColumns = {
        @JoinColumn(name = "DarbuotojoID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SuniukoID", referencedColumnName = "GyvunoID")})
    @ManyToMany
    private List<Suniukas> suniukasList;
    @JoinColumn(name = "Viesbutis", referencedColumnName = "Kodas")
    @ManyToOne(optional = false)
    private Viesbutis viesbutis;

//    public Darbuotojas() {
//    }
//
//    public Darbuotojas(String id) {
//        this.id = id;
//    }
//
//    public Darbuotojas(String id, String vardas, String pavarde, String pareigos) {
//        this.id = id;
//        this.vardas = vardas;
//        this.pavarde = pavarde;
//        this.pareigos = pareigos;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getVardas() {
//        return vardas;
//    }
//
//    public void setVardas(String vardas) {
//        this.vardas = vardas;
//    }
//
//    public String getPavarde() {
//        return pavarde;
//    }
//
//    public void setPavarde(String pavarde) {
//        this.pavarde = pavarde;
//    }
//
//    public String getPareigos() {
//        return pareigos;
//    }
//
//    public void setPareigos(String pareigos) {
//        this.pareigos = pareigos;
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
//    public Viesbutis getViesbutis() {
//        return viesbutis;
//    }
//
//    public void setViesbutis(Viesbutis viesbutis) {
//        this.viesbutis = viesbutis;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Darbuotojas)) {
            return false;
        }
        Darbuotojas other = (Darbuotojas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.Darbuotojas[ id=" + id + " ]";
    }
    
}
