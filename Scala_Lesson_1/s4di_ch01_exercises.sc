package src.exercises

import scala.math._
import BigInt.probablePrime
import util.Random

object chap01 {
// 1. In the Scala REPL, type 3. followed by the Tab key. What methods can be
// applied?
// => Do it in REPL. There are many methods including %, &, *, +, toByte, toChar etc.

// 2. In the Scala REPL, compute the square root of 3, and then square that value.
// By how much does the result differ from 3? (Hint: The res variables are your
// friend.)
  println(3 - pow(sqrt(3), 2))                    //> 4.440892098500626E-16
  
// 3. Are the res variables val or var?
// val
  
// 4. Scala lets you multiply a string with a number - try out "crazy" * 3 in the REPL.
// What does this operation do? Where can you find it in Scaladoc?
  "crazy" * 3                                     //> res0: String = crazycrazycrazy
// Can be found in the StringOps class
  
// 5. What does 10 max 2 mean? In which class is the max method defined?
  10 max 2                                  //> res1: Int = 10
// Defined in the RichInt class

// 6. Using BigInt, compute 2^1024.
  BigInt(2) pow 1024                        //> res2: scala.math.BigInt = 17976931348623159077293051907890247336179769789423
                                                  //| 0657273430081157732675805500963132708477322407536021120113879871393357658789
                                                  //| 7688144166224928474306394741243777678934248654852763022196012460941194530829
                                                  //| 5208500576883815068234246288147391311054082723716335051068458629823994724593
                                                  //| 8479716304835356329624224137216
	
// 7. What do you need to import so that you can get a random prime as
// probablePrime(100, Random), without any qualifiers before probablePrime and Random?
  // import BigInt.probablePrime
  // import util.Random
  probablePrime(100, Random)                //> res3: scala.math.BigInt = 912013777957722342425952556723
	
// 8. One way to create random file or directory names is to produce a random
// BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
// Poke around Scaladoc to find a way of doing this in Scala.
  probablePrime(100, Random).toString(36)   //> res4: String = 2w2bxtp6lz08l502sg9h
	
// 9. How do you get the first character of a string in Scala? The last character?
  val s = "String"                          //> s  : String = String
  s.head                                    //> res5: Char = S
  s(0)                                      //> res6: Char = S
  s.last                                    //> res7: Char = g
  s(s.length - 1)                           //> res8: Char = g
  
// 10. What do the take, drop, takeRight, and dropRight string functions do? What
// advantage or disadvantage do they have over using substring?
  // take: Selects the first n elements
  s.take(2)                                 //> res9: String = St
  // drop: Selects all elements except first n ones
  s.drop(2)                                 //> res10: String = ring
  // takeRight: Selects the last n elements
  s.takeRight(2)                            //> res11: String = ng
  // dropRight: Selects all elements except last n ones
  s.dropRight(2)                            //> res12: String = Stri
  // advantage: they are much more concise and intuitive than substring
}