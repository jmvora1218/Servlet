
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ForgotPass extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        
        
        /*out.println("<html><body>");
        out.println("<form name='submit' method='post' action='NewUser'>");
        out.println(" Enter username : <input type='text' name='un' value=''></br>");
        out.println(" <input type='submit' value='Get Password'></br>");
        
        out.println("</form></html></body>");*/
        
        
        String g=req.getParameter("greet");
        String n=req.getParameter("name");
        String p=req.getParameter("password");
        out.println(g+"  "+n+""+p);
        
    }
}     
    
    
