import java.awt.event.*;
import javax.swing.*;

public class StudentController {

    private StudentModel model;
    private StudentView view;

    StudentController(StudentModel model, StudentView view) {

        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    String name = view.nameField.getText();

                    int mark1 = Integer.parseInt(
                        view.mark1Field.getText()
                    );

                    int mark2 = Integer.parseInt(
                        view.mark2Field.getText()
                    );

                    int mark3 = Integer.parseInt(
                        view.mark3Field.getText()
                    );

                    if (name.isEmpty() ||
                        mark1 < 0 || mark1 > 100 ||
                        mark2 < 0 || mark2 > 100 ||
                        mark3 < 0 || mark3 > 100) {

                        JOptionPane.showMessageDialog(
                            view,
                            "Enter valid student details and marks between 0 and 100."
                        );

                        return;
                    }

                    model.setStudentDetails(
                        name,
                        mark1,
                        mark2,
                        mark3
                    );

                    model.calculateResult();

                    view.totalLabel.setText(
                        String.valueOf(model.getTotal())
                    );

                    view.averageLabel.setText(
                        String.format("%.2f", model.getAverage())
                    );

                    view.gradeLabel.setText(
                        String.valueOf(model.getGrade())
                    );

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                        view,
                        "Please enter valid numeric marks."
                    );
                }
            }
        });
    }

    public static void main(String[] args) {

        StudentModel model = new StudentModel();
        StudentView view = new StudentView();

        new StudentController(model, view);
    }
}