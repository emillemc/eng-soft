package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.SystemException;

import daos.AbstractDAO;
import entities.AbstractEntity;

public abstract class AbstractService<T extends AbstractEntity, D extends AbstractDAO<T>> {
	
	static EntityManagerFactory fac = new Persistence().createEntityManagerFactory("clientes");
	
	protected EntityManager manager;
	
	public void salvar(T entity) throws SystemException{
		manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			D dao = newDAO(manager);
			dao.salvar(entity);
			manager.getTransaction().commit();
		}
		catch(Exception e){
			manager.getTransaction().rollback();
			throw new SystemException("Erro ao salvar");
		}
		finally{
			manager.close();
		}
	}
	
	public void remover(T entity) throws SystemException{
		manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			if(entity.getId() == null || entity.getId() == 0){
				throw new SystemException("Id é obrigatório");
			}
			
			D dao = newDAO(manager);
			entity = dao.buscarPorId(entity.getId());
			dao.excluir(entity);
			manager.getTransaction().commit();
		}
		catch(Exception e){
			manager.getTransaction().rollback();
			throw new SystemException("Erro ao salvar");
		}
		finally{
			manager.close();
		}
	}
	
	public void alterar(T entity) throws SystemException{
		manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			D dao = newDAO(manager);
			dao.atualizar(entity);
			manager.getTransaction().commit();
		}
		catch(Exception e){
			manager.getTransaction().rollback();
			throw new SystemException("Erro ao atualizar");
		}
		finally{
			manager.close();
		}
	}
	
	public T buscarPorId(Long id){
		manager = fac.createEntityManager(); 
		return newDAO(manager).buscarPorId(id);
	}
	
    public List<T> listar(){
    	manager = fac.createEntityManager();
		return newDAO(manager).listar();
	}
    
    protected abstract D newDAO(EntityManager manager);
	
}
