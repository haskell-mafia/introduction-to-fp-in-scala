package patterns

import intro._

/*
 * A state data type that represents the threading
 * of some state value through computations in some effect M.
 */
case class StateT[M[_], S, A](run: S => M[(S, A)]) {

  /*
   * Exercise 7.1:
   *
   * Implement map for StateT[M, S, A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   *
   */
  def map[B](f: A => B)(implicit M: Monad[M]): StateT[M, S, B] =
    ???

  /*
   * Exercise 7.2:
   *
   * Implement flatMap (a.k.a. bind, a.k.a. >>=).
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   */
  def flatMap[B](f: A => StateT[M, S, B])(implicit M: Monad[M]): StateT[M, S, B] =
    ???
}

object StateT {
  /*
   * Exercise 7.3:
   *
   * Implement value  (a.k.a. return, point, pure).
   *
   * Hint: Try using StateT constructor.
   */
  def value[M[_]: Monad, S, A](a: => A): StateT[M, S, A] =
    ???

  /*
   * Exercise 7.4:
   *
   * Implement get.
   *
   * Get provides access to the current state (S).
   *
   * Hint: Try using StateT constructor.
   */
  def get[M[_]: Monad, S]: StateT[M, S, S] =
    ???

  /*
   * Exercise 7.5:
   *
   * Implement gets.
   *
   * Gets provides access to a view of the current state (S).
   *
   * Hint: Try building on get.
   */
  def gets[M[_]: Monad, S, A](f: S => A): StateT[M, S, A] =
    ???

  /*
   * Exercise 7.6:
   *
   * Implement modify.
   *
   * Update the current state and produce no value.
   *
   * Hint: Try using State constructor.
   */
  def modify[M[_]: Monad, S](f: S => S): StateT[M, S, Unit] =
    ???

  /*
   * Exercise 7.7:
   *
   * Implement put.
   *
   * Clobber the current state and produce no value.
   *
   * Hint: Try building on modify.
   */
  def put[M[_]: Monad, S](s: S): StateT[M, S, Unit] =
    ???

  class StateT_[F[_], S] {
    type l[a] = StateT[F, S, a]
  }

  class StateT__[S] {
    type l[f[_], a] = StateT[f, S, a]
  }

  implicit def StateTMonad[F[_], S](implicit F: Monad[F]): Monad[StateT_[F, S]#l] =
    new Monad[StateT_[F, S]#l] {
      def point[A](a: => A) = StateT(s => F.point((s, a)))
      def bind[A, B](a: StateT[F, S, A])(f: A => StateT[F, S, B]) = a flatMap f
    }

  /*
   * Exercise 7.8:
   *
   * Implement monad trans instance.
   *
   * Hint: Try using StateT constructor and Monad[M].map(ga).
   */
  implicit def StateTMonadTrans[S]: MonadTrans[StateT__[S]#l] =
    ???
}
