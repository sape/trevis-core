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

import java.util.Iterator;


/**
 * A ContextTreeNode is a (1) labeled, (2) weighted node of a ContextTree.
 * 
 * It is labeled: each node contains a "label".
 * Given the common use of context trees to represent "calling context trees",
 * we use the term "frame" (a stack frame, e.g. representing a method) instead of "label".
 * Multiple nodes in a given tree may contain the same label,
 * however, each <i>child</i> of a given node must contain a different label.
 * This last constraint allows us algorithms to treat a context tree as an ordered tree:
 * children can be ordered by their labels to get a canonical order.
 * This allows a drastic speedup of certain tree processing algorithms.
 * 
 * It is weighted: each node contains a "weight".
 * It must be meaningful to add up the weight of a node and all its descendants
 * to get an "inclusive" weight of that node.
 * A weight may correspond, e.g. to the amount of time in nanoseconds
 * spent in a given calling context, or the number of calls
 * to a given calling context, 
 * or the number of samples taken in a given calling context,
 * or the number of objects allocated in a given calling context.
 * Given the various possible weights, and their different types
 * (e.g. to store time in nanoseconds, we'd need a long,
 * to store samples, an int would be enough),
 * this class does not provide direct access to a node's weight.
 * Instead, implementers will add their own methods to access the weight,
 * and they have to provide NodeAttribute classes that access that weight.
 * This approach also allows for a node class to provide multiple weights
 * (and the user of the class can pick the weight to be used for a given
 * algorithm by providing a specific NodeAttribute).
 * 
 * Subclass this class in your own implementation.
 * Your subclass can store extra information,
 * especially the weights (e.g. call counts, cache misses, cycles, samples).
 * 
 * Each ContextTreeNode refers to a frame,
 * which, in a calling context tree, represents a stack frame
 * (e.g. containing function and object file name).
 * Multiple ContextTreeNodes may refer to the same frame
 * (e.g. different places in a CCT may have called the same function).
 * 
 * A ContextTreeNode knows its parent (the root node has null as its parent)
 * and its children.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public interface ContextTreeNode extends Iterable<ContextTreeNode> {	
	
	public abstract Object getLabel();

	public abstract ContextTreeNode getParent();
	
	public abstract Iterator<ContextTreeNode> iterator();
	
	public abstract int getChildCount();
	
	public abstract ContextTreeNode getChild(int index);
	
	/**
	 * Find the child (if any) that contains the given label
	 * (a label equal to the given label).
	 * 
	 * @param label the label we look for
	 * @return the corresponding child, or null if no such child exists.
	 */
	public abstract ContextTreeNode getChild(final Object label);

	public abstract int indexOfChild(final ContextTreeNode child);
		
	public abstract boolean isRoot();
	
}
