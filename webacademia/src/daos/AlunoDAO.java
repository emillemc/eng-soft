package daos;

import javax.persistence.EntityManager;

import entities.Aluno;

public class AlunoDAO extends AbstractDAO<Aluno>{

	public AlunoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	protected Class<Aluno> entityClass() {
		return Aluno.class;
	}
}
