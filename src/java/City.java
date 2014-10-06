
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class City extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("Text/html");
        PrintWriter out=res.getWriter();
      
        out.println("<html><body>");
        out.println("<form name='City' method='post' action='City'>");
        
        out.println("City: <input type='text' name='txtCity' value=' '>");
        //for hidden...
        out.println("<input type='hidden' name='txtname' value='"+req.getParameter("txtname")+"'>");
        out.println("<input type='hidden' name='txtpass' value='"+req.getParameter("txtpass")+"'>");
        
        
        out.println("<input type='Submit' name='Next' value='next'>");
        out.println("</form></body></html>");

    }
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("Text/html");
        PrintWriter out=res.getWriter();
        
        String n=req.getParameter("txtname");
        String p=req.getParameter("txtpass");
        String c=req.getParameter("txtCity");
        
        out.println("Name= " +n+ " Password= " +p+ " City= "+c);
    }
}