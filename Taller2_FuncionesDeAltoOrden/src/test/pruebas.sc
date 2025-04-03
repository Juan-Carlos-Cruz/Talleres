import Derivacion.*



val f: Double => Double = x => x*x
val g: Double => Double = x => Math.sin(1/x)

val d1 = derivada(f)
val d2 = derivada(g)
val d3 = derivadaSuma(f, g)
val d4 = derivadaResta(f, g)
val d5 = derivadaMult(f, g)
val d6 = derivadaDiv(f, g)

println(s"d1(2) = ${d1(2)}")  
println(s"d2(2) = ${d2(2)}")
println(s"d2(0) = ${d2(0)}")  
println(s"d3(2) = ${d3(2)}")
println(s"d4(2) = ${d4(2)}")
println(s"d5(2) = ${d5(2)}")
println(s"d6(2) = ${d6(2)}")
