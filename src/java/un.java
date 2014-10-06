
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class un extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("Text/html");
                PrintWriter out=res.getWriter();
		
		out.println("<html><body>");
		out.println("<form name='un' method='get' action='up'>");
		out.println("UserName: <input type='text' name='txtname' value=' '>");
		out.println("<input type='Submit' name='Next' value='next'>");
		out.println("</form></body></html>");
		
	}
}