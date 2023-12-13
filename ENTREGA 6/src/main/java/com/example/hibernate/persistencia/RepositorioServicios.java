package com.example.hibernate.persistencia;

import com.example.hibernate.dominio.Entidad;
import com.example.hibernate.dominio.TipoMedio;
import com.example.hibernate.dominio.Servicio;
import com.example.hibernate.dominio.Tramo;
import java.util.List;

import static java.util.Arrays.asList;
public class RepositorioServicios {
    public List<Servicio> obtenerTodas() {
        Servicio servicioUno = new Servicio();
        servicioUno.setId(1L);
        servicioUno.setNombre("Servicio1");
        Tramo tramo1 = new Tramo();
        servicioUno.setTramo(tramo1);

        Servicio servicioDos = new Servicio();
        servicioDos.setId(2L);
        servicioDos.setNombre("Servicio2");
        Tramo tramo2 = new Tramo();
        servicioUno.setTramo(tramo2);

        return asList(servicioUno, servicioDos);
    }
}
