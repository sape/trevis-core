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
 * Concatenate (+) the values of two or more string attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringConcat extends StringAttribute {

	private final StringAttribute[] arguments;
	private final String name;
	private final String description;
	
	
	public StringConcat(final StringAttribute left, final StringAttribute right) {
		this(new StringAttribute[] {left, right});
	}
	
	public StringConcat(final StringAttribute[] arguments) {
		this.arguments = arguments;
		name = "concat";
		description = buildDescription("#", arguments);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String evaluate(final ContextTreeNode node) {
		final StringBuffer sb = new StringBuffer();
		for (final StringAttribute argument : arguments) {
			sb.append(argument.evaluate(node));
		}
		return sb.toString();
	}
	
	protected static final String buildDescription(final String operator, final StringAttribute[] arguments) {
		final StringBuffer sb = new StringBuffer("(");
		for (int i=0; i<arguments.length-1; i++) {
			sb.append(arguments[i].getName());
			sb.append(operator);
		}
		sb.append(arguments[arguments.length-1].getName());
		return sb.append(")").toString();
	}
	
}
