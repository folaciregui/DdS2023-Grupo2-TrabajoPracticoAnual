public class UsuarioEmpresarial extends UsuarioGeneral{
    private TipoDeNotificacion tipoDeNotificacion;
    private FrecuenciaDeNotificacion frecuenciaDeNotificacion;
    public UsuarioEmpresarial(String nombre, String apellido, Cuenta cuenta, String correoElectronico, TipoDeNotificacion tipoNotif, FrecuenciaDeNotificacion frecNotif) {
        super(nombre, apellido, cuenta, correoElectronico);
        this.setTipoDeNotificacion(tipoNotif);
        this.setFrecuenciaDeNotificacion(frecNotif);
    }

    public void setTipoDeNotificacion(TipoDeNotificacion tipoDeNotificacion) {
        this.tipoDeNotificacion = tipoDeNotificacion;
    }

    public void setFrecuenciaDeNotificacion(FrecuenciaDeNotificacion frecuenciaDeNotificacion) {
        this.frecuenciaDeNotificacion = frecuenciaDeNotificacion;
    }

}
