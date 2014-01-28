package patterns

import intro._
import MonadTrans._

object HttpTransformerStack {
  type V[A] = HttpValue[A]
  type SV[A] = StateT[V, HttpState, A]
  type WSV[A] = WriterT[SV, HttpWrite, A]
  type RWSV[A] = ReaderT[WSV, HttpRead, A]


  /** Type aliases to use with liftM */
  type S_[F[_], A] = StateT[F, HttpState, A]
  type W_[F[_], A] = WriterT[F, HttpWrite, A]
  type R_[F[_], A] = ReaderT[F, HttpRead, A]

}

import HttpTransformerStack._

case class HttpT[A](run: RWSV[A]) {
  /*
   * Exercise 8b.1:
   *
   * Implement map for HttpT[A].
   *
   * The following laws must hold:
   *  1) r.map(z => z) == r
   *  2) r.map(z => f(g(z))) == r.map(g).map(f)
   */
  def map[B](f: A => B): HttpT[B] =
    ???

  /*
   * Exercise 8b.2:
   *
   * Implement flatMap (a.k.a. bind, a.k.a. >>=).
   *
   * The following law must hold:
   *   r.flatMap(f).flatMap(g) == r.flatMap(z => f(z).flatMap(g))
   *
   */
  def flatMap[B](f: A => HttpT[B]): HttpT[B] =
    ???
}

object HttpT {
  import ReaderT.{ask, local}
  import StateT.{modify, get}
  import WriterT.tell
  import MonadTrans.liftM

  /*
   * Exercise 8b.3:
   *
   * Implement value  (a.k.a. return, point, pure).
   *
   * Hint: Try using Http constructor.
   */
  def value[A](a: => A): HttpT[A] =
    ???

  /*
   * Exercise 8b.4:
   *
   * Implement ask for a Http.
   *
   * Hint: Try using Http constructor and ReaderT ask.
   */
  def httpAsk: HttpT[HttpRead] =
    ???

  /*
   * Exercise 8b.5:
   *
   * Implement get for a Http.
   *
   * Hint: Try using Http constructor, StateT get MonadTrans.liftM (twice).
   *
   * Hint Hint: liftM type signature is:
   *
   *     liftM[F[_[_], _], G[_], A](g: G[A])
   *
   * Hint Hint Hint: You will have to explicitly specify types for liftM and
   * there are convenience type aliases above R_, and W_ above that will help.
   *
   *     liftM[R_, WSV, HttpState](???): RWSV[HttpState]
   *     liftM[W_, SV, HttpState](???): WSV[HttpState]
   */
  def httpGet: HttpT[HttpState] =
    /** FREE ANSWER, so you don't get too hung up on syntax, next one is for you */
    HttpT(
      liftM[R_, WSV, HttpState](
        liftM[W_, SV, HttpState](
          get[V, HttpState])))

  /*
   * Exercise 8b.6:
   *
   * Implement modify for a Http.
   *
   * Hint: Try using Http constructor, StateT modify MonadTrans.liftM (twice).
   *
   * Hint Hint: liftM type signature is:
   *
   *     liftM[F[_[_], _], G[_], A](g: G[A])
   *
   * Hint Hint Hint: You will have to explicitly specify types for liftM and
   * there are convenience type aliases above R_, and W_ above that will help.
   *
   *     liftM[R_, WSV, Unit](???): RWSV[Unit]
   *     liftM[W_, SV, Unit](???): WSV[Unit]
   */
  def httpModify(f: HttpState => HttpState): HttpT[Unit] =
    ???

  /*
   * Exercise 8b.7:
   *
   * Implement get for a Http.
   *
   * Hint: Try using Http constructor, HttpWriteT tell MonadTrans.liftM (once).
   */
  def httpTell(w: HttpWrite): HttpT[Unit] =
    ???

  /*
   * Exercise 8b.8:
   *
   * Implement getBody.
   *
   * Hint: You may want to use httpAsk.
   */
  def getBody: HttpT[String] =
    ???

  /*
   * Exercise 8b.9:
   *
   * Implement addHeader.
   *
   * Hint: You may want to use httpModify.
   */
  def addHeader(name: String, value: String): HttpT[Unit] =
    ???

  /*
   * Exercise 8b.10:
   *
   * Implement log.
   *
   * Hint: Try using httpTell.
   */
  def log(message: String): HttpT[Unit] =
    ???

  implicit def HttpMonad: Monad[HttpT] =
    new Monad[HttpT] {
      def point[A](a: => A) = HttpT.value(a)
      def bind[A, B](a: HttpT[A])(f: A => HttpT[B]) = a flatMap f
  }
}

object HttpTExample {
  import Http._

 /*
   * Exercise 8a.11:
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
  def echo: HttpT[String] =
    ???
}
