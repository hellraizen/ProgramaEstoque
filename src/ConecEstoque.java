

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConecEstoque
 */
@WebServlet("/ConecEstoque")
public class ConecEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConecEstoque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome= request.getParameter("nome");
		int quantidade= Integer.parseInt(request.getParameter("quantidade"));
		System.out.println(nome);
		System.out.println(quantidade);
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>Resposta</title></head><body>");
		out.print("<a href='Cadastra.jsp'>Voltar</a>");
		out.print("<h1>Poduto Cadastrado com Sucesso "+ nome);
		out.print("</h1></body></html>");
		
	}

}
