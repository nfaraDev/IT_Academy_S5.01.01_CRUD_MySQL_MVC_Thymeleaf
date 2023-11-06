# IT_Academy_S5.01.01_CRUD_MySQL_MVC_Thymeleaf
# 
<p >
  <img src="src/main/resources/images/logos.png" width="100" />

</p>

## Spring Boot, MySQL, Thymeleaf, Postman, Swagger

### Description

Ejercicio aplicación Web CRUD con MySQL
Accede en la página ->https://start.spring.io/, y genera un proyecto Spring boot con las siguientes características:

## PROJECT (gestor de dependencias)
-Maven o Gradle
LANGUAGE
-Java
SPRING BOOT
-La última versión estable
PROJECT METADATA
Group
-cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01
Artifact
-S05T01N01GognomsNom
Name
-S05T01N01GognomsNom
Description
-S05T01N01GognomsNom
Package name
-cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01
PACKAGIN
-Jar
JAVA
-Mínimo versión 11
Dependencias:
-Spring Boot DevTools
-Spring Web
-Spring Fecha JPA
-MySQL Driver
-Thymeleaf

##Ejercicio:
Tenemos una entidad llamada Sucursal, que dispone de las siguientes propiedades:
- Integer pk_*SucursalID
- String nomSucursal
- String paisSucursal

También tenemos una DTO denominada SucursalDTO, que tendrá las mismas propiedades que la entidad Sucursal, añadiendo una:
- String tipusSucursal.

Esta propiedad, en función del país de la sucursal, tendrá que indicar si es “UE” o “Fuera UE”. Para hacer esto, puedes tener una lista privada a la misma DTO (por ejemplo: List<String> países), con los países que forman parte de la UE.
Aprovechando la especificación JPA, tendrás que persistir la entidad Sucursal a una base de datos MySql, siguiendo el patrón MVC.
El consejo es que SucursalDTO la uses al Controller y la Vista, y Sucursal al Repository. La capa de servicios será la encargada de hacer la traducción entre las dos.
Para lo cual, dependiendo del package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:
- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.controllers
- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.modelo.domain
- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.modelo.dto
- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.modelo.services
- cat.itacademy.barcelonactiva.apellidos.nombre.s05.t01.n01.modelo.repository

La clase ubicada al paquete controllers (SucursalController, por ejemplo), tendrá que ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:
http://localhost:9000/sucursal/add
http://localhost:9000/sucursal/update
http://localhost:9000/sucursal/delete/{*id}
http://localhost:9000/sucursal/getOne/{*id}
http://localhost:9000/sucursal/getAll

Como puedes ver, al archivo application.properties, tendrás que configurar que el puerto a utilizar sea el 9000.

La vista tendrá que estar desarrollada con Thymeleaf.

### References:

- PATRON DTO
  - [Programando en JAVA- PATRÓN de DISEÑO DTO en JAVA](https://www.youtube.com/watch?v=6GWtSKQoliQ)
  - 
-REPOSITORY- JPA
  - [Uncle Dave's code - Spring Data JPA - Repositorios ](https://youtu.be/Hnudy8Yc8NI?si=XLfYGVnOF6ajBkuA)

- CRUD MySQL
  - [Natsoft - CRUD Java JPA Spring Boot MySQL Api Rest] (https://youtu.be/3cJeqk3RYyM?si=e4IPh55xMVSvHxRU)

- SUAGGER
 - [ Runco de Nou- Swagger Configuration with Spring Boot 3 | Swagger + Spring Boot 3|](https://www.youtube.com/watch?v=Eo6v01KUeZM)

- Postman
  - [Geek QA- Pruebas de APIs con POSTMAN ](https://desarrolloweb.com/articulos/como-usar-postman-probar-api)
