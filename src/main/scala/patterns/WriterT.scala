package patterns

import intro._, EqualSyntax._

/*
 * A writer data type in transformer form that represents the pair of some
 * writer content with the production of a value in some effect M.
 */
case class WriterT[M[_], W, A](run: M[(W, A)]) {

  /*
   * Exercise 6.1:
   *
   * Implement map for WriterT[M, W, A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   *
   */
  def map[B](f: A => B)(implicit W: Monoid[W], M: Monad[M]): WriterT[M, W, B] =
    ???

  /*
   * Exercise 6.2:
   *
   * Implement flatMap (a.k.a. bind, a.k.a. >>=).
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   */
  def flatMap[B](f: A => WriterT[M, W, B])(implicit W: Monoid[W], M: Monad[M]): WriterT[M, W, B] =
    ???
}

object WriterT {
  /*
   * Exercise 6.3:
   *
   * Implement a convenience for constructing a WriterT with
   * value and writer content.
   *
   */
  def writer[M[_]: Monad, W, A](a: A)(w: W): WriterT[M, W, A] =
    ???

  /*
   * Exercise 6.4:
   *
   * Implement value  (a.k.a. return, point, pure) given a
   * Monoid for W.
   */
  def value[M[_]: Monad, W: Monoid, A](a: => A): WriterT[M, W, A] =
    ???

  /*
   * Exercise 6.5:
   *
   * Implement tell.
   *
   * Tell appends the writer content w and produces no value.
   */
  def tell[M[_]: Monad, W](w: W): WriterT[M, W, Unit] =
    ???


  class WriterT_[M[_], W] {
    type l[a] = WriterT[M, W, a]
  }

  class WriterT__[W] {
    type l[f[_], a] = WriterT[f, W, a]
  }

  implicit def WriterTMonad[F[_], W](implicit F: Monad[F], W: Monoid[W]): Monad[WriterT_[F, W]#l] =
    new Monad[WriterT_[F, W]#l] {
      def point[A](a: => A) = WriterT(F.point((W.identity, a)))
      def bind[A, B](a: WriterT[F, W, A])(f: A => WriterT[F, W, B]) = a flatMap f
    }

  implicit def WriterTEqual[F[_], W, A](implicit E: Equal[F[(W, A)]]) =
    Equal.from[WriterT[F, W, A]]((a, b) => a.run === b.run)

  /*
   * Exercise 6.6:
   *
   * Implement monad trans instance.
   *
   * Hint: Try using WriterT constructor and Monad[M].map(ga).
   */
  implicit def WriterTMonadTrans[W:Monoid]: MonadTrans[WriterT__[W]#l] =
    ???
}
