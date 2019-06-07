package com.sinensia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//Spring crea automáticamente un bean llamado productoRepository

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	//@Query(value = "SELECT * FORM producto WHERE producto.nombre = ?1", nativeQuery = true)
	
	Producto findByNombre(String nombre);
}
