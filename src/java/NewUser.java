
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewUser extends HttpServlet
{
    ServletContext ctx;
    String un,up,driver,url,name,pass,sql;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    
    public void init(ServletConfig sc)throws ServletException
    {
        super.init(sc);
        ctx=getServletContext();
        driver=(String)ctx.getInitParameter("driver");
        url=(String)ctx.getInitParameter("url");
        un=(String)ctx.getInitParameter("un");
        up=(String)ctx.getInitParameter("up");
 
       try
       {
        Class.forName(driver);
        con=DriverManager.getConnection(url,un,up);
           System.out.println("driver loaded");
        stmt=con.createStatement();
           System.out.println("connection establish");
        rs=stmt.executeQuery("select * from employee");
       }
       catch(Exception e)
       {
       System.out.println(e.getMessage());
       }
    }

      public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        if(req.getParameter("btnsubmit")!=null)
        {
            try
            {
                name=req.getParameter("txtname");
                pass=req.getParameter("txtpass");
                
                     String n=rs.getString("name");
                     String p=rs.getString("pass");
                     sql="insert into employee values('"+n+"','"+p+"')";
            stmt.executeUpdate(sql);
                    out.println("<h3> Username : "+ n +"is successfully registered! </h3>");
                
                
            }catch(Exception e){
                
            }
        }
    }
    
    
    
    
    
    
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        
        out.println("<html><body>");
        out.println("<form name='submit' method='post' action='NewUser'>");
        out.println("Enter Name:<input type='text' name='txtname'></br>");
        out.println("Enter Password:<input type='password' name='txtpass'></br>");
        out.println("<input type='submit' name='btnsubmit' value='Submit'></br>");
        out.println("</form></html></body>");
        /*
        String g=req.getParameter("greet");
        String n=req.getParameter("name");
        String p=req.getParameter("password");
        out.println(g+"  "+n+""+p);*/
        
    }
}