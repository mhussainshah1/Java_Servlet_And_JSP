package murach.http;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/downloadFile")
public class DownloadFileServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/");
        String name = request.getParameter("name");

        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment; filename=" + name);

        FileInputStream in = new FileInputStream(path + "/" + name);
        PrintWriter out = response.getWriter();

        int i = in.read();
        while (i != -1) {
            out.write(i);
            i = in.read();
        }
        in.close();
        out.close();
    }
}