import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, registerField;
    JRadioButton male, female, other;
    JComboBox<String> departmentBox;
    JButton submitButton;

    StudentRegistration() {

        setTitle("Student Registration System");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        
        add(new JLabel("Register Number:"));
        registerField = new JTextField();
        add(registerField);

        
        add(new JLabel("Gender:"));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        add(genderPanel);

        add(new JLabel("Department:"));

        String departments[] = {
            "Computer Science",
            "Information Technology",
            "Electronics",
            "Mechanical",
            "Civil"
        };

        departmentBox = new JComboBox<>(departments);
        add(departmentBox);

        
        add(new JLabel(""));
        submitButton = new JButton("Submit");
        add(submitButton);

        
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String registerNo = registerField.getText();

                String gender;

                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                } else if (other.isSelected()) {
                    gender = "Other";
                } else {
                    gender = "Not Selected";
                }

                String department =
                    departmentBox.getSelectedItem().toString();

                String message =
                    "Student Registration Details\n\n" +
                    "Name: " + name + "\n" +
                    "Register Number: " + registerNo + "\n" +
                    "Gender: " + gender + "\n" +
                    "Department: " + department;

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    message,
                    "Registration Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}