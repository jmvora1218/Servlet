
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B3 extends HttpServlet{
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        //for ButtonDemoUrl...
        
       // String m=req.getParameter("msg");
        //String g=req.getParameter("greet");
        //out.println(m+" "+g);  
    
        //for ButtonDemoDispatch...
        String m=(String)req.getAttribute("msg");
        String g=(String) req.getAttribute("greet");
        out.println(m+" "+g); 
        
    }
}