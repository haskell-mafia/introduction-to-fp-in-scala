package intro

/**
 * Abstraction of types that can be mapped over.
 *
 * The following laws should hold:
 *
 *  1) map(r)(z => z) == r
 *  2) map(r)(z => f(g(z))) == map(map(r)(g))(f)
 */
trait Functor[F[_]] {
  def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
  /**
   * Convenience for summoning a Functor instance.
   *
   * usage: Functor[Int].map(1, 2)
   */
  def apply[F[_]: Functor]: Functor[F] =
    implicitly[Functor[F]]

  /* Functor Instances (cheating is good) */

  implicit def IdFunctor: Functor[Id] = new Functor[Id] {
    def map[A, B](a: Id[A])(f: A => B) =
      a.map(f)
  }

  implicit def OptionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](a: Option[A])(f: A => B) =
      a.map(f)
  }

  implicit def OptionalFunctor: Functor[Optional] = new Functor[Optional] {
    def map[A, B](a: Optional[A])(f: A => B) =
      a.map(f)
  }

  implicit def ListFunctor: Functor[List] = new Functor[List] {
    def map[A, B](a: List[A])(f: A => B) =
      Lists.map(a)(f)
  }

  /* Functor Library */

  /** Exercise: 1 - Twin all `A`s in `fa`. */
  def fpair[F[_]: Functor, A](fa: F[A]): F[(A, A)] =
    ???

  /** Exercise: 2 - Pair all `A`s in `fa` with the result of function application. */
  def fproduct[F[_]: Functor, A, B](fa: F[A])(f: A => B): F[(A, B)] =
    ???

  /** Exercise: 3 - Inject `a` to the left of `B`s in `f`. */
  def strengthL[F[_]: Functor, A, B](a: A, f: F[B]): F[(A, B)] =
    ???

  /** Exercise: 4 - Inject `b` to the right of `A`s in `f`. */
  def strengthR[F[_]: Functor, A, B](f: F[A], b: B): F[(A, B)] =
    ???
}
