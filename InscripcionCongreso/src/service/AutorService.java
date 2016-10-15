package service;

import model.Autor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorDAOHiberJPA;

@Component
public class AutorService {

	private AutorDAOHiberJPA autorDAO;
	
	@Transactional(value = "transactionManager", rollbackFor = Exception.class)
	public Autor existeAutor(String nombre, String apellido,String correo_gmail) {
		return this.autorDAO.recuperar(nombre, apellido, correo_gmail);
	}

	public AutorDAOHiberJPA getAutorDAO() {
		return autorDAO;
	}

	public void setAutorDAO(AutorDAOHiberJPA autorDAO) {
		this.autorDAO = autorDAO;
	}
}
