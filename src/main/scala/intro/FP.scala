package course

object FP {

  def amIFunctionalProgramming[A](a: A, expr1: A => A, expr2: A => A): Boolean =
    func1(a, expr1, expr2) == func2(a, expr1, expr2)


  def func1[A](a: A, expr1: A => A, expr2: A => A): (A, A) = {
    val x = expr1(a)
    val y = expr2(a)
    (x, y)
  }

  def func2[A](a: A, expr1: A => A, expr2: A => A): (A, A) =
    (expr1(a), expr2(a))

  def main(args: Array[String]) {
    println(amIFunctionalProgramming[StringBuilder](
      new StringBuilder,
      _.append("hello"),
      _.append("hello")
    ))
  }
}
