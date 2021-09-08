package com.github.zjjfly.algorithm.sort

import scala.reflect.ClassTag

/**
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/28
  */
object SelectionSorter extends Sorter {

  override def sort[A: Ordering](a: Array[A])(
      implicit classTag: ClassTag[A]): Array[A] = {
    val list = a.toList
    sort(list).toArray[A]
  }

  def sort[A: Ordering](a: List[A]): List[A] = a match {
    case _ :: Nil => a
    case x :: xs =>
      val min = xs.min
      if (!less(x, min)) {
        val mins = List.fill(n = xs.count(_ == min))(min)
        mins ++ sort(xs.filter(_ != min) :+ x)
      } else {
        x :: sort(xs)
      }
  }

}
