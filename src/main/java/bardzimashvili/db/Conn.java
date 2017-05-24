package bardzimashvili.db;

import java.sql.*;

public class Conn
{
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    /**
     * Connect to DB
     * The existence of the file is checked, then the connection to the database
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        try
        {
            new DirAndFiles();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
    }

    /**
     * Create table
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void createDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();

        statmt.execute("CREATE TABLE if not exists 'app' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'nameApp' text, 'descriptions' text, 'size' text, 'category' INT);");

        statmt.execute("CREATE TABLE if not exists 'category' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");

        statmt.execute("CREATE TABLE if not exists 'subcategory' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, category_id INT);");
    }

    /**
     * Writing data to a table
     *
     * @throws SQLException
     */
    public void writeDB() throws SQLException
    {
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Crash Arena', 'descriptions', 'size', '1'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Fly Catbug Fly!', 'descriptions', 'size', '2'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Sumotori Dreams', 'descriptions', 'size', '3'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Facets', 'descriptions', 'size', '4'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('NBA 2K14', 'descriptions', 'size', '1'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Polar Bowler', 'descriptions', 'size', '2'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Domo - Icon Pack', 'descriptions', 'size', '3'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Fix My Car: Custom Mods', 'descriptions', 'size', '4'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('IMPOSSIBLE ROAD', 'descriptions', 'size', '1'); ");
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES ('Goat Rampage', 'descriptions', 'size', '2'); ");

        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Business'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Calc'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Game'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Engineering'); ");

        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Big Business', '1'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Small Business', '1'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Puzzle Games', '3'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Race', '3'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Education', '3'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name', 'category_id') VALUES ('Engineering', '4'); ");
    }

    public void writeTableApp(String name, String descriptions, String size, String category) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'app' ('nameApp', 'descriptions', 'size', 'category') VALUES " +
                           "('" + name + "','" + descriptions + "','" + size + "','" + category + "'); ");
    }

    public ResultSet readTable(String table) throws Exception
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM " + table + "; ");
        return resSet;
    }

    public ResultSet readTableAll() throws Exception
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT id, nameApp, descriptions, size," +
                                         " (SELECT name FROM subcategory WHERE subcategory.id = app.category) AS subcategory," +
                                         " (SELECT " +
                                         "(SELECT name FROM category WHERE category.id = subcategory.category_id) category_id " +
                                         "FROM subcategory WHERE subcategory.id = app.category) AS category_id" +
                                         " FROM app; ");

        return resSet;
    }

    public ResultSet readTableAll(String id) throws Exception
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT id, nameApp, descriptions, size, (SELECT name FROM subcategory WHERE subcategory.id = app.category) AS subcategory," +
                                         " (SELECT " +
                                         "(SELECT name FROM category WHERE category.id = subcategory.category_id) category_id " +
                                         "FROM subcategory WHERE subcategory.id = app.category) AS category_id" +
                                         " FROM app WHERE id = '" + id + "'; ");

        return resSet;
    }

    public ResultSet readTableCategoryWhere(String name) throws Exception
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT (SELECT name FROM category WHERE category.id = subcategory.category_id) AS category FROM subcategory WHERE subcategory.name = '" + name + "'; ");

        return resSet;
    }


    public ResultSet readTableWhere(String table, String id, String name) throws Exception
    {
        resSet = statmt.executeQuery("SELECT * FROM " + table + " WHERE " + name + "='" + id + "'; ");
        return resSet;
    }

    public void updateTableWhere(String id, String nameAppDb, String sizeDb, String descriptionsDb) throws Exception
    {
        statmt.execute("UPDATE app SET nameApp = '" + nameAppDb + "', descriptions = '" + descriptionsDb + "', size = '" + sizeDb + "' WHERE id = '" + id + "'; ");
    }

    public void deleteTableWhere(String id) throws Exception
    {
        statmt.execute("DELETE FROM app WHERE id = '" + id + "'; ");
    }

    public ResultSet searchTableWhere(String nameApp) throws Exception
    {
        statmt.executeQuery("SELECT *, " +
                                     "(SELECT name FROM subcategory WHERE subcategory.id = app.category) AS subcategory," +
                                        " (SELECT " +
                                            "(SELECT name FROM category WHERE category.id = subcategory.category_id) category_id " +
                                                "FROM subcategory WHERE subcategory.id = app.category) AS category_id " +
                                "FROM app WHERE nameApp LIKE '%" + nameApp + "%' OR " +
                                "(SELECT " +
                                "(SELECT name FROM category " +
                                "WHERE category.id = subcategory.category_id AND " +
                                "category.name LIKE '%" + nameApp + "%') AS category_id " +
                                "FROM subcategory WHERE subcategory.id = app.category) " +
                                "LIKE '%" + nameApp + "%'; ");
        return resSet;
    }
}
