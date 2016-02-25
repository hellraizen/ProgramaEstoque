

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fachada.Fachada;
import Produto.Produto;

/**
 * Servlet implementation class ListarEstoque
 */
@WebServlet("/ListarEstoque")
public class ListarEstoque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarEstoque() {
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
		PrintWriter out = response.getWriter();
		
		try {
			ArrayList<Produto> listaProduto=Fachada.getInstance().listarProduto();
			
				out.print("<html><head><title>Lista</title></head><body>");
				out.print("<h1>Lista</h1>");
				out.print(" <table borde=1 bgcolor=black >");
				out.print("<tr bgcolor= white>");
				out.print("<td>Id</td>");
				out.print("<td>Produto</td>");
				out.print("<td>Quantidade</td>");
				out.print("</tr>");
				out.print("</table>");
				
			
			for (Produto produtos : listaProduto) {
				int id = produtos.getId();
				String produto = produtos.getNome();
				int quantidade= produtos.getQuantidade();
				out.print(" <table>");
				out.print("<tr >");
				out.print("<td>	  "+id+"       </td>");
				out.print("<td>   "+produto+"     </td>");
				out.print("<td>   "+quantidade+"     </td>");
				out.print("</tr>");				
				out.print("</table>");
				out.print("</table></body></html>");
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

}
