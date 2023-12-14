****
### Conceptos clave
1. *Cómo hacemos* no *qué hacemos*
2. Abstracción
3. Encapsular
4. Interfaz


* Cuando planteamos un TAD, buscamos representar una cierta estructura de datos a partir de las operaciones que la misma puede hacer.
* Partimos de un modelo teórico sobre qué debe hacer la estructura (especificación) y planteamos una forma de implementar ese TAD (diseño). Toda estructura tiene un conjunto de operaciones contenidas en sí.
* Estas operaciones se encuentran dentro de la ***interfaz***.

#### Interfaz
-> La interfaz de un módulo es una capa "intermedia" entre las estructuras y los algoritmos que implementan el TAD y el usuario que las utiliza.

* Estos modulos con una determinada interfaz tienen:
	* Signatura (tipos de los parametros de *in/out*.)
	* *Pre* y *Post* de las operaciones.
	* Complejidad (espacial, temporal).

### Invariante de representación
-> Todo diseño de TAD debe representar una *estructura de representación*, es decir, debe respetar las "consignas" de la estructura abstracta que estamos buscando implementar.

-> No solo representamos la estructura, sino el valor (output) de las operaciones sobre dicha estructura.

* El invariante de representación es un predicado que nos devuelve *True* <=> el conjunto de valores pasados representan instancias válidas de la implementación.
* **El dominio sería el genero de representación de nuestro TAD y la imagen un booleano**.
* *Informalmente*: 
* invRep(i: InstanciaDelTAD) = True <=> i $\in$ Genero de representación.

### Función de abstracción
*¿Podemos demostrar que una TAD es correcto respecto a su especificación?*

-> Nos interesaría probar "la vuelta" de el invariante de representación. Es decir, dada alguna estructura, queremos formar una función que me vincule a alguna instancia en particular de nuestro TAD.

* funcAbs(estructuraDeRepresentación) -> valorAbstracto.

-> Es decir, agarra una estructura que utilizamos para representar un valor abstracto y me devuelve esa estructura abstracta en cuestión.

![[Pasted image 20231019135000.png]]


