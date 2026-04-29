package utils;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmailList extends TestBase{
        // test every email
        @Test
    public void testEmailValidity() throws SQLException {
            JDBCUtils.establishConnection();
            List<Map<String, Object>> data = JDBCUtils.runQuery("");
        }
}
