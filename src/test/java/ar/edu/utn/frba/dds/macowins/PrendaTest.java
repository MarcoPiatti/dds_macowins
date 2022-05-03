package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    assertEquals("CAMISA", camisaNueva(200).getTipo().toString());
  }

  @Test
  public void elTipoDeUnSacoEnLiquidacionEsSACO() {
    assertEquals("SACO", sacoEnLiquidacion(200).getTipo().toString());
  }

  @Test
  public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
    assertEquals(4000, camisaNueva(4000).precio(), 0);
    assertEquals(5000, camisaNueva(5000).precio(), 0);
  }

  @Test
  public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
    assertEquals(1500, sacoEnLiquidacion(3000).precio(), 0);
    assertEquals(4000, sacoEnLiquidacion(8000).precio(), 0);
  }

  @Test
  public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
    assertEquals(1300, pantalonEnPromocion(1500, 200).precio(), 0);
    assertEquals(1400, pantalonEnPromocion(1500, 100).precio(), 0);
  }

  @Test
  public void instanciarUnaPrendaConAtributosNulosLanzaExcepcion() {
    assertThrows(NullPointerException.class, () -> new Prenda(null, null, null));
    assertThrows(NullPointerException.class, () -> new Prenda(100.0, new PrendaNueva(), null));
    assertThrows(NullPointerException.class, () -> new Prenda(null, new PrendaNueva(), TipoPrenda.CAMISA));
  }

  private Prenda pantalonEnPromocion(double precioBase, double descuento) {
    return new Prenda(precioBase, new Promocion(descuento), TipoPrenda.PANTALON);
  }


  private Prenda camisaNueva(double precioBase) {
    return new Prenda(precioBase, new PrendaNueva(), TipoPrenda.CAMISA);
  }

  private Prenda sacoEnLiquidacion(double precioBase) {
    return new Prenda(precioBase, new Liquidacion(), TipoPrenda.SACO);
  }
}
