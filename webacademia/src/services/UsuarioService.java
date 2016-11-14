package services;

import javax.persistence.EntityManager;

import daos.UsuarioDAO;
import entities.Usuario;

public class UsuarioService extends AbstractService<Usuario, UsuarioDAO> {

	@Override
	protected UsuarioDAO newDAO(EntityManager manager) {
		return new UsuarioDAO(manager);
	}
	
	public Usuario efetuarLogin(String login, String senha){
		
		manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		return usuarioDAO.efetuarLogin(login, senha);
		
	}
}
