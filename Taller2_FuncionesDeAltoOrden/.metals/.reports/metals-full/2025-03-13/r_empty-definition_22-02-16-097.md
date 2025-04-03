error id: `<none>`.
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller2/derivacion/src/main/scala/package.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
  // 📌 Esto es crucial


package object Derivacion {
  val h: Double = 0.1

  def derivada(f: Double => Double): Double => Option[Double] = x0 =>
  
     Some((f(x0 - 2*h) - 8*f(x0 - h) + 8*f(x0 + h) - f(x0 + 2*h)) / (12*h))

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

empty definition using pc, found symbol in pc: `<none>`.