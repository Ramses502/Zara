# Proyecto Zara

Mi pequeño proyecto de simulación para Zara.

---

## Tecnologías utilizadas

- **Java 21**  
- **Spring Boot 3.5.6**  
- **Maven**  
- **Spring Data JPA**
- **H2**
- **Lombok**
- **MapStruct**
- **JUnit**
- **Mockito**

---

## Estructura del proyecto (Arquitectura Hexagonal)

La solución se organiza en capas siguiendo **puertos y adaptadores**:
- **Driving:** Carpeta que contiene los módulos que exponen la comunicación del micro, en este cado una API REST.
- **Driven:** Carpeta que contiene los módulos de persistencia. En este caso tenemos una base de datos H2.
- **Domain:** Módulo que contiene la lógica de negocio de la aplicación.
- **Boot:** Módulo que se encarga del arranque de la aplicación.

Los módulos de persistencia y API REST se comunican con el dominio mediante puertos y adaptadores.

## Ejecutar las pruebas

Una vez levantado el proyecto mediante el entorno de desarrollo, o bien desde comandos (**./mvnw spring-boot:run**), El proyecto estará disponible en **http://localhost:8080**.
Si queremos probar el endpoint desarrollado solo tendremos que lanzar una petición a la URL **http://localhost:8080/price?date=2020-10-03T15:30:00&productId=35455&brandId=1** cambiando los valores por los deseados.
Los tests propuestos por el ejercicio se encuentran en la ruta **boot/src/test/java/com/project/zara/rest/RestTest.java**. Cuando los lanzas levantan el proyecto con su respectiva H2 y una pequeña carga de datos, para posteriormente hacer llamadas al endpoint desarrollado.
También tenemos pruebas unitarias por si en algún momento se decide hacer un refactor tenemos una prueba unitaria para cada cosa.

## Ver la base de datos

Si se desea acceder a la consola de la base de datos, basta con poner en el buscador de nuestro navegador la URL **http://localhost:8080/h2-console**. En el campo de usuario pondremos "sa" y la contraseña la dejaremos vacía. Al final es una prueba y no estamos guardando nada relevante.

## Curiosidades sobre el código

- He decidido usar mapstruct junto a lombok. Algo peligroso ya que puede darse el caso de que mapstruct genere las clases de implementación antes de detectar los getters y setters que genera lombok. Para ello hay que   meter una configuración en el pom donde tengas dichas dependencias.
- He interpretado que cuando la petición te da una fecha quiere decir que esa fecha debe estar dentro del rango de fechas que tenemos en la tabla.
- He decidido hacer un Handler de excepciones para tener excepciones controladas. Aunque la verdad no la he hecho demasido elaborada.




