package murach.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.util.PasswordUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class CheckPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // check strength requirements
        String message;
        try {
            PasswordUtil.checkPasswordStrength(password);
            message = "";
        } catch (Exception e) {
            message = e.getMessage();
        }
        request.setAttribute("message", message);

        // hash and salt password
        String hashedPassword;
        String salt = "";
        String saltedAndHashedPassword;
        try {
            hashedPassword = PasswordUtil.hashPassword(password);
            salt = PasswordUtil.getSalt();
            saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);

        } catch (NoSuchAlgorithmException ex) {
            hashedPassword = ex.getMessage();
            saltedAndHashedPassword = ex.getMessage();
        }
        request.setAttribute("hashedPassword", hashedPassword);
        request.setAttribute("salt", salt);
        request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);

        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}