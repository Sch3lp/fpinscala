package fpinscala.errorhandling


import scala.{Option => _, Some => _, Either => _, _} // hide std library `Option`, `Some` and `Either`, since we are writing our own in this chapter

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  def getOrElse[B>:A](default: => B): B = this match {
    case None => default
    case Some(a) => a
  }

  def flatMap_Match[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => f(a)
  }

  //TODO Question: In the answer, they just go _ => instead of Some(_), is this because there are only 2 possible outcomes, and None already has a case, therefore you can just write _?
  def orElse_Match[B>:A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case Some(_) => this
  }

  def filter_Match(f: A => Boolean): Option[A] = this match {
    case None => None
    case Some(a) => if (f(a)) this
                    else None
  }

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f).getOrElse(None)

  def orElse[B>:A](ob: => Option[B]): Option[B] =
    None.getOrElse(ob)

  //TODO Question: In the answer they explicitly call a new Some() instead of just returning this. What's the difference?
  def filter(f: A => Boolean): Option[A] =
    flatMap(a => if (f(a)) this else None)

}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

object Option {
  def map2[A,B,C](optA: Option[A], optB: Option[B])(f: (A, B) => C): Option[C] = (optA, optB) match {
    case (Some(a), Some(b)) => Some(f(a,b))
    case _ => None
  }


  def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!") // `val y: Int = ...` declares `y` as having type `Int`, and sets it equal to the right hand side of the `=`.
    try {
      val x = 42 + 5
      x + y
    }
    catch { case e: Exception => 43 } // A `catch` block is just a pattern matching block like the ones we've seen. `case e: Exception` is a pattern that matches any `Exception`, and it binds this value to the identifier `e`. The match returns the value 43.
  }

  def failingFn2(i: Int): Int = {
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int) // A thrown Exception can be given any type; here we're annotating it with the type `Int`
    }
    catch { case e: Exception => 43 }
  }

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  def variance(xs: Seq[Double]): Option[Double] = sys.error("todo")


  def sequence[A](a: List[Option[A]]): Option[List[A]] = sys.error("todo")

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = sys.error("todo")
}