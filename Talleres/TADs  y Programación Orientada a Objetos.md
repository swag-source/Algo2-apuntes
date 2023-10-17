***
### Conceptos clave
* Objeto
* Clase
* Instancia/s
* Atributos
* Métodos
* Constructor

### Clases
* La idea de definir clases es *agarrar* un problema y simplificarlo en bloques más *abstractos.*
+ Definimos una clase de la siguiente forma:
	1. Definimos métodos públicos de la clase (cosas que podrá hacer la clase)
	2. Atributos privados de la clase
	3. Implementar métodos (escribir el código)
	4. Crear un constructor de la clase (lo que me arma la clase desde 0)


 *Ejemplo de TAD a Clase:*
 ![[Pasted image 20230922170958.png]]

* Podemos agarrar este ejemplo de TAD y llevarlo a una representación en forma de clase dentro de un lenguaje de programación (en nuestro caso, Java).

Para poder utilizar esta clase y sus funciones, es necesario implementarla.
La **implementación** está dada por:
-> **Representación** interna: se encarga de llevar cuenta de los cambios de estado de la instancia.
-> **Interfaz**: es un conjunto de funciones que están asociadas a la clase que estamos definiendo. Cuando se instancia un objeto del tipo, tenemos acceso a todas sus funciones internas.

![[Pasted image 20230922172627.png]]

* Acá estamos definiendo los métodos y sus tipos para mi clase Truco. Vemos cómo implementamos uno de los métodos. 

![[Pasted image 20230922172911.png]]

### Constructores
+ Los constructores son métodos dentro de mi clase que me permite inicializar desde cero una instancia nueva. 
+ No tienen tipo de retorno, simplemente es un procedimiento. *Procedimiento: función que no devuelve nada, modifica únicamente el estado del programa*

