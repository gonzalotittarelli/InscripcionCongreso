package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(name="AUTOR_FK",referencedColumnName="ID_AUTOR")
	private Autor autor;
	
	@OneToMany(mappedBy="trabajo")
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
	
	@Column(name = "APROBADO")
	private Boolean aprobado = false;
	
	@OneToOne
	@JoinColumn(name="EXPOSICION_FK", referencedColumnName="ID_EXPOSICION", nullable=true)
	private Exposicion exposicion;
	
	public Trabajo(){
		
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

	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}

	public Exposicion getExposicion() {
		return exposicion;
	}

	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}

}
