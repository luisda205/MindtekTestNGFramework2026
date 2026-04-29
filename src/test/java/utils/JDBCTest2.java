package utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String, Object>> data = JDBCUtils.runQuery("select * from departments");

    }
}
