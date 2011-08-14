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
 * Comparison (contains) of two string attributes,
 * determining whether the left string contains the right string.
 * 
 * @see ch.usi.inf.sape.trevis.model.StringMatch
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringContains extends BooleanAttribute {

	private final StringAttribute attribute;
	private final StringAttribute substringAttribute;
	
	
	public StringContains(final StringAttribute attribute, final StringAttribute substringAttribute) {
		this.attribute = attribute;
		this.substringAttribute = substringAttribute;
	}
		
	public String getName() {
		return attribute.getName()+" contains "+substringAttribute.getName();
	}
	
	public String getDescription() {
		return attribute.getName()+" contains "+substringAttribute.getName();
	}
	
	public boolean evaluate(final ContextTreeNode node) {
		return attribute.evaluate(node).contains(substringAttribute.evaluate(node));
	}
	
}
