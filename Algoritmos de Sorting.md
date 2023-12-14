***
### Conceptos clave
* Selection Sort
* Insertion Sort
* Quick Sort
* Heap Sort
* Merge Sort
* Radix Sort
***
Un problema muy típico en la computación es el ordenamiento de información.
* De alguna forma buscamos tomar un arreglo $a$ y buscar que se cumpla que:

ordenar($S$): $$S:array[\alpha] \longrightarrow array[\alpha] \space \space / \space \space a[i] < a[i+1]$$
esta relación nos interesa que sea de orden (reflexiva, simétrica y transitiva).

Bajo el arreglo de orden, sabemos que nuestro algoritmo para buscar un elemento dentro de un arreglo ordenado es la *búsqueda binaria* -> $\mathcal{O}$($log(n)$).

### Selection Sort
***
Una forma de ordenar un arreglo será, agarro de mi array el *mínimo* elemento y el último de la lista; al mínimo elemento lo inserto en una nueva lista. Nuevamente repito este ciclo hasta que el arreglo nuevo esté ordenado.

![[Pasted image 20231114174711.png]]

Podemos pensarlo desde el lado recursivo este siguiente algoritmo de la siguiente manera:
* Selecciono el mínimo elemento del arreglo.
* Lo inserto en una lista nueva (eliminándolo de la secuencia original).
* Aplico la recursión en el tail de la secuencia. -> selectionSort($tail(\text{a} \space : \text{array})$).

Respecto al tiempo de ejecución del siguiente algoritmo, si suponemos:
* Arreglo con n enteros.
* (n-1) ejecuciones del ciclo principal.
* En la i-ésima iteración hay que encontrar el mínimo de entre n-i elementos y por lo tanto necesitamos n-i-1 comparaciones.

$$\text{Costo} \space = \sum_{i=0}^{n-2}(n-i-1) = \sum_{i=1}^{n-1}\frac{n(n-1)}{2}$$
Con *Selection Sort* tenemos el inconveniente de que todos los tiempos de ejecución, sin importar la "forma" del input, será de orden cuadrático $\longrightarrow$ $\mathcal{O}(n^{2})$.
* Peor caso: $\mathcal{O}(n^{2})$
* Mejor caso: $\mathcal{O}(n^{2})$
* Amortizado: $\mathcal{O}(n^{2})$ 


### Insertion Sort
***




### Estabilidad de un algoritmo
***
Decimos que un algoritmo es *estable* si mantiene el orden anterior de elementos con igual clave.




