package ec.ups.edu.RemedialPaltaRayner.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.ups.edu.RemedialPaltaRayner.modelo.Autor;
import ec.ups.edu.RemedialPaltaRayner.modelo.Categoria;
import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;

@Local
public interface GestionProveedorLocale {
	
	public void actualizarLibro(Libro libro) throws Exception ;
	public boolean insertarLibro(Libro libro) throws Exception ;
	public List<Libro> obtenerLibro() throws Exception;
	public List<Libro> obtenerlibroCategoria(String categoria);
	public List<Autor> obtenerAutor() throws Exception;
	public List<Categoria> obtenerCato()throws Exception;
	
}
