import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpData extends HttpServlet
{
    Statement stmt=null;
    Connection con =null;
    String n,p,sql;
    String url="jdbc:mysql://localhost/lab",un="root",up="java";
    ResultSet rs;
    
    public void init(ServletConfig sc) throws ServletException{
        super.init(sc);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con=DriverManager.getConnection(url,un,up);
        } catch (SQLException ex) {
            Logger.getLogger(EmpData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stmt =con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EmpData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs=stmt.executeQuery("select * from employee");
        } catch (SQLException ex) {
            Logger.getLogger(EmpData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<form action='EmpData' method='post' >");
        out.println(" Enter username : <input type='text' name='textn' value=''>");
        out.println(" Enter password : <input type='password' name='textp' value=''>");
        out.println(" <input type='submit' value='Submit'>");
        out.println("</form> This is in the get request</body></html>");
        out.close();
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
            n=req.getParameter("textn");
            p=req.getParameter("textp");
            sql="insert into employee values('"+n+"','"+p+"')";
        try
        {
            out.println("<html> <body> <h2> Welcome to JayVora Organizaion! </h2> ");
            
            stmt.executeUpdate(sql);
            out.println("<h3> Username : "+ n +"is successfully registered! </h3>");
            out.println("Now the registered users are as follows : ");
            
            sql = "select NAME from employee";
            
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) { 
                out.println("<table border=2> <tr> <td> "+ rs.getString(1)+" </td> </tr></table> ");
            }
            
            
        }catch(Exception e)
        {
            out.println(e.getMessage());
        }
        
        
    }
}