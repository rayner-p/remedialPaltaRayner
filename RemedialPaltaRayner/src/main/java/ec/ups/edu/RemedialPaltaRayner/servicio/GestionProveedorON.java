package ec.ups.edu.RemedialPaltaRayner.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import ec.ups.edu.RemedialPaltaRayner.dato.AutorDao;
import ec.ups.edu.RemedialPaltaRayner.dato.CategoriaDao;
import ec.ups.edu.RemedialPaltaRayner.dato.LibroDao;
import ec.ups.edu.RemedialPaltaRayner.modelo.Autor;
import ec.ups.edu.RemedialPaltaRayner.modelo.Categoria;
import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;


@Stateless
public class GestionProveedorON implements GestionProveedorLocale {
	@Inject
	private LibroDao daoLibro;
	@Inject
	private CategoriaDao daoCato;
	@Inject
	private AutorDao daoProducto;
	private int cantidad;
	
	

	public void actualizarLibro(Libro libro) throws Exception {
		if (libro == null) {
			System.err.println("Libro nulo");
		} else {
			try {
				daoLibro.insertarLibro(libro);
			} catch (Exception e) {
				throw new Exception("Error al momento de insertar libro on" + e.getLocalizedMessage());

			}

		}

	}

	public boolean insertarLibro(Libro libro) throws Exception{
		if (libro == null) {
			System.err.println("Libro nulo");
		} else {
			try {
				daoLibro.insertarLibro(libro);
			} catch (Exception e) {
				throw new Exception("Error al momento de insertar libro on" + e.getLocalizedMessage());

			}

		}
		return false;
	}

	
	public List<Libro> obtenerLibro() throws Exception {
		List<Libro> newLibro = new ArrayList<Libro>();
		newLibro= daoLibro.obtenerLibro();
		return newLibro;
	}

	
	public List<Libro> obtenerlibroCategoria(String categoria) {
		List<Libro> newLibro2 = new ArrayList<Libro>();
		if (categoria == null) {
			System.err.println("Categoria nula");
		}else {
			
			newLibro2= daoLibro.obtenerlibroCategoria(categoria);
			return newLibro2;
		}
		return newLibro2;
	}

	
	public List<Autor> obtenerAutor() throws Exception {
		List<Autor> newAutor = new ArrayList<Autor>();
		try {
			newAutor = daoProducto.obtenerAutor();
		}catch (Exception e) {
			throw new Exception("Error al momento de obtener autor on" + e.getLocalizedMessage());
		}
		
		return newAutor;
	}
	public List<Categoria> obtenerCato()throws Exception{
		List<Categoria> newCato = new ArrayList<Categoria>();
		try {
			newCato = daoCato.obtenerCato();
		}catch (Exception e) {
			throw new Exception("Error al momento de obtener autor on" + e.getLocalizedMessage());
		}
		
		return newCato;
	}
}
