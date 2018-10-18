/*
 *  2018 Daryl Ospina
 */
package com.api.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "redencion_penas")
@NamedQueries({
    @NamedQuery(name = "RedencionPenas.findAll", query = "SELECT r FROM RedencionPenas r")
    , @NamedQuery(name = "RedencionPenas.findByIdredencionPenas", query = "SELECT r FROM RedencionPenas r WHERE r.idredencionPenas = :idredencionPenas")
    , @NamedQuery(name = "RedencionPenas.findBySancion", query = "SELECT r FROM RedencionPenas r WHERE r.sancion = :sancion")
    , @NamedQuery(name = "RedencionPenas.findByFechaEjecutoria", query = "SELECT r FROM RedencionPenas r WHERE r.fechaEjecutoria = :fechaEjecutoria")
    , @NamedQuery(name = "RedencionPenas.findByDias", query = "SELECT r FROM RedencionPenas r WHERE r.dias = :dias")})
@XmlRootElement
public class RedencionPenas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idredencion_penas")
    private Integer idredencionPenas;
    @Size(max = 100)
    @Column(name = "sancion")
    private String sancion;
    @Column(name = "fecha_ejecutoria")
    @Temporal(TemporalType.DATE)
    private Date fechaEjecutoria;
    @Size(max = 45)
    @Column(name = "dias")
    private String dias;
    @JoinColumn(name = "detenido_carcel_id_detenido_carcel", referencedColumnName = "id_detenido_carcel")
    @ManyToOne(optional = false)
    private SituacionJuridica detenidoCarcelIdDetenidoCarcel;

    public RedencionPenas() {
    }

    public RedencionPenas(Integer idredencionPenas) {
        this.idredencionPenas = idredencionPenas;
    }

    public Integer getIdredencionPenas() {
        return idredencionPenas;
    }

    public void setIdredencionPenas(Integer idredencionPenas) {
        this.idredencionPenas = idredencionPenas;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public Date getFechaEjecutoria() {
        return fechaEjecutoria;
    }

    public void setFechaEjecutoria(Date fechaEjecutoria) {
        this.fechaEjecutoria = fechaEjecutoria;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public SituacionJuridica getDetenidoCarcelIdDetenidoCarcel() {
        return detenidoCarcelIdDetenidoCarcel;
    }

    public void setDetenidoCarcelIdDetenidoCarcel(SituacionJuridica detenidoCarcelIdDetenidoCarcel) {
        this.detenidoCarcelIdDetenidoCarcel = detenidoCarcelIdDetenidoCarcel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idredencionPenas != null ? idredencionPenas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedencionPenas)) {
            return false;
        }
        RedencionPenas other = (RedencionPenas) object;
        if ((this.idredencionPenas == null && other.idredencionPenas != null) || (this.idredencionPenas != null && !this.idredencionPenas.equals(other.idredencionPenas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.RedencionPenas[ idredencionPenas=" + idredencionPenas + " ]";
    }
    
}
