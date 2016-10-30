package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EXPOSICION_DISPONIBLE")
public class ExposicionDisponible implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name = "ID_EXPOSICION_DISPONIBLE")
	private Long id;
	
	@Column(name = "FECHA")
	@Type(type="date")
	private Date fecha;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "LUGAR")
	private String lugar;
	
	@Column(name = "ASIGNADA")
	private Boolean asignada;
	
	public ExposicionDisponible(){
		super();
		this.asignada = false;
	}

	public ExposicionDisponible(Date fecha, String hora, String lugar) {
		this();
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Boolean getAsignada() {
		return asignada;
	}

	public void setAsignada(Boolean asignada) {
		this.asignada = asignada;
	}
}
