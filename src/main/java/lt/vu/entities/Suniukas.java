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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Suniukas")
@NamedQueries({
    @NamedQuery(name = "Suniukas.findAll", query = "SELECT s FROM Suniukas s")
    , @NamedQuery(name = "Suniukas.findByGyvunoID", query = "SELECT s FROM Suniukas s WHERE s.gyvunoID = :gyvunoID")
    , @NamedQuery(name = "Suniukas.findByVardas", query = "SELECT s FROM Suniukas s WHERE s.vardas = :vardas")
    , @NamedQuery(name = "Suniukas.findByVeisle", query = "SELECT s FROM Suniukas s WHERE s.veisle = :veisle")})
@EqualsAndHashCode(of = "gyvunoID")
@ToString(of = "gyvunoID")
public class Suniukas implements Serializable {

    //TODO Lombok
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GyvunoID")
    @Getter @Setter
    private String gyvunoID;
    @Column(name = "Vardas")
    @Getter @Setter
    private String vardas;
    @Column(name = "Veisle")
    @Getter @Setter
    private String veisle;
    @ManyToMany(mappedBy = "suniukasList")
    @Getter @Setter
    private List<Darbuotojas> darbuotojasList;
    @JoinColumn(name = "Viesbutis", referencedColumnName = "Kodas")
    @ManyToOne
    @Getter @Setter
    private Viesbutis viesbutis;

//    public Suniukas() {
//    }
//
//    public Suniukas(String gyvunoID) {
//        this.gyvunoID = gyvunoID;
//    }
//
//    public String getGyvunoID() {
//        return gyvunoID;
//    }
//
//    public void setGyvunoID(String gyvunoID) {
//        this.gyvunoID = gyvunoID;
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
//    public String getVeisle() {
//        return veisle;
//    }
//
//    public void setVeisle(String veisle) {
//        this.veisle = veisle;
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
//    public Viesbutis getViesbutis() {
//        return viesbutis;
//    }
//
//    public void setViesbutis(Viesbutis viesbutis) {
//        this.viesbutis = viesbutis;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (gyvunoID != null ? gyvunoID.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Suniukas)) {
//            return false;
//        }
//        Suniukas other = (Suniukas) object;
//        if ((this.gyvunoID == null && other.gyvunoID != null) || (this.gyvunoID != null && !this.gyvunoID.equals(other.gyvunoID))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "lt.vu.entities.Suniukas[ gyvunoID=" + gyvunoID + " ]";
//    }
    
}
