package com.sinensia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	//Creamos una variable tipo repositorio
	@Autowired //Inyección de dependencias
	private ProductoRepository prodRepo;
	
	@RequestMapping("/obten_prueba")
	public Producto devuelveProducto(@RequestParam(value="nombre", defaultValue = "Sin producto") String nombre) {
		System.out.println(" >>>>>> Petición - HTTP: " + nombre);
		return new Producto(1, nombre, 30.5, 3);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public @ResponseBody String addProducto(@RequestParam String nombre, 
			@RequestParam double precio, @RequestParam int cantidad) {
		Producto nuevoProd = new Producto(nombre, precio, cantidad);
		//Lo guardamos en BBDD mediante el CRUDRepo
		prodRepo.save(nuevoProd);
		return "Guardado";
	}
	
	//@GetMapping("/todos")
	@RequestMapping(method= RequestMethod.GET)
	public @ResponseBody Iterable<Producto> getTodosProductos(){
		return prodRepo.findAll();
	}
	
	//@RequestMapping(method= RequestMethod.DELETE)
	//public void eliminarProducto(@RequestParam Integer id) {
	//	prodRepo.deleteById(id);
	//}
	
	@RequestMapping(method= RequestMethod.DELETE)
	public String eliminarProducto(@RequestParam String nombre) {
		 for (Producto producto : getTodosProductos()) {
			if(producto.getNombre().equalsIgnoreCase(nombre)) {				
				prodRepo.deleteById(producto.getId());
			}
		}
		 return "Eliminado producto " + nombre;
	}
	
	@RequestMapping(path="/elimpornombre", method= RequestMethod.DELETE)
	public String eliminarPorNombre(@RequestParam String nombre) {
		 Producto producto = prodRepo.findByNombre(nombre);
		 prodRepo.delete(producto);		
		 return "Eliminado producto " + nombre;
	}
}
