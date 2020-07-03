/*
Sample input:
N: length of list
L: list
T: number of test cases
S: num to test T times

ex:
4
4 8 10 12
4
4
13
30
100

output:
1 : only require length 1
2 : require length 2
3 : require length 3
-1 : no ans
 */

import scala.io.StdIn.{readLine, readLong, readInt}

object Solution {
  def binarySearch(n: Int,VSum:Vector[Long],s:Long):Int={
    var min = 1;
    var max = n+1;
    while (min < max){
      val mid = (min+max)/2
      val currSum = VSum(mid)
      if (s > currSum){
        min = mid+1
      } else{
        max = mid
      }
    }
    return min
  }

  def main(args:Array[String]): Unit ={
    val n = readInt()
    val L =  readLine().split(" ").map(_.toLong).sortBy(-_)
    val VSum = L.scanLeft(0L)((acc,x)=>acc+x).toVector
    (1 to readInt()).foreach{
      i =>
        val s = readLong()
        val ind = binarySearch(n,VSum,s)
        if (ind > n) println("-1")
        else {
          println(ind)
        }
    }

  }
}
