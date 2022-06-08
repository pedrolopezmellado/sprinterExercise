# PRÁCTICA 4 MADS #
En esta práctica comenzaremos a trabajar en equipo y probaremos la metodología de trabajo con ramas de GitFlow. Además, haremos el despliegue de nuestra aplicación en producción con la BD de producción.

## NUEVAS FUNCIONALIDADES DESARROLLADAS ##
Issues que hemos implementado para esta versión:

### Equipos con descripción ###
##### Listado de clases y métodos implementados #####
- `Equipo.java`
- `EquipoService.java`
- `EquipoController.java`
- `EquipoData.java`
##### Listado de plantillas thymeleaf #####
- `detallesEquipo.html`
- `formEditarEquipo.html`
- `formNuevoEquipo.html`
##### Tests implementados #####
- Cambios en muchos tests para adecuarlos al nuevo campo `descripcion`
- `EquipoTest.java`
- `EquipoServiceTest.java`
- `EquipoWebTest.java`
##### Explicación código fuente relevante #####
Como hemos añadido un nuevo campo a la entidad `Equipo` hay que modificar los ficheros de inserción de datos a la BBDD para que funcionen correctamente.

# #

### Buscador de usuarios ###
##### Listado de clases y métodos implementados #####
- `UsuarioService.java`
  - `findByEmailLike`
- `UsuarioRepository.java`
  - `findByEmailLike`
- `UsuarioController.java`
  - @PostMapping("/usuarios/buscar")  ➡️  `buscarUsuario`
- `BuscadorUsuariosData.java`
##### Listado de plantillas thymeleaf #####
- `listaUsuarios.html`
##### Tests implementados #####
- `UsuarioTest.java`
  - Test `buscarUsuariosPorEmailLike` 
- `UsuarioServiceTest.java`
  - Test `servicioBuscadorUsuarios`
##### Explicación código fuente relevante #####
Nada importante.

# #

### Información de la cuenta ###
##### Listado de clases y métodos implementados #####
- `UsuarioController.java`
  - @GetMapping("/usuarios/{id}/cuenta")  ➡️  `detalleCuenta`
##### Listado de plantillas thymeleaf #####
- `detalleCuenta.html`
- `fragments.html`
##### Tests implementados #####
- `UsuarioWebTest.java`
  - Test `detalleCuenta` 
##### Explicación código fuente relevante #####
Nada importante.

# #

## DESPLIEGUE DE PRODUCCIÓN ##
- La puesta en producción se ha realizado con el usuario alu29
- El directorio donde se encuentra el backup es home/alu29/backup03092021.sql 
- El directorio donde se encuentra el script de migración de la base de datos es /home/alu29/todolist-equipo-13/sql/schema-1.2.0-1.3.0.sql 

### PASOS PARA PONER EN PRODUCCIÓN ###
- Mediante ssh iniciamos el perfil alu29
- Ponemos en marcha el contenedor db-equipo13: docker start db-equipo13
- Ejecutamos el contenedor con el perfil postfres-prod: docker run --rm --name spring-boot-equipo13 --network network-equipo13 -p8080:8080 pedrolopez123/mads-todolist-equipo13:1.3.0 --spring.profiles.active=postgres-prod --POSTGRES_HOST=postgres

## URL Tablero Trello
https://trello.com/b/j4x7RiXj/todolist-grupo13-mads
