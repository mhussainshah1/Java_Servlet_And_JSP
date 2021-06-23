package murach.email;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import murach.business.User;
import murach.data.UserDB;

import java.io.IOException;

@WebServlet(urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.html";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // use regular Java classes
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            // store the User object in request and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        } else if (action.equals("join")) {
            // set URL to index page
            url = "/index.html";
        }

        // forward request and response objects
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}