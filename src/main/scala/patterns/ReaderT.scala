package patterns

import intro._

/*
 * A reader data type in transformer form that represents the application of some
 * environment to produce a value in some effect M.
 */
case class ReaderT[M[_], R, A](run: R => M[A]) {

  /*
   * Exercise 5.1:
   *
   * Implement map for ReaderT[M, R, A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   *
   */
  def map[B](f: A => B)(implicit M: Monad[M]): ReaderT[M, R, B] =
    ???

  /*
   * Exercise 5.2:
   *
   * Implement flatMap (a.k.a. bind, a.k.a. >>=).
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   */
  def flatMap[B](f: A => ReaderT[M, R, B])(implicit M: Monad[M]): ReaderT[M, R, B] =
    ???
}

object ReaderT {
  /*
   * Exercise 5.3:
   *
   * Implement value  (a.k.a. return, point, pure).
   *
   * Hint: Try using ReaderT constructor.
   */
  def value[M[_]: Monad, R, A](a: => A): ReaderT[M, R, A] =
    ???

  /*
   * Exercise 5.4:
   *
   * Implement ask.
   *
   * Ask provides access to the current environment (R).
   *
   * Hint: Try using ReaderT constructor.
   */
  def ask[M[_]: Monad, R]: ReaderT[M, R, R] =
    ???

  /*
   * Exercise 5.5:
   *
   * Implement local.
   *
   * Local produce a reader that runs with a modified environment.
   *
   * Hint: Try using ReaderT constructor.
   */
  def local[M[_], R, A](f: R => R)(reader: ReaderT[M, R, A]): ReaderT[M, R, A] =
    ???

  class ReaderT_[F[_], R] {
    type l[a] = ReaderT[F, R, a]
  }

  class ReaderT__[R] {
    type l[f[_], a] = ReaderT[f, R, a]
  }

  implicit def ReaderTMonad[F[_], R](implicit F: Monad[F]): Monad[ReaderT_[F, R]#l] =
    new Monad[ReaderT_[F, R]#l] {
      def point[A](a: => A) = ReaderT(_ => F.point(a))
      def bind[A, B](a: ReaderT[F, R, A])(f: A => ReaderT[F, R, B]) = a flatMap f
    }

  /*
   * Exercise 5.6:
   *
   * Implement monad trans instance.
   *
   * Hint: Try using ReaderT constructor.
   */
  implicit def ReaderTMonadTrans[R]: MonadTrans[ReaderT__[R]#l] = new MonadTrans[ReaderT__[R]#l] {
    def liftM[M[_]: Monad, A](ga: M[A]): ReaderT[M, R, A] =
      ???
  }

}
