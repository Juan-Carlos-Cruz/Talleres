

final class Pruebas$_ {
def args = Pruebas_sc.args$
def scriptPath = """c:\Users\Usuario\OneDrive\Escritorio\Universidad\4 Semestre\FDP funcional y concurrente\Taller1\ejemplo1\src\test\Pruebas.sc"""
/*<script>*/
import Multiplicacion.*

PeasantAlgorithm(0,0)
PeasantAlgorithm(0,1)
PeasantAlgorithm(5,2)
PeasantAlgorithm(47,89)
PeasantAlgorithm(267,450)
PeasantAlgorithm(2145,3233)
PeasantAlgorithm(9999,9999)

PeasantAlgorithmIt(0,0)
PeasantAlgorithmIt(0,1)
PeasantAlgorithmIt(5,2)
PeasantAlgorithmIt(47,89)
PeasantAlgorithmIt(267,450)
PeasantAlgorithmIt(2145,3233)
PeasantAlgorithmIt(9999,9999)

splitMultiply(0,0)
splitMultiply(0,1)
splitMultiply(4,5)
splitMultiply(47,89)
splitMultiply(267,450)
splitMultiply(2145,3233)
splitMultiply(9999,9999)

fastAlgorithm(0,0)
fastAlgorithm(0,1)
fastAlgorithm(4,5)
fastAlgorithm(47,89)
fastAlgorithm(267,450)
fastAlgorithm(2145,3233)
fastAlgorithm(9999,9999) 





/*</script>*/ /*<generated>*//*</generated>*/
}

object Pruebas_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new Pruebas$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export Pruebas_sc.script as `Pruebas`

