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
package ch.usi.inf.sape.trevis.model.operations;

import java.util.ArrayList;
import java.util.Comparator;

import ch.usi.inf.sape.trevis.model.ContextTree;
import ch.usi.inf.sape.trevis.model.ContextTreeNode;


/**
 * If you want to use ContextTreeOperations for your ContextTree subclass,
 * you have to implement a corresponding ContextTreeFactory subclass.
 * 
 * NOTE: If all you want to do is visualize trees, you don't need to implement this class.
 * 
 * @see ch.usi.inf.sape.trevis.model.operations.ContextTreeOperations
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public interface ContextTreeFactory {

	/**
	 * Create a new ContextTree using the given ContextTreeNode as its root.
	 * @param root A ContextTreeNode to be used as the root of the new ContextTree.
	 * @return A newly created ContextTree.
	 */
	public ContextTree createTree(ContextTreeNode root);
	
	/**
	 * Create a clone of the given node (including the relevant attributes),
	 * but not the list of its children.
	 * 
	 * @param node A ContextTreeNode to be cloned
	 * @return a new ContextTreeNode, without children (!), representing a clone of node
	 */
	public ContextTreeNode cloneNode(ContextTreeNode node);
	
	/**
	 * Make the two nodes to be parent and child.
	 */
	public void connectParentAndChild(ContextTreeNode parent, ContextTreeNode child);
	
	/**
	 * Union just the contents of the nodes (e.g. the relevant attributes),
	 * but not the list of their children.
	 * 
	 * Union of numeric attributes usually corresponds to MAX(v1, v2).
	 * 
	 * Note that the two given nodes have to have equal labels 
	 * (as determined by the Comparator returned by getNodeComparator).
	 * 
	 * @param node1
	 * @param node2
	 * @return a new ContextTreeNode, without children, representing the union of node1 and node2
	 */
	public ContextTreeNode unionNodes(ContextTreeNode node1, ContextTreeNode node2);
	
	/**
	 * Intersect just the contents of the nodes (e.g. the relevant attributes),
	 * but not the list of their children.
	 * 
	 * Intersection of numeric attributes usually corresponds to MIN(v1, v2).
	 * 
	 * Note that the two given nodes have to have equal labels 
	 * (as determined by the Comparator returned by getNodeComparator).
	 * 
	 * @param node1
	 * @param node2
	 * @return a new ContextTreeNode, without children, representing the intersection of node1 and node2
	 */
	public ContextTreeNode intersectNodes(ContextTreeNode node1, ContextTreeNode node2);
	
	/**
	 * Add just the contents of the nodes (e.g. the relevant attributes),
	 * but not the list of their children.
	 * Note that the two given nodes have to have equal labels
	 * (as determined by the Comparator returned by getNodeComparator).
	 * 
	 * @param node1
	 * @param node2
	 * @return a new ContextTreeNode, without children, representing the Math.max(0, node1 - node2).
	 */
	public ContextTreeNode addNodes(ContextTreeNode node1, ContextTreeNode node2);
	
	/**
	 * Subtract just the contents of the nodes (e.g. the relevant attributes),
	 * but not the list of their children.
	 * Note that the two given nodes have to have equal labels
	 * (as determined by the Comparator returned by getNodeComparator).
	 * 
	 * @param node1
	 * @param node2
	 * @return a new ContextTreeNode, without children, representing the Math.max(0, node1 - node2).
	 */
	public ContextTreeNode subtractNodes(ContextTreeNode node1, ContextTreeNode node2);

	/**
	 * Return an ordered list of the children of the given node.
	 * 
	 * @param aNode
	 * @return
	 */
	public ArrayList<ContextTreeNode> getOrderedChildren(ContextTreeNode aNode);

	/**
	 * Return a comparator that produces the same order as used in getOrderedChildren().
	 * 
	 * @return
	 */
	public Comparator<ContextTreeNode> getNodeComparator();
	
}
