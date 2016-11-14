package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AlunoService;
import entities.Aluno;

/**
 * Servlet implementation class ListarAlunosServlet
 */
public class ListarAlunosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		AlunoService alunoService = new AlunoService();
		List<Aluno> alunos = alunoService.listar();
		request.setAttribute("alunos", alunos);
		request.getRequestDispatcher("listarAluno.jsp").forward(request, response);
		
			
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
