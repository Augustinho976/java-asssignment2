import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.sql.ResultSet;

public class ResultDtails {
    String host = "localhost";
    String port = "5432";
    String db_name = "postgres";
    String username = "postgres";
    String password = "33744525";


    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "5432";
        String db_name = "postgres";
        String username = "postgres";
        String password = "33744525";
        Statement stmt;
       String query;
        //ResultSet rs;

        Object rowData[][] = {{"Row1-Col1", "Row1-Col2", "Row1-Col3"}};
        Object columnNames[] = {"student_id", "name", "grade"};

        DefaultTableModel newModel = new DefaultTableModel(rowData, columnNames);
        JTable table = new JTable(newModel);
        Statement statement = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
             query = "Select * from result2";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        query = "SELECT student_id, name, grade FROM result2";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        // the gui
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(450, 180);
        frame.setVisible(true);

        // remove the temporary row
        newModel.removeRow(0);

        //temporary object array
        Object[] rows;

        while (rs.next()) {
            rows = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)};
            newModel.addRow(rows);
        }
    }
    }


