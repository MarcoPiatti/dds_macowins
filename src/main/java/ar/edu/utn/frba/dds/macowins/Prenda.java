package ar.edu.utn.frba.dds.macowins;

import java.util.Objects;

class Prenda {
    Double precioBase;
    TipoPrenda tipo;
    EstadoPrenda estado;

    Prenda(Double precioBase, EstadoPrenda estado, TipoPrenda tipo) {
        this.precioBase = Objects.requireNonNull(precioBase, "El precio base de la prenda no puede ser nulo");
        this.estado = Objects.requireNonNull(estado, "El estado de la prenda no puede ser nulo");
        this.tipo = Objects.requireNonNull(tipo, "El tipo de la prenda no puede ser nulo");
    }
    
    TipoPrenda getTipo() {
        return this.tipo;
    }

    Double precio() {
        return estado.precioSegunEstado(precioBase);
    }
}