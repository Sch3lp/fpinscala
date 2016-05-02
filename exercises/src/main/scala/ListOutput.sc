import fpinscala.datastructures.{Branch, Leaf, List, Tree}

//def Nil = fpinscala.datastructures.Nil
//def derp = Nil:List[String]
List.tail(List(1,2,3,4))
List.setHead(List(2,3,4),1)
List.setHead(List(),1)
List.drop(List(),1)
List.drop(List(1,2,3,4),2)
List.dropWhile(List(1,2,3,4))(x => x < 3)
List.dropWhile(List(3,2,1))(x => x < 3)
List.init(List(1,2,3,4))
List.length(List(4,3,2,1,0))
List.foldLeft(List(1,2,3,4),0)((b,a)=> a + b)
List.sumLeft(List(1,2,3,4))
List.productLeft(List(1.0,2.0,3.0))
List.reverse(List(1,2,3,4))
List.reverse(List(4,3,2,1))
List.reverse(List("A","B","C"))
List.map(List(1, 2, 3, 4))((a) => 42)
List.reverse(List(1,2,3,4)) == List(4,3,2,1)
