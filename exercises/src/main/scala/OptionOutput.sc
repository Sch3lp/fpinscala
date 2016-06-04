import fpinscala.errorhandling.{None, Some}

Some("derp").map(s => s.reverse)
None.map(s => s)

Some("derp").getOrElse(5)

Some("derp").flatMap(s => Some(s.reverse))
None.flatMap(s => Some("fart"))

Some("derp").orElse(Some("snarf"))
None.orElse(Some("snarf"))

Some("derp").filter(s => s.contains("d"))
Some("derp").filter(s => s.contains("z"))