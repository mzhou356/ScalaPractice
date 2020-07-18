/*
You are given a string, str, of length N consisting of lowercase letters of alphabet. You have to remove all those characters
from str which have already appeared in it, i.e., you have to keep only first occurrence of each letter.

Input Format
First line of input contains a string str of length N.

Output Format
A string with removed characters as described in the problem.

Constraints
1 <= N <= 30000
str will contain only lowercase letters ('a'-'z').
 */

import scala.io.StdIn.readLine;

object RemovingDuplicates {
  def main(args:Array[String]):Unit ={
    println(readLine().toSeq.distinct.unwrap);
  }

}
