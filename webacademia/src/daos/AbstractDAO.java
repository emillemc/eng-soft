package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.AbstractEntity;
import entities.Aluno;

public abstract class AbstractDAO<T extends AbstractEntity> {
	
	protected EntityManager manager;

	public AbstractDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(T entity) {
		manager.persist(entity);
	}

	public void atualizar(T entity) {
		manager.merge(entity);
	}

	public void excluir(T entity) {
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);
	}

	public T buscarPorId(Long id) {
		return manager.find(entityClass(), id);
	}

	public List<T> listar(){
		Query query = manager.createQuery("select a from "+entityClass().getSimpleName()+" a");
		return query.getResultList();
	}

	protected abstract Class<T> entityClass();

}
