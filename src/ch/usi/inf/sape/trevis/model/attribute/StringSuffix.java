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
 * Comparison (prefix) of two string attributes,
 * determining whether the left string ends with the right string.
 * 
 * @see ch.usi.inf.sape.trevis.model.StringMatch
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringSuffix extends BooleanAttribute {

	private final StringAttribute attribute;
	private final StringAttribute suffixAttribute;
	
	
	public StringSuffix(final StringAttribute attribute, final StringAttribute suffixAttribute) {
		this.attribute = attribute;
		this.suffixAttribute = suffixAttribute;
	}
	
	public String getName() {
		return attribute.getName()+"=..."+suffixAttribute.getName();
	}
	
	public String getDescription() {
		return attribute.getName()+" ends with "+suffixAttribute.getName();
	}
	
	public boolean evaluate(final ContextTreeNode node) {
		return attribute.evaluate(node).endsWith(suffixAttribute.evaluate(node));
	}
	
}
