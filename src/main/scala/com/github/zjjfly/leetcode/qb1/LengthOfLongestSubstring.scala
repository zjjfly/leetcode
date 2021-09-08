package com.github.zjjfly.leetcode.qb1

import scala.annotation.tailrec
import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
  *
  * @author zjjfly[https://github.com/zjjfly] on 2020/5/16
  */
object LengthOfLongestSubstring extends App {

  @tailrec
  def calculate(s: List[Char],
                maxDistinctSubSize: Int,
                prefix: mutable.ArrayBuffer[Char]): Int = s match {
    case c :: cs =>
      val bool = prefix.contains(c)
      if (bool) {
        val size = prefix.size
        val chars = prefix.dropWhile(c != _).drop(1)
        chars.append(c)
        calculate(cs,
                  if (size > maxDistinctSubSize) size else maxDistinctSubSize,
                  chars)
      } else {
        prefix.append(c)
        calculate(cs, maxDistinctSubSize, prefix)
      }
    case Nil =>
      if (prefix.size > maxDistinctSubSize) prefix.size else maxDistinctSubSize
  }

  def lengthOfLongestSubstring(s: String): Int = {
    calculate(s.toList, 0, mutable.ArrayBuffer())
  }

}
