package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import services.AlunoService;
import entities.Aluno;

/**
 * Servlet implementation class CasdastrarAlunoServlet
 */
public class CadastrarAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String id = request.getParameter("id");
		Aluno aluno = null;
		if(id != null){
			AlunoService alunoService = new AlunoService();
			aluno = alunoService.buscarPorId(new Long(id));
			
		}
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadatrar Aluno</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form method='post' action='/webacademia/cadastrarAluno'>");
		
		if(aluno != null){
			out.println("<input type='hidden' name='id' value='"+aluno.getId()+"'/></td>");
		}
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Nome:</td>");
		out.println("<td><input type='text' name='nome' value='"+(aluno != null ? aluno.getNome() : "")+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Cpf:</td>");
		out.println("<td><input type='text' name='cpf' value='"+(aluno != null ? aluno.getCpf() : "")+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Email:</td>");
		out.println("<td><input type='text' name='email' value='"+(aluno != null ? aluno.getEmail() : "")+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Data Nascimento:</td>");
		out.println("<td><input type='text' name='dataNascimento' value='"+(aluno != null ? format.format(aluno.getDataNascimento()) : "")+"'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td></td>");
		out.println("<td><input type='submit' value='Salvar'/></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aluno.setDataNascimento(format.parse(dataNascimento));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AlunoService alunoService = new AlunoService();
		try {
			if(id != null){
				aluno.setId(new Long(id));
				alunoService.alterar(aluno);
			}
			else{
				alunoService.salvar(aluno);
			}
			
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/webacademia/listarAluno");
	}

}
