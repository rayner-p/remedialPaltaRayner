package ec.ups.edu.RemedialPaltaRayner.vista;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.RemedialPaltaRayner.dato.LibroDao;
import ec.ups.edu.RemedialPaltaRayner.modelo.Autor;
import ec.ups.edu.RemedialPaltaRayner.modelo.Categoria;
import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;
import ec.ups.edu.RemedialPaltaRayner.servicio.GestionProveedorON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class LibroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private GestionProveedorON on;
	@Inject
	private LibroDao daoL;
	private Libro libro;
	private List<Autor> lstAutor;
	private List<Libro> lstLibo;
	private List<Libro> lstLibroC;
	private List<Categoria> cato;

	@PostConstruct
	public void init() {
		cato = new ArrayList<Categoria>();
		libro = new Libro();
		lstAutor = new ArrayList<Autor>();
		lstLibo = new ArrayList<Libro>();
		lstLibroC = new ArrayList<Libro>();
	}

	public void registrarLibro() throws Exception {
		try {
			on.insertarLibro(libro);
			System.out.println("INSERTADO");
		} catch (Exception e) {
			throw new Exception("Erro al insertar libro on" + e.getLocalizedMessage());
		}
	}

	public void obtenerListaAutor() throws Exception {
		try {

			if (on.obtenerLibro() == null) {
				System.out.println("LISTA NULA");
			} else {
				lstAutor = on.obtenerAutor();
			}
		} catch (Exception e) {
			throw new Exception("Erro al listar autor on" + e.getLocalizedMessage());

		}
	}

	public void obtenerListaLibro() throws Exception {
		try {

			if (on.obtenerLibro() == null) {
				System.out.println("LISTA NULA");
			} else {
				lstLibo = on.obtenerLibro();
			}
		} catch (Exception e) {
			throw new Exception("Erro al listar libro on" + e.getLocalizedMessage());

		}
	}

	public void obtenerListaLibroCategoria(String categoria) throws Exception {
		try {

			if (on.obtenerLibro() == null) {
				System.out.println("LISTA NULA");
			} else {
				lstLibroC = on.obtenerlibroCategoria(categoria);
			}
		} catch (Exception e) {
			throw new Exception("Erro al listar libro categoria on" + e.getLocalizedMessage());

		}
	}

	public void descontarStokc(Libro l) {
		Libro newL = new Libro();
		newL.setStock(l.getStock() - 1);
		daoL.actualizarLibro(l);
	}

	public void obtenerCategoria() throws Exception {
		try {

			if (on.obtenerCato() == null) {
				System.out.println("LISTA NULA");
			} else {
				cato = on.obtenerCato();
			}
		} catch (Exception e) {
			throw new Exception("Erro al listar categoria on" + e.getLocalizedMessage());

		}

	}
}
