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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "pena_delitos")
@NamedQueries({
    @NamedQuery(name = "PenaDelitos.findAll", query = "SELECT p FROM PenaDelitos p")
    , @NamedQuery(name = "PenaDelitos.findById", query = "SELECT p FROM PenaDelitos p WHERE p.id = :id")})
@XmlRootElement
public class PenaDelitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "Delitos_idDelitos", referencedColumnName = "idDelitos")
    @ManyToOne(optional = false)
    private Delitos delitosidDelitos;
    @JoinColumn(name = "pena_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pena penaId;

    public PenaDelitos() {
    }

    public PenaDelitos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Delitos getDelitosidDelitos() {
        return delitosidDelitos;
    }

    public void setDelitosidDelitos(Delitos delitosidDelitos) {
        this.delitosidDelitos = delitosidDelitos;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PenaDelitos)) {
            return false;
        }
        PenaDelitos other = (PenaDelitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.modelo.PenaDelitos[ id=" + id + " ]";
    }
    
}
