package com.graphbrain.eco.nodes

import com.graphbrain.eco.{Context, Contexts, NodeType}

class SumFun(params: Array[ProgNode], lastTokenPos: Int= -1) extends FunNode(params, lastTokenPos) {
  override val label = "+"

  override def ntype = {
    params(0).ntype match {
      case NodeType.Number => params(1).ntype match {
        case NodeType.Number => NodeType.Number
        case _ => {
          typeError()
          NodeType.Unknown
        }
      }
      case NodeType.String => params(1).ntype match {
        case NodeType.String => NodeType.String
        case _ => {
          typeError()
          NodeType.Unknown
        }
      }
      case _ => {
        typeError()
        NodeType.Unknown
      }
    }
  }

  override def stringValue(ctxts: Contexts, ctxt: Context) =
    params(0).stringValue(ctxts, ctxt) + params(1).stringValue(ctxts, ctxt)

  override def numberValue(ctxts: Contexts, ctxt: Context) =
    params(0).numberValue(ctxts, ctxt) + params(1).numberValue(ctxts, ctxt)

  override protected def typeError() = error("parameters must be either two numbers or two strings")
}