package intro

trait Monoid[A] {
  def zero: A
  def op(a: A, b: A): A
}

object Monoid {
  case class Sum(n: Int)
  case class Product(n: Int)
  case class Min(n: Int)
  case class Max(n: Int)
  case class Average(count: Int, total: Int)
  case class Endo[A](f: A => A)
  case class First[A](first: A)
  case class Last[A](last: A)

  implicit def SumMonoid: Monoid[Sum] =
    ???

  implicit def ProductMonoid: Monoid[Product] =
    ???

  implicit def MinMonoid: Monoid[Min] =
    ???

  implicit def MaxMonoid: Monoid[Max] =
    ???

  implicit def AverageMonoid: Monoid[Average] =
    ???

  implicit def EndoMonoid[A]: Monoid[Endo[A]] =
    ???

  implicit def FirstMonoid[A]: Monoid[First[A]] =
    ???

  implicit def LastMonoid[A]: Monoid[Last[A]] =
    ???

  implicit def ListMonoid[A]: Monoid[List[A]] =
    ???

  implicit def MapMonoid[A, B: Monoid]: Monoid[Map[A, B]] =
    ???

  implicit def Tuple2Monoid[A: Monoid, B: Monoid]: Monoid[(A, B)] =
    ???

  implicit def Tuple3Monoid[A: Monoid, B: Monoid, C: Monoid]: Monoid[(A, B, C)] =
    ???

  implicit def Tuple4Monoid[A: Monoid, B: Monoid, C: Monoid, D: Monoid]: Monoid[(A, B, C, D)] =
    ???

  def foldMap[A, B: Monoid](xs: List[A])(f: A => B): B =
    ???

  def sum[A: Monoid](xs: List[A]): A =
    ???
}

object MonoidExercise {
  case class Stats(min: Int, max: Int, total: Int, count: Int)
  case class Stock(ticker: String, date: String, cents: Int)

  def Data = List(
    Stock("FAKE", "2012-01-01", 10000)
  , Stock("FAKE", "2012-01-02", 10020)
  , Stock("FAKE", "2012-01-03", 10022)
  , Stock("FAKE", "2012-01-04", 10005)
  , Stock("FAKE", "2012-01-05",  9911)
  , Stock("FAKE", "2012-01-06",  6023)
  , Stock("FAKE", "2012-01-07",  7019)
  , Stock("CAKE", "2012-01-01",     1)
  , Stock("CAKE", "2012-01-02",     2)
  , Stock("CAKE", "2012-01-03",     3)
  , Stock("CAKE", "2012-01-04",     4)
  , Stock("CAKE", "2012-01-05",     5)
  , Stock("CAKE", "2012-01-06",     6)
  , Stock("CAKE", "2012-01-07",     7)
  , Stock("BAKE", "2012-01-01", 99999)
  , Stock("BAKE", "2012-01-02", 99999)
  , Stock("BAKE", "2012-01-03", 99999)
  , Stock("BAKE", "2012-01-04", 99999)
  , Stock("BAKE", "2012-01-05", 99999)
  , Stock("BAKE", "2012-01-06", 99999)
  , Stock("BAKE", "2012-01-07", 99999)
  , Stock("LAKE", "2012-01-01", 10012)
  , Stock("LAKE", "2012-01-02",  7000)
  , Stock("LAKE", "2012-01-03",  1234)
  , Stock("LAKE", "2012-01-04",    10)
  , Stock("LAKE", "2012-01-05",  6000)
  , Stock("LAKE", "2012-01-06",  6099)
  , Stock("LAKE", "2012-01-07",  5999)
  )
}
