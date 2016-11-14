package services;

import javax.persistence.EntityManager;

import daos.AlunoDAO;
import entities.Aluno;

public class AlunoService extends AbstractService<Aluno, AlunoDAO> {

	@Override
	protected AlunoDAO newDAO(EntityManager manager) {
		return new AlunoDAO(manager);
	}
}
