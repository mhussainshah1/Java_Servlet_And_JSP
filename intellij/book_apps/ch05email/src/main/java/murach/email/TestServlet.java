package murach.email;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MurachTestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>HTML from servlet</h1>");

        String rockCheckBox = request.getParameter("rock");
        if (rockCheckBox != null) {
            out.println("<h2>rock music was checked</h2>");
        }

        String[] selectedCountries = request.getParameterValues("country");
        for(String country : selectedCountries){
            out.println("<h2>"+ country +" was selected</h2>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}