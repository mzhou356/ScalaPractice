/*
Your task is to display all  rotations of string .

For example, if  = abc then it has 3 rotations. They are  = bca,  = cab and  = abc.

Input Format
The first line contains an integer, , which represents the number of test cases to follow. Then follows  lines, which represent a test case each.
Each test case contains a string, , which consists of lower case latin characters  only.

Output Format
For each test case, print all the rotations, , separated by a space.

Constraints


 will consist of lower case latin character,  only.

 */


import scala.io.StdIn.{readInt,readLine}
object RotatingStrings {
  def main (args:Array[String]):Unit={
    (1 to readInt()).foreach {
      i =>
        println(rotate(readLine()))
    }

  }

  def rotate(s:String): String = {
    (1 until s.size).scanLeft(s.tail+s.head){
      (acc,_)=> acc.tail+acc.head
    }.mkString(" ")
  }

}
