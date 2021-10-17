package co.edu.unbosque.NamelessBackWEB.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.NamelessBackWEB.dao.VentasDAO;
import co.edu.unbosque.NamelessBackWEB.model.Ventas;

@RestController //esta es una clase REST
@RequestMapping("ventas")
public class VentasAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para ventadDAO
	private VentasDAO ventasDAO;

	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	
	@GetMapping("/listar")
	public List<Ventas> listar(){
		return ventasDAO.findAll();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		ventasDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	
}

