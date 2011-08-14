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
 * A conditional operation picking between two boolean attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class BooleanConditional extends BooleanAttribute {

	private final String name;
	private final BooleanAttribute condition;
	private final BooleanAttribute ifArg;
	private final BooleanAttribute elseArg;
	
	
	public BooleanConditional(final BooleanAttribute condition, final BooleanAttribute ifArg, final BooleanAttribute elseArg) {
		this("if", condition, ifArg, elseArg);
	}
	
	public BooleanConditional(final String name, final BooleanAttribute condition, final BooleanAttribute ifArg, final BooleanAttribute elseArg) {
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
	
	public boolean evaluate(ContextTreeNode node) {
		if (condition.evaluate(node)) {
			return ifArg.evaluate(node);
		} else {
			return elseArg.evaluate(node);
		}
	}
	
}
