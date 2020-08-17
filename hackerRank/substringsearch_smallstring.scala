/*
In 1974, a very fast string searching method was proposed by the name of KMP algorithm with linear run-time complexity. Your task here is to code this (or any similar) algorithm in a functional language.

Given two strings text and pat, find whether pat exists as a substring in text.

Input
First line will contain an integer, T, which represents total number of test cases. Then T test cases follow. Each case will contains two lines each containing a string. First line will contain text while the second line will contain pat.

Output
For each case print YES if pat is a substring of text otherwise NO.

example:

4
abcdef
def
computer
muter
stringmatchingmat
ingmat
videobox
videobox
Sample Output

YES
NO
YES
YES

 */


import scala.io.StdIn.{readInt,readLine};



object SubStringSearch {
  def solution(word: String, pat: String): String = if(word.indexOf(pat) != -1) "YES" else "NO"
  def main(args: Array[String]) {
    val T = readInt();
    (1 to T).foreach{
      i=>
        val word = readLine();
        val pat = readLine();
        println(solution(word,pat));
    }
  }
}
