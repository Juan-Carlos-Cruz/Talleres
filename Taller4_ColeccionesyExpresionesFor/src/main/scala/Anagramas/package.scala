package object Anagramas {

  type Palabra = String
  type Frase = List[Palabra]
  type Occurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos")

  // usar groupBy, map, toList, sortBy
  def lOcPal(p: Palabra): Occurrencias = {
    p.toLowerCase
     .groupBy(c => c)
     .map { case (char, chars) => (char, chars.length) }
     .toList
     .sortBy(_._1)
  }

  // usar lOcPal, mkString
  def lOcFrase(frase: Frase): Occurrencias = {
    lOcPal(frase.mkString)
  }

  // usar groupBy, lOcPal
  lazy val diccionarioPorOcurrencias: Map[Occurrencias, List[Palabra]] = {
    diccionario.groupBy(lOcPal)
  }

  // usar diccionarioPorOcurrencias.get, lOcPal
  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    diccionarioPorOcurrencias.getOrElse(lOcPal(palabra), List())
  }

  // usar una expresión for para producir el resultado
  def combinaciones(ocurrencias: Occurrencias): List[Occurrencias] = {
    val agrupado = ocurrencias.map { case (char, count) =>
      (1 to count).map(n => (char, n)).toList
    }

    agrupado.foldRight(List(List.empty[(Char, Int)])) {
      case (listaChar, acc) =>
        acc ++ (for {
          combo <- acc
          elem <- listaChar
        } yield elem :: combo)
    }.map(_.sortBy(_._1))
  }

  // usar recursión en cola
  def complemento(lOc: Occurrencias, slOc: Occurrencias): Occurrencias = {
    val mapa = lOc.toMap.withDefaultValue(0)
    val submapa = slOc.toMap.withDefaultValue(0)
    (mapa.keySet ++ submapa.keySet).toList
      .map(k => (k, mapa(k) - submapa(k)))
      .filter(_._2 > 0)
      .sortBy(_._1)
  }

  // usar expresiones for y funciones auxiliares
  def anagramasDeFrase(frase: Frase): List[Frase] = {
    def aux(oc: Occurrencias): List[Frase] = {
      if (oc.isEmpty) List(Nil)
      else {
        for {
          combo <- combinaciones(oc)
          if diccionarioPorOcurrencias.contains(combo)
          palabra <- diccionarioPorOcurrencias(combo)
          resto <- aux(complemento(oc, combo))
        } yield palabra :: resto
      }
    }
    aux(lOcFrase(frase))
  }

}
