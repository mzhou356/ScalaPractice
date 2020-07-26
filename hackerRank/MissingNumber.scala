/*
Sometimes you need to compare lists of number, but sorting each one normally will take too much time. Instead you can use alternative methods to find the differences between each list.

Challenge
Numeros The Artist was arranging two identical lists A and B into specific orders. The arrangements of the two arrays were random, Numeros was very proud of his arrangements. Unfortunately, some numbers got left out of List A. Can you find the missing numbers from A without messing up his order?

Details
There are many duplicates in the lists, but you need to find the extra numbers, i.e. B - A. Print the numbers in numerical order. Print each missing number once, even if it is missing multiple times. The numbers are all within a range of 100 from each other.

Input Format
There will be four lines of input:

n - the size of the first list
This is followed by n numbers that makes up the first list.
m - the size of the second list
This is followed by m numbers that makes up the second list.

Output Format
Output all the numbers (in ascending order) that are in B but not in A.

Constraints
1<= n,m <= 200000
-10000 <= x <= 10000 , x ∈ B
Xmax - Xmin < 101
 */

import scala.io.StdIn.{readLong,readLine}

object MissingNumbers {
  def ListToMap(input:Array[Int]):scala.collection.immutable.Map[Int,Int] = {
    return input.groupBy(identity).map {
      case (v, l) => (v, l.size)
    }
  }

  def comPare(map1:scala.collection.immutable.Map[Int,Int],
              map2:scala.collection.immutable.Map[Int,Int]):List[Int]={
    map2.keySet.filter{
      x=> map2.getOrElse(x,0) > map1.getOrElse(x,0)
    }.toList.sorted
  }

  def main(args:Array[String]):Unit = {
    val n = readLong()
    val A = readLine().split(" ").map(_.toInt)
    val m = readLong()
    val B = readLine().split(" ").map(_.toInt)
    println(comPare(ListToMap(A),ListToMap(B)).mkString(" "))

  }

}
