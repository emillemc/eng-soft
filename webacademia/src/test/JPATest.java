package test;

import java.util.ArrayList;
import java.util.Date;

import services.AlunoService;
import services.MedidaAvaliacaoService;
import services.UsuarioService;
import entities.Aluno;
import entities.Avaliacao;
import entities.MedidaAvaliacao;
import entities.Usuario;

public class JPATest {
	
	
	public static void main(String[] args) throws Exception {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setData(new Date());
		
		avaliacao.setMedidasAvaliacao(new ArrayList());
		
		MedidaAvaliacao  medida1 = new MedidaAvaliacao();
		avaliacao.getMedidasAvaliacao().add(medida1);
		
		MedidaAvaliacao  medida2 = new MedidaAvaliacao();
		avaliacao.getMedidasAvaliacao().add(medida2);
		
		medida1.setAvaliacao(avaliacao);
		
		medida2.setAvaliacao(avaliacao);
		
		MedidaAvaliacaoService service = new MedidaAvaliacaoService();
		
		service.salvar(medida1);
		
		Usuario usuario = new Usuario();
		usuario.setLogin("micael");
		usuario.setSenha("123");
		
		
		Aluno aluno = new Aluno();
		aluno.setNome("micael");
		aluno.setCpf("123213");
		aluno.setEmail("micael.lopes05@gmail.com");
		
		
		
		UsuarioService Userservice = new UsuarioService();
		Userservice.salvar(usuario);
		
		AlunoService alunoservice = new AlunoService();
		alunoservice.salvar(aluno);
		
		
	}

}
