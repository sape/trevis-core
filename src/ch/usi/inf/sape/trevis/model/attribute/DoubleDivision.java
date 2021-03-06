/*
 * This file is licensed to You under the "Simplified BSD License".
 * You may not use this software except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/bsd-license.php
 *
 * See the COPYRIGHT file distributed with this work for information
 * regarding copyright ownership.
 */
package ch.usi.inf.sape.trevis.model.attribute;


/**
 * Divide (/) the values of two double attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DoubleDivision extends DoubleBinaryOperation {
	
	public DoubleDivision(final DoubleAttribute a, final DoubleAttribute b) {
		this(Util.buildDescription("/", a, b), a, b);
	}

	public DoubleDivision(final String name, final DoubleAttribute a, final DoubleAttribute b) {
		this(name, Util.buildDescription("/", a, b), a, b);
	}

	public DoubleDivision(final String name, final String description, final DoubleAttribute a, final DoubleAttribute b) {
		super(name, description, a, b);
	}
	
	public double compute(final double a, final double b) {
		return a/b;
	}
	
}
