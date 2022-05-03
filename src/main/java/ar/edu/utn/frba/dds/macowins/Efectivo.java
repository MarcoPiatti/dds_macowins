package ar.edu.utn.frba.dds.macowins;

class Efectivo implements MedioDePago {
    public Double precioConRecargo(Double precio) {
        return precio;
    }
}
