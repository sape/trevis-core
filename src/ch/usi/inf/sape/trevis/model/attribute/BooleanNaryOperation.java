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
 * An operation on N boolean attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class BooleanNaryOperation extends BooleanAttribute {

	private final BooleanAttribute[] arguments;
	private final String name;
	private final String description;

	
	public BooleanNaryOperation(final String name, final String description, final BooleanAttribute[] arguments) {
		this.arguments = arguments;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public final boolean evaluate(final ContextTreeNode node) {
		boolean result = neutralElement();
		for (final BooleanAttribute argument : arguments) {
			result = compute(result, argument.evaluate(node));
		}
		return result;
	}
	
	protected abstract boolean neutralElement();
	
	protected abstract boolean compute(final boolean a, final boolean b);

	protected static final String buildDescription(final String operator, final BooleanAttribute[] arguments) {
		final StringBuffer sb = new StringBuffer("(");
		for (int i=0; i<arguments.length-1; i++) {
			sb.append(arguments[i].getName());
			sb.append(operator);
		}
		sb.append(arguments[arguments.length-1].getName());
		return sb.append(")").toString();
	}
	
}
