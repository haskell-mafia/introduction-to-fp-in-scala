package intro

/**
 * `Id` is one of the most basic parameterized types. It
 * is simply a container for some value `A`.
 */
case class Id[A](value: A) {

  /*
   * Implement map for Id[A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   *
   * scala> Id(1).map(x => x + 10)
   *  = Id(11)
   */
  def map[B](f: A => B): Id[B] =
    ???

  /*
   * Implement flatMap.
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   * scala> Id(1).flatMap(x => Id(x + 10))
   *  = Id(11)
   */
  def flatMap[B](f: A => Id[B]): Id[B] =
    ???
}

object Id {
  /*
   * Implement point.
   *
   * scala> point(1)
   *  = Id(1)
   */
  def point[A](v: A): Id[A] =
    ???
}
