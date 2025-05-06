import Matrices._
import Benchmark._

val tamaños = List(2, 4, 8, 16, 32, 64, 128)

for (n <- tamaños) {
  val m1 = matrizAlAzar(n, 2)
  val m2 = matrizAlAzar(n, 2)

  println(s"Tamaño: $n x $n")

  val (t1, t2, speed) = compararAlgoritmos(multMatriz, multMatrizPar)(m1, m2)
  println(f"Secuencial: $t1%.4f s | Paralelo: $t2%.4f s | Aceleración: $speed%.2fx")
  println("-" * 50)
}
