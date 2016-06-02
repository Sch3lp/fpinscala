package fpinscala.datastructures

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {

  def size[A](tree: Tree[A]): Int =
    tree match {
      case Leaf(_) => 1
      //TODO Question: why does the solution have 1 + size of left and right?
      //TODO Question: is it because to count all nodes you have to count "yourself" too? With yourself being a Branch of two other Trees?
      case Branch(l, r) => 1 + size(l) + size(r)
    }

  def maximum(t: Tree[Int]): Int =
    t match {
      case Leaf(a) => a
      case Branch(l, r) => maximum(l) max maximum(r)
    }

  //TODO Question: they return 0 as Leaf because the "root" counts as depth 0?
  def depth[A](t: Tree[A]): Int =
    t match {
      case Leaf(_) => 0
      case Branch(l, r) => 1 + (depth(l) max depth(r))
    }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] =
    t match {
      case Leaf(a) => Leaf(f(a))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }


  def foldSize[A](tree: Tree[A]): Int =
    fold(tree)(tree => 1)((l,r) => 1 + l + r)

  def foldMaximum(t: Tree[Int]): Int =
    fold(t)(a => a)((l,r) => l max r)

  def foldDepth[A](t: Tree[A]): Int =
    fold(t)(a => 0)((l,r) => 1 + l max r)

  def foldMap[A, B](t: Tree[A])(f: A => B): Tree[B] =
    t match {
      case Leaf(a) => Leaf(f(a))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }

  //TODO Remark: I don't immediately see the similarity between map and maximum or size.
  //TODO Remark: Is it that we're always "recursing" with both our sides of a Branch and combining those results with a +, a max or in a new Branch?
  //TODO Remark: Second insight: or maybe fold is supposed to be a higher order function?
  //TODO Remark: Third insight: tried to `fold(l,r)(someFunc)`, but then noticed I want to match on one param, then figured out I probably want to extract the Leaf() case as well (maybe as an `accumulator` or whatever it's called)
  //TODO Remark: Changed my signature accordingly, then started implementing the different functions with fold, foldMap got me walled
  def fold[A, B](t: Tree[A])(f: (A) => B)(g: (B,B) => B): B =
    t match {
      case Leaf(a) => f(a)
      case Branch(l, r) => g(fold(l)(f)(g),fold(r)(f)(g))
    }

}

