package u;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import c.HybridVehicle;

public class HybridVehicleTest {

    private HybridVehicle hv;

    @Before
    public void setUp() {
        // mpg=20, gas=$3.50/gal, electricity=$0.24/kWh
        hv = new HybridVehicle(20.0, 3.50, 0.24);
    }

    @Test
    public void testInitialGetters() {
        assertEquals(20.0, hv.getMpg(), 1e-6);
        assertEquals(3.50, hv.getCostPerGallon(), 1e-6);
        assertEquals(0.24, hv.getCostPerKWh(), 1e-6);
    }

    @Test
    public void testSettersUpdateValues() {
        hv.setMpg(32.5);
        hv.setCostPerGallon(3.99);
        hv.setCostPerKWh(0.21);

        assertEquals(32.5, hv.getMpg(), 1e-6);
        assertEquals(3.99, hv.getCostPerGallon(), 1e-6);
        assertEquals(0.21, hv.getCostPerKWh(), 1e-6);
    }

    @Test
    public void testComputeMpge_HandoutExample() {
        //  300 miles using 70 kWh => 144.43 MPGe
        // (miles/kWh) * 33.7
        double mpge = hv.mpge(300.0, 70.0);
        assertEquals(144.43, mpge, 0.01);
    }

    @Test
    public void testGasTripCost_120Miles() {
        // 120 miles, 20 mpg, $3.50/gal => 6 gallons * 3.50 = $21.00
        double cost = hv.gasTripCost(120.0);
        assertEquals(21.00, cost, 1e-6);
    }

    @Test
    public void testElectricTripCost_OneGallonEquivalent() {
        // 33.7 kWh at $0.24/kWh => $8.088 (~ $8.09 in handout)
        double cost = hv.electricTripCost(120.0, 33.7);
        assertEquals(8.088, cost, 1e-3);
    }

    @Test
    public void testHybridAverageMpg_UsingGasAndElectric() {
        double gasOnly = hv.getMpg();                // 20.0
        double electricOnly = hv.mpge(300.0, 70.0);  // ~144.43
        double avg = hv.hybridAverageMpg(gasOnly, electricOnly);

        assertEquals((gasOnly + electricOnly) / 2.0, avg, 1e-6);
    }

    @Test
    public void testMpgeMonotonicity() {
        // More miles for same kWh => higher MPGe
        double a = hv.mpge(100.0, 25.0);  // 4.0 * 33.7 = 134.8
        double b = hv.mpge(150.0, 25.0);  // 6.0 * 33.7 = 202.2
        assertTrue(b > a);

        // More kWh for same miles => lower MPGe
        double c = hv.mpge(150.0, 30.0);  // 5.0 * 33.7 = 168.5
        assertTrue(c < b);
    }
}
