import javax.swing.*;
import java.awt.*;

public class VehicleServiceView extends JFrame {

    JTextField registrationField;

    JRadioButton twoWheeler;
    JRadioButton car;

    JCheckBox generalService;
    JCheckBox oilChange;
    JCheckBox brakeService;
    JCheckBox batteryCheck;

    JButton calculateButton;

    JLabel resultLabel;

    VehicleServiceView() {

        setTitle("Vehicle Service Cost Estimator");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 10, 10));

        add(new JLabel("Registration Number:"));
        registrationField = new JTextField();
        add(registrationField);

        add(new JLabel("Vehicle Type:"));

        twoWheeler = new JRadioButton("Two Wheeler");
        car = new JRadioButton("Car");

        ButtonGroup vehicleGroup = new ButtonGroup();
        vehicleGroup.add(twoWheeler);
        vehicleGroup.add(car);

        JPanel vehiclePanel = new JPanel();
        vehiclePanel.add(twoWheeler);
        vehiclePanel.add(car);

        add(vehiclePanel);

        add(new JLabel("Services:"));

        generalService = new JCheckBox("General Service - Rs.1000");
        add(generalService);

        add(new JLabel(""));
        oilChange = new JCheckBox("Oil Change - Rs.800");
        add(oilChange);

        add(new JLabel(""));
        brakeService = new JCheckBox("Brake Service - Rs.1200");
        add(brakeService);

        add(new JLabel(""));
        batteryCheck = new JCheckBox("Battery Check - Rs.500");
        add(batteryCheck);

        add(new JLabel(""));
        calculateButton = new JButton("Calculate Cost");
        add(calculateButton);

        add(new JLabel("Total Service Cost:"));
        resultLabel = new JLabel("Rs. 0");
        add(resultLabel);

        setVisible(true);
    }
}