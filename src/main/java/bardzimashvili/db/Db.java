package bardzimashvili.db;

import java.sql.SQLException;

public class Db {
    public void db() throws ClassNotFoundException, SQLException {
        Conn conn = new Conn();

        conn.createDB();
        conn.writeDB();
    }
}

