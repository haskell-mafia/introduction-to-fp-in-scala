package intro

import org.scalacheck._, Arbitrary._, Gen._, Prop._

object ListSpecification extends Properties("List") {
  /*
   * Example: Verify that that our Lists.length matches the
   * builtin List#size
   */
  property("Lists#length matches standard library") =
    forAll((xs: List[Int]) => Lists.length(xs) == xs.size)

  /* Exercise 1 */
  property("Lists#append - the length of the result is equal to the sum of the two input lengths") =
    ???

  /* Exercise 2 */
  property("Lists#append - every element in the first and second list appears in the result") =
    ???

  /* Exercise 3 */
  property("Lists#filter - filter(_ => false) always gives empty list") =
    ???

  /* Exercise 4 */
  property("Lists#filter - filter(_ => true) always gives input list") =
    ???

  /* Exercise 5 */
  property("Lists#filter - length of output is always less than length of input") =
    ???

  /* *Challenge* exercise 6
     Identify a set of properties that together with the type signature
     guarantees the validity of your reverse function (assuming pure-total FP) */
  property("Lists#reverse...") =
    ???

  /* *Challenge* exercise 7
     Identify a set of properties for testing sequence */
  property("Lists#sequence...") =
    ???

  /* *Challenge* exercise 8
     Identify a set of properties for testing ranges */
  property("Lists#ranges...") =
    ???

}
