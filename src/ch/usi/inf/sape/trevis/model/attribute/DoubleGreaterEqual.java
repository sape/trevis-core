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

import ch.usi.inf.sape.trevis.model.ContextTreeNode;


/**
 * Comparison (>=) of two double attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DoubleGreaterEqual extends BooleanAttribute {

	private final DoubleAttribute a;
	private final DoubleAttribute b;
	private final String name;
	private final String description;

	
	public DoubleGreaterEqual(final DoubleAttribute a, final DoubleAttribute b) {
		this(Util.buildDescription(">=", a, b), a, b);
	}

	public DoubleGreaterEqual(final String name, final DoubleAttribute a, final DoubleAttribute b) {
		this(name, Util.buildDescription(">=", a, b), a, b);
	}

	public DoubleGreaterEqual(final String name, final String description, final DoubleAttribute a, final DoubleAttribute b) {
		this.name = name;
		this.description = description;
		this.a = a;
		this.b = b;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public final boolean evaluate(final ContextTreeNode node) {
		return a.evaluate(node)>=b.evaluate(node);
	}
	
}
