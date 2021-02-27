package ec.ups.edu.RemedialPaltaRayner.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Libro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private int stock;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="autor_fk")	
	private Autor autor_fk;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="libro_categoria_fk")
	private Categoria libro_categoria_fk;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Categoria getCategoria_fk() {
		return libro_categoria_fk;
	}
	public void setCategoria_fk(Categoria categoria_fk) {
		this.libro_categoria_fk = categoria_fk;
	}
	
	
	
	public Autor getAutor_fk() {
		return autor_fk;
	}
	public void setAutor_fk(Autor autor_fk) {
		this.autor_fk = autor_fk;
	}
	public Categoria getLibro_categoria_fk() {
		return libro_categoria_fk;
	}
	public void setLibro_categoria_fk(Categoria libro_categoria_fk) {
		this.libro_categoria_fk = libro_categoria_fk;
	}
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", autor_fk=" + autor_fk
				+ ", categoria_fk=" + libro_categoria_fk + "]";
	}
	
	

}
