public class VehicleServiceModel {

    private String registrationNumber;
    private String vehicleType;
    private int totalCost;

    public void setVehicleDetails(String registrationNumber, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public void calculateCost(boolean generalService,
                              boolean oilChange,
                              boolean brakeService,
                              boolean batteryCheck) {

        totalCost = 0;

        if (generalService) {
            totalCost += 1000;
        }

        if (oilChange) {
            totalCost += 800;
        }

        if (brakeService) {
            totalCost += 1200;
        }

        if (batteryCheck) {
            totalCost += 500;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getTotalCost() {
        return totalCost;
    }
}