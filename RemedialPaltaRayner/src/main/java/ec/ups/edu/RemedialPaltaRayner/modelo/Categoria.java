package ec.ups.edu.RemedialPaltaRayner.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private int codigo;
	private String tipo;
	
	
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", tipo=" + tipo + "]";
	}
	
	
}
