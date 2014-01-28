package patterns

trait MonadTrans[F[_[_], _]] {
  def liftM[G[_]: Monad, A](g: G[A]): F[G, A]
}

object MonadTrans {
  def apply[F[_[_], _]](implicit F: MonadTrans[F]): MonadTrans[F] =
    F

  def liftM[F[_[_], _], G[_], A](g: G[A])(implicit F: MonadTrans[F], G: Monad[G]): F[G, A] =
    F.liftM(g)
}
