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

            // set as a request attribute
            request.setAttribute("users", users);

            // forward to index.jsp

        } else if (action.equals("display_user")) {
            // get user for specified email
            String email = request.getParameter("email");
            User user = UserDB.selectUser(email);

            // set as session attribute
            session.setAttribute("user", user);

            // forward to user.jsp
            url = "/user.jsp";
        } else if (action.equals("update_user")) {
            // update user in database
            User user = UserDB.selectUser(request.getParameter("email"));
            UserDB.update(user);

            // get current user list and set as request attribute
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users", users);

            // forward to index.jsp
        } else if (action.equals("delete_user")) {
            // get the user for the specified email
            // delete the user            
            // get current list of users
            // set as request attribute
            // forward to index.jsp
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