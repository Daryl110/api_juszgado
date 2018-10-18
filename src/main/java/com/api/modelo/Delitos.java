/*
 *  2018 Daryl Ospina
 */
package com.api.modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "delitos")
@NamedQueries({
    @NamedQuery(name = "Delitos.findAll", query = "SELECT d FROM Delitos d")
    , @NamedQuery(name = "Delitos.findByIdDelitos", query = "SELECT d FROM Delitos d WHERE d.idDelitos = :idDelitos")
    , @NamedQuery(name = "Delitos.findByDescripcion", query = "SELECT d FROM Delitos d WHERE d.descripcion = :descripcion")})
@XmlRootElement
public class Delitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDelitos")
    private Integer idDelitos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delitosidDelitos")
    private List<PenaDelitos> penaDelitosList;

    public Delitos() {
    }

    public Delitos(Integer idDelitos) {
        this.idDelitos = idDelitos;
    }

    public Delitos(Integer idDelitos, String descripcion) {
        this.idDelitos = idDelitos;
        this.descripcion = descripcion;
    }

    public Integer getIdDelitos() {
        return idDelitos;
    }

    public void setIdDelitos(Integer idDelitos) {
        this.idDelitos = idDelitos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PenaDelitos> getPenaDelitosList() {
        return penaDelitosList;
    }

    public void setPenaDelitosList(List<PenaDelitos> penaDelitosList) {
        this.penaDelitosList = penaDelitosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelitos != null ? idDelitos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delitos)) {
            return false;
        }
        Delitos other = (Delitos) object;
        if ((this.idDelitos == null && other.idDelitos != null) || (this.idDelitos != null && !this.idDelitos.equals(other.idDelitos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Delitos[ idDelitos=" + idDelitos + " ]";
    }
    
}
