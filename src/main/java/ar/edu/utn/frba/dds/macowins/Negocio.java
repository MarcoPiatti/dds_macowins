package ar.edu.utn.frba.dds.macowins;

import java.util.Collection;
import java.time.LocalDate;

public class Negocio {
    Collection<Venta> ventas;

    Negocio(Collection<Venta> ventas) {
        this.ventas = ventas;
    }

    Double gananciaPorFecha(LocalDate fecha){
        return ventas.stream().filter(v -> v.fecha.equals(fecha)).mapToDouble(v -> v.ganancia()).sum();
    }

    void registrar(Venta venta) {
        ventas.add(venta);
    }
}