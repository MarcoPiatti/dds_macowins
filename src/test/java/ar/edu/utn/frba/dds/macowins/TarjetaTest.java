package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaTest {
  
  Double precioBase;

  @BeforeEach
  public void setUp() {
    precioBase = Double.valueOf(100);
  }

  private Tarjeta tarjetaCon10CuotasYCoeficienteDe10() {
    return new Tarjeta(10, 10);
  }

  private Tarjeta tarjetaConCoeficiente0() {
    return new Tarjeta(1, 0);
  }

  private Tarjeta tarjetaCon7CuotasYCoeficienteDe1() {
    return new Tarjeta(7, 1);
  }

  @Test
  public void elRecargoSinCoeficienteEs1PorcientoDelPrecio(){
    assertEquals(101, tarjetaConCoeficiente0().precioConRecargo(precioBase), 0);
  }

  @Test
  public void elRecargoEs1PorcientoDelPrecioMasCuotasPorCoeficiente(){
    assertEquals(201, tarjetaCon10CuotasYCoeficienteDe10().precioConRecargo(precioBase), 0);
    assertEquals(108, tarjetaCon7CuotasYCoeficienteDe1().precioConRecargo(precioBase), 0);
  }
}
