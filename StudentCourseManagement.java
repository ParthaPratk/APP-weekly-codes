import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentCourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;
    DefaultTableModel model;
    JTextField studentName;
    JButton addButton, removeButton;

    StudentCourseManagement() {

        setTitle("Student Course Management System");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        studentName = new JTextField();

        String[] courses = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Computer Networks",
            "Operating Systems"
        };

        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane courseScrollPane = new JScrollPane(courseList);

        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.add(new JLabel("Available Courses"), BorderLayout.NORTH);
        leftPanel.add(courseScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(new JLabel("Student Name:"), BorderLayout.WEST);
        inputPanel.add(studentName, BorderLayout.CENTER);

        addButton = new JButton("Add Registration");
        removeButton = new JButton("Remove Registration");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(table);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.add(inputPanel, BorderLayout.NORTH);
        rightPanel.add(tableScrollPane, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = studentName.getText();
                String course = courseList.getSelectedValue();

                if (name.isEmpty() || course == null) {
                    JOptionPane.showMessageDialog(
                        StudentCourseManagement.this,
                        "Enter student name and select a course."
                    );
                } else {
                    model.addRow(new Object[] {
                        name,
                        course,
                        "Enrolled"
                    });

                    studentName.setText("");
                    courseList.clearSelection();
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row >= 0) {
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                        StudentCourseManagement.this,
                        "Select a registration to remove."
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentCourseManagement();
    }
}