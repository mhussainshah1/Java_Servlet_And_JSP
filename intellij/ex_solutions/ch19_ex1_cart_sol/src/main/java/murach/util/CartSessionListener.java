package murach.util;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CartSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.log("Session created");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        // no cleanup necessary
    }
}