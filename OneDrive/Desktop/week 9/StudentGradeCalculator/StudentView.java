import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {

    JTextField nameField;
    JTextField mark1Field;
    JTextField mark2Field;
    JTextField mark3Field;

    JButton calculateButton;

    JLabel totalLabel;
    JLabel averageLabel;
    JLabel gradeLabel;

    StudentView() {

        setTitle("Student Grade Calculator");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Subject 1 Marks:"));
        mark1Field = new JTextField();
        add(mark1Field);

        add(new JLabel("Subject 2 Marks:"));
        mark2Field = new JTextField();
        add(mark2Field);

        add(new JLabel("Subject 3 Marks:"));
        mark3Field = new JTextField();
        add(mark3Field);

        add(new JLabel(""));
        calculateButton = new JButton("Calculate Result");
        add(calculateButton);

        add(new JLabel("Total:"));
        totalLabel = new JLabel();
        add(totalLabel);

        add(new JLabel("Average:"));
        averageLabel = new JLabel();
        add(averageLabel);

        add(new JLabel("Grade:"));
        gradeLabel = new JLabel();
        add(gradeLabel);

        setVisible(true);
    }
}