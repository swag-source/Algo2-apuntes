***
### Conceptos clave
* Diccionario
* Criptografía
* Colisiones
* Direccionamiento por concatenación
* Direccionamiento abierto

***

* *Motivación por ejemplo:* tenemos un conjunto de clientes y queremos poder almacenarlos y acceder a ellos rápidamente!
	-> Podríamos guardarlo en un arreglo con todas las posibles claves tal que 
	$0 \leq claves \leq$ \#\DNIposibles.
* Vemos que así acceder mi *complejidad $\mathcal{O}$(1).* (Buenisimo).
* Estamos desperdiciando MUCHISIMO espacio vacío (Malisimo).

*Planteamos dos problemas fundamentales*
	-> Solo sirve para claves que son enteros no negativos.
	-> Mucho desperdicio de memoria!

![[Pasted image 20231112150041.png]]
### Hashing perfecto y colisiones
***
* Idealmente para todo conjunto K, queremos poder mapear una posición del arreglo H tal que si k1 != k2 => H(k1) != H(k2), es decir, evitar colisiones. (es decir, una función inyectiva)
* También que H(k1) != H(k2) => k1 != k2
* Encontrar esta función *perfecta* rara vez es posible, solo casos muy especiales y poco pragmáticos.

![[Pasted image 20231112151933.png]]

*Idealmente así debería verse una función de hashing perfecta*.

**Habitualmente nos enfrentamos con que**
* k1 != k2 => H(k1) = H(k2) -> colisión en la función de hash.
* Paradoja del cumpleaños

-> De alguna forma queremos encontrar algún método que se encargue de la *resolución de colisiones*
### Resolución de colisiones
* Como quisieramos idealmente tener una función que sea inyectiva => K <= $|n|$ (pero no podemos), necesitamos poder manejar esas "colisiones".

*Ejemplo colisión*: ejemplo con mi hash H(k) = k mod 5.

![[Pasted image 20231112170511.png]]

* tenemos alternativas para manejar este tipo de colisiones: *Direccionamiento por concatenación* y *Direccionamiento abierto*.
* Idealmente nosotros buscamos construir una función de hashing cuya distribución de datos sea lo más uniforme posible. Esto implica que a mayor uniformidadm menor es la probabilidad de colisión => $\frac{1}{n}$ ya que tenderia a ser "equiprobable". 

### Direccionamiento por concatenación 
***
*Idea principal:* creamos un array de {0, 1, ..., N-1} elementos tal que cada posición contenga una lista enlazada con los elementos colisionados.

![[Pasted image 20231112172731.png]]

Suponemos que tenemos mi función H(k) = k mod 5

* K => {k1 = 0, k2 = 4, k4 = 10, k5 = 9, k7 = 14} 
=> H(k) = {H(k1) = H(k4) = 0, H(k5) = H(k7) = H(k2) = 4}

Por lo que vemos, una función de hash a partir de aritmética modular no siempre es la mejor idea!

![[Pasted image 20231112173524.png]]

* La última linea nos indíca que *en promedio* cuando la cantidad de elementos tiende a la dimensión de la tabla de hash, entonces la complejidad -> $\mathcal{O}$(1).
### Direccionamiento abierto
***
* A diferencia del direccionamiento por concatenación, los valores los almacenamos en la posición de la tabla de hash y utilizamos un mecanismo diferente para salvar colisiones.
* Hay que considerar que la función de Hash tenemos que agregarle un parametro más i tal que: $H(k,i)$ donde $i$ es la $i$-esima iteración guardada.

Es decir:
$$h: U \times \{0,1,.....,n-1\} \longrightarrow \{0,1,.....,n-1\}$$

-> Si $H(K_{1})=H(K_{2})=i$ entonces al elemento que más *"tarde"* llegó lo movemos a la posición siguiente (si está disponible).
 

***Algoritmos de inserción y borrado***

![[Pasted image 20231113105524.png]]

![[Pasted image 20231113105544.png]]


***aclaración**:* si observamos el algoritmo de insertar, en el caso de que eliminaramos el primer elemento $h(k_{0}$) de una lista de colisiones y luego quisieramos insertar no podríamos, entonces no tendríamos forma de acceder a los siguientes elementos $h(k_{i+1}$) por como tenemos planteado nuestro algoritmo.

### Funciones de hashing
***
Además de ser una estructura de datos *súper* conveniente para almacenar valores a partir de pares (clave, valor) por su rapidez de cómputo, también es una excelente estructura para guardar información de manera segura.
* Si queremos tener un registro bancario con los usuarios y números de tarjeta de crédito, podríamos construir una tabla de hash donde cada usuario esté hasheado.

Para asegurarnos que ninguna persona pueda "*descifrar*" ese texto escondido, tenemos que construir una buena función de hashing. Para eso pedimos que la función que creemos cumpla ciertos requisitos.

-> *uniformidad de claves*: para cualquier valor del dominio $K$ haya igual probabilidad de caer en $H$ al aplicar $h(k) = q$ sea $\frac{1}{n}$ con $H \in \{0, 1, ..., n-1\}$ 

->*universalidad de claves*: para cualesquiera valores $k_{1}$ y $k_{2}$ $\in K$, la probabilidad de que $h(k_{1}) = h(k_{2})$ sea como mucho $\frac{1}{n}$.  

