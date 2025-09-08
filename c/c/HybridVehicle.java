package c;

public class HybridVehicle implements Gasoline, Electric {
    private double costPerGallon;
    private double costPerKWh;
    private double mpg; // gas-only efficiency

    public HybridVehicle(double mpg, double costPerGallon, double costPerKWh) {
        this.mpg = mpg;
        this.costPerGallon = costPerGallon;
        this.costPerKWh = costPerKWh;
    }

    // --- Gasoline ---
    @Override
    public void setCostPerGallon(double dollarsPerGallon) { this.costPerGallon = dollarsPerGallon; }
    @Override
    public double getCostPerGallon() { return costPerGallon; }
    @Override
    public void setMpg(double mpg) { this.mpg = mpg; }
    @Override
    public double getMpg() { return mpg; }

    // --- Electric ---
    @Override
    public void setCostPerKWh(double dollarsPerKWh) { this.costPerKWh = dollarsPerKWh; }
    @Override
    public double getCostPerKWh() { return costPerKWh; }

    // --- Convenience computations ---
    public double gasTripCost(double miles) {
        double gallons = miles / mpg;
        return gallons * costPerGallon;
    }

    public double electricTripCost(double miles, double kWhUsed) {
        return kWhUsed * costPerKWh;
    }

    public double mpge(double miles, double kWhUsed) {
        return Electric.super.computeMPGe(miles, kWhUsed);
    }

    public double hybridAverageMpg(double mpgGas, double mpgeElectric) {
        // “average MPG (MPG + MPGe)/2” for half-gas/half-electric
        return (mpgGas + mpgeElectric) / 2.0;
    }
}

