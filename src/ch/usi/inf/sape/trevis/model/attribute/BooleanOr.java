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
 * Compute the OR (|) of two boolean attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class BooleanOr extends BooleanNaryOperation {

	public BooleanOr(final BooleanAttribute a, final BooleanAttribute b) {
		this(new BooleanAttribute[] {a, b});
	}
	
	public BooleanOr(final BooleanAttribute[] arguments) {
		this(BooleanNaryOperation.buildDescription("|", arguments), arguments);
	}

	public BooleanOr(final String name, final BooleanAttribute[] arguments) {
		this(name, BooleanNaryOperation.buildDescription("|", arguments), arguments);
	}

	public BooleanOr(final String name, final String description, final BooleanAttribute[] arguments) {
		super(name, description, arguments);
	}

	protected boolean neutralElement() {
		return false;
	}
	
	public boolean compute(final boolean a, final boolean b) {
		return a|b;
	}
	
}
