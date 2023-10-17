***
## Apuntes clase

+ Repasamos conceptos sobre GIT basados en el taller ComCom.
+ GIT plantea la idea de Sistemas de Control De Versiones.

### Sistema de control de versiones
Programas que permiten manejar los cambios de los archivos en un proyecto a lo largo del tiempo, a través de un seguimiento de sus modificaciones.

Permite principalmente tres cosas:
* **Volver a una versión anterior.
* **Comparar distintas etapas del proyecto.
* **Compartir el código con otras personas y resolver conflictos.

### GIT
Sistema de control de versiones distribuido y de **código abierto**, con énfasis en el **rendimiento, seguridad y flexibilidad.**

-> **Ej:** GitHub, BitBucket, GitLab.

* GIT funciona pensando en los datos dentro del repositorio como "snapshots".
* Con cada commit, o cada vez que se guarda el estado del repo, saca una foto al mismo y guarda una referencia en ella.
* Si los archivos no cambia, no saca ninguna foto: solo se toma la última.

#### Comandos desde la terminal

>[!Git add]
>Una vez hechos los cambios, nosotros le pedimos a GIT que agregue los cambios al estado del repositorio.

>[!Git commit]
>Habiendo hecho stage de los cambios, queremos generar una versión nueva. En este momento los cambios no están reflejados en el repositorio remoto. Siempre dejamos un mensaje de commit.

>[!Git status]
>Pedimos el estado de los cambios, si algún archivo se encuentra en alguno de estos 4 estados: **Untracked, modified, staged, commited.**

>[!Git push]
>Cuando tenemos confirmado el commit, utilizamos push para subir los archivos al repositorio y reflejar los cambios.

>[!Git pull]
>Sirve para traer una actualización entera de un repositorio.


Pueden haber situaciones en las que generamos **conflictos**.

-> Persona A y B están editando el mismo archivo de texto y los dos modifican el mismo contenido. Se genera un conflicto en el archivo que GIT tiene que resolver (o puede no resolver).

-> Puedo decidir cómo tiene que quedar el archivo final.
-> Hago add.
-> Después del commit se deja un mensaje tipo 'Merge'.


### Branches (ramas)

Representa una linea independiente de desarrollo.
Al crear nuevas ramas/branches, podemos pensar que nuestro proyecto **diverge** en dos lineas distintas: los cambios que hagamos en una no impactan a la otra.

Nos interesaría crear nuevas ramas:

>[!Git branch]
>Para crear una rama nueva, ejecutamos git branch [nombre de la rama] 

Si se trata de una rama remota, debemos crearla localmente y luego obtenerla.

### Inspeccionando los cambios

>[!Git diff]
>Muestra las diferencias entre el estado actual de los archivos y la última vez que realizamos cambio sobre los archivos/repositorio

>[!Git log]
>Muestra el historial de *_commits_* para saber cuáles son las modificaciones que se hicieron (siempre y cuando hayamos elegido mensajes descirptivos)

