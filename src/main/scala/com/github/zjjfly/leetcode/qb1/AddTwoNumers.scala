package com.github.zjjfly.leetcode.qb1

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author zjjfly[https://github.com/zjjfly] on 2020/5/16
 */
object AddTwoNumers extends App {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val num1 = nodes2array(l1, ArrayBuffer())
    val num2 = nodes2array(l2, ArrayBuffer())
    val sums = num1.zipAll(num2, 0, 0).map(t => t._1 + t._2).toList
    val node = ListNode()
    list2Nodes(sums, node)
    node
  }

  @tailrec
  def list2Nodes(l: List[Int], listNode: ListNode): Unit = l match {
    case Nil => ()
    case x :: xs =>
      val sum = x + listNode.x
      val n = sum / 10
      val mod = sum % 10
      listNode.x = mod
      if (xs.nonEmpty || n > 0) {
        val next = ListNode()
        next.x += n
        listNode.next = next
        list2Nodes(xs, next)
      }
  }

  val node1: ListNode = ListNode(5)
  val node2: ListNode = ListNode(5)
  node1.next = node2
  println(addTwoNumbers(node1, node2).x)
  println(addTwoNumbers(node1, node2).next.x)
}
