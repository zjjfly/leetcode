package com.github.zjjfly.leetcode.qb1

import scala.collection.mutable.ArrayBuffer

/**
  * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
  *
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/16
  */
object ReverseKGroup extends App {

  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    val ints = nodes2array(head, ArrayBuffer())
    val list = ints.sliding(k, k).flatMap(f => if (f.length<k) f else f.reverse).toList
    val newHead = ListNode()
    list2Nodes(list, newHead)
    newHead
  }

  val node1: ListNode = ListNode(1)
  val node2: ListNode = ListNode(2)
  node1.next = node2
  val node3: ListNode = ListNode(3)
  node2.next = node3
  println(reverseKGroup(node1, 2))
}
