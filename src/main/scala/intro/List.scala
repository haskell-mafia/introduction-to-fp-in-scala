package intro

object ListExercises {

  /*
   *
   * The following examples are all based upon the 'List'
   * data structure.
   *
   * In scala this data structure looks like this:
   *
   * {{{
   *   sealed trait List[+A]
   *   case object Nil extends List[Nothing]
   *   case class ::[A](h: A, t: List[A]) extends List[A]
   * }}}
   *
   * We call this a "sum-type", where "List" is a type
   * constructor that has two data constructors, "Nil",
   * and "::" (pronounced ~cons~). We can declare values
   * of type List using either the data constructors or
   * via the convenience function `List`.
   *
   * {{{
   *   val xs = "goodbye" :: "cruel" :: "world" :: Nil
   *   val ys = List("we", "have", "the", "technology")
   * }}}
   *
   * Lists can be worked with via pattern matching or via
   * the standard library methods foldRight & foldLeft.
   * These are defined as:
   *
   * {{{
   *   List[A]#foldRight[B](z: B)(f: (A, B) => B)
   *   List[A]#foldLeft[B](z: B)(f: (B, A) => A)
   * }}}
   *
   */


  /*
   * Example 1:
   *
   * Implement length using pattern matching.
   *
   * scala> import warmup.Warmup._
   * scala> length(List(1, 2, 3, 4))
   * resX: Int = 4
   */
  def length[A](xs: List[A]): Int =
    ???

  /*
   * Example 2:
   *
   * Implement length using foldRight.
   *
   * scala> import warmup.Warmup._
   * scala> lengthX(List(1, 2, 3, 4))
   * resX: Int = 4
   */
  def lengthX[A](xs: List[A]): Int =
    ???

  /*
   * Exercise: 3:
   *
   * Append two lists to produce a new list.
   *
   * scala> import warmup.Warmup._
   * scala> append(List(1, 2, 3, 4), List(5, 6, 7, 8))
   * resX: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
   */
  def append[A](x: List[A], y: List[A]): List[A] =
    ???

  /*
   * Exercise: 4:
   *
   * Map the given function across each element of the list.
   *
   * scala> import warmup.Warmup._
   * scala> map(List(1, 2, 3, 4))(x => x + 1)
   * resX: List[Int] = List(2, 3, 4, 5)
   *
   * ~~~ Syntax hint: type annotations
   *
   *     (Nil : List[A]) // Nil _is of type_ List[A]
   *
   *     Type annotations are required when scala can
   *     not infer what you mean.
   */
  def map[A, B](xs: List[A])(f: A => B): List[B] =
    ???

  /*
   * Exercise: 5:
   *
   * Return elements satisfying the given predicate.
   *
   * scala> import warmup.Warmup._
   * scala> filter(List(1, 2, 3, 4))(i => i < 3)
   * resX: List[Int] = List(1, 2)
   */
  def filter[A](xs: List[A])(p: A => Boolean): List[A] =
    ???

  /*
   * Exercise: 6:
   *
   * Reverse a list to produce a new list.
   *
   * scala> import warmup.Warmup._
   * scala> reverse(List( 1, 2, 3, 4))
   * resX: List[Int] = List(4, 3, 2, 1)
   *
   * ~~~ Syntax hint: type annotations
   *
   *     (Nil : List[A]) // Nil _is of type_ List[A]
   *
   *     Type annotations are required when scala can
   *     not infer what you mean.
   */
  def reverse[A](xs: List[A]): List[A] =
    ???

  /*
   * *Challenge* Exercise: 7:
   *
   * Return a list of ranges.
   *
   * scala> import warmup.Warmup._
   * scala> ranges(List(1, 2, 3, 4, 7, 8, 9, 10, 30, 40, 41))
   * resX: List[(Int, Int)] = List((1, 4), (7, 10), (30, 30), (40, 41))
   *
   * ~~~ library hint: use can just use List[A]#sorted to sort the list before you start.
   */
  def ranges(xs: List[Int]): List[(Int, Int)] =
    ???
}
