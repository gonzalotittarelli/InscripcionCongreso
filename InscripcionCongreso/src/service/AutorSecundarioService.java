package service;

import model.AutorSecundario;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.AutorSecundarioDAOHiberJPA;

@Component
public class AutorSecundarioService {
	
	private AutorSecundarioDAOHiberJPA autorSecundarioDAO;
	
	@Transactional(value = "transactionManager", rollbackFor = Exception.class)
	public AutorSecundario existeAutorSecundario(String nombre, String apellido) {
		return this.autorSecundarioDAO.recuperar(nombre, apellido);		
	}

	public AutorSecundarioDAOHiberJPA getAutorSecundarioDAO() {
		return autorSecundarioDAO;
	}

	public void setAutorSecundarioDAO(AutorSecundarioDAOHiberJPA autorSecundarioDAO) {
		this.autorSecundarioDAO = autorSecundarioDAO;
	}

}
