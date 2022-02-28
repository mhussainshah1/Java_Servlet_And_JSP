package murach.util;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class CartSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext sc = session.getServletContext();
        sc.log("Session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}