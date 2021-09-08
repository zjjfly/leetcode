package com.github.zjjfly.leetcode.qb1

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/subarray-sum-equals-k/
  *
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/15
  */
object SubarraySum extends App {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    if (nums.isEmpty) 0
    else {
      val prefixSums = Stream
        .iterate((0, 0))((tuple: (Int, Int)) =>
          (tuple._1 + nums(tuple._2), tuple._2 + 1))
        .take(nums.length + 1)
        .toList
      val map = mutable.HashMap[Int, Int]()
      val seq = for (i <- prefixSums.indices) yield {
        val sum = prefixSums(i)._1
        val complement = sum - k
        map.get(complement) match {
          case None =>
            map.put(sum, map.getOrElse(sum, 0) + 1)
            0
          case Some(i) =>
            map.put(sum, map.getOrElse(sum, 0) + 1)
            i
        }
      }
      seq.sum
    }
  }
}
