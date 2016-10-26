package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
@Table(name="ESTADO_TRABAJO")
public class EstadoTrabajo implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	@Column(name = "ID_ESTADO_TRABAJO")
	private Long id;
	
	@Column(name = "DESCRIPCION_ESTADO_TRABAJO")
	private String descripcion;
	

	public EstadoTrabajo(){
		this.setDescripcion("INSCRIPTO");
	}
	
	public EstadoTrabajo(String descripcion){
		this.setDescripcion(descripcion);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
