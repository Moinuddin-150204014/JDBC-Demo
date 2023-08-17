package bjit.academy;

import java.sql.*;

public class DBOperations {
    Connection conn;
    public void doConnectDB() {
        String connectionStr = "jdbc:mysql://localhost:3306/"+Utils.DB_NAME;
        String userName = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(connectionStr, userName, password);
            System.out.println("DB Connection is successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchData() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+Utils.TABLE_NAME + " emp JOIN " + Utils.TABLE_NAME1 + " dept ON emp.id = dept.department_id");

            while (rs.next()) {
                String name = rs.getString(Utils.COLUMN_EMPNAME);
                int age = rs.getInt(Utils.COLUMN_AGE);
                String bloodGroup = rs.getString(Utils.COLUMN_BG);
                String deptName = rs.getString(Utils.DEPARTMENT_NAME);
                System.out.println("Name: " + name + ", Age: " + age + ", Blood group: "+bloodGroup + ", DPT name: " + deptName);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}