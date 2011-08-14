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
 * Negate (-) the value of a long attribute.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongNegation extends LongAttribute {
	
	private final LongAttribute argument;
	private final String name;
	private final String description;
	

	public LongNegation(final LongAttribute argument) {
		this("-", argument);
	}

	public LongNegation(final String name, final LongAttribute argument) {
		this(name, "-"+argument.getName(), argument);
	}

	public LongNegation(final String name, final String description, final LongAttribute argument) {
		this.argument = argument;
		this.name = name;
		this.description = description;
	}

	public long evaluate(final ContextTreeNode node) {
		return -argument.evaluate(node);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
