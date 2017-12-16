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
 * CartesianCoordinate
 * 
 * Version 1.0
 * 
 * Date 29.10.2017
 */

public class CartesianCoordinate extends AbstractCoordinate{

	private static ArrayList<CartesianCoordinate> allCartesianCoordinate = new ArrayList<CartesianCoordinate>();
	private final double x,y,z;
	
	private CartesianCoordinate(double x, double y, double z){
		//Preconditions
		assertIsValidDoubleValue(x);
		assertIsValidDoubleValue(y);
		assertIsValidDoubleValue(z);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z){
		CartesianCoordinate temp = allCartesianCoordinate(x,y,z);
		if(temp == null){
			temp = new CartesianCoordinate(x,y,z);
			allCartesianCoordinate.add(temp);
			return temp;
		}
		else{
			return temp;
		}
	}
	
	public static CartesianCoordinate allCartesianCoordinate(double x, double y, double z){
		for(int i = 0; i < allCartesianCoordinate.size(); i++){
			if(isDoubleEqual(allCartesianCoordinate.get(i).getX(), x) && isDoubleEqual(allCartesianCoordinate.get(i).getY(), y) && isDoubleEqual(allCartesianCoordinate.get(i).getZ(), z)){
				return allCartesianCoordinate.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 
	 */
	public CartesianCoordinate asCartesianCoordinate(){
		return this;
	}

	/**
	 * Converts the CartesianCoordinate into a SphericCoordinate
	 */
	public SphericCoordinate asSphericCoordinate(){		
		assertClassInvariants();	
		//Preconditions
		assertIsValidRadicand(this.x * this.x + this.y * this.y + this.z * this.z);
		assertIsValidDivisor(Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
		
		double latitude = Math.atan2(this.y, this.x);
		double longitude = Math.acos(this.z / (Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z)));
		double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		
		//Postconditions
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		assertClassInvariants();	
		
		return SphericCoordinate.getSphericCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * Vergleicht zwei Coordinaten ob diese identisch sind
	 */
	public boolean isEqual(Coordinate coordinate){
		if(coordinate instanceof CartesianCoordinate){
			if(isDoubleEqual(this.x,coordinate.asCartesianCoordinate().getX()) && isDoubleEqual(this.y,coordinate.asCartesianCoordinate().getY()) && isDoubleEqual(this.z,coordinate.asCartesianCoordinate().getZ())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public void assertClassInvariants(){
		assertIsValidDoubleValue(x);
		assertIsValidDoubleValue(y);
		assertIsValidDoubleValue(z);
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setX(int x) {
		//Preconditions
		assertIsValidDoubleValue(x);
		return getCartesianCoordinate(x, this.y, this.z);
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setY(int y) {
		//Preconditions
		assertIsValidDoubleValue(y);
		return getCartesianCoordinate(this.x, y, this.z);
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setZ(int z) {
		//Preconditions
		assertIsValidDoubleValue(z);
		return getCartesianCoordinate(this.x, this.y, z);
	}
}
