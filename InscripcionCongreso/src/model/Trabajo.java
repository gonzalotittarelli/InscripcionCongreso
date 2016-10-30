package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="TRABAJO")
public class Trabajo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name = "ID_TRABAJO")
	private Long id;

	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "ID_GOOGLE_DRIVE", nullable=true)
	private String idGoogleDrive;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="AUTOR_FK",referencedColumnName="ID_AUTOR")
	private Autor autor;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="trabajo")
	private Collection<AutorSecundario> autoresSecundarios;
	
	@Column(name = "RESUMEN")
	@Type(type="text")
	private String resumen;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TEMA")
	private Temas tema;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PRESENTACION")
	private TiposPresentacion tipoPresentacion;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="EXPOSICION_FK", referencedColumnName="ID_EXPOSICION", nullable=true)
	private Exposicion exposicion;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ESTADO_TRABAJO_FK",referencedColumnName="ID_ESTADO_TRABAJO")
	private EstadoTrabajo estadoTrabajo;
	
	public Trabajo(){
		
	}
	
	public Trabajo(String titulo, Autor autor,
			Collection<AutorSecundario> autoresSecundarios, String resumen,
			Temas tema, TiposPresentacion tipoPresentacion, Exposicion exposicion, EstadoTrabajo estadoTrabajo) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.autoresSecundarios = autoresSecundarios;
		this.resumen = resumen;
		this.tema = tema;
		this.tipoPresentacion = tipoPresentacion;
		this.exposicion = exposicion;
		this.estadoTrabajo = estadoTrabajo;
		this.idGoogleDrive = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Collection<AutorSecundario> getAutoresSecundarios() {
		return autoresSecundarios;
	}

	public void setAutoresSecundarios(Collection<AutorSecundario> autoresSecundarios) {
		this.autoresSecundarios = autoresSecundarios;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Temas getTema() {
		return tema;
	}

	public void setTema(Temas tema) {
		this.tema = tema;
	}

	public TiposPresentacion getTipoPresentacion() {
		return tipoPresentacion;
	}

	public void setTipoPresentacion(TiposPresentacion tipoPresentacion) {
		this.tipoPresentacion = tipoPresentacion;
	}

	public Exposicion getExposicion() {
		return exposicion;
	}

	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}

	public String getIdGoogleDrive() {
		return idGoogleDrive;
	}

	public void setIdGoogleDrive(String idGoogleDrive) {
		this.idGoogleDrive = idGoogleDrive;
	}

	public EstadoTrabajo getEstadoTrabajo() {
		return estadoTrabajo;
	}

	public void setEstadoTrabajo(EstadoTrabajo estadoTrabajo) {
		this.estadoTrabajo = estadoTrabajo;
	}

}
