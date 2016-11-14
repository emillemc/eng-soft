package services;

import javax.persistence.EntityManager;
import javax.transaction.SystemException;

import daos.AvaliacaoDAO;
import entities.Avaliacao;


public class AvaliacaoService extends AbstractService<Avaliacao, AvaliacaoDAO>{
	
	@Override
	protected AvaliacaoDAO newDAO(EntityManager manager) {
		return new AvaliacaoDAO(manager);
	}
	
	// Apesar da herança resolver a maioria dos problemas dos services, às vezes é importante
	// sobrepor alguns destes métodos como por exemplo, o salvar. Isso porque, para salvar é preciso
	// checar se na avaliacao existe o aluno e pelo menos uma medida de avaliação. O metodo herdado nesse
	// nao faz essas validações, necessitando que seja sobreposto.
	
	// Segue exemplo:
	
	@Override
	public void salvar(Avaliacao avaliacao) throws SystemException {
//		if(avaliacao.getAluno() == null || !avaliacao.hasValidId()){
//			throw new SystemException("A avaliacao precisa de um aluno");
//		}
//		if(avaliacao.getMedidasAvaliacao() == null || avaliacao.getMedidasAvaliacao().isEmpty()){
//			throw new SystemException("A avaliacao precisa de pelo menos uma medida");
//		}
		
		super.salvar(avaliacao);
	}
	
	// Isso vale pra muitos métodos. Exemplo: salvar uma reserva sem hospede, cadastrar uma ficha sem exercicios,
	// cadastrar um quarto semuma categoria, cadastrar uma ficha do usário da academia sem o instrutor.
	
	
	
}
