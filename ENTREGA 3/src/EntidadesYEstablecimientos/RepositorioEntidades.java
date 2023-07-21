package EntidadesYEstablecimientos;

import java.util.List;

public class RepositorioEntidades {
    private List<Entidad> entidades;

    public void altaEntidad(Entidad entidad){
        entidades.add(entidad);
    }

    public void bajaEntidad(Entidad entidad){
        entidades.remove(entidad);
    }
}