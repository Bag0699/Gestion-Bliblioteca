# Gestión de Biblioteca con Spring Boot
Este repositorio contiene el código fuente de la API REST para la administración de una biblioteca, desarrollada con Spring Boot. Proporciona las funcionalidades necesarias para gestionar el catálogo de libros, la información de los usuarios, el sistema de reservas y el control de sanciones.

## Tabla de Contenidos

* [Características Principales](#características-principales)
* [Tecnologías Utilizadas](#tecnologías-utilizadas)
* [Cómo Empezar](#cómo-empezar)
    * [Requisitos Previos](#requisitos-previos)
    * [Instalación](#instalación)
    * [Configuración](#configuración)
    * [Ejecución](#ejecución)
* [Endpoints de la API](#endpoints-de-la-api)
    * [Libros](#libros)
    * [Usuarios](#usuarios)
    * [Reservas](#reservas)
    * [Sanciones](#sanciones)
    * [Lista de Lectura](#lista-de-lectura)
* [Contribución](#contribución)

## Características Principales

* **Gestión de Libros:** Permite la creación, lectura, actualización y eliminación de libros.
* **Gestión de Usuarios:** Permite el registro, la obtención de información y la gestión de usuarios con diferentes roles.
* **Sistema de Reservas:** Implementa la funcionalidad para que los usuarios reserven libros disponibles.
* **Gestión de Sanciones:** Permite imponer sanciones con fechas de fin y levanta automáticamente las sanciones expiradas.
* **Lista de Lectura:** Los usuarios pueden gestionar sus listas de lectura personalizadas.
* **Autenticación y Autorización:** (Describe el método de seguridad implementado, si aplica).
* **Validación de Datos:** Utiliza Jakarta Bean Validation para asegurar la integridad de los datos.

## Tecnologías Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* MySQL 
* Lombok
* Jakarta Bean Validation
* MapStruct
* Maven 

## Cómo Empezar

Sigue estos pasos para ejecutar la API localmente.

### Requisitos Previos

* Java Development Kit (JDK) 21 o superior
* Maven 3.4.5 o superior 
* Una instancia en ejecución de MySQL 

### Instalación

1.  Clona el repositorio:
    ```bash
    git clone [https://github.com/Bag0699/Gestion-Bliblioteca.git](https://github.com/Bag0699/Gestion-Bliblioteca.git)
    cd gestion-biblioteca
    ```

### Configuración

1.  Crea una base de datos llamada `gestion_biblioteca` (o el nombre que prefieras) en tu instancia de MySQL.
2.  Configura la conexión a la base de datos en el archivo `src/main/resources/application.properties` (o `application.yml`). Asegúrate de ajustar los siguientes parámetros:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_biblioteca
    spring.datasource.username=tu_usuario_db
    spring.datasource.password=tu_password_db
    spring.jpa.hibernate.ddl-auto=update # Ajusta según tu necesidad (create, create-drop, validate)
    ```
    Reemplaza `tu_usuario_db` y `tu_password_db` con tus credenciales de MySQL.

### Ejecución

1.  Ejecuta la aplicación Spring Boot utilizando Maven:
    ```bash
    mvn spring-boot:run
    ```
2.  La API estará disponible en `http://localhost:8080`.

## Endpoints de la API

Aquí se describen brevemente algunos de los endpoints principales de la API. (Puedes expandir esta sección con más detalles y ejemplos si lo deseas, o incluso crear una documentación aparte con Swagger/OpenAPI).

### Libros

* `POST /api/books`: Crea un nuevo libro.
* `GET /api/books`: Obtiene todos los libros (con opciones de paginación y filtrado).
* `GET /api/books/{id}`: Obtiene un libro por su ID.
* `PUT /api/books/{id}`: Actualiza un libro existente.
* `DELETE /api/books/{id}`: Elimina un libro.

### Usuarios

* `POST /api/users`: Registra un nuevo usuario.
* `GET /api/users`: Obtiene todos los usuarios.
* `GET /api/users/{id}`: Obtiene un usuario por su ID.
* `PUT /api/users/{id}`: Actualiza la información de un usuario.
* `DELETE /api/users/{id}`: Elimina un usuario.

### Reservas

* `POST /api/reservations/create`: Crea una nueva reserva para uno o varios libros.
* `GET /api/reservations/user/{userId}`: Obtiene las reservas de un usuario.
* `GET /api/reservations/{id}`: Obtiene una reserva por su ID.
* `DELETE /api/reservations/{id}`: Cancela una reserva.

### Sanciones

* `GET /api/sanctions/user/{userId}`: Obtiene la sanción activa de un usuario (si existe).
* `POST /api/sanctions/apply`: Aplica una sanción a un usuario.
* `POST /api/sanctions/lift/{userId}`: Levanta manualmente la sanción de un usuario.
    * *(Nota: Las sanciones expiradas se levantan automáticamente por una tarea programada)*

### Lista de Lectura

* `POST /api/reading-list/add`: Añade un libro a la lista de lectura del usuario.
* `GET /api/reading-list/{userId}`: Obtiene la lista de lectura de un usuario.
* `DELETE /api/reading-list/remove`: Elimina un libro de la lista de lectura del usuario.

## Contribución

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1.  Haz un "fork" del repositorio.
2.  Crea una nueva rama para tus contribuciones (`git checkout -b feature/tu-funcionalidad`).
3.  Realiza tus cambios y haz "commit" de ellos (`git commit -m 'Añade nueva funcionalidad'`).
4.  Sube tus cambios al "fork" (`git push origin feature/tu-funcionalidad`).
5.  Crea un "Pull Request" desde tu rama en tu "fork" hacia la rama principal de este repositorio.

Por favor, revisa el archivo `CONTRIBUTING.md` (si lo creas) para obtener directrices más detalladas sobre las contribuciones.

---

¡Gracias por visitar este repositorio!