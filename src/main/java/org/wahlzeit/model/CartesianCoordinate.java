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

/*
 * CartesianCoordinate
 * 
 * Version 1.0
 * 
 * Date 29.10.2017
 */

public class CartesianCoordinate implements Coordinate{

	private double x,y,z;
	private static final double epsilon = 0.00000001d;
	
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * 
	 */
	public CartesianCoordinate asCartesianCoordinate(){
		return this;
	}

	/**
	 * 
	 */
	public SphericCoordinate asSphericCoordinate(){
		return new SphericCoordinate(Math.atan2(this.y, this.x),
				Math.acos(this.z/ (Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z))),
				Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
	}
	
	/**
	 * Berechnet die Distanz zwischen zwei CartesianCoordinaten (Euclidean distance)
	 */
	public double getCartesianDistance(Coordinate coordinate){
		return Math.sqrt(Math.pow(Math.abs(this.x -  coordinate.asCartesianCoordinate().getX()), 2.0)  + 
				Math.pow(Math.abs(this.y - coordinate.asCartesianCoordinate().getY()), 2.0) + 
				Math.pow(Math.abs(this.z - coordinate.asCartesianCoordinate().getZ()), 2.0));
	}
	
	/**
	 * 
	 */
	public double getSphericDistance(Coordinate coordinate){
		return this.asSphericCoordinate().getSphericDistance(coordinate);
	}

	/**
	 * 
	 */
	public double getDistance(Coordinate coordinate){
		if(coordinate instanceof CartesianCoordinate){
			return this.getCartesianDistance(coordinate);			
		}
		else if(coordinate instanceof SphericCoordinate){
			return this.getCartesianDistance(coordinate.asCartesianCoordinate());
		}
		else{
			return 0.0d;
		}
	}
	
	/**
	 * Vergleicht zwei Double Werte ob diese identisch sind
	 */
	private boolean isDoubleEqual(double a, double b)
	{
		if(Math.abs(a-b)< epsilon){
			return true;
		}
		return false;
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
	
	/**
	 *  Override der Methode equals die zwei Coordinaten mit der Methode isEqual vergleicht
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof CartesianCoordinate){
			return this.isEqual((CartesianCoordinate) obj);
		}
		return false;
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
	public void setX(int x) {
		this.x = x;
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
	public void setY(int y) {
		this.y = y;
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
	public void setZ(int z) {
		this.z = z;
	}
}
