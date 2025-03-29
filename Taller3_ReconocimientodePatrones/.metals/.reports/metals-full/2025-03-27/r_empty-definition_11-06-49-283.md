error id: `<none>`.
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller3/Taller3_ReconocimientodePatrones/src/main/scala/ManiobrasTrenes/package.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package object ManiobraTrenes {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  trait Movimiento
  case class Uno(n: Int) extends Movimiento
  case class Dos(n: Int) extends Movimiento

  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = {
    e match {
         case  (principal,uno,dos) => m match {
            case Uno(n) if n > 0 => 
              val (mover,resto) = principal.splitAt(n)
              (resto,mover.reverse ++ uno, dos)
      }
    }
  }

//   def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = {
    
//   }

//   def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
//     // Dados dos trenes t1 (el original) y t2 (el deseado), devuelve la maniobra que se necesita hacer
//     // para pasar una estación de maniobras del estado (t1, List(), List()) al estado (t2, List(), List())
    
//   }
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.