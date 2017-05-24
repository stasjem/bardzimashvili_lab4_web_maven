package bardzimashvili;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputServletPartOne extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        /**
         * Took the values of variables
         */
        String nameApp = req.getParameter("nameApp");
        String categoryId = req.getParameter("categoryId");
        String size = req.getParameter("size");
        String descriptions = req.getParameter("descriptions");

        //req.setAttribute("testId", testId);
        req.setAttribute("nameApp", nameApp);
        req.setAttribute("categoryId", categoryId);
        req.setAttribute("size", size);
        req.setAttribute("descriptions", descriptions);

        req.getRequestDispatcher("formInputPart2.jsp").forward(req, resp);
    }
}
