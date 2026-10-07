import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLoginPreferences extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox rememberMe, notifications;
    JButton loginButton;

    UserLoginPreferences() {

        setTitle("User Login and Preferences");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Preferences:"));

        JPanel preferencePanel = new JPanel();

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        preferencePanel.add(rememberMe);
        preferencePanel.add(notifications);

        add(preferencePanel);

        add(new JLabel(""));

        loginButton = new JButton("Login");
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        UserLoginPreferences.this,
                        "Please enter username and password.",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                    );

                } else {

                    String message = "Login Successful!\n\n"
                            + "Username: " + username + "\n"
                            + "Remember Me: "
                            + (rememberMe.isSelected() ? "Yes" : "No") + "\n"
                            + "Receive Notifications: "
                            + (notifications.isSelected() ? "Yes" : "No");

                    JOptionPane.showMessageDialog(
                        UserLoginPreferences.this,
                        message,
                        "Login Details",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLoginPreferences();
    }
}