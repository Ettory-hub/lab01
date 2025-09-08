package c;

public interface Electric {
    void setCostPerKWh(double dollarsPerKWh);
    double getCostPerKWh();

    // You can model efficiency as "kWh used over some miles" and compute MPGe on demand.
    default double computeMPGe(double miles, double kWhUsed) {
        // 1 gallon ≡ 33.7 kWh
        return (miles / kWhUsed) * 33.7;
    }
}
