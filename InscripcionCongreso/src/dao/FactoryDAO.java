package dao;

public class FactoryDAO {
	
	public static TrabajoDAOHiberJPA getTrabajoDAO(){
		return new TrabajoDAOHiberJPA();
	}
	
	public static AutorDAOHiberJPA getAutorDAO(){
		return new AutorDAOHiberJPA();
	}
	
	public static AutorSecundarioDAOHiberJPA getAutorSecundarioDAO(){
		return new AutorSecundarioDAOHiberJPA();
	}
}
