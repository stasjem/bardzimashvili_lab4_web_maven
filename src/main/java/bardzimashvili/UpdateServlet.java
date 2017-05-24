package bardzimashvili;

import bardzimashvili.db.Conn;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet implements Properties
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String id = req.getParameter("idDb");
        String nameAppDb = req.getParameter("nameApp");
        String sizeDb = req.getParameter("size");
        String descriptionsDb = req.getParameter("descriptions");

        try
        {
            Conn conn = new Conn();

            try
            {
                conn.updateTableWhere(id, nameAppDb, sizeDb, descriptionsDb);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        req.getRequestDispatcher("allList.jsp").forward(req, resp);
    }

}
