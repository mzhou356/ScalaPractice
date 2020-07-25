*
/Arsenal have been on a losing streak for years now. Their critic have gone to the extent of saying that they can't even defeat a team of lemurs. So Arsenal decided to show them how wrong they are. But they have done a grave mistake. You are in charge of lemur team and are confident of the abilities of a lemur. Given N lemurs, you have to select K out of them who will be facing off Arsenal in a soccer match.

You have to count total number of different teams you can form by selecting K out of N lemurs. A team is different from other team if there's exist atleast one lemur who is in one team but not in other. As this number can be large print answer modulo (10^8+7).

Let's say count(N, K) represent how many different team can be formed by selecting K out of N lemurs. Then any of the following condition may occur:

K = 0, that is you have to select no one. There only one way of doing that, ie, selecting no one.
K = N, you have to select all of them. Here, also, is only way of doing that, ie, selecting all.
0 < K < N, let's number N lemurs from [1, N]. Then there are two option
Select first lemur, and then select (K-1) lemurs from remaining (N-1) lemurs.
Don't select first lemur, so you have to select K lemurs from remaining (N-1) lemurs.

Basically formula for combination

 */

import scala.io.StdIn.{readInt,readLine}

object DifferentWays {

  def fact(N:Int):BigInt = {
    @annotation.tailrec
    def loop(acc:BigInt,n:Int):BigInt={
      if (n<=1) return acc
      else{
        return loop(acc*n,n-1)
      }

    }
    loop(1,N)
  }

  def combo(N:Int,K:Int):BigInt= {
    val num = fact(N)
    val deNom = fact(N-K)*fact(K)
    return (num/deNom)%(100000007)
  }

  def main(args:Array[String]):Unit={
    (1 to readInt()).foreach {
      i =>
        val inputs = readLine().split(" ").map(_.toInt)
        println(combo(inputs(0),inputs(1)))
    }
  }

}
