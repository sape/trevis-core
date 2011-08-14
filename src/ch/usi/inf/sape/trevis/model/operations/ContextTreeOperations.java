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
 * ContextTreeOperations allows you to clone a ContexTree,
 * or to compute the union, intersection, or difference of two ContextTrees.
 * 
 * This is useful for example to compute the tree representing a whole cluster of trees (union),
 * or a tree representing the intersection between trees (for highlighting the common nodes).
 * 
 * This also is useful as a means of computing certain similarity metrics,
 * or to highlight all nodes in two trees that are part of their intersection.
 * 
 * @see http://www.google.com/url?sa=t&source=web&ct=res&cd=5&ved=0CCQQFjAE&url=http%3A%2F%2Feprints.pascal-network.org%2Farchive%2F00002510%2F01%2F01.pdf&ei=I1M2S6PtHceC_Qb84ISLCQ&usg=AFQjCNGUmvpL6sVtJ-zGMDCOTt1eJgE4iA&sig2=bc5-78GECwZjP9NQyq3a2Q
 */
public final class ContextTreeOperations {

	/**
	 * Create a ContextTree C, where each node nc, contains the union of the children of
	 * the corresponding node in A, na, and the corresponding node in B, nb.
	 */
	public static ContextTree union(final ContextTree a, final ContextTree b, final ContextTreeFactory factory) {
		final ContextTreeNode root = factory.unionNodes(a.getRoot(), b.getRoot());
		unionChildren(a.getRoot(), b.getRoot(), root, factory);
		final ContextTree tree = factory.createTree(root);
		return tree;
	}
	
	private static void unionChildren(final ContextTreeNode aNode, final ContextTreeNode bNode, final ContextTreeNode outNode, final ContextTreeFactory factory) {
		final ArrayList<ContextTreeNode> aChildren = factory.getOrderedChildren(aNode);
		final ArrayList<ContextTreeNode> bChildren = factory.getOrderedChildren(bNode);
		final Comparator<ContextTreeNode> comparator = factory.getNodeComparator();
		int a = 0;
		int b = 0;
		while (a<aChildren.size() || b<bChildren.size()) {
			if (a<aChildren.size() && b<bChildren.size()) {
				final ContextTreeNode aChild = aChildren.get(a);
				final ContextTreeNode bChild = bChildren.get(b);
				final int result = comparator.compare(aChild, bChild);
				if (result==0) {
					// a==b
					final ContextTreeNode outChild = factory.unionNodes(aChild, bChild); 
					factory.connectParentAndChild(outNode, outChild);
					unionChildren(aChild, bChild, outChild, factory);
					a++;
					b++;
				} else if (result<0) {
					// a<b
					final ContextTreeNode outChild = factory.cloneNode(aChild);
					factory.connectParentAndChild(outNode, outChild);
					cloneChildren(aChild, outChild, factory);
					a++;
				} else {
					// b<a
					final ContextTreeNode outChild = factory.cloneNode(bChild);
					factory.connectParentAndChild(outNode, outChild);
					cloneChildren(bChild, outChild, factory);
					b++;
				}
			} else if (a<aChildren.size()) {
				final ContextTreeNode aChild = aChildren.get(a);
				final ContextTreeNode outChild = factory.cloneNode(aChild);
				factory.connectParentAndChild(outNode, outChild);
				cloneChildren(aChild, outChild, factory);
				a++;				
			} else {
				final ContextTreeNode bChild = bChildren.get(b);
				final ContextTreeNode outChild = factory.cloneNode(bChild);
				factory.connectParentAndChild(outNode, outChild);
				cloneChildren(bChild, outChild, factory);
				b++;				
			}
		}
	}
	
	/**
	 * Create a ContextTree C, where each node nc, contains the intersection of the children of
	 * the corresponding node in A, na, and the corresponding node in B, nb.
	 */
	public static ContextTree intersection(final ContextTree a, final ContextTree b, final ContextTreeFactory factory) {
		final ContextTreeNode root = factory.intersectNodes(a.getRoot(), b.getRoot());
		intersectChildren(a.getRoot(), b.getRoot(), root, factory);
		final ContextTree tree = factory.createTree(root);
		return tree;
	}
	
