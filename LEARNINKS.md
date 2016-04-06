# Chapter 3
## recursion == foldLeft
In the case that you can recurse and always move through the entire list, so without a break condition, then you can *always* use foldLeft.
  
## Nil:List[String]
```
def doubleToString(l: List[Double]): List[String] =
    foldRight(l, Nil:List[String])((h,t) => Cons(h.toString,t))
```
You want an empty List, but Nil is typed with `[Nothing]` and `[Nothing]` is not `[B]`.

## Styling curly braces

## foldLeft 

## Using foldRight but want it tail recursive? Use reverse(foldLeft)

## More abstract means more responsibility
Because of the fact that in FP you're getting rid of duplication into more abstract concepts,
your abstract concepts have WAAAAAAAYYYYY more weight and importance compared to e.g. Java classes.

## Concepts vs. explicitness discussion
`fold` in the context of `tree` vs. always use `match case`.
Requires knowledge of concepts and those in a certain context.
 