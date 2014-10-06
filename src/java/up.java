
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class up extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("Text/html");
                PrintWriter out=res.getWriter();
		
		out.println("<html><body>");
		out.println("<form name='up' method='get' action='City'>");
		out.println("Password: <input type='text' name='txtpass' value=' '>");
                
                // for hidden form ....
                
		out.println("<input type='hidden' name='txtname' value='"+req.getParameter("txtname")+"'>");
		
                out.println("<input type='Submit' name='Next' value='next'>");
		out.println("</form></body></html>");
		
	}
}