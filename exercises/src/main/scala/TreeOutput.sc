import fpinscala.datastructures.{Branch, Leaf, Tree}

Leaf(1)
def tree1 = Leaf(1)
def tree2 = Branch(tree1,Leaf(2))
def tree3 = Branch(Leaf(1),Branch(Leaf(2),Leaf(3)))
def tree32 = Branch(Branch(Leaf(2),Leaf(3)),tree1)
val leftBranch = tree2
val rightBranch = Branch(Leaf(5),Branch(Leaf(4),Leaf(3)))
def tree5 = Branch(leftBranch,rightBranch)

Tree.size(tree1)
Tree.size(tree2)
Tree.size(tree3)
Tree.size(tree32)
Tree.size(tree5)

Tree.maximum(tree5)

Tree.depth(tree1)
Tree.depth(tree2)
Tree.depth(tree3)
Tree.depth(tree32)
Tree.depth(tree5)

Tree.map(tree5)(a => a + 1)

Tree.foldSize(tree1)
Tree.foldSize(tree2)
Tree.foldSize(tree3)
Tree.foldSize(tree32)
Tree.foldSize(tree5)

Tree.foldMaximum(tree5)

Tree.foldDepth(tree1)
Tree.foldDepth(tree2)
Tree.foldDepth(tree3)
Tree.foldDepth(tree32)
Tree.foldDepth(tree5)

Tree.foldMap(tree5)(a => a + 1)