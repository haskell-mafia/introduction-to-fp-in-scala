package patterns

import intro._

trait Applicative[F[_]] extends Functor[F] {
  def pure[A](a: => A): F[A]
  def ap[A, B](a: F[A])(f: F[A => B]): F[B]
}

object Applicative {
  def apply[F[_]: Applicative]: Applicative[F] =
    implicitly[Applicative[F]]
}
