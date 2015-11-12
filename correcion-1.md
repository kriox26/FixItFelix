## OO:

En general, el modelado de clases, estados, herencia y delegación está bien trabajado, existen sin embargo algunos puntos concretos a revisar:

- La clase `TestMain` no debería incluir lógica del juego.  La clase Main (el juego) es la que tiene que tener la lógica. Al funcionar como test, TestMain solo debería crear el objeto que representa al juego e invocar su inicio. Se entiende que a fines de definir movimientos prefijados, los declaren en el Test, pero lo que no está bien desde el punto de vista orientado a objetos, es que en el loop principal manejen directamente el lanzamiento de ladrillos y las reparaciones de ventanas. Estas son responsabilidades exclusivas de Ralph y de Felix respectivamente, por lo que el juego debería delegar estas tareas en ellos.

Tampoco está bien que verifiquen en el Test las colisiones de Felix con los ladrillos, ya que esto forma parte directa de la lógica del juego.

- Para aprovechar mejor las posibilidades de la POO, podrían buscar **definir claramente un método que se encargue de actualizar un turno del juego** (una unidad de tiempo). Este método, se encargaría de controlar cierta lógica general, y de invocar la actualización de cada uno de las entidades que participan del juego: Ralph, Felix, cada ladrillo, cada pájaro, Nicelanders. En la versión actual, esto lo hacen en distintas partes: los ladrillos en el método gameOver, Ralph y Felix en el método Main. En lugar de esto, podrían **valerse del polimorfismo y hacer que el juego tenga una colección de objetos de juego**(podría ser de la clase Dinamico) que sepan actualizarse.

El método `#actualizarTurno()` de juego, podría hacer simplemente:
```java
for(Dinamico o: colleccionConTodosLosObjetos){
    o.actualizar();
}
```
Lo cual queda mucho más prolijo y modificable.

## Sintaxis Java:

El uso de Java es adecuado.

## Funcionamiento:

- En la entrega no incluyeron el archivo .jar pedido en el enunciado.

- En cuanto a la funcionalidad, si bien tal vez omitieron ciertas cuestiones por no participar en el Test, se pedía abarcar todos los aspectos del juego. En este sentido está faltando: **aparición de los pasteles, inclusión de pájaros, reaparición de Felix luego de morir, y modelado de niveles (y sus variables de dificultad)**.

- **No se está invocando la verificiación de si Felix puede pasar por las distintas ventanas** (aunque el código está preparado para hacerlo, a través del método pasarHabilitado).

## Documentación:

Si bien agregaron comentarios al código, no generaron a través de javadoc la documentación HTML pedida.
