package murach.email;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="MurachTestServlet", urlPatterns={"/test"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");        
        PrintWriter out = response.getWriter();        
        try {
            out.println("<h1>HTML from servlet</h1>");
        } 
        finally {
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }    
}