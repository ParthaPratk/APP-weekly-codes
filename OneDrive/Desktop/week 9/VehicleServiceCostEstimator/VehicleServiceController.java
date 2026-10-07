import java.awt.event.*;
import javax.swing.*;

public class VehicleServiceController {

    private VehicleServiceModel model;
    private VehicleServiceView view;

    VehicleServiceController(VehicleServiceModel model,
                             VehicleServiceView view) {

        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String registrationNumber =
                    view.registrationField.getText();

                String vehicleType;

                if (view.twoWheeler.isSelected()) {
                    vehicleType = "Two Wheeler";
                } else if (view.car.isSelected()) {
                    vehicleType = "Car";
                } else {
                    JOptionPane.showMessageDialog(
                        view,
                        "Please select a vehicle type."
                    );
                    return;
                }

                if (registrationNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        view,
                        "Please enter the vehicle registration number."
                    );
                    return;
                }

                model.setVehicleDetails(
                    registrationNumber,
                    vehicleType
                );

                model.calculateCost(
                    view.generalService.isSelected(),
                    view.oilChange.isSelected(),
                    view.brakeService.isSelected(),
                    view.batteryCheck.isSelected()
                );

                view.resultLabel.setText(
                    "Rs. " + model.getTotalCost()
                );

                JOptionPane.showMessageDialog(
                    view,
                    "Registration Number: "
                    + model.getRegistrationNumber()
                    + "\nVehicle Type: "
                    + model.getVehicleType()
                    + "\nTotal Service Cost: Rs. "
                    + model.getTotalCost()
                );
            }
        });
    }

    public static void main(String[] args) {

        VehicleServiceModel model =
            new VehicleServiceModel();

        VehicleServiceView view =
            new VehicleServiceView();

        new VehicleServiceController(model, view);
    }
}