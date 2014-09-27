import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
    ServletContext ctx;
    String un,up,driver,url,name,pass;
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    boolean flag1=false;
    boolean flag2=false;


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
           System.out.println("28");
        Class.forName(driver);
        con=DriverManager.getConnection(url,un,up);
           System.out.println("driver loaded");
        stmt=con.createStatement();
           System.out.println("connection establish");
        rs=stmt.executeQuery("select * from employee");
           System.out.println(" 34");
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
                
                System.out.println(name+pass);
                while(rs.next())
                {
                     String n=rs.getString("NAME");
                     String p=rs.getString("PASSWORD");
                     System.out.println(" "+n+p);
                     if(name.equals(n))
                     {
                        flag1=true;
                        if(pass.equals(p))
                        {
                            flag2=true;
                        }
                     }
                 }
                if(flag1&&flag2)
                {
                     String url="welcome?greet=welcome&name='"+name+"'&password='"+pass+"'";
                    //   String url="welcome?greet=welcome&name=abc&password=pwd";

                     res.sendRedirect(url);
                }
            }
            catch(Exception e)
            {
                out.println(e.getMessage());
            }
        }
       
    }
      
          public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><body><form method='post' action='Login'>");
        out.println("Enter Name:<input type='text' name='txtname'></br>");
        out.println("Enter Password:<input type='password' name='txtpass'></br>");
        out.println("<input type='submit' name='btnsubmit' value='Submit'></br>");
        out.println("<a href ='NewUser'>New User</a></br><a href ='ForgotPass'>Forgot Password</a>");
        out.println("</form></body></html>");

    }
}

