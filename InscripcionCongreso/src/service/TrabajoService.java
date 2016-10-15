package service;

import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.AutorSecundario;
import model.Temas;
import model.TiposPresentacion;
import model.Trabajo;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.TrabajoDAOHiberJPA;

@Component
public class TrabajoService {
	
	private TrabajoDAOHiberJPA trabajoDAO;
	private AutorService autorService;

	/**
	 * Este metodo se encarga de persistir el trabajo. Verifica si el autor ya existe y se lo asigna al trabajo. De lo contrario crea uno nuevo.
	 * 
	 * Con respecto a los autores secundarios, como no se hizo una relacion de N a N dejo que se creen repetidos.. si pensas que es necesario lo hago.
	 * 
	 * Para esto ultimo habria que crear en AutorSecundario una coleccion de trabajos en lugar de solo un trabajo y mapearlo con hibernate.
	 * @param nombre
	 * @param apellido
	 * @param correo
	 * @param correo_gmail
	 * @param titulo_trabajo
	 * @param tema_trabajo
	 * @param tipo_presentacion
	 * @param apellidos_nombres_secundarios
	 * @param resumen
	 */
	@Transactional(value = "transactionManager", rollbackFor = Exception.class)
	public void guardarTrabajo(String nombre, String apellido,
			String correo, String correo_gmail, String titulo_trabajo,
			String tema_trabajo, String tipo_presentacion,
			String apellidos_nombres_secundarios, String resumen) {
		
		Autor autor = this.autorService.existeAutor(nombre, apellido, correo_gmail);
		if(autor == null)
			autor = new Autor(nombre, apellido, correo, correo_gmail);
		
		List<AutorSecundario> autores = null;
		
		Trabajo trabajo = new Trabajo(titulo_trabajo, autor, autores, resumen, Temas.valueOf(tema_trabajo), TiposPresentacion.valueOf(tipo_presentacion), false, null);
		
		if(apellidos_nombres_secundarios!=null){
			autores = this.autoresSecundarios(apellidos_nombres_secundarios, trabajo);
		}
		
		trabajo.setAutoresSecundarios(autores);
		
		this.trabajoDAO.alta(trabajo);
	}
	
	/**
	 * Este metodo crea los autores secundarios para luego setearselos al trabajo
	 * @param apellidos_nombres_secundarios
	 * @param trabajo
	 * @return autores secundarios del trabajo
	 */
	private List<AutorSecundario> autoresSecundarios(String apellidos_nombres_secundarios, Trabajo trabajo){
		List<AutorSecundario> autores = null;
		if(apellidos_nombres_secundarios!=null && (!apellidos_nombres_secundarios.equals(""))){
			String[] autores_secundarios = apellidos_nombres_secundarios.split(",");
			if (autores_secundarios.length!=0){
				autores = new ArrayList<AutorSecundario>();
				for (String autor : autores_secundarios) {
					String [] nombre_apellido = autor.split("/");
					AutorSecundario autorsecundario = new AutorSecundario(nombre_apellido[0], nombre_apellido[1]);
					autorsecundario.setTrabajo(trabajo);
					autores.add(autorsecundario);
				}
			}
		}
		return autores;
	}

	public TrabajoDAOHiberJPA getTrabajoDAO() {
		return trabajoDAO;
	}

	public void setTrabajoDAO(TrabajoDAOHiberJPA trabajoDAO) {
		this.trabajoDAO = trabajoDAO;
	}

	public AutorService getAutorService() {
		return autorService;
	}

	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}

}
