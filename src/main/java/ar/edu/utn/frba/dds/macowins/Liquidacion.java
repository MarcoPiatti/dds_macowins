package ar.edu.utn.frba.dds.macowins;

class Liquidacion implements EstadoPrenda {
    public Double precioSegunEstado(Double precioBase) {
        return precioBase * 0.5;
    }
}