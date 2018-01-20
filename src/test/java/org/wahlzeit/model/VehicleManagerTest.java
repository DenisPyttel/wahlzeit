package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class VehicleManagerTest {

	private Vehicle vehicle_1;
	private Vehicle vehicle_2;
	private Vehicle vehicle_3;
	
	private VehicleType bmw;
	private VehicleType bmw_1;
	private VehicleType bmw_3;
	private VehicleType mercedes;
	private VehicleType mercedes_A_Klasse;
	
	@Before
	public void setUp(){
		bmw = VehicleManager.getInstance().createVehicleType("BMW");
		mercedes = VehicleManager.getInstance().createVehicleType("Mercedes");
		bmw_1 = VehicleManager.getInstance().createVehicleType("BMW 1", 150, 200);
		bmw_3 = VehicleManager.getInstance().createVehicleType("BMW 3", 300, 270);
		mercedes_A_Klasse = VehicleManager.getInstance().createVehicleType("Mercedes A-Klasse", 200, 250);
		bmw.addSubtype(bmw_1);
		bmw.addSubtype(bmw_3);
		mercedes.addSubtype(mercedes_A_Klasse);
		
		vehicle_1 = VehicleManager.getInstance().createVehicle("AAA AAA", "BMW");
		vehicle_2 = VehicleManager.getInstance().createVehicle("BBB BBB", "Mercedes A-Klasse");
		vehicle_3 = VehicleManager.getInstance().createVehicle("CCC CCC", "BMW 1");
	}
	
	@Test
	public void TestCreateVehicle(){
		assertEquals("VehicleBrand: BMW Kennzeichen: AAA AAA", vehicle_1.asString());
		assertEquals("VehicleModel: Mercedes A-Klasse VehiclePS: 200 maxSpeed: 250 Kennzeichen: BBB BBB", vehicle_2.asString());
		assertEquals("VehicleModel: BMW 1 VehiclePS: 150 maxSpeed: 200 Kennzeichen: CCC CCC", vehicle_3.asString());
		vehicle_3.setVehicleType(vehicle_2.getVehicleType());
		vehicle_3.getVehicleType().setVehiclePS(700);
		assertEquals("VehicleModel: Mercedes A-Klasse VehiclePS: 700 maxSpeed: 250 Kennzeichen: BBB BBB", vehicle_2.asString());
		assertEquals("VehicleModel: Mercedes A-Klasse VehiclePS: 700 maxSpeed: 250 Kennzeichen: CCC CCC", vehicle_3.asString());		
	}
	
	@Test
	public void TestCreateVehicleType(){
		assertEquals("VehicleBrand: BMW", bmw.asString());
		assertEquals("VehicleModel: BMW 1 VehiclePS: 150 maxSpeed: 200", bmw_1.asString());
		assertEquals("VehicleBrand: Mercedes", mercedes.asString());
		assertEquals("VehicleModel: BMW 3 VehiclePS: 300 maxSpeed: 270", bmw_3.asString());
	}
}
