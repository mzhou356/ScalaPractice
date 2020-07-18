/*
Input
First line of input contains the positive integer N (1 <= N <= 1000).
  Second line of input contains N space-separated positive integers not greater than 104, whose product is the number A.
Third line of input contains the positive integer M (1 <= M <= 1000).
  Fourth line of input contains M space-separated positive integers not greater than 104, whose product is the number B.

OUTPUT
Print the greatest common divisor of numbers A and B modulo 1000000007.

Constraints
1 <= N, M <= 1000
1 <= element of list <= 10000

*/
// key is to use BigInt to handle large Int product

import scala.io.StdIn.{readInt,readLine};
object HugeGCD {
  def GCD(N1:BigInt, N2:BigInt):BigInt = {
    if (N1%N2==0) return N2%(1000000007) else GCD(N2,N1%N2)
  }

  def main(args:Array[String]): Unit = {
    readInt();
    val num1:BigInt = readLine().split(" ").map(BigInt(_)).product;
    readInt();
    val num2:BigInt = readLine().split(" ").map(BigInt(_)).product;
    println(GCD(num1,num2));
  }

}
