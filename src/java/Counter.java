
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Counter extends HttpServlet{
    ServletContext ctx;
    int c;
    public void doget(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        ctx=getServletContext();
        String cnt=(String)ctx.getAttribute("Counter");
        if(cnt!=null){
            c=Integer.parseInt(cnt);
        }else
        {
            c=0;
        }
        c=c+1;
        out.print("visit="+c);
        ctx.setAttribute("Counting",c+"");
    }
}