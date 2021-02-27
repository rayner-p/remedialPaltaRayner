package ec.ups.edu.RemedialPaltaRayner.rest;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.ups.edu.RemedialPaltaRayner.modelo.Autor;
import ec.ups.edu.RemedialPaltaRayner.modelo.Categoria;
import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;

@Path("transacciones")
public class ServiciosRest {
	@Inject
	private ec.ups.edu.RemedialPaltaRayner.servicio.GestionProveedorLocale on;
	private Libro libro;
	private Autor autor;
	private Categoria categoria;

	private int cantidad;

	public ServiciosRest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo a enviar para solicitar pedidos
	 * 
	 * @param transac
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/solicitarProducto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registrarLibro(@QueryParam("nombre") String nombre, @QueryParam("categoria") String categoria,
			@QueryParam("autor") String autor, @QueryParam("stock") int stock) throws Exception {
		libro = new Libro();
		try {
			libro.setNombre(nombre);
			// libro.setCategoria_fk(categoria);
			// libro.setAutor_fk(autor_fk);
			libro.setStock(stock);
			on.insertarLibro(libro);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Info ", "LIBRO INSERTADO");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			throw new Exception("Se ah producido un error al insertar el libro rest"+e.getMessage());
			
		}

		return "ok";
	}

	@GET
	@Path("/listadoLibro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> obtenerLibros() throws Exception {
		try {
			return on.obtenerLibro();
		} catch (Exception e) {
			throw new Exception("Se ah producido un error al listar libros" + e.getMessage());

		}
	}

	@GET
	@Path("/listadoLibroCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> listarProductos(@QueryParam("categoria") String categoria) throws Exception {
		try {
			return on.obtenerlibroCategoria(categoria);
		} catch (Exception e) {
			throw new Exception("Se ah producido un error al listar por categoria" + e.getMessage());
		}
	}
	
	@GET
	@Path("/listadoAutores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Autor> obtenerAutores() throws Exception {
		try {
			return on.obtenerAutor();
		} catch (Exception e) {
			throw new Exception("Se ah producido un error al listar autores" + e.getMessage());

		}
	}
	@GET
	@Path("/listadoCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> obtenerCategoria() throws Exception {
		try {
			return on.obtenerCato();
		} catch (Exception e) {
			throw new Exception("Se ah producido un error al listar categorias" + e.getMessage());

		}
	}

}
