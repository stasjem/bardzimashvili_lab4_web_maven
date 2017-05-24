package bardzimashvili;

import bardzimashvili.db.Conn;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InputServletPartTwo extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String nameApp = req.getParameter("nameApp");
        String size = req.getParameter("size");
        String descriptions = req.getParameter("descriptions");
        String subcategoryId = req.getParameter("subcategoryId");

        try
        {
            Conn conn = null;
            try
            {
                conn = new Conn();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            conn.writeTableApp(nameApp, descriptions, size, subcategoryId);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }
}
