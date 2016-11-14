package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import services.AlunoService;
import entities.Aluno;

/**
 * Servlet implementation class RemoverAlunoServlet
 */
public class RemoverAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Aluno aluno = new Aluno(new Long(id));
		AlunoService alunoService = new AlunoService();
		try {
			alunoService.remover(aluno);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/webacademia/listarAluno");
	}
}
