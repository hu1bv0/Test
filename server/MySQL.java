package dragon.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class MySQL {
    
    private final Connection conn;
    private static final Object LOCK = new Object();
    
    public MySQL(String host, String database, String user, String pass) throws SQLException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        synchronized (LOCK) {
            this.conn = DriverManager.getConnection(String.format(URL_FORMAT, host, database), user, pass);
        }
    }
    
    public static MySQL createData1() throws SQLException {
        return new MySQL("Localhost", "ae_data", "root", " ");
    }
    
    public static MySQL createData2() throws SQLException {
        return new MySQL("Localhost", "ae_game", "root", " ");
    }
    
    public static MySQL createData3() throws SQLException {
        return new MySQL("Localhost", "ae_player", "root", " ");
    }
    
    public static MySQL createData4() throws SQLException {
        return new MySQL("Localhost", "ae_rank", "root", " ");
    }
    
    public static MySQL createData5() throws SQLException {
        return new MySQL("Localhost", "ae_lucky", "root", " ");
    }
    
    public static MySQL createData6() throws SQLException {
        return new MySQL("Localhost", "ae_option", "root", " ");
    }
    
    public static MySQL createData7() throws SQLException {
        return new MySQL("Localhost", "ae_effect", "root", " ");
    }
    
    public static MySQL createData8() throws SQLException {
        return new MySQL("Localhost", "ae_game2", "root", " ");
    }
    
//    public static MySQL createData1() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_data", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData2() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_game", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData3() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_player", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData4() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_rank", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData5() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_lucky", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData6() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_option", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData7() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_effect", "root", "J(A*j39f bv03");
//    }
//    
//    public static MySQL createData8() throws SQLException {
//        return new MySQL("Localhost", "ngocrong_game2", "root", "J(A*j39f bv03");
//    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    //static
    
    private static final String URL_FORMAT = "jdbc:mysql://%s/%s";
}
