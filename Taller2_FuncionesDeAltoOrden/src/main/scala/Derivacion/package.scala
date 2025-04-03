

package object Derivacion {

  def derivada(f: Double => Double): Double => Double = {
    def derivadaAux(x: Double, h: Double): Double = {
  
      // Verificar si la función está definida en x
      val fx = f(x)
      val esFuncionIndefinida = fx.isNaN || fx.isInfinite

      // Determinar el valor a devolver
      val resultado = if (esFuncionIndefinida) {
        Double.NaN  // Devolver NaN si la función no está definida en x
      } else {
        // Calcular las derivadas izquierda y derecha
         def abs(x:Double): Double ={
          if (x<0) -x
          else x
        }
        val derivadaIzquierda = (fx - f(x - h)) / h
        val derivadaDerecha = (f(x + h) - fx) / h
        val diferencia = abs(derivadaIzquierda - derivadaDerecha)
        val tolerancia = 1e-6
       
        if (diferencia < tolerancia || h < 1e-6) {
          // Calcular la derivada final usando diferencias finitas de cuarto orden
          (f(x - 2 * h) - 8 * f(x - h) + 8 * f(x + h) - f(x + 2 * h)) / (12 * h)
        } else {
          // Reducir h y llamar recursivamente
          derivadaAux(x, h / 2)
        }
      }

      resultado  // Devolver el valor calculado
    }

    // Devolver la función derivada que usa la función auxiliar
    (x: Double) => derivadaAux(x, 0.1)  // Iniciar con h = 0.1
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