package u;

import c.HybridVehicle;
import org.junit.Test;
import static org.junit.Assert.*;

public class HybridVehicleTest {

    @Test
    public void testMpgeExample() {
        HybridVehicle hv = new HybridVehicle(20.0, 3.50, 0.24);
        double mpge = hv.mpge(300.0, 70.0);
        assertEquals(144.43, mpge, 0.01); // from the lab example
    }

    @Test
    public void testHybridAverage() {
        HybridVehicle hv = new HybridVehicle(20.0, 3.50, 0.24);
        double avg = hv.hybridAverageMpg(20.0, 144.43);
        assertEquals((20.0 + 144.43) / 2.0, avg, 1e-6);
    }

    @Test
    public void testCostsFor120Miles() {
        HybridVehicle hv = new HybridVehicle(20.0, 3.50, 0.24);
        // Gas: 120mi at 20mpg = 6 gal * $3.50 = $21.00 (as in spec)
        assertEquals(21.00, hv.gasTripCost(120.0), 1e-6);

        // Electric: 33.7 kWh costs 33.7 * $0.24 = $8.088 ≈ $8.09 (as in spec)
        assertEquals(8.09, hv.electricTripCost(120.0, 33.7), 0.01);
    }
}
