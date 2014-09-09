import javax.servlet.GenericServlet;
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

public class emp extends HttpServlet{
    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;
    String n,p;
    String url="jdbc:mysql://localhost/lab",un="root",up="java";
    public void init(ServletConfig sc) throws ServletException{
        super.init(sc);
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Driver is loaded");
        try {
            con=DriverManager.getConnection(url,un,up);
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("Connection created");
        try {
            stmt =con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("Wrapper created");
        try {
            rs=stmt.executeQuery("select * from employee");
        } catch (SQLException ex) {
            Logger.getLogger(emp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        out.println("<html><body><table border='1'>");
        out.println("<th> Name </th> <th> Passworld </th>");
        try{
            rs.beforeFirst();
            while(rs.next()){
                n=rs.getString(1);
                p=rs.getString(2);
            out.println("<tr>");
                out.println("<td>"+ n + "</td>");
                out.println("<td>"+ p + "</td>");
            out.println("</tr>");    
            }
        }catch(SQLException sqle){
            out.println(sqle.getMessage());
        }
            out.println("</table>");
            out.println("</html>");
    }
}