/*
Definite Integrals via Numerical Methods

This relates to definite integration via numerical methods.

Consider the algebraic expression given by:



For the purpose of numerical computation, the area under the curve  between the limits  and  can be computed by the Limit Definition of a Definite Integral.

Here is some background about areas and volume computation.

Using equal subintervals of length , you need to:

Evaluate the area bounded by a given polynomial function of the kind described above, between the given limits of  and .

Evaluate the volume of the solid obtained by revolving this polynomial curve around the -axis.

A relative error margin of  will be tolerated.

Input Format

The first line contains  integers separated by spaces, which are the values of .
The second line contains  integers separated by spaces, which are the values of .
The third line contains two space separated integers,  and , the lower and upper range limits in which the integration needs to be performed, respectively.

Constraints




Output Format

The first line should contain the area between the curve and the -axis, bound between the specified limits.
The second line should contain the volume of the solid obtained by rotating the curve around the -axis, between the specified limits.
 */

import scala.io.StdIn.readLine;

object AUCANDVOfRevolvingACurve {
  // defines the exponential func
  def f(coefficients:List[Int],powers:List[Int],x:Double):Double = (coefficients zip powers).foldLeft(0.0){
      (acc,p)=>acc+p._1*math.pow(x,p._2)
    }
// formula for each disk is pi*r^2, r = y for Volume calculation (rotate around x axis)
  def area(coefficients:List[Int],powers:List[Int],x:Double):Double = math.Pi*math.pow(f(coefficients,powers,x),2)

  def summation(func:(List[Int],List[Int],Double)=>Double,upperLimit:Int,lowerLimit:Int,coefficients:List[Int],
                powers:List[Int]):Double =
  {
    val step = 0.001
    val interval = BigDecimal(lowerLimit) to BigDecimal(upperLimit) by step
    val ans = interval.foldLeft(0.0){
      (acc,x)=>acc+func(coefficients,powers,x.toDouble)*step
    }
    return ans
  }
  def main(args:Array[String]):Unit ={
    val coefs = readLine().split(" ").map(_.toInt).toList
    val powers = readLine().split(" ").map(_.toInt).toList
    val bounds = readLine().split(" ").map(_.toInt)
    val upper = bounds(1)
    val lower = bounds(0)
    // return area function (height) * delta sum over interval
    println(summation(f,upper,lower,coefs,powers))
    // return V revolve around the x axis which is each disk are * height (delta step) and area of disk is pi*r^2, r= y
    println(summation(area,upper,lower,coefs,powers))
  }

}
