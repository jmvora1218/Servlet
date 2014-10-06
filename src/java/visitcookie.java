/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHREEJI
 */
public class visitcookie extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    Cookie c[]=req.getCookies();
    Cookie m=null;
    int hitscount=0;
    
    if(c==null){
    m=new Cookie("hits","1");
    hitscount=1;
    }else{
        for(int i=0;i<c.length;i++) { 
            if(c[i].getName().equals("hits")) { 
                m = c[i];
                hitscount = Integer.parseInt(m.getValue());
                hitscount++;
                m.setValue(String.valueOf(hitscount));
                break;
            }
        }
    }
    m.setMaxAge(60*5);
    res.addCookie(m);
    res.addCookie(new Cookie("hi","hello"));
    res.addCookie(new Cookie("hi1","jv"));
    res.addCookie(new Cookie("hi2","patthubha"));
    res.addCookie(new Cookie("hi3","r"));
    
    
    out.println("<h1>Hello welcome to my page!</h1><br><hr><br>");
    out.println("<h3>My page has "+ hitscount +" visits!!</h3>");
    
    out.println("<br><hr><br>The last cookie set is : " + c[c.length-1].getName() + " : " + c[c.length-1].getValue() );
    
    
    }
}
