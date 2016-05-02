package fpinscala.datastructures

import javax.print.DocFlavor.BYTE_ARRAY

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {

  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    //TODO Question: why does the solution have 1 + size of left and right?
    case Branch(left, right) => size(left) + size(right)
  }

  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(a) => a
    case Branch(l,r) => maximum(l) max maximum(r)
  }
}

