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
 * Multiply (*) the values of two long attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongMultiplication extends LongBinaryOperation {
	
	public LongMultiplication(final LongAttribute a, final LongAttribute b) {
		this(Util.buildDescription("*", a, b), a, b);
	}

	public LongMultiplication(final String name, final LongAttribute a, final LongAttribute b) {
		this(name, Util.buildDescription("*", a, b), a, b);
	}

	public LongMultiplication(final String name, final String description, final LongAttribute a, final LongAttribute b) {
		super(name, description, a, b);
	}
	
	public long compute(final long a, final long b) {
		return a*b;
	}
	
}
