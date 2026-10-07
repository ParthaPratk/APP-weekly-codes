public class StudentModel {

    private String studentName;
    private int mark1;
    private int mark2;
    private int mark3;
    private int total;
    private double average;
    private char grade;

    public void setStudentDetails(String name, int m1, int m2, int m3) {
        studentName = name;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
    }

    public void calculateResult() {
        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public char getGrade() {
        return grade;
    }
}