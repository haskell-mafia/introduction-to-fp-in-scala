package patterns

import intro._

sealed trait HttpValue[A] {
  def fold[X](
    explosion: Throwable => X,
    fail: String => X,
    ok: A => X
  ): X = this match {
    case Explosion(exception) => explosion(exception)
    case Fail(message) => fail(message)
    case Ok(value) => ok(value)
  }

  def map[B](f: A => B): HttpValue[B] =
    flatMap(f andThen HttpValue.ok)

  def flatMap[B](f: A => HttpValue[B]): HttpValue[B] =
    fold(HttpValue.explosion, HttpValue.fail, f)
}

case class Explosion[A](exception: Throwable) extends HttpValue[A]
case class Fail[A](message: String) extends HttpValue[A]
case class Ok[A](value: A) extends HttpValue[A]

object HttpValue {
  def explosion[A](exception: Throwable): HttpValue[A] =
    Explosion(exception)

  def fail[A](message: String): HttpValue[A] =
    Fail(message)

  def ok[A](value: A): HttpValue[A] =
    Ok(value)

  implicit def HttpValueMonad: Monad[HttpValue] = new Monad[HttpValue] {
    def point[A](a: => A) = ok(a)
    def bind[A, B](a: HttpValue[A])(f: A => HttpValue[B]) = a flatMap f
  }
}
