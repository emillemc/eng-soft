package daos;

import javax.persistence.EntityManager;

import entities.Aluno;
import entities.MedidaAvaliacao;

public class MedidaAvaliacaoDAO extends AbstractDAO<MedidaAvaliacao>{

	public MedidaAvaliacaoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<MedidaAvaliacao> entityClass() {
		return MedidaAvaliacao.class;
	}
}
