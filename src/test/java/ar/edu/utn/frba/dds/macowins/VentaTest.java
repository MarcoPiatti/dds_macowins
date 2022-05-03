package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.time.LocalDate;
import java.util.ArrayList;

public class VentaTest {
  private ArrayList<ArticuloVenta> articulos;

  private Venta ventaConTarjeta10Cuotas(Collection<ArticuloVenta> articulos) {
    return new Venta(LocalDate.now(), new Tarjeta(10, 1), articulos);
  }

  private Venta ventaConEfectivo(Collection<ArticuloVenta> articulos) {
    return new Venta(LocalDate.now(), new Efectivo(), articulos);
  }

  @BeforeEach
  public void setUp() {
    ArticuloVenta dosCamisasNuevasDe500 = new ArticuloVenta(new Prenda(Double.valueOf(500), new PrendaNueva(), TipoPrenda.CAMISA), 2);
    ArticuloVenta cuatroPantalonesLiquidadosDe1000 = new ArticuloVenta(new Prenda(Double.valueOf(1000), new Liquidacion(), TipoPrenda.PANTALON), 4);
    articulos = new ArrayList<ArticuloVenta>();
    articulos.add(dosCamisasNuevasDe500);
    articulos.add(cuatroPantalonesLiquidadosDe1000);
  }

  @Test 
  public void laGananciaConEfectivoEsLaSumaDeLosPrecios() {
    assertEquals(3000, ventaConEfectivo(articulos).ganancia());
  }

  @Test
  public void laGananciaConTarjetaEsLaSumaMasRecargo() {
    assertEquals(3040, ventaConTarjeta10Cuotas(articulos).ganancia());
  }

}