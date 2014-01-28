package intro

import org.scalacheck._, Arbitrary._, Gen._, Prop._

object MonoidSpecification extends Properties("Monoid") {
  /*
   * Exercise 1: Define arbitrary instances for these basic monoid data types.
   */

  implicit def MinArbitrary: Arbitrary[Min] =
    Arbitrary(arbitrary[Int].map(n => Min(n)))

  implicit def MaxArbitrary: Arbitrary[Max] =
    ???

  implicit def FirstArbitrary: Arbitrary[First[Int]] =
    ???

  /*
   * *Challenge* Exercise 2: Define arbitrary instance for Endo.
   *
   * Hint: Use Gen.choose(n: Int, m: Int): Gen[Int]
   * Hint: Use Gen.oneOf[A](values: A*): Gen[A]
   */
  implicit def EndoArbitrary: Arbitrary[Endo[Int]] =
    ???

  /*
   * *Challenge* Exercise 2: ensure that our Monoid instances satisfy
   * the monoid laws.
   *
   * (A subset has been specified to keep things smaller)
   *
   * Note: Try refactoring as you go, don't repeat the test for
   *       every property.
   */

  property("Min is Lawful") =
    ???

  property("Max is Lawful") =
    ???

  property("Endo is Lawful") =
    ???

  property("First is Lawful") =
    ???

  property("List is Lawful") =
    ???

  property("Map is Lawful") =
    ???


  /**
   * *Challenge* Exercise 3: Can you use a property to prove something isn't a Monoid?
   *
   * Hint: What about doubles?
   */
  property("Not a monoid") =
    ???

}