	private static void intersectChildren(final ContextTreeNode aNode, final ContextTreeNode bNode, final ContextTreeNode outNode, final ContextTreeFactory factory) {
		final ArrayList<ContextTreeNode> aChildren = factory.getOrderedChildren(aNode);
		final ArrayList<ContextTreeNode> bChildren = factory.getOrderedChildren(bNode);
		final Comparator<ContextTreeNode> comparator = factory.getNodeComparator();
		int a = 0;
		int b = 0;
		while (a<aChildren.size() && b<bChildren.size()) {
			final ContextTreeNode aChild = aChildren.get(a);
			final ContextTreeNode bChild = bChildren.get(b);
			final int result = comparator.compare(aChild, bChild);
			if (result==0) {
				// a==b
				final ContextTreeNode outChild = factory.intersectNodes(aChild, bChild); 
				factory.connectParentAndChild(outNode, outChild);
				intersectChildren(aChild, bChild, outChild, factory);
				a++;
				b++;
			} else if (result<0) {
				// a<b
				final ContextTreeNode outChild = factory.cloneNode(aChild);
				factory.connectParentAndChild(outNode, outChild);
				cloneChildren(aChild, outChild, factory);
				a++;
			} else {
				// b<a
				b++;
			}
		}
	}
	
	/**
	 * Create a ContextTree C, where each node nc, contains the difference of the children of
	 * the corresponding node in A, na, and the corresponding node in B, nb.
	 */
	public static ContextTree subtract(final ContextTree a, final ContextTree b, final ContextTreeFactory factory) {
		final ContextTreeNode root = factory.subtractNodes(a.getRoot(), b.getRoot());
		subtractChildren(a.getRoot(), b.getRoot(), root, factory);
		final ContextTree tree = factory.createTree(root);
		return tree;
	}
	
	private static void subtractChildren(final ContextTreeNode aNode, final ContextTreeNode bNode, final ContextTreeNode outNode, final ContextTreeFactory factory) {
		final ArrayList<ContextTreeNode> aChildren = factory.getOrderedChildren(aNode);
		final ArrayList<ContextTreeNode> bChildren = factory.getOrderedChildren(bNode);
		final Comparator<ContextTreeNode> comparator = factory.getNodeComparator();
		int a = 0;
		int b = 0;
		while (a<aChildren.size() || b<bChildren.size()) {
			if (a<aChildren.size() && b<bChildren.size()) {
				final ContextTreeNode aChild = aChildren.get(a);
				final ContextTreeNode bChild = bChildren.get(b);
				final int result = comparator.compare(aChild, bChild);
				if (result==0) {
					// a==b
					final ContextTreeNode outChild = factory.subtractNodes(aChild, bChild); 
					factory.connectParentAndChild(outNode, outChild);
					subtractChildren(aChild, bChild, outChild, factory);
					a++;
					b++;
				} else if (result<0) {
					// a<b
					a++;
				} else {
					// b<a
					b++;
				}
			} else if (a<aChildren.size()) {
				final ContextTreeNode aChild = aChildren.get(a);
				final ContextTreeNode outChild = factory.cloneNode(aChild);
				factory.connectParentAndChild(outNode, outChild);
				cloneChildren(aChild, outChild, factory);
				a++;				
			} else {
				b++;
			}
		}
	}

	/**
	 * Clone a complete ContextTree (with all its node)
	 * 
	 * @param inTree A ContextTree
	 * @param factory A ContextTreeFactory for the given inTree
	 * @return A deep clone of the given tree
	 */
	public static ContextTree clone(final ContextTree inTree, final ContextTreeFactory factory) {
		final ContextTreeNode outRoot = clone(inTree.getRoot(), factory);
		final ContextTree outTree = factory.createTree(outRoot);
		return outTree;
	}
	
	/**
	 * Clone a subtree (starting at the given subtree root node).
	 * 
	 * @param inSubtreeRoot A ContextTreeNode
	 * @param factory A ContextTreeFactory for the given inSubtreeRoot
	 * @return A deep clone of the given subtree
	 */
	public static ContextTreeNode clone(final ContextTreeNode inSubtreeRoot, final ContextTreeFactory factory) {
		final ContextTreeNode outSubtreeRoot = factory.cloneNode(inSubtreeRoot);
		cloneChildren(inSubtreeRoot, outSubtreeRoot, factory);
		return outSubtreeRoot;
	}
	
	private static void cloneChildren(final ContextTreeNode inNode, final ContextTreeNode outNode, final ContextTreeFactory factory) {
		for (final ContextTreeNode inChild : inNode) {
			final ContextTreeNode outChild = factory.cloneNode(inChild);
			factory.connectParentAndChild(outNode, outChild);
			cloneChildren(inChild, outChild, factory);
		}
	}

}
