import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/MyDB";
            String username = "root";
            String password = "MySQL@987";
            
            con = DriverManager.getConnection(url, username, password);

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
