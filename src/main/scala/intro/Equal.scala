package intro

/**
 * Type safe equality.
 */
sealed trait Equal[A] {
  def equal(a1: A, a2: A): Boolean
}

object Equal {
  /**
   * Convenience for summoning an Equal instance.
   *
   * usage: Equal[Int].equal(1, 2)
   */
  def apply[A: Equal]: Equal[A] =
    implicitly[Equal[A]]

  /**
   * Convenience for constructing an Equal instance from
   * a function.
   */
  def from[A](f: (A, A) => Boolean): Equal[A] =
    new Equal[A] { def equal(a1: A, a2: A) = f(a1, a2) }

  /**
   * Convenience for constructing an Equal instance from
   * built in scala equals.
   */
  def derived[A]: Equal[A] =
    from[A](_ == _)

  /* Equal Instances */

  implicit def StringEqual =
    derived[String]

  implicit def IntEqual =
    derived[Int]

  implicit def OptionEqual[A: Equal]: Equal[Option[A]] =
    from[Option[A]]({
      case (Some(a1), Some(a2))  => Equal[A].equal(a1, a2)
      case (None,     None)      => true
      case (None,     Some(_))   => false
      case (Some(_),  None)      => false
    })

  implicit def OptionalEqual[A: Equal]: Equal[Optional[A]] =
    from[Optional[A]]({
      case (Full(a1), Full(a2))  => Equal[A].equal(a1, a2)
      case (Empty(),  Empty())   => true
      case (Empty(),  Full(_))   => false
      case (Full(_),  Empty())   => false
    })

  implicit def ListEqual[A: Equal] =
    from[List[A]](_.corresponds(_)(Equal[A].equal))

  implicit def Tuple2Equal[A: Equal, B: Equal] =
    from[(A, B)]({
      case ((a1, b1), (a2, b2)) =>
        Equal[A].equal(a1, a2) && Equal[B].equal(b1, b2)
    })

  implicit def Tuple3Equal[A: Equal, B: Equal, C: Equal] =
    from[(A, B, C)]({
      case ((a1, b1, c1), (a2, b2, c2)) =>
        Equal[A].equal(a1, a2) && Equal[B].equal(b1, b2) && Equal[C].equal(c1, c2)
    })

  implicit def ThrowableEqual =
    derived[Throwable]
}

/**
 * Syntactic support for the Equal type class.
 *
 * Anywhere this is in scope the `===` operator
 * can be used for type safe equality.
 *
 * Usage:
 *   import EqualSyntax._
 *
 *   1 === 2
 *
 *   1 === "hello" // doesn't compile
 */
object EqualSyntax {
  implicit class AnyEqualSyntax[A: Equal](value: A) {
    def ===(other: A) =
      Equal[A].equal(value, other)
  }
}

/**
 * Type classes should have laws, these are the laws for the
 * Equal type class.
 */
object EqualLaws {
  def commutative[A: Equal](a1: A, a2: A): Boolean =
    Equal[A].equal(a1, a2) == Equal[A].equal(a2, a1)

  def reflexive[A: Equal](f: A): Boolean =
    Equal[A].equal(f, f)

  def transitive[A: Equal](a1: A, a2: A, a3: A): Boolean =
    !(Equal[A].equal(a1, a2) && Equal[A].equal(a2, a3)) || Equal[A].equal(a1, a3)
}

/**
 * Example usage.
 */
object EqualExample {
  import EqualSyntax._

  1 === 1

 // 1 === "hello"  -- doesn't compile

  def filterLike[A: Equal](a: A, xs: List[A]) =
    xs.filter(x => x === a)

  filterLike(1, List(1, 2, 3)) // List(1)

//  filterLike(1.0d, List(1.0d, 2.0d)) -- doesn't compile because we didn't define an instance for double
}
