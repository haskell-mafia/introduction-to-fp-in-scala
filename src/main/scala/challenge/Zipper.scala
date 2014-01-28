package challenge

/**
 *
 * A `Zipper` is a focussed position, with a list of values to the left and to the right.
 *
 * For example, taking the list [0,1,2,3,4,5,6], the moving focus to the third position, the zipper looks like:
 *
 *   Zipper(lefts = [2,1,0], focus = 3, rights = [4,5,6])
 *
 * Supposing then we move left on this zipper:
 *
 *   Zipper(lefts = [1,0], focus = 2, rights = [3,4,5,6])
 *
 * Then suppose we add 17 to the focus of this zipper:
 *
 *   Zipper(lefts = [1,0], focus = 19, rights = [3,4,5,6])
 */
case class Zipper[A](lefts: List[A], focus: A, rights: List[A]) {
  /**
   Exercise 1
   ----------
   Map the given function over a Zipper.
   */
  def map[B](f: A => B): Zipper[B] =
    ???

  /*
  Exercise 2
  ----------
  Return true if the zipper has an element to the right.
  */
  def hasRight: Boolean =
    ???

  /*
  Exercise 2
  ----------
  Return true if the zipper has an element to the left.
  */
  def hasLeft: Boolean =
    ???

  /*
  Exercise 3
  ----------
  Move the zipper one element to the right, or not if there is not a right element.
  */
  def right: Option[Zipper[A]] =
    ???

  /*
  Exercise 4
  -----------
  Move the zipper one element to the left, or not if there is not a left element.
  */
  def left: Option[Zipper[A]] =
    ???

  /*
  Exercise 5
  -----------
  Return the list from this zipper.

  ~~~ Remember to preserve correct ordering
  */
  def toList: List[A] =
    ???

  /*
  Exercise 6
  -----------
  Update the focus with the given function.
  */
  def withFocus(k: A => A): Zipper[A] =
    ???

  /*
  Exercise 7
  -----------
  Set the focus to the given value.
  */
  def :=(a: A): Zipper[A] =
    ???

  /*
  Exercise 8
  -----------
  Move the focus to the right until the focus meets the given predicate.
  */
  def findRight(p: A => Boolean): Option[Zipper[A]] =
    ???

  /*
  Exercise 9
  -----------
  Move the focus to the left until the focus meets the given predicate.
  */
  def findLeft(p: A => Boolean): Option[Zipper[A]] =
    ???

  /*
  Exercise 10
  -----------
  Insert the given value at the focus and push the old focus to the right.
  */
  def insertPushRight(a: A): Zipper[A] =
    ???

  /*
  Exercise 11
  -----------
  Insert the given value at the focus and push the old focus to the left.
  */
  def insertPushLeft(a: A): Zipper[A] =
    ???

  /*
  Exercise 12
  -----------
  Move the focus to the first element.
  */
  // @annotation.tailrec
  final def start: Zipper[A] =
    ???

  /*
  Exercise 13
  -----------
  Move the focus to the last element.
  */
  // @annotation.tailrec
  final def end: Zipper[A] =
    ???

  /*
  Exercise 14
  -----------
  Swap the focus with the element to the right. If there is no element to the right, leave unchanged.
  */
  def swapRight: Zipper[A] =
    ???

  /*
  Exercise 15
  -----------
  Swap the focus with the element to the left. If there is no element to the left, leave unchanged.
  */
  def swapLeft: Zipper[A] =
    ???

  /*
  Exercise 16
  -----------
  Delete the focus and pull the new focus from the right. If there is no element to the right, leave unchanged.
  */
  def deletePullRight: Zipper[A] =
    ???

  /*
  Exercise 17
  -----------
  Delete the focus and pull the new focus from the left. If there is no element to the left, leave unchanged.
  */
  def deletePullLeft: Zipper[A] =
    ???

  /*
  Exercise 18
  -----------
  Move the focus to the right the given number of times. If the number is negative, move left up to 0 instead.
  */
  def rightN(n: Int): Option[Zipper[A]] =
    ???

  /*
  Exercise 19
  -----------
  Move the focus to the left the given number of times. If the number is negative, move right up to 0 instead.
  */
  def leftN(n: Int): Option[Zipper[A]] =
    ???

  /*
  Exercise 20
  -----------
  Move the focus to the right the given number of times. If the number is negative, move left up to 0 instead.
  If the movement exceeds the boundary of the zipper, return the number of times were moved to the boundary (in Left).
  */
  def rightAtN(n: Int): Either[Int, Zipper[A]] =
    ???

  /*
  Exercise 21
  -----------
  Move the focus to the left the given number of times. If the number is negative, move right up to 0 instead.
  If the movement exceeds the boundary of the zipper, return the number of times were moved to the boundary (in Left).
  */
  def leftAtN(n: Int): Either[Int, Zipper[A]] =
    ???

  /*
  Exercise 22
  -----------
  Move the focus to the given absolute index in the zipper.
  Be careful not to traverse the zipper more than is required.

  ~~~ Use leftAtN to move left
  ~~~ Use rightN and leftN
  */
  def nth(i: Int): Option[Zipper[A]] =
    ???
}

object Zipper {
  def fromList[A](a: List[A]): Option[Zipper[A]] =
    a match {
      case Nil => None
      case h::t => Some(Zipper(Nil, h, t))
    }
}
