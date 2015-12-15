#Reentrega módulo I

Mejoraron cuestiones relativas a la POO en general, a la documentación y a la generación del jar.
En cuanto a funcionalidad, sigue faltando la aparición de los pasteles, la inclusión de los pájaros y el modelado de niveles (y sus variables de dificultad).
La nueva nota del módulo I es 85.
**RESPUESTA**:`En la nueva entrega agregamos el modelado de niveles con sus variables de dificultad, inclusion de pajaros y pasteles esta pero la grafica no esta acomodada`

#Módulo II

La entrega del módulo II no alcanza para aprobar, se encuentra incompleta en distintos aspectos y tiene problemas de funcionamiento en otros. La nota obtenida es 30.

* Gráfica y Funcionamiento General:
- Hay problemas importantes en cuanto al funcionamiento general del juego:
Por una lado, después de jugar unos segundos, el juego se queda bloqueado y no se puede continuar. Revisando el código esto se produce porque gameOver() retorna true sin que aparentemente se haya perdido.
Por otro, aún logrando reparar todas las ventanas, no avanza a la siguiente sección, por lo que tampoco se puede completar el nivel.
- Arrastra del módulo I la falta de funcionalidad referente a pasteles y pájaros.
- La visualización gráfica muestra un parpadeo al redibujar. Para solucionar esto, en lugar de dibujar en un JFrame, debería dibujarse en un JPanel, dentro del método paintComponent(Graphics g).
- La gráfica debe mostrar el puntaje actual, vidas y tiempo restante.
- La forma de eliminar los ladrillos haciendo obj = null es incorrecta, obj es una variable temporal y esta asignación no tiene efecto. Deberían eliminar el ladrillo de la colección original, o al menos marcarlo como inactivo.
**RESPUESTA**:`Se corrigio el bloqueo del juego, ahora se puede jugar desde principio a fin sin problemas. Reparando todas las ventanas se avanza y se puede completar el nivel. El parpadeo se soluciono usando el JPanel, con la clase PanelJuego.java. La forma de eliminar los ladrillos se actualizo, marcandolo como inactivo en el modelo y eliminandolo en la grafica(correspondiente al inactivo).`

* SWING y Eventos:
- La pantalla de configuración está incompleta y no permite seleccionar un nivel (también falta la implementación de niveles en el modelo)
- No se definió la pantalla de carga de nombre, ni la validación asociada.
- Falta implementar la tabla de puntajes, con su correspondiente manejo de archivos para la persistencia.
**RESPUESTA**:`Se corrigio la pantalla de configuracion, ahora se puede elegir niveles y jugar el nivel acorde al elegido. Por default es 1. La pantalla de carga de nombre esta definida pero no terminamos de implementar la funcionalidad detras de eso. Ibamos a utilizar un archivos .csv (comma-separated values), volcando informacion en un array list, manipulandola ahi y agregando solo lo necesario de vuelta al archivo. Utiliza un JTable para mostrar los scores, no lo pudimos terminar.`

* Threads:
El manejo de Threads en general es adecuado, aunque al cerrar las ventanas abiertas, el programa no termina su ejecución y sigue corriendo en el fondo. Pueden solucionarlo agregando a la ventana la línea  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
**RESPUESTA**:`Se agrego el this.setDefaultCloseOperation(EXIT_ON_CLOSE) para que se corte la ejecucion.`

* Model/View/Controller:

- Hay un problema conceptual en el manejo de los ladrillos. La vista debería mirar el modelo para saber dónde están los ladrillos, y dibujar en base a lo que muestre ese modelo. En este caso, esto puede relajarse un poco (para obtener un movimiento más fluido) creando ambos objetos al mismo tiempo y esperando que se comporten igual, pero está mal que por ejemplo la velocidad no sea leída del modelo, o que no se consulte periódicamente en el modelo si ese ladrillo sigue activo.
Igualmente, lo ideal es que siempre consulten el modelo para dibujar (la fluidez del movimiento puede lograrse de igual manera sumando un offset variable a la posición consultada)
- Muchas inicializaciones de la vista se hacen en el controlador, ensuciando esta clase. Por ejemplo los métodos generarViewIrrompible, generarViewSimple, generarViewPuerta, generarViewSemiCircular, actualizarLadrillos, actualizarPersonajes, actualizarVentana y parte del método crearEdificio, son propios de la vista y no deberían estar en el controlador. El controlador solo debería invocar la creación de la vista, sin tener él estos métodos.
**RESPUESTA**:`Se corrigio el manejo de los ladrillos, de todas maneras no es la vista la que mira el modelo, sino que el controlador lo mira y le manda la informacion a la vista para que esta se comporte de acuerdo, ahors estan sincronizados, mediante un contador creado en el modelo utilizado por Main y por el Controlador para la creacion de ladrillos. En cuanto a las inicializaciones, estan en controlador porque no son VISTAS a pesar del nombre, esos objetos representan una imagen y un offsetX y offsetY que estan directamente relacionados con el modelo, es por eso que estan dentro del controlador, si lo sacaramos del controlador y los pusieramos en el Play, tendriamos que tambien poner toda la generacion del edificio en el play, eso provocaria que el Controlador no actue como controlador, ya que no estaria enviando informacion a nadie ni obteniendo informacion de nadie.`

* Sintaxis Java:
El uso del lenguaje Java es adecuado. 

* Excepciones:
- El uso de la excepción propia InvalidMoveException es correcto. En el enunciado se pedía sin embargo que creen dos excepciones propias, por lo que estaría faltando una.
**RESPUESTA**: `Se agregaron excepciones para el manejo de cambio de secciones y de ladrillos inexistentes.`
