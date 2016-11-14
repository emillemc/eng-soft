package daos;

import javax.persistence.EntityManager;

import entities.Avaliacao;

public class AvaliacaoDAO extends AbstractDAO<Avaliacao>{

	public AvaliacaoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Avaliacao> entityClass() {
		return Avaliacao.class;
	}
}
