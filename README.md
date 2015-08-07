## Taller de Lenguajes 2




### Workflow
El proyecto se va a manejar usando [Trello](https://trello.com/b/fmporp48/taller-2), todas las tareas a asignar y cualquier comunicacion(ya sean problemas, necesidad de ayuda o lo que sea) se va a manejar ahi.
El mantenimiento del codigo del proyecto se va a manejar aca.

* #### Trello
	Inicialmente van a ver 7 listas(a medida que el proyecto avanza puede llegar a ser necesario agregar nuevas listas). Las tarjetas que se creen se deben poner en la lista correspondiente.
	* **TAREAS**: En esta lista van todas las tareas obligatorias que hay que implementar(recomendable usar `labels` para indicar estado, por ejemplo si es urgente, y tambien hay que asignar a la persona correspondiente).
	* **EN PROCESO**: Cuando se ponen a hacer una de las tareas de la lista `TAREAS`, la mueven a esta lista para que todos sepamos que estan trabajando en eso.
	* **TERMINADO**: Cuando terminan una de las tarjetas de `EN PROCESO`, la mueven a esta lista, y luego se fijan que es lo proximo(urgente) que hay que hacer.
	* **BUGS**: Cualquier problema que encuentren lo publican aca, por mas de que sea dependiente de la plataforma que usan. La idea de poner cualquier problema que encuentren es para que no andemos preguntado: Che a vos te paso esto??, si apenas nos pasa lo agregamos a esta lista ya vamos a saber quien anda teniendo problemas con algo.(**ACLARACION**: problemas con algo no quiere decir a cuando les cueste programar alguna tarea, sino que quiere decir a errores o cosas con las que nos vayamos encontrando)
	* **ARREGLADO**: Cuando una de las tarjetas que estaban en `BUGS` se soluciona, se la mueve a esta lista.
	* **REFACTORIZAR**: En caso de estar apurado a terminar una tarea de la lista `TAREAS` y no tener tiempo para revisar el codigo, agregan una tarjeta diferente a esta lista en la que diga que se necesita mejorar y/o refactorizar el codigo correspondiente(indicar archivo en lo posible).
	* **SUGERENCIAS**: Cualquier idea(que no sea urgente) que quieran agregar y que piensen que esta piola, va a esta lista.

	##### Prioridades de las listas:
	> 1. **BUGS**: Si saben como solucionar algo que esta en esta lista dejan lo que estan haciendo actualmente y ayudan a solucionar el problema.(Esto seria mas que nada para que nadie se estanque con algun error bldo que tire de incompatibilidad o cosas asi y pueda seguir desarrollando)  
	> 2. **TAREAS/EN PROCESO**: La idea es que cada uno tenga una sola tarjeta asignada a la vez(es decir que no tendrian que haber mas de 3 tarjetas en la lista `EN PROCESO`), y que no empiezen a hacer otra hasta que terminen la actual(es decir hasta que no se mueva a **TERMINADO**).  
	> 3. **REFACTORIZAR**: A veces antes de agregar una nueva(y opcional) funcionalidad es preferible refactorizar y reordenar el codigo previo, por eso se pone `REFACTORIZAR` como prioridad sobre `SUGERENCIAS`  
	> 4. **SUGERENCIAS**: Una vez que todo lo **_urgente_** este terminado, podemos implementar lo que sea que este en esta lista.  
	
	***

* #### Git/Github
  El workflow de `Git` se va a basar en el uso de `ramas o branches`. El proceso seria algo asi(mas abajo estan las especifaciones de cada rama):

  > Se trabaja principalmente en rama **DEVELOP**, en caso de empezar a trabajar en algo relativamente grande, se crea una nueva rama con: **git checkout -b _nombre-de-rama_** y se trabaja ahi, una vez terminado se hace: **git checkout develop** y luego **git merge _nombre-de-rama_**. En caso de que esten solucionando algun _bug_ o algo por el estilo, no hace falta crear una nueva rama, simplemente lo hacen en **DEVELOP**.  
  **ES FUNDAMENTAL QUE LOS COMMITS SEAN CHICOS(POCAS EDICIONES) Y QUE LOS MENSAJES SEAN DESCRIPTIVOS**  
  ***

  ##### Descripcion de ramas
  | Branch/Rama   | Caracteristicas |
  | ------------- |:---------------:|
  | Master        | Esta es la rama **estable** del proyecto, a medida que vayamos terminando tareas y comprobando que funciona(en la rama **develop**) yo me voy a encargar de hacer un merge. El proposito de tener dos ramas separadas es simplemente seguridad, si algo le pasa a la rama **develop**(se rompe algo) y no sabemos como solucionarlo, podemos reestablecer la rama **develop** a **master**, la cual va a tener el ultimo estado en el que todo funcionaba.   |
  | Develop       | Rama **develop** es como dice el nombre, la rama de desarrollo, aca se va a estar trabajando constantemente, todas las nuevas ramas que se crean se van a basar en el estado de **develop**, cualquier modificacion que se quiera hacer en el proyecto se le hace a esta rama.(esto a veces significa que la aplicacion puede no funcionar en **develop**, osea que si se quiere probar la app se chequea la rama **master** y se la prueba ahi)        |
  | Alguna otra   | A veces se va a necesitar crear nuevas ramas para trabajar en cosas distintas, un ejemplo claro seria: Supongamos que se me indica a mi la tarea de desarrollar una super funcionalidad que revoluciona el mundo(?, yo para esto crearia una nueva rama que sea: **_revoluciono-el-mundo_**, y mientras trabajo yo solo en esta rama(osea mientras revoluciono el mundo :thumbsup:) un bug ocurre relacionado con algo que hice yo previamente, para no rehacer el trabajo que hice hasta ahora lo que haria es chequear **develop** con **git checkout develop** solucionar el bug y luego volver a revolucionar el mundo con **git checkout revoluciono-el-mundo**, de esta manera el trabajo se mantiene 'modularizado' y es practicamente imposible hacer modificaciones que rompan alguna otra cosa.        |  

  
  
### Como tener el repo localmente
Todavia no hay que clonar este repositorio, lo ideal seria que una vez que nos digan que es lo que tenemos que implementar, creamos el proyecto(probablemente usando eclipse dentro de la carpeta workspace) y luego dentro de la carpeta del proyecto creado se hace un **git clone https://github.com/kriox26/taller-2** y estamos listos :thumbsup:.

### Informacion y comandos de git utiles
Git distingue los archivos segun sus estados.
* **_Tracked files_**: son aquellos archivos que estan agregados al repositorio, es decir a los que les hicieron _git add_
* **_Untracked files_**: opuesto al anterior, es decir todos aquellos archivos que git no esta siguiendo
* **_Staged files_**: estos son todos los archivos que van a ser 'commiteados', es decir los archivos que van dentro del proximo _git commit_
* **_Unstaged files_**: estos son todos los archivos que fueron modificados, eliminados o renombrados y que todavia no se agregaron para commitear, es decir que si hacen un _git commit_ estos archivos **NO VAN A FORMAR PARTE DEL COMMIT**

Los comandos que mas vamos a utilizar van a ser:  
> **git add _nombre-o-nombres-de-los-archivos_**: agrega los archivos especificados a **_Staged files_**. Por ejemplo si yo hice un cambio a un archivo que se llama `luca` y otro que se llama `jorge` los puedo agregar haciendo alguna de las siguientes:
> * git add luca    -     git add jorge
> * git add luca jorge
> * git add -A  es equivalente a git add . (con el punto incluido, esto lo que hace es agregar TODO, incluyendo archivos que no estan siendo seguidos)  
>
> **git commit -m "mensaje del commit"**: crea un commit con el mensaje y archivos(aquellos que estaban en **_Staged files_**) correspondientes. Por ejemplo, luego de hacer el _git add_ a los archivos luca y jorge, hariamos lo siguiente(tener en cuenta que el tamaño de los mensajes tiene un limite):
> * git commit -m "agrego los archivos luca y jorge(tiburon)"
>
> **git pull**: Este comando trae todos los cambios que estan en el repositorio remoto y no estan en el repositorio local. **PRESTAR CUIDADO ATENCION A LA RAMA EN LA QUE ESTAN**.
>
> **git push**: Hace lo opuesto a pull, lleva todos los commits(es decir cambios) hechos localmente que no estan el repositorio remoto. Hacer los push cuando hayan terminado unicamente(o cuando alguien necesite el trabajo que hicieron hasta ahora).
>
> **git checkout _rama_**: Esto lo que hace es chequear la _rama_ especificada. Por ejemplos si estamos en la rama _develop_ y queremos probar la funcionalidad del juego en version estable(la cual estaria en la rama _master_), hariamos lo siguiente:
> * git checkout master
> hacer todo lo que quieran aca
> * git checkout develop    # Para volver a develop y seguir desarrollando ahi
>
> **git checkout -b _nombre-de-rama_**: Esto lo que hace es crear una rama con nombre _nombre-de-rama_ y cambiar luego chequear esa rama, es decir los deja listos para empezar a trabajar en la rama definida. Por ejemplo, supongamos que quiero empezar a trabajar en la rama _jorge-ataca-como-tiburo_, lo que haria es:
> * git checkout -b jorge-ataca-como-tiburon  # Esto me mueve a esa rama
> hacer lo que sea
> * git checkout develop # Para volver a la rama develop o si se quiere ir a otra rama se puede cambiar el nombre develop por el nombre de la rama que se quiera
>
> **git merge**: Esto se hace cuando se quiere mergear una rama con otra. Por ejemplo, si yo me pongo a trabajar en la rama _luca-y-josi_ hago lo que tengo que hacer ahi y luego quiero integrar esa rama con develop haria lo siguiente:
> * git checkout develop # para asegurarme que estoy en develop
> * git checkout -b luca-y-josi # Para crear la rama
> hacer todo el trabajo que se quiera hacer en la rama
> * git checkout develop # Para volver a la rama develop
> * git merge luca-y-josi # Para integrar los cambios que hice en luca-y-josi a develop  

A medida que surge la necesidad de nuevos comandos los voy a ir agregando, dejo links a cheatsheets y libros buenos:
[ProGit - Un libro muy bueno recomendado por github](https://git-scm.com/book/en/v2)
[Cheatsheet de comandos para git](http://www.git-tower.com/blog/git-cheat-sheet/)


### Extra
Cualquier otra cosa que se necesite ir agregando se pone aca abajo, por ejemplo cuando nos digan que juego implementar, podemos agregar aca las reglas del juego, links utiles, imagenes del juego actual o lo que sea.
Happy coding (? :smiley:
