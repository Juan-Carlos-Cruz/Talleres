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
            // Movimiento del Trayecto Principal al trayecto Uno 
              case Uno(n) if n > 0 => 
                val (mover,resto) = principal.reverse.splitAt(n)
                if (principal.length < n) {
                (Nil, principal ++ uno , dos)
                }
                else 
                (resto.reverse , mover.reverse ++ uno, dos)

            // Movimiento del Trayecto Uno al trayecto Principal

              case Uno(n) if n < 0 =>
                val (mover, resto) = uno.splitAt(-n)
                if (uno.length < -n) {
                (principal ++ mover, Nil, dos)
                }
                else 
                (principal ++ mover, resto, dos)  

              // Movimiento del Trayecto Principal al trayecto Dos
              case Dos(n) if n > 0 => 
                val (mover,resto) = principal.reverse.splitAt(n)
                if (principal.length < n) {
                (Nil,  uno , principal ++ dos)
                }
                else 
                (resto.reverse, uno, mover.reverse ++ dos)

              // Movimiento del Trayecto Dos  al trayecto Principal 
              case Dos(n) if n < 0 =>
                val (mover, resto) = dos.splitAt(-n)
                if (uno.length < -n) {
                (principal ++ mover,uno, Nil)
                }
                else 
                (principal ++ mover, uno, resto)

              case _ =>  e 
              
        }
      }
    }

  def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = {
    val estadosInversos = movs.foldLeft(List(e)) { (estadosAcum, mov) =>
      val nuevoEstado = aplicarMovimiento(estadosAcum.head, mov)
      nuevoEstado :: estadosAcum
    }
    estadosInversos.reverse
  }

    // BFS funcional que no usa 'while' ni 'for':
  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {
    val inicio: Estado = (t1, Nil, Nil)
    val fin:    Estado = (t2, Nil, Nil)

    // Genera todos los (estadoSiguiente, movimiento) vecinos de un estado
    def vecinos(e: Estado): List[(Estado, Movimiento)] = {
      val (p, u, d) = e
      val maxN = math.max(p.length, math.max(u.length, d.length))
      // Sin 'for': utilizamos range y flatMap:
      val movs = (1 to maxN).toList.flatMap(n => List(Uno(n), Uno(-n), Dos(n), Dos(-n)))
      // Para cada movimiento, devolvemos (nuevoEstado, mov)
      movs.map(m => (aplicarMovimiento(e, m), m))
    }

    // BFS recursivo: 'queue' es la cola en forma de lista,
    // cada elemento es (estado, maniobraParaLlegar).
    // 'visitados' guarda los estados ya explorados.
    def bfs(queue: List[(Estado, Maniobra)], visitados: Set[Estado]): Option[Maniobra] = {
      queue match {
        case Nil => None
        case (estActual, path) :: resto =>
          if (estActual == fin) Some(path)
          else {
            // Obtenemos los vecinos y actualizamos la cola y visitados SIN for:
            val (restoActualizado, nuevosVisitados) =
              vecinos(estActual).foldLeft((resto, visitados)) {
                case ((q, v), (estSig, mov)) =>
                  if (!v.contains(estSig)) ((q :+ (estSig, path :+ mov)), v + estSig)
                  else (q, v)
              }
            bfs(restoActualizado, nuevosVisitados)
          }
      }
    }

    // Iniciamos con la cola conteniendo solamente el estado inicial, y sin movimientos.
    // Si no hay solución, devolvemos Nil.
    bfs(List((inicio, Nil)), Set(inicio)).getOrElse(Nil)
  }

  }

