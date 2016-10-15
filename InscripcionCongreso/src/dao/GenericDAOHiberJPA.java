package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDAOHiberJPA<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	protected Class<T> persistentClass;	
	
	public GenericDAOHiberJPA(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}

	public T alta(T entidad) {
		this.getEntityManager().persist(entidad);
		return entidad;
	}

	public void borrar(Serializable id) {
		T entidad = this.recuperar(id);
		if(entidad != null)
			this.getEntityManager().remove(entidad);
	}

	public T actualizar(T entidad) {
		return this.getEntityManager().merge(entidad);
	}

	public T recuperar(Serializable id) {
		return this.getEntityManager().find(this.getPersistentClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperarTodos() {
		List<T> resultado = null;
		Query consulta = this.getEntityManager().createQuery("SELECT e FROM " + this.getPersistentClass().getSimpleName() + " e");
		resultado = consulta.getResultList();
		return resultado;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> recuperarTodosPor(String stringOrderBy) {
		List<T> resultado = null;
		Query consulta = this.getEntityManager().createQuery("SELECT e FROM " + this.getPersistentClass().getSimpleName() + " e ORDER BY " + stringOrderBy);
		resultado = consulta.getResultList();
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperarTodos(String columOrder) {
		List<T> resultado = null;
		Query consulta = this.getEntityManager().createQuery("SELECT e FROM " + this.getPersistentClass().getSimpleName() + " e ORDER BY e " + columOrder);
		resultado = consulta.getResultList();
		return resultado;
	}
	
	public int contar() {
		Query consulta = this.getEntityManager().createQuery("SELECT COUNT(e.id) FROM " + this.getPersistentClass().getSimpleName() + " e");
		return (int)(long)consulta.getSingleResult();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	private void setPersistentClass(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}

}
