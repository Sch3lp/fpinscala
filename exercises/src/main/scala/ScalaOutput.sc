def List = fpinscala.datastructures.List
List.tail(List(1,2,3,4))
List.setHead(List(2,3,4),1)
List.setHead(List(),1)
List.drop(List(),1)
List.drop(List(1,2,3,4),2)
// Why do I have to write (x:Int),
// if dropWhile already states that it can only take a function that takes an A when also passed a List[A]?
List.dropWhile(List(1,2,3,4), (x:Int) => x < 3)
