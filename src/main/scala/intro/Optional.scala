package intro

sealed trait Optional[A] {
  def fold[X](
    full: A => X,
    empty: => X
  ): X = this match {
    case Full(a) => full(a)
    case Empty() => empty
  }

  def map[B](f: A => B): Optional[B] =
    fold(a => Full(f(a)), Empty[B])

  def flatMap[B](f: A => Optional[B]): Optional[B] =
    fold(f, Empty[B]())
}

case class Full[A](a: A) extends Optional[A]
case class Empty[A]() extends Optional[A]
