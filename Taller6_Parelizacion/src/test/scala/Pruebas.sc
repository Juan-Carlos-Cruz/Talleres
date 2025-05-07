import Matrices._

val m1 = matrizAlAzar(16, 100)
val m2 = matrizAlAzar(16, 100)

// Multiplicaciones básicas
val r1 = multMatriz(m1, m2)
val r2 = multMatrizPar(m1, m2)

// Multiplicación con colecciones paralelas
val pm1 = transformToParD(m1)
val pm2 = transformToParD(m2)
val r3 = multMatrizParD(pm1, pm2)

// Multiplicación recursiva
val r4 = multMatrizRec(m1, m2)

// Multiplicación recursiva en paralelo
val r5 = multMatrizRecPar(m1, m2)

// Algoritmo de Strassen
val r6 = multStrassen(m1, m2)

// Algoritmo de Strassen en paralelo
val r7 = multStrassenPar(m1, m2)

// Impresión de resultados para verificación (opcional, puedes comentar si es muy grande)
println("Resultado multMatriz: " + r1)
println("Resultado multMatrizPar: " + r2)
println("Resultado multMatrizParD: " + r3)
println("Resultado multMatrizRec: " + r4)
println("Resultado multMatrizRecPar: " + r5)
println("Resultado multStrassen: " + r6)
println("Resultado multStrassenPar: " + r7)
