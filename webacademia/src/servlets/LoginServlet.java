package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.UsuarioService;
import entities.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login.equals("") || senha.equals("")){
			request.setAttribute("msg", "preencha os campos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		UsuarioService usuarioService = new UsuarioService();
		
		Usuario usuario = usuarioService.efetuarLogin(login, senha);
		
		if(usuario == null){
			request.setAttribute("msg", "login ou senha inválidos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
		
		
		
		response.sendRedirect("/webacademia/listarAluno");
		
		
		
		
			
		
		
	}

}
