file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller4/Taller4_ColeccionesyExpresionesFor/src/main/scala/Anagramas/package.scala
### scala.MatchError: TypeDef(Ocurrencias,AppliedTypeTree(Ident(List),List(Tuple(List(Ident(Char), Ident(Int)))))) (of class dotty.tools.dotc.ast.Trees$TypeDef)

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 344
uri: file:///C:/Users/Usuario/OneDrive/Escritorio/Universidad/4%20Semestre/FDP%20funcional%20y%20concurrente/Taller4/Taller4_ColeccionesyExpresionesFor/src/main/scala/Anagramas/package.scala
text:
```scala
package object Anagramas {

type Palabra = String
type Frase = List [Palabra]
type Ocurrencias = List [(Char,Int)]

val diccionario: List[Palabra] 

def lOcPal( p : Palabra): Ocurrencias = {
    //Usar groupBy, map,.......
}
def lOcFrase (f:Frase): Ocurrencias = {
    //Usar locPal, mkString
}
def diccionarioPorOcurrencias: map¿@@
def anagramasDePalabra
def combinaciones
def complemneto
def anagramasDeFrase



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

scala.MatchError: TypeDef(Ocurrencias,AppliedTypeTree(Ident(List),List(Tuple(List(Ident(Char), Ident(Int)))))) (of class dotty.tools.dotc.ast.Trees$TypeDef)