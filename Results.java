import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Results {
    private JTextField txtID;
    private JTextField txtName;
    private JTextArea textA;
    private JButton saveButton;
    private JButton readButton;
    private JPanel Main;
    private JTable table1;
    //private JTextField txtGrade;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Results");
        frame.setContentPane(new Results().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Results() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String myId = txtID.getText();
                String myName = txtName.getText();
                String myGrade = textA.getText();
             ;


                Connection connection = null;
                ResultSet rs = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "postgres";
                String username = "postgres";
                String password = "33744525";
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");

                    if (connection != null) {
                        String query = "insert into result2 values('" + myId + "', '" + myName + "', '" + myGrade + "')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(query);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(saveButton, "Already saved!!");
                        } else {
                            JOptionPane.showMessageDialog(saveButton, "Saved!!");
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ResultDtails.main(new String[0]);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

        });
    }
}
