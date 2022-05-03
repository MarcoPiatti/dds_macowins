package ar.edu.utn.frba.dds.macowins;

class Tarjeta implements MedioDePago {
    Integer cuotas;
    Integer coeficiente;

    Tarjeta(Integer cuotas, Integer coeficiente) {
        this.cuotas = cuotas;
        this.coeficiente = coeficiente;
    }

    public Double precioConRecargo(Double precio) {
        return precio + cuotas * coeficiente + 0.01 * precio;
    }
}
