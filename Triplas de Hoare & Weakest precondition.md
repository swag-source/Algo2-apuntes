***
## Correctitud de un programa

>[!Definición]
> Decimos que un programa *S* es *correcto respecto de una especificación* dada por una una precondición *P* y una postcondición *Q*, si siempre que un programa comienza en un estado que cumple la precondición *P*, el programa **termina su ejecución**, y en su estado final satisface Q.

Utilizamos la notación siguiente para demostrar que un programa es correcto respecto de su especificación:

**Notación**: Cuando *S* es correcto respecto de la especificación (*P, Q*), lo denotamos con la siguiente **Tripla de Hoare**:

$$\{P\} \ S \ \{Q\}.$$

El objetivo de utilizar la tripla de Hoare para demostrar la correctitud de un programa a partir de la misma es obtener una formula lógica que denotamos con la letra $\alpha$ tal que 

$$\alpha \ \text{es valida} \ \iff \{P\} \ S \ \{Q\}.$$

## Weakest precondition
Al momento de buscar un mecanismo para demostrar "automáticamente" la correctitud de un programa respecto a la especificación, nos interesa buscar de todo el universo de precondiciones posibles *P* para mi programa *S* que satisfaga *Q*, la precondición que menores restricciones imponga a nuestro programa sin perder valores posibles que satisfagan *Q*.

![[Pasted image 20240220122034.png]]

**Notación:** notamos $wp(\textbf{S}, Q)$ a la precondición más debil del programa *S* que satisface la postcondición *Q* de nuestro programa.

Si nosotros podemos probar que la precondición $P$  se encuentra "contenida" dentro de la $wp(\textbf{S}, Q)$, entonces la Tripla de Hoare $\{P\} \ S \ \{Q\}$ es válida.

$$P \Longrightarrow_{L} wp(\textbf{S}, Q)$$

Entonces necesitamos un mecanismo para obtener la Weakest Precondition para mi programa *S* a partir de la postcondición *Q*.

* Vemos que la precondición más debil se *deriva* a partir de la postcondición que le pedimos a nuestro programa.
* Puede ocurrir al revés, pero suele ser más dificil.

![[Pasted image 20240220141617.png]]
![[Pasted image 20240220141759.png]]

