package services;

import javax.persistence.EntityManager;

import daos.AvaliacaoDAO;
import daos.MedidaAvaliacaoDAO;
import entities.MedidaAvaliacao;

public class MedidaAvaliacaoService extends AbstractService<MedidaAvaliacao, MedidaAvaliacaoDAO> {

	@Override
	protected MedidaAvaliacaoDAO newDAO(EntityManager manager) {
		return new MedidaAvaliacaoDAO(manager);
	}
}
