/*
Filter elements:
input:
n is number of Lists
for each List (n)
len of List minCount
List

expected output:
sequence of integer with the number of count meets the minCount

if non the element meets the minCount, return "-1"

Ex:
input
3
9 2
4 5 2 5 4 3 1 3 4
9 4
4 5 2 5 4 3 1 3 4
10 2
5 4 3 2 1 1 2 3 4 5

output
4 5 3
-1
5 4 3 2 1

*/



import scala.io.StdIn.{readInt,readLine}

object Solution {
    def main(args: Array[String]):Unit= {
      val n = readInt()
      (1 to n).foreach {
        i =>
        val minCount = readLine().split(" ")(1).toInt
        val L = readLine().split(" ").map(Integer.parseInt)
        val countMap = L.groupBy(x=>x)
        val result = L.distinct.filter(x=>countMap(x).size >= minCount)
        println(if (result.isEmpty) "-1" else result.mkString(" "))
      }
    }
}
