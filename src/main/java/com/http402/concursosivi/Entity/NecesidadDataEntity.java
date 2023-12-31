package com.http402.concursosivi.Entity;

import jakarta.persistence.*;

@Entity
public class NecesidadDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombreSolicitante;
    private String rutSolicitante;
    private String correo;
    private String tituloNecesidad;
    @Column(length = 1000)
    private String descripcionNecesidad;
    private String Categoria;
    private String tipoEntidad;
    private String comuna;
    private String palabrasClave;
    private String objetivosDS;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    private String imagen;

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(String rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTituloNecesidad() {
        return tituloNecesidad;
    }

    public void setTituloNecesidad(String tituloNecesidad) {
        this.tituloNecesidad = tituloNecesidad;
    }

    public String getDescripcionNecesidad() {
        return descripcionNecesidad;
    }

    public void setDescripcionNecesidad(String descripcionNecesidad) {
        this.descripcionNecesidad = descripcionNecesidad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getObjetivosDS() {
        return objetivosDS;
    }

    public void setObjetivosDS(String objetivosDS) {
        this.objetivosDS = objetivosDS;
    }
}
