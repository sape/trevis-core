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
 * A conditional operation picking between two long attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongConditional extends LongAttribute {

	private final String name;
	private final BooleanAttribute condition;
	private final LongAttribute ifArg;
	private final LongAttribute elseArg;
	
	
	public LongConditional(final BooleanAttribute condition, final LongAttribute ifArg, final LongAttribute elseArg) {
		this("if", condition, ifArg, elseArg);
	}
	
	public LongConditional(final String name, final BooleanAttribute condition, final LongAttribute ifArg, final LongAttribute elseArg) {
		this.name = name;
		this.condition = condition;
		this.ifArg = ifArg;
		this.elseArg = elseArg;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return "if ("+condition.getDescription()+") {"+ifArg.getDescription()+"} else {"+elseArg.getDescription()+"}";
	}
	
	public long evaluate(final ContextTreeNode node) {
		if (condition.evaluate(node)) {
			return ifArg.evaluate(node);
		} else {
			return elseArg.evaluate(node);
		}
	}
	
}
