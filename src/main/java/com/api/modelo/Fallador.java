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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "fallador")
@NamedQueries({
    @NamedQuery(name = "Fallador.findAll", query = "SELECT f FROM Fallador f")
    , @NamedQuery(name = "Fallador.findByIdFallador", query = "SELECT f FROM Fallador f WHERE f.idFallador = :idFallador")
    , @NamedQuery(name = "Fallador.findByDescripcion", query = "SELECT f FROM Fallador f WHERE f.descripcion = :descripcion")})
@XmlRootElement
public class Fallador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFallador")
    private Integer idFallador;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fallador1")
    private List<Procesos> procesosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "falladoridFallador1")
    private List<Procesos> procesosList1;

    public Fallador() {
    }

    public Fallador(Integer idFallador) {
        this.idFallador = idFallador;
    }

    public Integer getIdFallador() {
        return idFallador;
    }

    public void setIdFallador(Integer idFallador) {
        this.idFallador = idFallador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Procesos> getProcesosList() {
        return procesosList;
    }

    public void setProcesosList(List<Procesos> procesosList) {
        this.procesosList = procesosList;
    }

    @XmlTransient
    public List<Procesos> getProcesosList1() {
        return procesosList1;
    }

    public void setProcesosList1(List<Procesos> procesosList1) {
        this.procesosList1 = procesosList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFallador != null ? idFallador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fallador)) {
            return false;
        }
        Fallador other = (Fallador) object;
        if ((this.idFallador == null && other.idFallador != null) || (this.idFallador != null && !this.idFallador.equals(other.idFallador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Fallador[ idFallador=" + idFallador + " ]";
    }
    
}
