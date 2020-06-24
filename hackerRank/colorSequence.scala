/*
Sequence full of colors

input:
T: number of seq of color {R,B,G,Y}
follow by seq of strings

EX:
INPUT
2
RGGB
YRBY

output:
True
False

True means color and False means not colorful

4 criteria to be colorful:
as many red (R) as green (G)
as many blue(B) as yellow (Y)
At any time of the sequence of the string the abs difference between R and G
or Y and B can't be more than 1

EX:
YGYGRBRB is false because although there are
2Y and 2B and 2G and 2R
but YGYG creates more than 2 difference between Y and B and R and G
*/



import scala.io.StdIn.{readInt, readLine}
import scala.util.control.Breaks._


object Solution {
  def delta(x:Int,y:Int):Int = math.abs(x-y)
  def main(args: Array[String]):Unit = {
    val T = readInt()
    (1 to T).foreach{
      t =>
        val word = readLine().toVector
        val countCombo = word.scanLeft(Map.empty[Char,Int].withDefaultValue(0)){
          case (acc, w)=>acc.updated(w,acc(w)+1)
        }  // all combo of word and count
        // check if same length
        val finalCount = countCombo.last
        if ((finalCount('R')!=finalCount('G')) || (finalCount('Y')!=finalCount('B'))){
          println("False")
        } else {
          //anything side the breakable loop won't execute after break
          // statement being invoked.
          breakable {
            for (c <- countCombo.dropRight(1)){
              if ((delta(c('G'),c('R'))>1) || (delta(c('Y'), c('B'))>1)){
                println("False")
                break
              }
            }
            println("True")
          }
        }
    }
  }
}
