package com.github.zjjfly.algorithm.sort

import scala.reflect.ClassTag

/**
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/30
  */
object InsertSorter extends Sorter {

  override def sort[A: Ordering](a: Array[A])(
      implicit classTag: ClassTag[A]): Array[A] = {
    val list = a.toList
    executeSort(list).toArray[A]
  }

  def executeSort[A: Ordering](a: List[A]): List[A] = {
    val sorted = sort(a)
    sorted match {
      case _ :: Nil => sorted
      case xs :+ x =>
        executeSort(xs) :+ x
    }
  }

  def sort[A: Ordering](a: List[A]): List[A] = {
    a match {
      case _ :: Nil => a
      case x :: xs =>
        val head = xs.head
        if (!less(x, head)) {
          head :: sort(x :: xs.tail)
        } else {
          x :: sort(xs)
        }
    }
  }
}
