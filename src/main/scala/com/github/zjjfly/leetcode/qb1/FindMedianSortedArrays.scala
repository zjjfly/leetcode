package com.github.zjjfly.leetcode.qb1

/**
  * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
  *
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/18
  */
object FindMedianSortedArrays extends App {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    medianSortedArrays(nums1.toList, nums2.toList)
  }

  def medianSortedArrays(nums1: List[Int], nums2: List[Int]): Double =
    nums1 match {
      case x :: Nil =>
        nums2 match {
          case y :: Nil => (x + y) / 2.0
          case _ =>
            val i = nums2(nums2.length / 2)
            if (x > i) medianSortedArrays(nums1, nums2.drop(nums2.length / 2))
            else medianSortedArrays(nums1, nums2.take(nums2.length / 2))
        }
      case _ =>
        nums2 match {
          case x :: Nil =>
            val i = nums1(nums1.length / 2)
            if (x > i) medianSortedArrays(nums1.drop(nums1.length / 2), nums2)
            else medianSortedArrays(nums1.take(nums1.length / 2), nums2)
          case _ =>
            val i = nums1(nums1.length / 2)
            val j = nums2(nums2.length / 2)
            if (i > j)
              medianSortedArrays(nums1.take(nums1.length / 2),
                                 nums2.drop(nums2.length / 2))
            else
              medianSortedArrays(nums1.drop(nums1.length / 2),
                                 nums2.take(nums2.length / 2))
        }
    }

  def middle(ints: List[Int]): Double = {
    val size = ints.length
    if ((size % 2) == 0) (ints(size / 2) + ints(size / 2 - 1)) / 2.0
    else ints(size / 2)
  }

  println(findMedianSortedArrays(Array(1, 2, 5), Array(3, 4)))
}
