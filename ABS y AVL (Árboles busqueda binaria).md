***
### Conceptos clave:
1. Estructura de datos
2. Diccionario/Conjunto
3. Complejidad/Eficiencia
4. 

### Repaso
* Planteamos un nuevo capítulo en la materia.
* Dejamos de lado el mundo de la especificación de problemas y nos concentramos en resolver problemas concretos.
* **Problema principal de la algoritmia:** buscar elementos con características particulares dentro de un conjunto de datos (grande o pequeño).

#### Diccionario (estructura de dato)
Recordamos la nueva estructura para el TAD diccionario.

*Insertar foto TAD diccionario*

* Recordamos que los diccionarios los utilizamos cuando queremos asociar un determinado valor K a un valor V (ej: K: manzana -> V: cantidad).
* Otros ejemplos: El diccionario del corrector ortográfico (a cada horror ortográfico nuestro se le asocia la palabra "correcta" que quisimos escribir para poder reemplazarla).
* El padron electoral, con clave el DNI, nombre, domicilio.
* Las claves de usuarios en una base de datos se encuentra en una estructura de tipo diccionario (de forma encriptada la password para prevenir ataques).

Podemos encontrar formas de representar la estructura de Diccionario o Conjuntos, se nos puede ocurrir de manera secuencial.

![[Pasted image 20231017135052.png]]

Podríamos representar la misma idea de diccionario a partir de un arreglo (seq\<Clave x Significado\>)

* A partir de esta estructura, podemos ver el orden de complejidad de realizar ciertas operaciones.

#### Opción 1: Seq \<Clave, Significado>, Ult (puntero)

**CrearDiccionario:** O(1) simplemente inicializamos un arreglo vacío y un puntero vacío.

**Definir:** O(1) movemos el puntero una posición para adelante de donde está "guardado" e insertamos el elemento en la posición anterior a donde apunta el puntero.

**Pertenece:** O(n) tendríamos que hacer una busqueda secuencial por todo el arreglo (n en el peor de los casos) a ver si el elemento está en el arreglo.

**ObtenerElemento:** O(n) al igual que pertenece, como peor caso el elemento que queremos obtener puede estar al final del arreglo que planteamos.


* Podríamos pensar también una alternativa a nuestro diccionario **ORDENANDOLO**. Simplificaría la complejidad de buscar/obtener elementos en la secuencia.


#### Opción 2: Seq \<Clave, Significado>, Ult (puntero) -> Ordenado

**CrearDiccionario:** O(1) simplemente inicializamos un arreglo vacío y un puntero vacío.

**Definir:** O(1) movemos el puntero una posición para adelante de donde está "guardado" e insertamos el elemento en la posición anterior a donde apunta el puntero.
**Pertenece:** O(log n) tendríamos que hacer una busqueda binaria en el arreglo.

**Pertenece:** O(log n) tendríamos que hacer una busqueda secuencial por todo el arreglo (n en el peor de los casos) a ver si el elemento está en el arreglo.

**ObtenerElemento:** O(log n) al igual que pertenece, realizamos busqueda binaria para verificar si está el elemento.

* Tendríamos el problema que cada vez que insertamos un elemento, tenemos que ordenar nuevamente todo el diccionario (es costoso) para que las busquedas se mantengan en tiempo logaritmico.

+ *¿Cuál es mejor?* depende del problema.
	-> **Prioridad es buscar**: Opción 2
	-> **Prioridad es manipular la estructura** (insertar, agregar): Opción 1

****

#### Árboles (estructura de dato)

*¿Podríamos encontrar una estructura para los Diccionarios y Conjuntos con una complejidad menor a lineal O(n) para las operaciones de búsqueda?*

-> Vimos que un arreglo ordenado la búsqueda y obtener era log(n).

* Entremos a ver la idea de **Árbol Binario**.

>[!Arbol binario]
>Un árbol binario es una estructura de datos de tipo árbol la cual, en ningún caso puede ocurrir que un nodo tenga más de dos subarboles. (no pueden salir más de 2 circulitos de cada nodo).

**Ejemplo visual**
![[Pasted image 20231017142006.png]]


* Queremos ver que ventajas tiene utilizar esta estructura de datos para representar la idea de diccionario.
* Veamos las operaciones y su complejidad para el árbol.

#### Árbol desordenado

**CrearArbol:** O(1) simplemente inicializamos un arreglo vacío

**Definir:** Dependiendo de como planteamos nuestros arbol el costo de definir. Si queremos un árbol completo (cubro siempre todos los niveles) => O(n) si no tengo puntero al hueco vacío.

**Pertenece:** O(n) tendríamos que hacer una busqueda secuencial por todo el árbol

**ObtenerElemento:** O(n) al igual que pertenece, como peor caso el elemento que queremos obtener puede estar al final del árbol.



*¿Para qué planteamos esta estructura si no es más eficiente que lo planteado antes*
-> Esto da paso a la siguiente estructura


#### Árbol Binario de Busqueda (ABB - Binary Search Tree/BST)

** Insertar diapositiva de ¿Qué es un arbol binario de busqueda?


