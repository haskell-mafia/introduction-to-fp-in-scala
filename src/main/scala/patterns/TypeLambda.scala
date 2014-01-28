package patterns

class TypeLambda[F[_, _], A] {
  type l[a] = F[A, a]
}
