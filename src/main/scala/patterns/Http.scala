package patterns

import intro._ // type classes

/*
 * A http datatype that represents a number of read/write/state/result
 * like structure as a function.
 */
case class Http[A](run: (HttpRead, HttpState) => (HttpWrite, HttpState, HttpValue[A])) {

  /*
   * Exercise 8a.1:
   *
   * Implement map for Http[A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   */
  def map[B](f: A => B): Http[B] =
    ???

  /*
   * Exercise 8a.2:
   *
   * Implement flatMap (a.k.a. bind, a.k.a. >>=).
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   */
  def flatMap[B](f: A => Http[B]): Http[B] =
    ???
}

object Http {
  /*
   * Exercise 8a.3:
   *
   * Implement value  (a.k.a. return, point, pure).
   *
   * Hint: Try using Http constructor.
   */
  def value[A](a: => A): Http[A] =
    ???

  /*
   * Exercise 8a.4:
   *
   * Implement ask for Http, similar behaviour to Reader.ask.
   *
   * Hint: Try using Http constructor.
   */
  def httpAsk: Http[HttpRead] =
    ???

  /*
   * Exercise 8a.5:
   *
   * Implement get for Http, similar behaviour to State.get.
   *
   * Hint: Try using Http constructor.
   */
  def httpGet: Http[HttpState] =
    ???

  /*
   * Exercise 8a.6:
   *
   * Implement modify for Http, similar behaviour to State.modify.
   *
   * Hint: Try using Http constructor.
   */
  def httpModify(f: HttpState => HttpState): Http[Unit] =
    ???

  /*
   * Exercise 8a.7:
   *
   * Implement getBody.
   *
   * Hint: You may want to define some other combinators to help
   *       that have not been specified yet, remember exercise 2 ask?
   */
  def getBody: Http[String] =
    ???

  /*
   * Exercise 8a.8:
   *
   * Implement addHeader.
   *
   * Hint: You may want to define some other combinators to help
   *       that have not been specified yet, remember exercise 4 update?
   */
  def addHeader(name: String, value: String): Http[Unit] =
    ???

  /*
   * Exercise 8a.9:
   *
   * Implement log.
   *
   * Hint: Try using Http constructor.
   */
  def log(message: String): Http[Unit] =
    ???

  implicit def HttpMonad: Monad[Http] =
    new Monad[Http] {
      def point[A](a: => A) = Http.value(a)
      def bind[A, B](a: Http[A])(f: A => Http[B]) = a flatMap f
  }
}

object HttpExample {
  import Http._

  /*
   * Exercise 8a.10:
   *
   * Implement echo http service.
   *
   * Echo service should:
   *   return body as string,
   *   add "content-type" header of "text/plain"
   *   log a message with the length of the body in characters.
   *
   * Hint: Try using flatMap or for comprehensions.
   */
  def echo: Http[String] =
    ???
}


/** Data type wrapping up all http state data */
case class HttpState(resheaders: Headers)

/** Data type wrapping up all http environment data */
case class HttpRead(method: Method, body: String, reqheaders: Headers)

/** Data type wrapping up http log data */
case class HttpWrite(log: Vector[String]) {
  def ++(w: HttpWrite) =
    HttpWrite(log ++ w.log)
}

/** Monoid for HttpWrite (for completeness and convenience). */
object HttpWrite {
  implicit def HttpWriteMonoid: Monoid[HttpWrite] = new Monoid[HttpWrite] {
    def identity = HttpWrite(Vector())
    def op(a: HttpWrite, b: HttpWrite) = a ++ b
  }
}

/** Headers data type. */
case class Headers(headers: Vector[(String, String)] = Vector()) {
  def :+(p: (String, String)) =
    Headers(headers :+ p)
}

/** Method data type. */
sealed trait Method
case object Options extends Method
case object Get extends Method
case object Head extends Method
case object Post extends Method
case object Put extends Method
case object Delete extends Method
case object Trace extends Method
case object Connect extends Method
