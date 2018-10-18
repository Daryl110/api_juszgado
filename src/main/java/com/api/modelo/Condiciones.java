/*
 *  2018 Daryl Ospina
 */
package com.api.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "condiciones")
@NamedQueries({
    @NamedQuery(name = "Condiciones.findAll", query = "SELECT c FROM Condiciones c")
    , @NamedQuery(name = "Condiciones.findByIdcondiciones", query = "SELECT c FROM Condiciones c WHERE c.idcondiciones = :idcondiciones")
    , @NamedQuery(name = "Condiciones.findByText", query = "SELECT c FROM Condiciones c WHERE c.text = :text")})
@XmlRootElement
public class Condiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcondiciones")
    private Integer idcondiciones;
    @Size(max = 200)
    @Column(name = "text")
    private String text;
    @JoinColumn(name = "detenido_id_detenido_carcel", referencedColumnName = "id_detenido_carcel")
    @ManyToOne(optional = false)
    private SituacionJuridica detenidoIdDetenidoCarcel;

    public Condiciones() {
    }

    public Condiciones(Integer idcondiciones) {
        this.idcondiciones = idcondiciones;
    }

    public Integer getIdcondiciones() {
        return idcondiciones;
    }

    public void setIdcondiciones(Integer idcondiciones) {
        this.idcondiciones = idcondiciones;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SituacionJuridica getDetenidoIdDetenidoCarcel() {
        return detenidoIdDetenidoCarcel;
    }

    public void setDetenidoIdDetenidoCarcel(SituacionJuridica detenidoIdDetenidoCarcel) {
        this.detenidoIdDetenidoCarcel = detenidoIdDetenidoCarcel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcondiciones != null ? idcondiciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condiciones)) {
            return false;
        }
        Condiciones other = (Condiciones) object;
        if ((this.idcondiciones == null && other.idcondiciones != null) || (this.idcondiciones != null && !this.idcondiciones.equals(other.idcondiciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.Condiciones[ idcondiciones=" + idcondiciones + " ]";
    }
    
}
