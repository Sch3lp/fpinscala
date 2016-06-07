import fpinscala.errorhandling.{None, Option, Some}

Some("derp").map(s => s.reverse)
None.map(s => s)

Some("derp").getOrElse(5)

Some("derp").flatMap(s => Some(s.reverse))
None.flatMap(s => Some("fart"))

Some("derp").orElse(Some("snarf"))
None.orElse(Some("snarf"))

Some("derp").filter(s => s.contains("d"))
Some("derp").filter(s => s.contains("z"))

def snarf(a:String, b:String) = a + b

val optA = Some("Lion")
val optB = Some("-O")

Option.map2(optA,optB)(snarf)

Option.sequence(List(Some(1),Some(2),Some(3)))
Option.sequence(List(Some(1),Some(2),None))
Option.sequence(List(Some(1),None,Some(3)))