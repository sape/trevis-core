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
 * For any given node, it returns its height
 * (the length of the longest downward path from the node to a leaf).
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class HeightAttribute extends LongAttribute {

	public String getName() {
		return "Height";
	}
	
	public String getDescription() {
		return "Height of node (length of longest downward path to a leaf)";
	}
	
	public long evaluate(final ContextTreeNode node) {
		long maxChildHeight = 0;
		for (final ContextTreeNode child : node) {
			maxChildHeight = Math.max(maxChildHeight, evaluate(child));
		}
		return 1+maxChildHeight;
	}
	
}
