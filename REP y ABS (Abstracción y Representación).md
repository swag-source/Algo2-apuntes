****
### Conceptos clave
1. *Cómo hacemos* no *qué hacemos*


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
* Podemos pensar que el invariante de representación representa la Pre y Post condición de cada instrucción.
*  
### Función de abstracción

*¿Podemos demostrar que una TAD es correcto respecto a su especificación?*

-> **Estariamos buscando**: para toda operación (O) y instancia (*X*) del TAD, se tiene que cumplir el invariante de representación.

![[Pasted image 20231019135000.png]]


