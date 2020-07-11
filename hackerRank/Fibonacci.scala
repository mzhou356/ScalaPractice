/*
You are given a list of non-negative integers.
For each integer, n, in the list print nth fibonacci number modulo 108+7.

Input Format
The first line contains an integer T, denoting the number of test-cases.
T lines follow, each representing a test case. In each line there is a
non-negative integer, n.

Output Format
For each test case, print Fibn % (108+7).

Constraints
1 <= T <= 104
0 <= n <= 104

f(0) 0 fib(1) 1 fib(n): fib(n-2)+fib(n-1)  n>1

KEY PROBLEM:
since n = 104, you will run into issues when You calculate n>92  even if you
set Long

The key formula is

(a+b)%c = (a%c+b%c)%c to avid big fib number
*/


import scala.io.StdIn.readInt;

object Fibonacci {

  def main (args: Array[String]): Unit ={
    (1 to readInt()).foreach {
      i =>
        println(fib(readInt()))
    }

  }

  def fib(n:Int):Long = {
    def loop(remain:Int,prev:Long,curr:Long):Long = {
      if(remain==0) return 0
      else if (remain==1) return curr
      else{
        return loop(remain-1,curr,(prev+curr)%(100000007))
      }
    }
    loop(n,0L,1L)
  }
}
