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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pena")
@NamedQueries({
    @NamedQuery(name = "Pena.findAll", query = "SELECT p FROM Pena p")
    , @NamedQuery(name = "Pena.findById", query = "SELECT p FROM Pena p WHERE p.id = :id")
    , @NamedQuery(name = "Pena.findByPenaPrision", query = "SELECT p FROM Pena p WHERE p.penaPrision = :penaPrision")
    , @NamedQuery(name = "Pena.findByPenaMulta", query = "SELECT p FROM Pena p WHERE p.penaMulta = :penaMulta")
    , @NamedQuery(name = "Pena.findByProcesoRequerido", query = "SELECT p FROM Pena p WHERE p.procesoRequerido = :procesoRequerido")})
@XmlRootElement
public class Pena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "pena_prision")
    private String penaPrision;
    @Column(name = "pena_multa")
    private Integer penaMulta;
    @Column(name = "procesoRequerido")
    private Integer procesoRequerido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "penaId")
    private List<PenaDelitos> penaDelitosList;
    @JoinColumn(name = "Condenados_identificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false)
    private Condenados condenadosidentificacion;
    @JoinColumn(name = "Procesos_NI", referencedColumnName = "NI")
    @ManyToOne(optional = false)
    private Procesos procesosNI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "penaId")
    private List<SituacionJuridica> situacionJuridicaList;

    public Pena() {
    }

    public Pena(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPenaPrision() {
        return penaPrision;
    }

    public void setPenaPrision(String penaPrision) {
        this.penaPrision = penaPrision;
    }

    public Integer getPenaMulta() {
        return penaMulta;
    }

    public void setPenaMulta(Integer penaMulta) {
        this.penaMulta = penaMulta;
    }

    public Integer getProcesoRequerido() {
        return procesoRequerido;
    }

    public void setProcesoRequerido(Integer procesoRequerido) {
        this.procesoRequerido = procesoRequerido;
    }

    @XmlTransient
    public List<PenaDelitos> getPenaDelitosList() {
        return penaDelitosList;
    }

    public void setPenaDelitosList(List<PenaDelitos> penaDelitosList) {
        this.penaDelitosList = penaDelitosList;
    }

    public Condenados getCondenadosidentificacion() {
        return condenadosidentificacion;
    }

    public void setCondenadosidentificacion(Condenados condenadosidentificacion) {
        this.condenadosidentificacion = condenadosidentificacion;
    }

    public Procesos getProcesosNI() {
        return procesosNI;
    }

    public void setProcesosNI(Procesos procesosNI) {
        this.procesosNI = procesosNI;
    }

    @XmlTransient
    public List<SituacionJuridica> getSituacionJuridicaList() {
        return situacionJuridicaList;
    }

    public void setSituacionJuridicaList(List<SituacionJuridica> situacionJuridicaList) {
        this.situacionJuridicaList = situacionJuridicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pena)) {
            return false;
        }
        Pena other = (Pena) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Pena[ id=" + id + " ]";
    }
    
}
