/*
Mario and Luigi earn points in their steps to save the Princess Peach from a dragon. Let's denote Mario's points by M and Luigi's by L. Princess Peach is wondering how many postive integers are there that are divisors to both numbers, M and L. Help her find the answer.

Input
First line of input contains an integer, T, which represent the number of test cases. Then follows T lines. Each line contains two space separated integers, M L, representing the points earned by Mario and Luigi, respectively.

Output
For each test case, print the solution in different lines.

Constraints
1 <= T <= 10
1 <= L, M <= 10^8
L, M are integers
 */

import scala.io.StdIn.{readInt,readLine};

object CommonDivisors {
  def GCD(L:Int,M:Int):Int={
    if (L%M==0) return M.toInt else return GCD(M,L%M)
  }

  def Divisors(gcd:Int):Int={
    if (gcd == 1) return 1 else {
      (2 to math.sqrt(gcd).toInt).foldLeft(2) {
        (acc, x) => if (gcd % x == 0 && gcd / x != x) acc + 2 else if (gcd%x == 0 && gcd / x == x) acc + 1 else acc
      }
    }
  }

  def main(args:Array[String]):Unit={
    val n = readInt()
    (1 to n).foreach{
      i=>
        val Num = readLine().split(" ").map(_.toInt)
        val M = Num(0)
        val L = Num(1)
        println(Divisors(GCD(M,L)))
    }

  }

}
