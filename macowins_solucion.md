# Macowins

## 1. Requerimientos

- Determinar precio de venta de prendas y saber su tipo
- Registrar ventas y determinar ganancias de un determinado día

## 2. Modelos de solución

### Sobre el precio de venta de prendas y saber su tipo

- Hay una Interfaz `EstadoPrenda` que incluye el mensaje `modificarPrecio(Double)`
	- Cada tipo de estado de prenda es una clase que implementa esa interfaz
		- La clase `Promocion` tiene un atributo `porcentaje (double)`
		con el cual se calcula `modificarPrecio`

- Hay una clase `Prenda`, que entiende los mensajes `precioDeVenta()` y `getTipo()`
y tiene los atributos `precioBase (int)`, `tipo (Enum)` y `estado (EstadoPrenda)`
	- La clase se construye a partir de un nuevo precio base, y objeto de estado
	- Cada tipo de prenda es un tag diferente de un enum
	
### Sobre registrar ventas y determinar las ganancias del dia

Disclaimer: se debería consultar al cliente si con ganancias se refiere a las ganancias reales,
o al dinero recaudado en las ventas (ya que para averiguar las ganancias se requiere saber
el dinero que Macowins gastó en las prendas previo a su venta). Por el momento entendemos por
ganancias al primer caso, que se puede calcular con la información que ya se tiene.

- Hay una clase `ArticuloVenta` que tiene los atributos `prenda (Prenda)`
y `cantidad (Int)` y entiende el mensaje `precio()`

- Hay una interfaz `MedioDePago` que entiende el mensaje `modificarVenta(Double)`
	- los modos de pago `Efectivo` y `Tarjeta` son clases que implementan esta interfaz.
		- `Tarjeta` tiene atributos `cuotas` y `coeficiente`.

- Hay una clase `Venta` con los atributos `fecha (LocalDate)`, `medioDePago (MedioDePago)`
y `articulos (lista de ArticuloVenta)`, y entiende el mensaje `ganancia()`

- Hay una clase `VentasRegistradas` con el atributo `ventas (lista de Ventas)` y 
entiende los mensajes `gananciaPorFecha(LocalDate)` y `registrar(Venta)`

## 3. Comentarios de alternativas descartadas

- La clase prenda podria haberse implementado como abstracta, y cada subtipo ser una subclase

- Liquidacion podría ser subclase de Promoción lógicamente
pero es un caso tan simple que no hay diferencia real
entre una implementación y otra.