package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class VehicleManagerTest {

	private static VehicleManager vehicleManager;
	private Vehicle vehicle_1;
	private Vehicle vehicle_2;
	private VehicleType bmw;
	private VehicleType bmw_1;
	private VehicleType mercedes;
	
	@Before
	public void setUp(){
		bmw = vehicleManager.getInstance().createVehicleType("BMW");
		mercedes = vehicleManager.getInstance().createVehicleType("mercedes");
		bmw_1 = vehicleManager.getInstance().createVehicleType("BMW 1", 150, 200);
		vehicle_1 = vehicleManager.getInstance().createVehicle("AAA AAA", "BMW");
		vehicle_2 = vehicleManager.getInstance().createVehicle("BBB BBB", "BMW 1");
	}
	
	@Test
	public void TestCreateVehicleType(){
		VehicleType test = vehicleManager.getInstance().createVehicleType("BMW",20,40);
		assertEquals("VehicleBrand: BMW", bmw.asString());
		assertEquals("VehicleModel: BMW 1 VehiclePS: 150 maxSpeed: 200", bmw_1.asString());
		assertEquals("VehicleBrand: BMW", test.asString());
	}
	
	@Test
	public void TestCreateVehicle(){
		assertEquals("VehicleBrand: BMW Kennzeichen: AAA AAA", vehicle_1.asString());
		assertEquals("VehicleModel: BMW 1 VehiclePS: 150 maxSpeed: 200 Kennzeichen: BBB BBB", vehicle_2.asString());
	}
}
