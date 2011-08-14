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
 * Comparison (>) of two string attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringGreaterThan extends BooleanAttribute {

	private final StringAttribute a;
	private final StringAttribute b;
	private final String name;
	private final String description;

	
	public StringGreaterThan(final StringAttribute a, final StringAttribute b) {
		this(Util.buildDescription(">", a, b), a, b);
	}

	public StringGreaterThan(final String name, final StringAttribute a, final StringAttribute b) {
		this(name, Util.buildDescription(">", a, b), a, b);
	}

	public StringGreaterThan(final String name, final String description, final StringAttribute a, final StringAttribute b) {
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
		return a.evaluate(node).compareTo(b.evaluate(node))>0;
	}
	
}
