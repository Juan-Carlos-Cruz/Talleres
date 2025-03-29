error id: 
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller3/Taller3_ReconocimientodePatrones/src/test/scala/pruebas.sc
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -ManiobraTrenes.aplicarMovimientos.
	 -ManiobraTrenes.aplicarMovimientos#
	 -ManiobraTrenes.aplicarMovimientos().
	 -aplicarMovimientos.
	 -aplicarMovimientos#
	 -aplicarMovimientos().
	 -scala/Predef.aplicarMovimientos.
	 -scala/Predef.aplicarMovimientos#
	 -scala/Predef.aplicarMovimientos().

Document text:

```scala
import ManiobraTrenes._

val e1 = (List('a', 'b', 'c', 'd'), Nil, Nil)
val e2 = aplicarMovimiento(e1, Uno(2))
val e3 = aplicarMovimiento(e2, Dos(3))
val e4 = aplicarMovimiento(e3, Dos(-1))
val e5 = aplicarMovimiento(e4, Uno(-2))

aplicarMovimientos(e1, List(Uno(2), Dos(3), Dos(-1), Uno(-2), Dos(-1)))
aplicarMovimientos(e, List(Uno(1), Dos(1), Uno(-2)))

definirManiobra(List('a', 'b', 'c', 'd'), List('d', 'b', 'c', 'a'))

```

#### Short summary: 

empty definition using pc, found symbol in pc: 