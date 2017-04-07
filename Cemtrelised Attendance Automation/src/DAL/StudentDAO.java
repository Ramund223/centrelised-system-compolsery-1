/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emil
 */
public class StudentDAO 
{
//    String query = "select COF_NAME, SUP_ID, PRICE, " +
//                   "SALES, TOTAL " +
//                   "from " + "CS_2016A_21 Attendance" + ".COFFEES";
    
    public List<Student> getAllStudents() throws SQLServerException, SQLException, IOException
    {
        ConnectionManager cm = new ConnectionManager();
        ArrayList<Student> allStudents = new ArrayList<>();
        try(Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Student";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
//               Student s = new Student("Name", "ID", "Class", true, "Picture");
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String school = rs.getString("School");
                String classRoom = rs.getString("Class");
                boolean present = rs.getBoolean("Present");
                String picture = rs.getString("Picture");
                
                Student student = new Student(name, id, school, classRoom, present, picture);
                allStudents.add(student);
            }
        }
        return allStudents;
    }
}
