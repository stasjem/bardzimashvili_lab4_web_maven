package bardzimashvili;

import bardzimashvili.db.Conn;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditServlet extends HttpServlet implements Properties
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String id = req.getParameter("id");

        try
        {
            ResultSet resSet;
            Conn conn = new Conn();
            try
            {
                resSet = conn.readTableAll(id);
                while (resSet.next())
                {
                    String idDb = resSet.getString("id");
                    String nameAppDb = resSet.getString("nameApp");
                    String sizeDb = resSet.getString("size");
                    String descriptionsDb = resSet.getString("descriptions");
                    String category = resSet.getString("subcategory");
                    String category_id = resSet.getString("category_id");

                    req.setAttribute("idDb", idDb);
                    req.setAttribute("nameAppDb", nameAppDb);
                    req.setAttribute("category", category);
                    req.setAttribute("category_id", category_id);
                    req.setAttribute("sizeDb", sizeDb);

                    req.setAttribute("descriptionsDb", descriptionsDb);

                    req.getRequestDispatcher("editApp.jsp").forward(req, resp);
                }
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
    }
}
