package ar.edu.utn.frba.dds.macowins;

class ArticuloVenta {
    Prenda prenda;
    Integer cantidad;

    ArticuloVenta(Prenda prenda, Integer cantidad) {
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    Double precio() {
        return prenda.precio() * cantidad;
    }
}
