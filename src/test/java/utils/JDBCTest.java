package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        System.out.println("Lets get started!");

        // Establish conection:
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_production",
                "postgres",
                "190590"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from Regions");
//        resultSet.next();
//        System.out.println(resultSet.getString("first_name"));
//        resultSet.next();
//        System.out.println(resultSet.getString("first_name"));

//        while(resultSet.next()){
//            System.out.println("--------------");
//            System.out.println("first_name: " + resultSet.getString("first_name"));
//            System.out.println("last_name: " + resultSet.getString("last_name"));
//            System.out.println("phone_number: " + resultSet.getString("phone_number"));
//            System.out.println("salary: $" + resultSet.getString("salary"));
//        }

        ResultSetMetaData rsmd = resultSet.getMetaData();
//        System.out.println(rsmd.getColumnCount());
//        System.out.println(rsmd.getColumnName(3));
//
//        for(int i = 1 ; i <= rsmd.getColumnCount(); i ++){
//            System.out.println(rsmd.getColumnName(i));
//        }

        List<Map<String, Object>> tableData = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rowData.put(rsmd.getColumnName(i), resultSet.getString(rsmd.getColumnName(i)));
            }
            tableData.add(rowData);
        }
        for (Map<String, Object> el : tableData) System.out.println(el);

    }
}
