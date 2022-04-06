package com.macowins;

import java.util.Collection;
import java.util.ArrayList;
import java.time.LocalDate;

class ArticuloVenta {
    Prenda prenda;
    int cantidad;

    ArticuloVenta(Prenda prenda, int cantidad) {
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    double precio() {
        return prenda.precioDeVenta() * cantidad;
    }
}

interface MedioDePago {
    double modificarVenta(double precio);
}

class Efectivo implements MedioDePago {
    public double modificarVenta(double precio) {
        return precio;
    }
}

class Tarjeta implements MedioDePago {
    int cuotas;
    int coeficiente;

    Tarjeta(int cuotas, int coeficiente) {
        this.cuotas = cuotas;
        this.coeficiente = coeficiente;
    }

    public double modificarVenta(double precio) {
        return precio + cuotas * coeficiente + 0.01 * precio;
    }
}

class Venta {
    LocalDate fecha;
    MedioDePago medioDePago;
    Collection<ArticuloVenta> articulos;

    Venta(MedioDePago medioDePago, Collection<ArticuloVenta> articulos) {
        this.medioDePago = medioDePago;
        this.articulos = articulos;
        fecha = LocalDate.now();
    }

    Venta(MedioDePago medioDePago){
        this.medioDePago = medioDePago;
        this.articulos = new ArrayList<>();
        fecha = LocalDate.now();
    }

    void agregarArticulo(Prenda prenda, int cantidad) {
        articulos.add(new ArticuloVenta(prenda, cantidad));
    }

    void agregarArticulo(ArticuloVenta articulo) {
        articulos.add(articulo);
    }

    double ganancia() {
        double gananciaBase = articulos.stream().mapToDouble(a -> a.precio()).sum();
        return medioDePago.modificarVenta(gananciaBase);
    }
}

class VentasRegistradas {
    Collection<Venta> ventas;

    VentasRegistradas(){
        ventas = new ArrayList<>();
    }

    VentasRegistradas(Collection<Venta> ventas) {
        this.ventas = ventas;
    }

    double gananciaPorFecha(LocalDate fecha){
        return ventas.stream().filter(v -> v.fecha.equals(fecha)).mapToDouble(v -> v.ganancia()).sum();
    }

    void registrar(Venta venta) {
        ventas.add(venta);
    }
}
