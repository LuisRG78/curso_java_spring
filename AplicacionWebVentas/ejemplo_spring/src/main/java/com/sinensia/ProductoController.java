package com.sinensia;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	@RequestMapping("/obten_prueba")
	public Producto devuelveProducto(@RequestParam(value="nombre", defaultValue = "Sin producto") String nombre) {
		return new Producto(1, nombre, "30");
	}
}
