import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDao {   //Database Access Object --> Interacts with the database
    public static void addData(Student s) throws Exception{
        Connection con = DB.getConnection();
        String query = Query.insert;

        PreparedStatement pStatement = con.prepareStatement(query);
        pStatement.setInt(1, s.getRoll());
        pStatement.setString(2, s.getName());
        pStatement.setFloat(3, s.getMarks());

        pStatement.execute();
        pStatement.close();
    }

    public static ArrayList<Student> displayData(){
        ArrayList<Student> list = new ArrayList<>();
        Connection con = DB.getConnection();
        String query = Query.select;
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void updateRoll(int old, int newRoll){
        try{
            Connection con = DB.getConnection();
            String query = "UPDATE STUDENT SET ROLL = ? WHERE ROLL = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, newRoll);
            pst.setInt(2, old);

            pst.execute();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateName(int roll, String newName){
        try{
            Connection con = DB.getConnection();
            String query = "UPDATE STUDENT SET NAME = ? WHERE ROLL = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newName);
            pst.setInt(2, roll);

            pst.execute();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateMarks(int roll, float marks){
        try{
            Connection con = DB.getConnection();
            String query = "UPDATE STUDENT SET MARKS = ? WHERE ROLL = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setFloat(1, marks);
            pst.setInt(2, roll);

            pst.execute();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void DeleteData(int roll){
        try{
            Connection con = DB.getConnection();
            String query = Query.delete + roll;

            Statement st = con.createStatement();
            st.execute(query);
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
