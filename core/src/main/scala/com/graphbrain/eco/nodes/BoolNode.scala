package com.graphbrain.eco.nodes

import com.graphbrain.eco.{Contexts, Context, NodeType}

class BoolNode(val value: Boolean, lastTokenPos: Int= -1) extends ProgNode(lastTokenPos) {
  override def ntype(ctxt: Context) = NodeType.Boolean
  override def booleanValue(ctxts: Contexts, ctxt: Context) = value

  override def toString = value.toString

  override def equals(obj:Any) = obj match {
    case b: BoolNode => b.value == value
    case _ => false
  }
}