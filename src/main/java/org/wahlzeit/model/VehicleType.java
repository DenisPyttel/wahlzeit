/*
 * Copyright (c) 2017 by Denis Pyttel
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * VehicleType
 * 
 * Version 1.0
 * 
 * Date 12.01.2018
 */

public class VehicleType{
	
	protected Set<VehicleType> subTypes = new HashSet<VehicleType>();
	protected String model;
	protected int vehiclePS = 0;
	protected int maxSpeed = 0;
	
	public VehicleType(String model){
		this.model = model;
	}
	
	public VehicleType(String model, int vehiclePS, int maxSpeed){
		this.model = model;
		this.vehiclePS = vehiclePS;
		this.maxSpeed = maxSpeed;
	}
	
	public boolean hasInstance(Vehicle vehicle){
		assert (vehicle != null);
		if(vehicle.getVehicleType() == this){
			return true;
		}
		
		for(VehicleType type : subTypes){
			if(type.hasInstance(vehicle)){
				return true;
			}
		}
		return false;
	}
	
	public void addSubtype(VehicleType subType){
		if(!subTypes.contains(subType)){
			subTypes.add(subType);
		}
	}
	
	public void removeSubtype(VehicleType subType){
		subTypes.remove(subType);
	}
	
	public boolean isSubtype(VehicleType vehicleType){
		if(subTypes.contains(vehicleType))
			return true;
		return false;
	}

	public String getModel() {
		return model;
	}
	
	public int getVehiclePS() {
		return vehiclePS;
	}

	public void setVehiclePS(int vehiclePS) {
		this.vehiclePS = vehiclePS;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String asString(){
		if(vehiclePS == 0 && maxSpeed == 0){
			return "VehicleBrand: " + model;
		}
		return "VehicleModel: " + model +
				" VehiclePS: " + vehiclePS +
				" maxSpeed: " + maxSpeed;
	}
}
