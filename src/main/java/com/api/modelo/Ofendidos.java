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
@Table(name = "ofendidos")
@NamedQueries({
    @NamedQuery(name = "Ofendidos.findAll", query = "SELECT o FROM Ofendidos o")
    , @NamedQuery(name = "Ofendidos.findByIdOfendidos", query = "SELECT o FROM Ofendidos o WHERE o.idOfendidos = :idOfendidos")
    , @NamedQuery(name = "Ofendidos.findByDescripcion", query = "SELECT o FROM Ofendidos o WHERE o.descripcion = :descripcion")})
@XmlRootElement
public class Ofendidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfendidos")
    private Integer idOfendidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofendidosidOfendidos")
    private List<Procesos> procesosList;

    public Ofendidos() {
    }

    public Ofendidos(Integer idOfendidos) {
        this.idOfendidos = idOfendidos;
    }

    public Ofendidos(Integer idOfendidos, String descripcion) {
        this.idOfendidos = idOfendidos;
        this.descripcion = descripcion;
    }

    public Integer getIdOfendidos() {
        return idOfendidos;
    }

    public void setIdOfendidos(Integer idOfendidos) {
        this.idOfendidos = idOfendidos;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfendidos != null ? idOfendidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofendidos)) {
            return false;
        }
        Ofendidos other = (Ofendidos) object;
        if ((this.idOfendidos == null && other.idOfendidos != null) || (this.idOfendidos != null && !this.idOfendidos.equals(other.idOfendidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Ofendidos[ idOfendidos=" + idOfendidos + " ]";
    }
    
}
