/*
Pentagon number calculates the num of dots in a Pentagon
p(1) is just one dot
p(2) is add 4 dots so 5
p(3) is adding 7 dots to 5 so 12
etc.

The mathematical formula:
P(n) = (n*(3*n-1))/2
*/

import scala.io.StdIn.{readLong, readInt}

object PentagonNumber {
  // Long allows big integer such as 100000
  def P(n:Long):Long = (n*(3*n-1))/2
  def main(args: Array[String]): Unit ={
    val T = readInt();
    (1 to T).foreach{
      t =>
        println(P(readLong()))
    }
  }
}

/*
if you don't know the pattern you can also detect
for each p(n), it is a function of p(n-1), p(n-2)
n = 0, 0
n = 1, 1
n >=2, 2*p(n-1)-p(n-2)+3 
*/

object PentagonNumber {

  def pentNum(n:Long):Long = {
    @annotation.tailrec
    def loop(n:Long,prev:Long,curr:Long):Long = {
      if (n==1) return curr
      else return loop(n-1,curr,2*curr-prev+3)
    }
    loop(n,0,1)
  }

  def main(args: Array[String]): Unit ={
    val T = readInt();
    (1 to T).foreach{
      t =>
        println(pentNum(readLong()))
    }
  }
}
