package bardzimashvili;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String nameApp = req.getParameter("nameApp").trim();
        req.setAttribute("nameApp", nameApp);
        req.getRequestDispatcher("searchView.jsp").forward(req, resp);
    }
}
