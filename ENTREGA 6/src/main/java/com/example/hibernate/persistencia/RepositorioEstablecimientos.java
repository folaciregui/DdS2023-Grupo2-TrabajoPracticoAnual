package com.example.hibernate.persistencia;

import com.example.hibernate.dominio.Entidad;
import com.example.hibernate.dominio.Establecimiento;
import com.example.hibernate.dominio.TipoMedio;
import com.example.hibernate.dominio.TipoSucursal;

import java.util.List;

import static java.util.Arrays.asList;

public class RepositorioEstablecimientos {
    public List<Establecimiento> obtenerTodas() {
        Establecimiento establecimientoUno = new Establecimiento();
        establecimientoUno.setId_establecimiento(1L);
        establecimientoUno.setNombre("Establecimiento1");
        establecimientoUno.setTipoEstablecimiento("Negocio");
        establecimientoUno.setTipoSucursal(TipoSucursal.SUPERMERCADO);

        Establecimiento establecimientoDos = new Establecimiento();
        establecimientoDos.setId_establecimiento(2L);
        establecimientoDos.setNombre("Establecimiento2");
        establecimientoDos.setTipoEstablecimiento("Negocio");
        establecimientoDos.setTipoSucursal(TipoSucursal.SUPERMERCADO);

        return asList(establecimientoUno, establecimientoDos);
    }
}
