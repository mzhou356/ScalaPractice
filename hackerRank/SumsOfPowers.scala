/*
Given two integers:
first input: X (total value)
second input: N (power)

Output:

how many ways you can represent X as sums of power of unique values

for example
10 = 3^2 + 1^ 1 => output = 1

100 = 10^2 + 8^2+6^2 + 7^2+5^2+4^2+3^2+1^2 => output = 3

*/

import scala.io.StdIn.readInt


object SumsOfPowers {
  // custom root function for root of 3
  def root (X:Int,N:Int):Int = {
    var result = math.round(math.pow(X,1.0/N)).toInt
    if ((X - math.pow(result,N))<0) result -= 1
    return result
  }
  // custom power function to make sure output is Int not double/float
  def power (X:Int,N:Int):Int = math.pow(X,N).toInt
  // speed up the search for next biggest root to try
  def findNext(remain: Int, n:Int, num:Int):Int = return math.min(root(remain,n),num-1)

  def numberOfWays(X:Int,N:Int):Int ={
    def loop(remainder: Int, curr: Int) :Int = {
      // if remainder adds up with the power is less than remainder, no solution
      if ((1 to curr).foldLeft(0)((acc,x)=>acc+power(x,N)) < remainder) return 0
      else if (remainder == power(curr,N)) return 1 + loop(remainder, curr-1)
      else {
        // exhaust all possibility for curr number
        val newRemainder = remainder - power(curr,N)
        val next = findNext(newRemainder, N, curr)
        return loop(remainder,curr-1)+loop(newRemainder, next)
      }
    }
    loop(X, root(X,N))
  }

  def main(args:Array[String]): Unit ={
    println(numberOfWays(readInt(),readInt()))
  }
}
