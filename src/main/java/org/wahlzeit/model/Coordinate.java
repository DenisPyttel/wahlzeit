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
 * Coordinate
 * 
 * Version 1.0
 * 
 * Date 29.10.2017
 */

public class Coordinate {

	private double x,y,z;
	
	public Coordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
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

	/**
	 * Berechnet die Distanz zwischen zwei Coordinaten (Euclidean distance)
	 */
	public double getDistance(Coordinate coordinate){
		return Math.sqrt(Math.pow(Math.abs(this.x - coordinate.getX()), 2.0)  + 
				Math.pow(Math.abs(this.y - coordinate.getY()), 2.0) + 
				Math.pow(Math.abs(this.z - coordinate.getZ()), 2.0)); 
	}
	
	/**
	 * Vergleicht zwei Coordinaten ob diese gleich sind
	 */
	public boolean isEqual(Coordinate coordinate){
		if(this.x == coordinate.getX() && this.y == coordinate.getY() && this.z == coordinate.getZ()){
			return true;
		}else{
			return false;
		}
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
		if(obj instanceof Coordinate){
			return this.isEqual((Coordinate) obj);
		}
		return false;
	}
}
