package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Table(name = "persona") //opcional
public class UsuarioGeneral {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreoElectonico() {
        return correoElectonico;
    }

    public void setCorreoElectonico(String correoElectonico) {
        this.correoElectonico = correoElectonico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public TipoFrecuencia getFrecuenciaNotificacion() {
        return frecuenciaNotificacion;
    }

    public void setFrecuenciaNotificacion(TipoFrecuencia frecuenciaNotificacion) {
        this.frecuenciaNotificacion = frecuenciaNotificacion;
    }

    public Organizacion getEmpresaInteres() {
        return empresaInteres;
    }

    public void setEmpresaInteres(Organizacion empresaInteres) {
        this.empresaInteres = empresaInteres;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="correoElectronico")
    private String correoElectonico;
    @Column(name="apellido")
    private String apellido;
    @Column(name="nombre")
    private String nombre;
    @JoinColumn(name="cuenta")
    @OneToOne
    private Cuenta cuenta;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipoNotificacion;
    @Enumerated(EnumType.STRING)
    private TipoFrecuencia frecuenciaNotificacion;

    @OneToOne
    @JoinColumn(name="empresaPrestadora")
    private Organizacion empresaInteres;

}
