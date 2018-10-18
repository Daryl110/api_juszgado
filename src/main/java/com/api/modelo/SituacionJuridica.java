/*
 *  2018 Daryl Ospina
 */
package com.api.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "situacion_juridica")
@NamedQueries({
    @NamedQuery(name = "SituacionJuridica.findAll", query = "SELECT s FROM SituacionJuridica s")
    , @NamedQuery(name = "SituacionJuridica.findByIdDetenidoCarcel", query = "SELECT s FROM SituacionJuridica s WHERE s.idDetenidoCarcel = :idDetenidoCarcel")
    , @NamedQuery(name = "SituacionJuridica.findByFechaCaptura", query = "SELECT s FROM SituacionJuridica s WHERE s.fechaCaptura = :fechaCaptura")
    , @NamedQuery(name = "SituacionJuridica.findByDiasAdicionalesDetencion", query = "SELECT s FROM SituacionJuridica s WHERE s.diasAdicionalesDetencion = :diasAdicionalesDetencion")
    , @NamedQuery(name = "SituacionJuridica.findByCarcel", query = "SELECT s FROM SituacionJuridica s WHERE s.carcel = :carcel")
    , @NamedQuery(name = "SituacionJuridica.findByObservaciones", query = "SELECT s FROM SituacionJuridica s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "SituacionJuridica.findByLugarCumplimiento", query = "SELECT s FROM SituacionJuridica s WHERE s.lugarCumplimiento = :lugarCumplimiento")
    , @NamedQuery(name = "SituacionJuridica.findByFolio", query = "SELECT s FROM SituacionJuridica s WHERE s.folio = :folio")
    , @NamedQuery(name = "SituacionJuridica.findByTipo", query = "SELECT s FROM SituacionJuridica s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "SituacionJuridica.findByEstado", query = "SELECT s FROM SituacionJuridica s WHERE s.estado = :estado")
    , @NamedQuery(name = "SituacionJuridica.findByFechaFinalizacion", query = "SELECT s FROM SituacionJuridica s WHERE s.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "SituacionJuridica.findByFechaExtincion", query = "SELECT s FROM SituacionJuridica s WHERE s.fechaExtincion = :fechaExtincion")})
@XmlRootElement
public class SituacionJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detenido_carcel")
    private Integer idDetenidoCarcel;
    @Column(name = "fecha_captura")
    @Temporal(TemporalType.DATE)
    private Date fechaCaptura;
    @Size(max = 45)
    @Column(name = "dias_adicionales_detencion")
    private String diasAdicionalesDetencion;
    @Size(max = 200)
    @Column(name = "carcel")
    private String carcel;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 100)
    @Column(name = "lugar_cumplimiento")
    private String lugarCumplimiento;
    @Size(max = 100)
    @Column(name = "folio")
    private String folio;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaFinalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Column(name = "fechaExtincion")
    @Temporal(TemporalType.DATE)
    private Date fechaExtincion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacionJuridicaIdDetenidoCarcel")
    private List<Caucion> caucionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detenidoCarcelIdDetenidoCarcel")
    private List<RedencionPenas> redencionPenasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detenidoIdDetenidoCarcel")
    private List<Condiciones> condicionesList;
    @JoinColumn(name = "pena_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pena penaId;

    public SituacionJuridica() {
    }

    public SituacionJuridica(Integer idDetenidoCarcel) {
        this.idDetenidoCarcel = idDetenidoCarcel;
    }

    public Integer getIdDetenidoCarcel() {
        return idDetenidoCarcel;
    }

    public void setIdDetenidoCarcel(Integer idDetenidoCarcel) {
        this.idDetenidoCarcel = idDetenidoCarcel;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getDiasAdicionalesDetencion() {
        return diasAdicionalesDetencion;
    }

    public void setDiasAdicionalesDetencion(String diasAdicionalesDetencion) {
        this.diasAdicionalesDetencion = diasAdicionalesDetencion;
    }

    public String getCarcel() {
        return carcel;
    }

    public void setCarcel(String carcel) {
        this.carcel = carcel;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getLugarCumplimiento() {
        return lugarCumplimiento;
    }

    public void setLugarCumplimiento(String lugarCumplimiento) {
        this.lugarCumplimiento = lugarCumplimiento;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Date getFechaExtincion() {
        return fechaExtincion;
    }

    public void setFechaExtincion(Date fechaExtincion) {
        this.fechaExtincion = fechaExtincion;
    }

    @XmlTransient
    public List<Caucion> getCaucionList() {
        return caucionList;
    }

    public void setCaucionList(List<Caucion> caucionList) {
        this.caucionList = caucionList;
    }

    @XmlTransient
    public List<RedencionPenas> getRedencionPenasList() {
        return redencionPenasList;
    }

    public void setRedencionPenasList(List<RedencionPenas> redencionPenasList) {
        this.redencionPenasList = redencionPenasList;
    }

    @XmlTransient
    public List<Condiciones> getCondicionesList() {
        return condicionesList;
    }

    public void setCondicionesList(List<Condiciones> condicionesList) {
        this.condicionesList = condicionesList;
    }

    public Pena getPenaId() {
        return penaId;
    }

    public void setPenaId(Pena penaId) {
        this.penaId = penaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetenidoCarcel != null ? idDetenidoCarcel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionJuridica)) {
            return false;
        }
        SituacionJuridica other = (SituacionJuridica) object;
        if ((this.idDetenidoCarcel == null && other.idDetenidoCarcel != null) || (this.idDetenidoCarcel != null && !this.idDetenidoCarcel.equals(other.idDetenidoCarcel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.SituacionJuridica[ idDetenidoCarcel=" + idDetenidoCarcel + " ]";
    }
    
}
