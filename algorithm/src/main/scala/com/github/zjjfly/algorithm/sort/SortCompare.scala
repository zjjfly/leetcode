package com.github.zjjfly.algorithm.sort

import edu.princeton.cs.algs4.{StdOut, Stopwatch}

import scala.reflect.ClassTag

/**
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/30
  */
object SortCompare extends App {
  def time[A: Ordering](alg: String, a: Array[A])(
      implicit classTag: ClassTag[A]): Double = {
    val timer = new Stopwatch()
    alg match {
      case "Insertion" => InsertSorter.sort(a)
      case "Selection" => SelectionSorter.sort(a)
    }
    timer.elapsedTime
  }

  def timeRandomInput(alg: String, N: Int, T: Int): Double = {
    import edu.princeton.cs.algs4.StdRandom
    val a: Array[Double] = new Array[Double](N)
    val times = for (_ <- 0 to T) yield {
      // 进行一次测试(生成一个数组并排序)
      var i: Int = 0
      while ({
        i < N
      }) {
        a(i) = StdRandom.uniform
        i += 1
      }
      time(alg, a)
    }
    times.sum
  }
  private val alg1 = "Insertion"
  private val alg2 = "Selection"
  val N: Int = 1000
  val T: Int = 100
  //算法1的总时间
  val t1 = timeRandomInput(alg1, N, T)
  //算法2的总时间
  val t2 = timeRandomInput(alg2, N, T);
  StdOut.printf(s"For ${N} random doubles, ${alg1} is")
  StdOut.printf(s" ${t2 / t1} times faster than ${alg2}\n")
}
