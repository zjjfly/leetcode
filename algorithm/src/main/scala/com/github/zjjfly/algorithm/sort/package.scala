package com.github.zjjfly.algorithm

import edu.princeton.cs.algs4.Stopwatch

import scala.reflect.ClassTag

/**
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/28
  */
package object sort {

  trait Sorter {

    def sort[A: Ordering](a: Array[A])(implicit classTag: ClassTag[A]): Array[A]

    def less[A: Ordering](v: A, w: A): Boolean = {
      val order = implicitly[Ordering[A]]
      order.compare(v, w) <= 0
    }

    def exch[A: Ordering](a: Array[A], i: Int, j: Int): Unit = {
      val t = a(i)
      a(i) = a(j)
      a(j) = t
    }

    def show[A: Ordering](a: Array[A]): Unit = {
      println(a.mkString(" "))
    }

    def isSorted[A: Ordering](a: Array[A]): Boolean = {
      a.sliding(2)
        .forall((as: Array[A]) => less(as(0), as(1))(implicitly[Ordering[A]]))
    }

  }

}
