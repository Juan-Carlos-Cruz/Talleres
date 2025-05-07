file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller6/src/main/scala/Matrices/package.scala
### scala.MatchError: TypeDef(Matriz,AppliedTypeTree(Ident(Vector),List(AppliedTypeTree(Ident(Vector),List(Ident(Int)))))) (of class dotty.tools.dotc.ast.Trees$TypeDef)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 2874
uri: file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller6/src/main/scala/Matrices/package.scala
text:
```scala
import common._
import Benchmark._
import scala.util.Random
import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.immutable.ParVector

package object Matrices {

   val random = new Random()

  type Matriz = Vector[Vector[Int]]

  def matrizAlAzar(long: Int, vals: Int): Matriz =
    Vector.fill(long, long)(random.nextInt(vals))

  def vectorAlAzar(long: Int, vals: Int): Vector[Int] =
    Vector.fill(long)(random.nextInt(vals))

  def transformToParD(m: Matriz): Vector[ParVector[Int]] =
    m.map(_.par).toVector

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int =
    (v1 zip v2).map { case (i, j) => i * j }.sum

  def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int =
    (v1 zip v2).map { case (i, j) => i * j }.sum

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }
// Ejercicio 1.1.1
  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val m2T = transpuesta(m2)
    Vector.tabulate(m1.length, m2T.length)((i, j) => prodPunto(m1(i), m2T(j)))
  }
//  Ejercicio 1.1.1

  def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val m2T = transpuesta(m2)
    Vector.tabulate(m1.length, m2T.length)((i, j) => task { prodPunto(m1(i), m2T(j)) }.join())
  }
//  Ejercicio 1.1.2

  def multMatrizParD(m1: Vector[ParVector[Int]], m2: Vector[ParVector[Int]]): Matriz = {
    val m2T = m2.map(_.seq).transpose.map(_.toVector.par)
    Vector.tabulate(m1.length, m2T.length)((i, j) =>
      (m1(i) zip m2T(j)).map { case (a, b) => a * b }.sum
    )
  }

  //  Ejercicio 1.2.1

  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz =
    Vector.tabulate(l, l)((x, y) => m(i + x)(j + y))

  //  Ejercicio 1.2.2

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz =
    Vector.tabulate(m1.length, m1.length)((i, j) => m1(i)(j) + m2(i)(j))

  //  Ejercicio 1.2.3

  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
    else {
      val l = n / 2
      val A11 = subMatriz(m1, 0, 0, l)
      val A12 = subMatriz(m1, 0, l, l)
      val A21 = subMatriz(m1, l, 0, l)
      val A22 = subMatriz(m1, l, l, l)
      val B11 = subMatriz(m2, 0, 0, l)
      val B12 = subMatriz(m2, 0, l, l)
      val B21 = subMatriz(m2, l, 0, l)
      val B22 = subMatriz(m2, l, l, l)

      val C11 = sumMatriz(multMatrizRec(A11, B11), multMatrizRec(A12, B21))
      val C12 = sumMatriz(multMatrizRec(A11, B12), multMatrizRec(A12, B22))
      val C21 = sumMatriz(multMatrizRec(A21, B11), multMatrizRec(A22, B21))
      val C22 = sumMatriz(multMatrizRec(A21, B12), multMatrizRec(A22, B22))

      C11.zip(C12).map { case (r1, r2) => r1 ++ r2 } ++ C21.zip(C22).map { case (r1, r2) => r1 ++ r2 }
    }
  }
  //  Ejercicio 1.2.@@
  def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n <= 64) multMatrizRec(m1, m2)
    else {
      val l = n / 2
      val A11 = subMatriz(m1, 0, 0, l)
      val A12 = subMatriz(m1, 0, l, l)
      val A21 = subMatriz(m1, l, 0, l)
      val A22 = subMatriz(m1, l, l, l)
      val B11 = subMatriz(m2, 0, 0, l)
      val B12 = subMatriz(m2, 0, l, l)
      val B21 = subMatriz(m2, l, 0, l)
      val B22 = subMatriz(m2, l, l, l)

      val (c11, c12, c21, c22) = parallel(
        sumMatriz(multMatrizRecPar(A11, B11), multMatrizRecPar(A12, B21)),
        sumMatriz(multMatrizRecPar(A11, B12), multMatrizRecPar(A12, B22)),
        sumMatriz(multMatrizRecPar(A21, B11), multMatrizRecPar(A22, B21)),
        sumMatriz(multMatrizRecPar(A21, B12), multMatrizRecPar(A22, B22))
      )

      c11.zip(c12).map { case (r1, r2) => r1 ++ r2 } ++ c21.zip(c22).map { case (r1, r2) => r1 ++ r2 }
    }
  }

  //  Ejercicio 1.3.1
    def restaMatriz(m1: Matriz, m2: Matriz): Matriz =
    Vector.tabulate(m1.length, m1.length)((i, j) => m1(i)(j) - m2(i)(j))
  //  Ejercicio 1.32
  def multStrassen(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
    else {
      val l = n / 2
      val A11 = subMatriz(m1, 0, 0, l)
      val A12 = subMatriz(m1, 0, l, l)
      val A21 = subMatriz(m1, l, 0, l)
      val A22 = subMatriz(m1, l, l, l)
      val B11 = subMatriz(m2, 0, 0, l)
      val B12 = subMatriz(m2, 0, l, l)
      val B21 = subMatriz(m2, l, 0, l)
      val B22 = subMatriz(m2, l, l, l)

      val m1_ = multStrassen(sumMatriz(A11, A22), sumMatriz(B11, B22))
      val m2_ = multStrassen(sumMatriz(A21, A22), B11)
      val m3_ = multStrassen(A11, restaMatriz(B12, B22))
      val m4_ = multStrassen(A22, restaMatriz(B21, B11))
      val m5_ = multStrassen(sumMatriz(A11, A12), B22)
      val m6_ = multStrassen(restaMatriz(A21, A11), sumMatriz(B11, B12))
      val m7_ = multStrassen(restaMatriz(A12, A22), sumMatriz(B21, B22))

      val C11 = sumMatriz(restaMatriz(sumMatriz(m1_, m4_), m5_), m7_)
      val C12 = sumMatriz(m3_, m5_)
      val C21 = sumMatriz(m2_, m4_)
      val C22 = sumMatriz(restaMatriz(sumMatriz(m1_, m3_), m2_), m6_)

      C11.zip(C12).map { case (r1, r2) => r1 ++ r2 } ++ C21.zip(C22).map { case (r1, r2) => r1 ++ r2 }
    }
  }

  def multStrassenPar(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n <= 64) multStrassen(m1, m2)
    else {
      val l = n / 2
      val A11 = subMatriz(m1, 0, 0, l)
      val A12 = subMatriz(m1, 0, l, l)
      val A21 = subMatriz(m1, l, 0, l)
      val A22 = subMatriz(m1, l, l, l)
      val B11 = subMatriz(m2, 0, 0, l)
      val B12 = subMatriz(m2, 0, l, l)
      val B21 = subMatriz(m2, l, 0, l)
      val B22 = subMatriz(m2, l, l, l)

      val (m1_, m2_, m3_, m4_) = parallel(
        multStrassenPar(sumMatriz(A11, A22), sumMatriz(B11, B22)),
        multStrassenPar(sumMatriz(A21, A22), B11),
        multStrassenPar(A11, restaMatriz(B12, B22)),
        multStrassenPar(A22, restaMatriz(B21, B11))
      )

      val t5 = task { multStrassenPar(sumMatriz(A11, A12), B22) }
      val t6 = task { multStrassenPar(restaMatriz(A21, A11), sumMatriz(B11, B12)) }
      val t7 = task { multStrassenPar(restaMatriz(A12, A22), sumMatriz(B21, B22)) }

      val m5_ = t5.join()
      val m6_ = t6.join()
      val m7_ = t7.join()

      val C11 = sumMatriz(restaMatriz(sumMatriz(m1_, m4_), m5_), m7_)
      val C12 = sumMatriz(m3_, m5_)
      val C21 = sumMatriz(m2_, m4_)
      val C22 = sumMatriz(restaMatriz(sumMatriz(m1_, m3_), m2_), m6_)

      C11.zip(C12).map { case (r1, r2) => r1 ++ r2 } ++ C21.zip(C22).map { case (r1, r2) => r1 ++ r2 }
    }
  }
}

```



#### Error stacktrace:

```
dotty.tools.pc.completions.KeywordsCompletions$.checkTemplateForNewParents$$anonfun$2(KeywordsCompletions.scala:218)
	scala.Option.map(Option.scala:242)
	dotty.tools.pc.completions.KeywordsCompletions$.checkTemplateForNewParents(KeywordsCompletions.scala:215)
	dotty.tools.pc.completions.KeywordsCompletions$.contribute(KeywordsCompletions.scala:44)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:126)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:135)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:150)
```
#### Short summary: 

scala.MatchError: TypeDef(Matriz,AppliedTypeTree(Ident(Vector),List(AppliedTypeTree(Ident(Vector),List(Ident(Int)))))) (of class dotty.tools.dotc.ast.Trees$TypeDef)