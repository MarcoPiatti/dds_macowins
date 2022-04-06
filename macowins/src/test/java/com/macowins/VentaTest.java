package com.macowins;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class VentaTest {
    Tarjeta tarjetaConDiezCuotas;
    Efectivo efectivo;
    Prenda camisaLiquidada;
    Prenda pantalonesTreintaOff;
    Prenda sacoNuevo;
    Venta ventaConTarjeta;
    Venta ventaConEfectivo;
    VentasRegistradas listadoVentas;

    @Before
    public void setUp() {
        tarjetaConDiezCuotas = new Tarjeta(10, 1);
        efectivo = new Efectivo();
        
        camisaLiquidada = new Prenda(500, new Liquidacion(), TipoPrenda.CAMISA);
        pantalonesTreintaOff = new Prenda(1000, new Promocion(30), TipoPrenda.PANTALON);
        sacoNuevo = new Prenda(2000, new PrendaNueva(), TipoPrenda.SACO);
        
        ventaConTarjeta = new Venta(tarjetaConDiezCuotas);
        ventaConTarjeta.agregarArticulo(camisaLiquidada, 4);
        ventaConTarjeta.agregarArticulo(sacoNuevo, 2);

        ventaConEfectivo = new Venta(efectivo);
        ventaConEfectivo.agregarArticulo(pantalonesTreintaOff, 4);

        listadoVentas = new VentasRegistradas();
        listadoVentas.registrar(ventaConTarjeta);
        listadoVentas.registrar(ventaConEfectivo);
    }

    @Test
    public void testGananciaDelDia() {
        assertEquals(2800, ventaConEfectivo.ganancia(), 0.01);
        assertEquals(5060, ventaConTarjeta.ganancia(), 0.01);
    }
}
