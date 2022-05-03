package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NegocioTest {
  
  private Negocio negocioConVentasEnDosFechas;
  private LocalDate primerDia;
  private LocalDate segundoDia;
  private LocalDate unDiaSinVentas;

  @BeforeEach
  public void setUp() {
    primerDia = LocalDate.of(2020, 1, 1);
    segundoDia = LocalDate.of(2020, 1, 2);
    unDiaSinVentas = LocalDate.of(2020, 1, 3);

    Prenda camisaNuevaDe100 = new Prenda(Double.valueOf(100), new PrendaNueva(), TipoPrenda.CAMISA);

    ArrayList<ArticuloVenta> articulosPrimerDia = new ArrayList<ArticuloVenta>();
    articulosPrimerDia.add(new ArticuloVenta(camisaNuevaDe100, 1));
    
    ArrayList<ArticuloVenta> articulosSegundoDia = new ArrayList<ArticuloVenta>();
    articulosSegundoDia.add(new ArticuloVenta(camisaNuevaDe100, 4));

    Venta ventaEnPrimerDia = new Venta(primerDia, new Efectivo(), articulosPrimerDia);
    Venta VentaEnSegundoDia = new Venta(segundoDia, new Efectivo(), articulosSegundoDia);
    
    negocioConVentasEnDosFechas = new Negocio(new ArrayList<Venta>());
    negocioConVentasEnDosFechas.registrar(ventaEnPrimerDia);
    negocioConVentasEnDosFechas.registrar(VentaEnSegundoDia);
  }

  @Test
  public void laGananciaPorFechaEnLaSegundaFechaEsDe4CamisasDe100() {
    assertEquals(400, negocioConVentasEnDosFechas.gananciaPorFecha(segundoDia));
  }

  @Test
  public void laGananciaPorFechaEnLaPrimerFechaEsDe1CamisaDe100() {
    assertEquals(100, negocioConVentasEnDosFechas.gananciaPorFecha(primerDia));
  }

  @Test
  public void LaGanaciaPorFechaEs0CuandoNoHayVentasEnFecha() {
    assertEquals(0, negocioConVentasEnDosFechas.gananciaPorFecha(unDiaSinVentas));
  }
}
