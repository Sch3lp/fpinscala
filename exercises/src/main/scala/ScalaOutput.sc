def List = fpinscala.datastructures.List
List.tail(List(1,2,3,4))
List.setHead(List(2,3,4),1)
List.setHead(List(),1)
List.drop(List(),1)
List.drop(List(1,2,3,4),2)
// Why do I have to write (x:Int),
// if dropWhile already states that it can only take a function that takes an A when also passed a List[A]?
// Answer was in 3.3.2 :) But I don't know how I feel about readability.
List.dropWhile(List(1,2,3,4))(x => x < 3)
List.dropWhile(List(3,2,1))(x => x < 3)
List.init(List(1,2,3,4))