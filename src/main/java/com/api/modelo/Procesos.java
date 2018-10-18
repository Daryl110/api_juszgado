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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "procesos")
@NamedQueries({
    @NamedQuery(name = "Procesos.findAll", query = "SELECT p FROM Procesos p")
    , @NamedQuery(name = "Procesos.findByNi", query = "SELECT p FROM Procesos p WHERE p.ni = :ni")
    , @NamedQuery(name = "Procesos.findByFechaReparto", query = "SELECT p FROM Procesos p WHERE p.fechaReparto = :fechaReparto")
    , @NamedQuery(name = "Procesos.findByFechaIngreso", query = "SELECT p FROM Procesos p WHERE p.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Procesos.findByNumero", query = "SELECT p FROM Procesos p WHERE p.numero = :numero")
    , @NamedQuery(name = "Procesos.findByNumeroCuadernos", query = "SELECT p FROM Procesos p WHERE p.numeroCuadernos = :numeroCuadernos")
    , @NamedQuery(name = "Procesos.findByFechaSentencia", query = "SELECT p FROM Procesos p WHERE p.fechaSentencia = :fechaSentencia")
    , @NamedQuery(name = "Procesos.findByFechaSentencia2", query = "SELECT p FROM Procesos p WHERE p.fechaSentencia2 = :fechaSentencia2")})
@XmlRootElement
public class Procesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NI")
    private Integer ni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaReparto")
    @Temporal(TemporalType.DATE)
    private Date fechaReparto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroCuadernos")
    private int numeroCuadernos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSentencia")
    @Temporal(TemporalType.DATE)
    private Date fechaSentencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSentencia2")
    @Temporal(TemporalType.DATE)
    private Date fechaSentencia2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesosNI")
    private List<Pena> penaList;
    @JoinColumn(name = "Fallador1", referencedColumnName = "idFallador")
    @ManyToOne(optional = false)
    private Fallador fallador1;
    @JoinColumn(name = "Fallador_idFallador1", referencedColumnName = "idFallador")
    @ManyToOne(optional = false)
    private Fallador falladoridFallador1;
    @JoinColumn(name = "Ofendidos_idOfendidos", referencedColumnName = "idOfendidos")
    @ManyToOne(optional = false)
    private Ofendidos ofendidosidOfendidos;

    public Procesos() {
    }

    public Procesos(Integer ni) {
        this.ni = ni;
    }

    public Procesos(Integer ni, Date fechaReparto, Date fechaIngreso, String numero, int numeroCuadernos, Date fechaSentencia, Date fechaSentencia2) {
        this.ni = ni;
        this.fechaReparto = fechaReparto;
        this.fechaIngreso = fechaIngreso;
        this.numero = numero;
        this.numeroCuadernos = numeroCuadernos;
        this.fechaSentencia = fechaSentencia;
        this.fechaSentencia2 = fechaSentencia2;
    }

    public Integer getNi() {
        return ni;
    }

    public void setNi(Integer ni) {
        this.ni = ni;
    }

    public Date getFechaReparto() {
        return fechaReparto;
    }

    public void setFechaReparto(Date fechaReparto) {
        this.fechaReparto = fechaReparto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNumeroCuadernos() {
        return numeroCuadernos;
    }

    public void setNumeroCuadernos(int numeroCuadernos) {
        this.numeroCuadernos = numeroCuadernos;
    }

    public Date getFechaSentencia() {
        return fechaSentencia;
    }

    public void setFechaSentencia(Date fechaSentencia) {
        this.fechaSentencia = fechaSentencia;
    }

    public Date getFechaSentencia2() {
        return fechaSentencia2;
    }

    public void setFechaSentencia2(Date fechaSentencia2) {
        this.fechaSentencia2 = fechaSentencia2;
    }

    @XmlTransient
    public List<Pena> getPenaList() {
        return penaList;
    }

    public void setPenaList(List<Pena> penaList) {
        this.penaList = penaList;
    }

    public Fallador getFallador1() {
        return fallador1;
    }

    public void setFallador1(Fallador fallador1) {
        this.fallador1 = fallador1;
    }

    public Fallador getFalladoridFallador1() {
        return falladoridFallador1;
    }

    public void setFalladoridFallador1(Fallador falladoridFallador1) {
        this.falladoridFallador1 = falladoridFallador1;
    }

    public Ofendidos getOfendidosidOfendidos() {
        return ofendidosidOfendidos;
    }

    public void setOfendidosidOfendidos(Ofendidos ofendidosidOfendidos) {
        this.ofendidosidOfendidos = ofendidosidOfendidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ni != null ? ni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesos)) {
            return false;
        }
        Procesos other = (Procesos) object;
        if ((this.ni == null && other.ni != null) || (this.ni != null && !this.ni.equals(other.ni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Procesos[ ni=" + ni + " ]";
    }
    
}
