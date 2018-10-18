/*
 *  2018 Daryl Ospina
 */
package com.api.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "caucion")
@NamedQueries({
    @NamedQuery(name = "Caucion.findAll", query = "SELECT c FROM Caucion c")
    , @NamedQuery(name = "Caucion.findByIdcaucion", query = "SELECT c FROM Caucion c WHERE c.idcaucion = :idcaucion")
    , @NamedQuery(name = "Caucion.findByNDeposito", query = "SELECT c FROM Caucion c WHERE c.nDeposito = :nDeposito")
    , @NamedQuery(name = "Caucion.findByValor", query = "SELECT c FROM Caucion c WHERE c.valor = :valor")
    , @NamedQuery(name = "Caucion.findByFechaDevolucion", query = "SELECT c FROM Caucion c WHERE c.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Caucion.findByPoliza", query = "SELECT c FROM Caucion c WHERE c.poliza = :poliza")})
@XmlRootElement
public class Caucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcaucion")
    private Integer idcaucion;
    @Column(name = "nDeposito")
    private Integer nDeposito;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "fechaDevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Size(max = 45)
    @Column(name = "poliza")
    private String poliza;
    @JoinColumn(name = "situacion_juridica_id_detenido_carcel", referencedColumnName = "id_detenido_carcel")
    @ManyToOne(optional = false)
    private SituacionJuridica situacionJuridicaIdDetenidoCarcel;

    public Caucion() {
    }

    public Caucion(Integer idcaucion) {
        this.idcaucion = idcaucion;
    }

    public Integer getIdcaucion() {
        return idcaucion;
    }

    public void setIdcaucion(Integer idcaucion) {
        this.idcaucion = idcaucion;
    }

    public Integer getNDeposito() {
        return nDeposito;
    }

    public void setNDeposito(Integer nDeposito) {
        this.nDeposito = nDeposito;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public SituacionJuridica getSituacionJuridicaIdDetenidoCarcel() {
        return situacionJuridicaIdDetenidoCarcel;
    }

    public void setSituacionJuridicaIdDetenidoCarcel(SituacionJuridica situacionJuridicaIdDetenidoCarcel) {
        this.situacionJuridicaIdDetenidoCarcel = situacionJuridicaIdDetenidoCarcel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaucion != null ? idcaucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caucion)) {
            return false;
        }
        Caucion other = (Caucion) object;
        if ((this.idcaucion == null && other.idcaucion != null) || (this.idcaucion != null && !this.idcaucion.equals(other.idcaucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Caucion[ idcaucion=" + idcaucion + " ]";
    }
    
}
