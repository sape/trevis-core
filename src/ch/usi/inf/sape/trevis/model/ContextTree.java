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
package ch.usi.inf.sape.trevis.model;


/**
 * A ContextTree is a tree with the following properties:
 * 
 * <ol>
 * <li>each node (a ContextTreeNode) contains a label
 * <li>the labels of sibling nodes must differ (according to their equals() method)
 * <li>there is at least one inclusive NodeAttribute, 
 * where inclusive means that the value of the NodeAttribute for a parent
 * is greater or equal to the sum of the values of the NodeAttributes of its children.
 * </ol>
 * 
 * The second property allows the children of a node to be brought into a canonical order,
 * and thus the tree to be processed as an <i>ordered tree</i>.
 * 
 * The third property is fulfilled by the class DescendantCountAttribute,
 * which, given a node, evaluates to the number of its descendants.
 * 
 * @see ch.usi.inf.sape.trevis.model.attribute.DescendantCountAttribute
 * 
 * Implement this interface, or subclass class AbstractContextTree,
 * for your own kinds of ContextTrees.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public interface ContextTree {
	
	/**
	 * @return get the root node of this context tree.
	 * Note that a ContextTree is truly a tree, and thus has a single root.
	 */
	public abstract ContextTreeNode getRoot();
	
	/**
	 * Get the label (the string that briefly describes this tree).
	 */
	public abstract String getName();

}
