package fpinscala.datastructures

import javax.print.DocFlavor.BYTE_ARRAY

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

//  def fold
}

