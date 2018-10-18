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
@Table(name = "condenados")
@NamedQueries({
    @NamedQuery(name = "Condenados.findAll", query = "SELECT c FROM Condenados c")
    , @NamedQuery(name = "Condenados.findByIdentificacion", query = "SELECT c FROM Condenados c WHERE c.identificacion = :identificacion")
    , @NamedQuery(name = "Condenados.findByNombreCondenado", query = "SELECT c FROM Condenados c WHERE c.nombreCondenado = :nombreCondenado")
    , @NamedQuery(name = "Condenados.findByProcesosAcumulados", query = "SELECT c FROM Condenados c WHERE c.procesosAcumulados = :procesosAcumulados")})
@XmlRootElement
public class Condenados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificacion")
    private Integer identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreCondenado")
    private String nombreCondenado;
    @Size(max = 45)
    @Column(name = "procesosAcumulados")
    private String procesosAcumulados;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condenadosidentificacion")
    private List<Pena> penaList;

    public Condenados() {
    }

    public Condenados(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Condenados(Integer identificacion, String nombreCondenado) {
        this.identificacion = identificacion;
        this.nombreCondenado = nombreCondenado;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCondenado() {
        return nombreCondenado;
    }

    public void setNombreCondenado(String nombreCondenado) {
        this.nombreCondenado = nombreCondenado;
    }

    public String getProcesosAcumulados() {
        return procesosAcumulados;
    }

    public void setProcesosAcumulados(String procesosAcumulados) {
        this.procesosAcumulados = procesosAcumulados;
    }

    @XmlTransient
    public List<Pena> getPenaList() {
        return penaList;
    }

    public void setPenaList(List<Pena> penaList) {
        this.penaList = penaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condenados)) {
            return false;
        }
        Condenados other = (Condenados) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Condenados[ identificacion=" + identificacion + " ]";
    }
    
}
