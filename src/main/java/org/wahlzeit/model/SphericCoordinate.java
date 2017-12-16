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

import java.util.ArrayList;

/*
 * SphericCoordinate
 * 
 * Version 1.0
 * 
 * Date 17.11.2017
 */

public class SphericCoordinate extends AbstractCoordinate{

	private static ArrayList<SphericCoordinate> allSphericCoordinate = new ArrayList<SphericCoordinate>();
	final private double latitude;
	final private double longitude;
	final private double radius;
	
	/**
	 * 
	 * @param latitude the range of latitude is [0, 2*PI)
	 * @param longitude the range of longitude is [0, PI]
	 * @param radius the radius should be a positive double value
	 */
	private SphericCoordinate(double latitude, double longitude, double radius){
		//Preconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public static SphericCoordinate getSphericCoordinate(double latitude, double longitude, double radius){
		SphericCoordinate temp = allSphericCoordinates(latitude, longitude, radius);
		if(temp == null){
			temp = new SphericCoordinate(latitude, longitude, radius);
			allSphericCoordinate.add(temp);
			return temp;
		}
		else{
			return temp;
		}
	}
	
	public static SphericCoordinate allSphericCoordinates(double latitude, double longitude, double radius){
		for(int i = 0; i < allSphericCoordinate.size(); i++){
			if(isDoubleEqual(allSphericCoordinate.get(i).getLatitude(), latitude)&& isDoubleEqual(allSphericCoordinate.get(i).getLongitude(), longitude) && isDoubleEqual(allSphericCoordinate.get(i).getRadius(), radius)){
				return allSphericCoordinate.get(i);
			}
		}
		return null;
	}
	
	public SphericCoordinate asSphericCoordinate(){
		return this;
	}
	
	/**
	 * Converts the SphericCoordinate into a CartesianCoordinate
	 */
	public CartesianCoordinate asCartesianCoordinate(){
		assertClassInvariants();
		double x = this.radius * Math.sin(this.longitude) * Math.cos(this.latitude);
		double y = this.radius * Math.sin(this.longitude) * Math.sin(this.latitude);
		double z = this.radius * Math.cos(longitude);
		
		//Postconditions
		assertIsValidDoubleValue(x);
		assertIsValidDoubleValue(y);
		assertIsValidDoubleValue(z);
		
		assertClassInvariants();
		
		return CartesianCoordinate.getCartesianCoordinate(x, y, z);
	}
	
	/**
	 * Vergleicht zwei Coordinaten ob diese identisch sind
	 */
	public boolean isEqual(Coordinate coordinate){
		if(coordinate instanceof SphericCoordinate){
			if(isDoubleEqual(this.latitude,coordinate.asSphericCoordinate().getLatitude()) && isDoubleEqual(this.longitude,coordinate.asSphericCoordinate().getLongitude()) && isDoubleEqual(this.radius,coordinate.asSphericCoordinate().getRadius())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public void assertClassInvariants(){
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
	}

	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setLatitude(double latitude) {
		//Preconditions
		assertIsValidLatitude(latitude);
		return getSphericCoordinate(latitude, this.longitude, this.radius);
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setLongitude(double longitude) {
		//Preconditions
		assertIsValidLongitude(longitude);
		return getSphericCoordinate(this.latitude, longitude, this.radius);
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setRadius(double radius) {
		//Preconditions
		assertIsValidRadius(radius);	
		return getSphericCoordinate(this.latitude, this.longitude, radius);
	}
}
