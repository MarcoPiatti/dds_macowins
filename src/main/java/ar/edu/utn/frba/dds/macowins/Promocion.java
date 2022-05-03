package ar.edu.utn.frba.dds.macowins;

class Promocion implements EstadoPrenda {
    Double precioDescontado;

    Promocion(Double precioDescontado) {
        this.precioDescontado = precioDescontado;
    }

    public Double precioSegunEstado(Double precioBase) {
        return Math.max(precioBase - precioDescontado, 0);
    }
}
