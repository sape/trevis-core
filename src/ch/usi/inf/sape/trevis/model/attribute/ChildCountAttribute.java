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
 * This is a general attribute.
 * It does not depend on a specific ContextTreeNode implementation.
 * For any given node, it returns the number of children.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class ChildCountAttribute extends LongAttribute {

	public String getName() {
		return "Children";
	}
	
	public String getDescription() {
		return "Number of children";
	}
	
	public long evaluate(final ContextTreeNode node) {
		return node.getChildCount();
	}
	
}
