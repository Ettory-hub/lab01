package c;

public class CarRunner {
    public static void main(String[] args) {
        // Given in the assignment:
        double gasPrice = 3.50;
        double kwhPrice = 0.24;

        
        HybridVehicle hv = new HybridVehicle(20.0, gasPrice, kwhPrice);

        double mpg = hv.getMpg();


        // 300 miles using 70 kWh => 144.43 MPGe
        double mpge = hv.mpge(300.0, 70.0);

        // Average “hybrid” mpg:
        double avgHybrid = hv.hybridAverageMpg(mpg, mpge);

        System.out.printf("Gas-only MPG: %.2f%n", mpg);
        System.out.printf("Electric-only MPGe: %.2f%n", mpge);
        System.out.printf("Hybrid (half/half) average MPG: %.2f%n", avgHybrid);

        //  trip costs 
        double electricTripCost120 = hv.electricTripCost(120.0, 33.7); // 1 “gallon equivalent”
        double gasTripCost120 = hv.gasTripCost(120.0);
        System.out.printf("120mi electric cost (33.7 kWh): $%.2f%n", electricTripCost120);
        System.out.printf("120mi gas cost (mpg=%.1f): $%.2f%n", mpg, gasTripCost120);
    }
}
