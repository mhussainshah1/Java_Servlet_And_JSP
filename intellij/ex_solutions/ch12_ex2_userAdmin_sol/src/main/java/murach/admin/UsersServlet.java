package murach.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import murach.business.User;
import murach.data.UserDB;

import java.io.IOException;
import java.util.ArrayList;

public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("display_users")) {
            // get list of users
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        } else if (action.equals("display_user")) {
            String emailAddress = request.getParameter("email");
            User user = UserDB.selectUser(emailAddress);
            session.setAttribute("user", user);
            url = "/user.jsp";
        } else if (action.equals("update_user")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // get and update user
            User user = (User) session.getAttribute("user");
            user.setFirstName(firstName);
            user.setLastName(lastName);
            UserDB.update(user);

            // get and set updated users
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        } else if (action.equals("delete_user")) {
            // get the user
            String email = request.getParameter("email");
            User user = UserDB.selectUser(email);

            // delte the user
            UserDB.delete(user);

            // get and set updated users
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);
        }

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