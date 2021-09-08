package com.github.zjjfly.leetcode.qb1

/**
  * https://leetcode-cn.com/problems/two-sum/
  *
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/15
  */
object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var map = Map[Int, Int]()
    for (i <- nums.indices) {
      val complement = target - nums(i)
      if (map.contains(complement)) {
        return Array(map(complement), i)
      } else {
        map += (nums(i) -> i)
      }
    }
    Array(0, 0)
  }
}
