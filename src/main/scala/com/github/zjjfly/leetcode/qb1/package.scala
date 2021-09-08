package com.github.zjjfly.leetcode

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/16
  */
package object qb1 {

  case class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    override def toString: String =
      s"ListNode(${if (next == null) "null" else next.toString},${x})"
  }

  @tailrec
  def nodes2array(listNode: ListNode, buffer: ArrayBuffer[Int]): Array[Int] = {
    if (listNode.next == null) {
      buffer.append(listNode.x)
      buffer.toArray
    } else {
      buffer.append(listNode.x)
      nodes2array(listNode.next, buffer)
    }
  }

  @tailrec
  def list2Nodes(list: List[Int], currentNode: ListNode): Unit = list match {
    case x :: xs =>
      currentNode.x = x
      xs.headOption match {
        case Some(i) =>
          val next = ListNode()
          currentNode.next = next
          next.x = i
          list2Nodes(xs, next)
        case None => ()
      }
  }

}
