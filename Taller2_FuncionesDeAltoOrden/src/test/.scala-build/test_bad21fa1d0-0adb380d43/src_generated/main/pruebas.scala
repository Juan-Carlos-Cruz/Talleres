

final class pruebas$_ {
def args = pruebas_sc.args$
def scriptPath = """c:\Users\Usuario\OneDrive\Escritorio\Universidad\4 Semestre\FDP funcional y concurrente\Taller-2\src\test\pruebas.sc"""
/*<script>*/
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

/*</script>*/ /*<generated>*//*</generated>*/
}

object pruebas_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new pruebas$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export pruebas_sc.script as `pruebas`

