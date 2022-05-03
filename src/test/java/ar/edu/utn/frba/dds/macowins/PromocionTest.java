package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromocionTest {

  @Test
  public void elPrecioFinalEsElBaseMenosElDescuento(){
    assertEquals(1300.0, unaPromo(100.0).precioSegunEstado(1400.0), 0);
  }
  
  @Test
  public void elPrecioFinalNoEsNegativoConDescuentosMasGrandes(){
    assertEquals(0.0, unaPromo(100.0).precioSegunEstado(50.0), 0);
  }

  private Promocion unaPromo(double descuento) {
    return new Promocion(descuento);
  }
}
