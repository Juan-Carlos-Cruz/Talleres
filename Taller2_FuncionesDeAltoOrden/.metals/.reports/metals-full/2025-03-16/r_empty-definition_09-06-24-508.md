error id: scala/Double.
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller2/carpeta/Taller2_FuncionesdeAltoOrden/src/main/scala/Derivacion/package.scala
empty definition using pc, found symbol in pc: scala/Double.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala


package object Derivacion {

  val h: Double = 0.1

  def derivada(f: Double => Double): Double => Double = { 
    (x:Double)=>{
      val derivadaIzquierda = (f(x) - f(x - h)) / h
      val derivadaDerecha = (f(x + h) - f(x)) / h
      val diferencia = derivadaIzquierda - derivadaDerecha
      val dif = Math.abs(f(x + h) - f(x - h)) 
      if(Math.abs(diferencia) > 1.0 || dif > 1.0) Double.NaN
      else
        (f(x - 2*h) - 8*f(x -h) + 8*f(x + h) - f(x + 2*h))/(12*h)
    }  
 }
  
  def derivadaSuma(f: Double => Double, g: Double => Double): Double => Double ={ 
    (x:Double) => derivada(f)(x) + derivada(g)(x)
  }

  def derivadaResta(f: Double => Double, g: Double => Double): Double => Double ={
    (x:Double) => derivada(f)(x) - derivada(g)(x)
  }
  
  def derivadaMult(f: Double => Double, g: Double => Double) : Double => Double ={
    (x:Double) => derivada(f)(x)*g(x) + f(x)*derivada(g)(x)
  }

  def derivadaDiv(f: Double => Double, g: Double => Double): Double => Double={
    (x:Double) => (derivada(f)(x)*g(x) - f(x)*derivada(g)(x))/(g(x)*g(x))
  }
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: scala/Double.