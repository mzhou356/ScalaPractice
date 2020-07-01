/*
Lists and GCD

Input:
length of the list
num1: primNum power primNum power etc
num2: primNum power primNum power ec
etc.

Output:
primNum power primeNum power (in ascending order of primNum) for greatest common divisor

Ex:
Input:
2
7 2 5 1 3 1
7 1 5 2 13 1

Output
5 1 7 1
 */

import scala.io.StdIn.{readInt,readLine}
object ListsandGCD {
  def common_key(p1: List[(Int, Int)],
                 p2: List[(Int, Int)]): List[Int] = {
    val s1 = p1.map(_._1).toSet
    val s2 = p2.map(_._1).toSet
    return s1.intersect(s2).toList
    }

  def lowestPower(p1: List[(Int, Int)],
                  p2: List[(Int, Int)]): List[(Int, Int)] = {
    val commonBases:List[Int] = common_key(p1, p2)
    val results = for {
      b <- commonBases
    } yield (b, math.min(p1.filter(x => x._1 == b).head._2, p2.filter(x => x._1 == b).head._2))
    return results.toList
    }

  def main(args: Array[String]){
    val size = readInt()
    val valueList = (1 to size).map{
      i =>
        readLine().split(" ").map(Integer.parseInt).toList.sliding(2,2).collect{
          case List(a,b)=>(a,b)
        }.toList
    }.toList
    println(valueList.reduceLeft(lowestPower(_,_)).sortBy(_._1).flatMap(p=>List(p._1,p._2)).mkString(" "))
    }
}
