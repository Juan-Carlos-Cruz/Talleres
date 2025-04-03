error id: scala/package.List.
file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller4/Taller4_ColeccionesyExpresionesFor/src/main/scala/Anagramas/package.scala
empty definition using pc, found symbol in pc: scala/package.List.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -locurrencias.
	 -locurrencias#
	 -locurrencias().
	 -scala/Predef.locurrencias.
	 -scala/Predef.locurrencias#
	 -scala/Predef.locurrencias().
offset: 663
uri: file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller4/Taller4_ColeccionesyExpresionesFor/src/main/scala/Anagramas/package.scala
text:
```scala
package object Anagramas {

type Palabra = String
type Frase = List [Palabra]
type Ocurrencias = List [(Char,Int)]

val diccionario: List[Palabra] =  List( " cosas " , "como" , "yo", "y" , "ocasos" , "cayo" , "mocosos" , "roca" , "moco", "sos"" )


def lOcPal( p : Palabra): Ocurrencias = {
    //Usar groupBy, map,.......
}
def lOcFrase (f:Frase): Ocurrencias = {
    //Usar locPal, mkString
}
def diccionarioPorOcurrencias: Map[Ocurrencias,List[Palabra]] = {
    // usa r groupBy , lOcPa l , . . .
}
def anagramasDePalabra(palabra:Palabra): List[Palabra]={
    // usar diccionarioPorOcurrencias.get , lOcPa l

}
    
def combinaciones(loc@@urrencias: Ocurrencias):List[Ocurrencias]={
   // Usar una expresion for para producir el resultado
}
def complemento (lOc:Ocurrencias,slOc:Ocurrencias):Ocurrencias = {
    //Usar recursion en cola
}
def anagramasDeFrase(sentence:Frase):List[Frase] ={
    //Usar expresiones for  y funciones auxiliares
}



}
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/package.List.