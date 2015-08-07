## Taller de Lenguajes 2




### Workflow
El proyecto se va a manejar usando [Trello](), todas las tareas a asignar y cualquier comunicacion(ya sean problemas, necesidad de ayuda o lo que sea) se va a manejar ahi.
El mantenimiento del codigo del proyecto se va a manejar aca.

* #### Trello
	Inicialmente van a ver NUM listas(a medida que el proyecto avanza puede llegar a ser necesario agregar nuevas listas). Las tarjetas que se creen sse deben poner en la lista correspondiente.
	* **TAREAS**: En esta lista van todas las tareas que falta hacer(recomendable usar `labels` para indicar estado, por ejemplo si es urgente, y ademas asignar a la persona correspondiente).
	* **EN PROCESO**: Cuando se ponen a hacer una de las tareas que habian en la lista `TAREAS`, la mueven a esta lista para que todos sepamos que estan trabajando en eso.
	* **TERMINADO**: Cuando terminan una de las tarjetas de `EN PROCESO`, la mueven a esta lista, y empiezan con la siguiente que tengan asignada en `TAREAS`.
	* **BUGS**: Cualquier problema que encuentren lo publican aca, por mas de que sea dependiente de la plataforma que usan. La idea de poner cualquier problema que encuentren es para que no andemos preguntado: Che a vos te paso esto??.
	* **ARREGLADO**: Cuando una de las tarjetas que estaban en `BUGS` se soluciona, se la mueve a esta lista.
	* **REFACTORIZAR**: En caso de estar apurado a terminar una tarea de la lista `TAREAS` y no tener tiempo para revisar el codigo, agregan una tarjeta diferente a esta lista en la que diga que se necesita mejorar y/o refactorizar el codigo correspondiente(indicar archivo en lo posible).
	* **SUGERENCIAS**: Cualquier idea(que no sea urgente) que quieran agregar y que piensen que esta piola, va a esta lista.

	##### Prioridades de las listas:
	> 1) **BUGS**: Si saben como solucionar algo que esta en esta lista dejan lo que estan haciendo actualmente y ayudan a solucionar el problema.(Esto seria mas que nada para que nadie se estanque con algun error bldo que tire de incompatibilidad o cosas asi y pueda seguir desarrollando)  
	> 2) **TAREAS**: La idea es que cada uno tenga una sola tarjeta asignada a la vez(es decir que no tendrian que haber mas de 3 tarjetas en la lista `EN PROCESO`), y que no empiezen a hacer otra hasta que terminen la actual(es decir hasta que no se mueva a **TERMINADO**).
	> 3) **REFACTORIZAR**: A veces antes de agregar una nueva(y opcional) funcionalidad es preferible refactorizar y reordenar el codigo previo, por eso se pone `REFACTORIZAR` como prioridad sobre `SUGERENCIAS`
	> 4) **SUGERENCIAS**: Una vez que todo lo **_urgente_** este terminado, podemos implementar lo que sea que este en esta lista.
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


