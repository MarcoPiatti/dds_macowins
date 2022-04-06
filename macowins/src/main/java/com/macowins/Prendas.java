package com.macowins;

interface EstadoPrenda {
    double modificarPrecio(double precioBase);
}

class PrendaNueva implements EstadoPrenda {
    public double modificarPrecio(double precioBase) {
        return precioBase;
    }
}

class Promocion implements EstadoPrenda {
    double porcentaje;

    Promocion(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double modificarPrecio(double precioBase) {
        return precioBase * (1 - porcentaje/100);
    }
}

class Liquidacion implements EstadoPrenda {
    public double modificarPrecio(double precioBase) {
        return precioBase * 0.5;
    }
}

enum TipoPrenda {
    CAMISA,
    PANTALON,
    SACO
}

class Prenda {
    double precioBase;
    TipoPrenda tipo;
    EstadoPrenda estado;

    Prenda(double precioBase, EstadoPrenda estado, TipoPrenda tipo) {
        this.precioBase = precioBase;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    String getTipo() {
        return tipo.toString();
    }

    double precioDeVenta() {
        return estado.modificarPrecio(precioBase);
    }
}