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
 * For any given node, it returns its depth
 * (the length of the path to the root).
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DepthAttribute extends LongAttribute {

	public String getName() {
		return "Depth";
	}
	
	public String getDescription() {
		return "Depth of node (length of path to root)";
	}
	
	public long evaluate(final ContextTreeNode node) {
		long depth;
		if (node.getParent()==null) {
			depth = 0;
		} else {
			depth = 1+evaluate(node.getParent());
		}
		return depth;
	}
	
}
