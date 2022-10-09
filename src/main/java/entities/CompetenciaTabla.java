/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author demozath
 */
@Entity
@Table(name = "competencia_tabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenciaTabla.findAll", query = "SELECT c FROM CompetenciaTabla c"),
    @NamedQuery(name = "CompetenciaTabla.findByRut", query = "SELECT c FROM CompetenciaTabla c WHERE c.rut = :rut"),
    @NamedQuery(name = "CompetenciaTabla.findByNombre", query = "SELECT c FROM CompetenciaTabla c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CompetenciaTabla.findByApellidoPaterno", query = "SELECT c FROM CompetenciaTabla c WHERE c.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "CompetenciaTabla.findByEdad", query = "SELECT c FROM CompetenciaTabla c WHERE c.edad = :edad"),
    @NamedQuery(name = "CompetenciaTabla.findByGenero", query = "SELECT c FROM CompetenciaTabla c WHERE c.genero = :genero"),
    @NamedQuery(name = "CompetenciaTabla.findByPeso", query = "SELECT c FROM CompetenciaTabla c WHERE c.peso = :peso")})
public class CompetenciaTabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rut")
    private String rut;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "apellido paterno")
    private String apellidoPaterno;
    @Size(max = 2147483647)
    @Column(name = "edad")
    private String edad;
    @Size(max = 2147483647)
    @Column(name = "genero")
    private String genero;
    @Size(max = 2147483647)
    @Column(name = "peso")
    private String peso;

    public CompetenciaTabla() {
    }

    public CompetenciaTabla(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenciaTabla)) {
            return false;
        }
        CompetenciaTabla other = (CompetenciaTabla) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompetenciaTabla[ rut=" + rut + " ]";
    }
    
}
