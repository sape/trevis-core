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
 * A binary operation on two long attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class LongBinaryOperation extends LongAttribute {

	private final LongAttribute a;
	private final LongAttribute b;
	private final String name;
	private final String description;

	
	public LongBinaryOperation(final String name, final String description, final LongAttribute a, final LongAttribute b) {
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
	
	public final long evaluate(final ContextTreeNode node) {
		return compute(a.evaluate(node), b.evaluate(node));
	}
	
	protected abstract long compute(final long a, final long b);

}
