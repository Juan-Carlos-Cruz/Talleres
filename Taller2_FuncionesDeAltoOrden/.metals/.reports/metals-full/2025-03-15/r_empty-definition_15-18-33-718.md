error id: scala/Double#
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller2/derivacion/src/main/scala/package.scala
empty definition using pc, found symbol in pc: scala/Double#
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
  // 📌 Esto es crucial


package object Derivacion {
  val h: Double = 0.1

  def Derivada(f: Double => Double): Double => Double = {
    if ( x => {Derivada(f) == Derivada(x + h)} ) 0.0
    else x =>  (f(x - 2*h) - 8*f(x -h) + 8*f(x + h) - f(x + 2*h))/(12*h)
  } 
  


  def derivadaSuma(f: Double => Double, g: Double => Double): Double => Option[Double] =
    x => for { df <- derivada(f)(x); dg <- derivada(g)(x) } yield df + dg

  def derivadaResta(f: Double => Double, g: Double => Double): Double => Option[Double] =
    x => for { df <- derivada(f)(x); dg <- derivada(g)(x) } yield df - dg

  def derivadaMult(f: Double => Double, g: Double => Double): Double => Option[Double] =
    x => for { df <- derivada(f)(x); dg <- derivada(g)(x) } yield df * g(x) + f(x) * dg

  def derivadaDiv(f: Double => Double, g: Double => Double): Double => Option[Double] =
    x => for { df <- derivada(f)(x); dg <- derivada(g)(x) } yield (df * g(x) - f(x) * dg) / (g(x) * g(x))
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: scala/Double#