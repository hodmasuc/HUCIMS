package so.edu.hodmas.ims.hucims;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String url ;
    String user;
    String password;
    String databaseName;


    public Database( String user, String password, String databaseName) {
        this.url = "jdbc:mysql://localhost:3306/"+databaseName+"?allowMultiQueries=true";
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;
    }


    public Connection connect (){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection to MySQL has been established.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }




}
