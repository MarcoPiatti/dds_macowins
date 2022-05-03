package ar.edu.utn.frba.dds.macowins;

import java.util.Collection;
import java.time.LocalDate;

class Venta {
    LocalDate fecha;
    MedioDePago medioDePago;
    Collection<ArticuloVenta> articulos;

    Venta(LocalDate fecha, MedioDePago medioDePago, Collection<ArticuloVenta> articulos) {
        this.fecha = fecha;
        this.medioDePago = medioDePago;
        this.articulos = articulos;
    }

    Double ganancia() {
        Double gananciaBase = articulos.stream().mapToDouble(a -> a.precio()).sum();
        return medioDePago.precioConRecargo(gananciaBase);
    }
}