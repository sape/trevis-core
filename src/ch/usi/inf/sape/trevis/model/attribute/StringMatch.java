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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.usi.inf.sape.trevis.model.ContextTreeNode;


/**
 * Comparison (=~) of two string attributes,
 * determining whether the left string matches the regular expression in the right string.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringMatch extends BooleanAttribute {

	private final StringAttribute left;
	private final StringAttribute right;
	private final String name;
	private final String description;

	
	public StringMatch(final StringAttribute left, final StringAttribute right) {
		this(Util.buildDescription("=~", left, right), left, right);
	}

	public StringMatch(final String name, final StringAttribute left, final StringAttribute right) {
		this(name, Util.buildDescription("=~", left, right), left, right);
	}

	public StringMatch(final String name, final String description, final StringAttribute left, final StringAttribute right) {
		this.name = name;
		this.description = description;
		this.left = left;
		this.right = right;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public final boolean evaluate(final ContextTreeNode node) {
		final String text = left.evaluate(node);
		final String patternString = right.evaluate(node);
		final Pattern pattern = Pattern.compile(patternString);
		final Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}
	
}
