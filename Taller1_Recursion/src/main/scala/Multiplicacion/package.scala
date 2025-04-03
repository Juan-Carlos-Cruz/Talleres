package object Multiplicacion {

  def PeasantAlgorithm(a: Int, b:Int): Int ={
    def recursion(a: Int, b:Int): Int = {
      if (a == 0)  0
      else if (a % 2 == 0) recursion(a/2,b+b)
      else recursion(a/2,b+b) + b
    }
    val resultado = recursion(a,b)
    if (a < 0) -resultado else resultado 
  }




  def PeasantAlgorithmIt(a: Int, b:Int): Int = {
    val x = if (a < 0) -a else a
    def recursion(x: Int, b:Int, acumulador: Int): Int = {
      val z = if (x % 2 == 0 || x % 2!=0) x/2 else 0
      val w = b+b
      val y = if (x % 2 == 0) acumulador else acumulador+b
      if (x == 0) acumulador
      else recursion(z, w, y)
    }
  
    val resultado = recursion(x, b, 0)
    if (a < 0) -resultado else resultado 
  
  }

  def splitMultiply(a:Int, b:Int): Int ={
    if (a < 10 && b < 10) a * b
    else {
      def countsDigits(n: Int): Int = {
        if(n == 0) 0 else countsDigits(n/10) + 1
      }
      val A = countsDigits(a)
      val B = countsDigits(b)
      val m = (if (A > B) A else B)/2
  
      val potencia = math.pow(10,m).toInt
      val potencia2 = math.pow(10,m+m).toInt
      val x = a/potencia
      val y = a % potencia
      val z = b/potencia
      val w = b % potencia
  
      val multi1 =  splitMultiply(x,z)
      val multi2 =  splitMultiply(x,w)
      val multi3 =  splitMultiply(y,z)
      val multi4 =  splitMultiply(y,w)
      potencia2 * multi1 + potencia *  (multi2 + multi3 ) + multi4
    }
  }

  def fastAlgorithm(a: Int, b: Int): Int = {
    if (a < 10 && b < 10) a * b
    else {
      def countsDigits1(n: Int): Int = {
        if (n == 0) 0 else countsDigits1(n / 10) + 1
      }

      val A = countsDigits1(a)
      val B = countsDigits1(b)
      val m = (if (A > B) A else B) / 2

      val potencia = math.pow(10, m).toInt
      val potencia2 = math.pow(10, m + m).toInt
      val x = a / potencia
      val y = a % potencia
      val z = b / potencia
      val w = b % potencia

      val multi1 = fastAlgorithm(x, z)
      val multi2 = fastAlgorithm(x, w)
      val multi3 = fastAlgorithm(y, z)
      val multi4 = fastAlgorithm(y, w)
      val multi5 =fastAlgorithm(x-y,z-w)
      potencia2 * multi1 + potencia *  (multi1+multi4-multi5) + multi4

  }
} }




object Main {
  def main(args: Array[String]): Unit = {
    println("Resultado: " + Multiplicacion.PeasantAlgorithm(10,-10))
    println("Resultado: " + Multiplicacion.PeasantAlgorithmIt(2,-3))
    println("Resultado: " + Multiplicacion.splitMultiply(1000,-100))
    println("Resultado: " + Multiplicacion.fastAlgorithm(9999,9999))


  }
}
  