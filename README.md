# Proyecto Sprinter

Proyecto Sprinter realizado en Spring Boot en java 1.8 con endpoint restful.

Modelo: `Article`

![image](https://user-images.githubusercontent.com/60979312/172842222-079f8ef7-c547-4f0e-9f61-dc21c8d7b3e7.png)

Información adicional:

La búsqueda se realizará por `code`, el cual debe ser único. El `id`es secuencial pero no se emplea como dato de entrada para niguna funcionalidad.

## Ejecución

Puede ejecutar la aplicación usando el _goal_ `run` del _plugin_ Maven 
de Spring Boot:

```
$ ./mvnw spring-boot:run 
```   

También puede ejecutar el `jar` que se encuetra en la carpeta `/production`:

```
$ java -jar .\target\sprinter-exercise-1.2.0-SNAPSHOT.jar 
```

## Población de DB

Al ejecutarse el proyecto se cargará el script `data-dev.sql` que ejecutará 3 secuencias Insert para que la DB esté mínimamente poblada.

![image](https://user-images.githubusercontent.com/60979312/172863898-c764edfc-f5a0-4556-bac3-02c65fce2eaf.png)

## Rutas

Una vez lanzada la aplicación puede abrir una plataforma de API como `Postman`:

### Crear un artículo

Dirección: `http://localhost:8080/articles/new`

Body ejemplo:

![image](https://user-images.githubusercontent.com/60979312/172838924-c08f1c06-b41a-4c3f-8edd-ca9871ac47e3.png)

Salida:

![image](https://user-images.githubusercontent.com/60979312/172839098-07c5ea8f-0288-42f0-8565-48e02d90657b.png)

Status:

`200` Correcto.

`500` Ya se encuentra un artículo con ese código.

### Obtener un artículo

Dirección: `http://localhost:8080/articles/search`

Body ejemplo:

![image](https://user-images.githubusercontent.com/60979312/172839558-6a2e9717-d15b-497b-9313-3861c64ae90c.png)

Salida:

![image](https://user-images.githubusercontent.com/60979312/172839654-0607047d-dcb5-41bf-a06d-a4c2ca07d9f2.png)

Status:

`200` Correcto.

`404` No hay un artículo con ese código.

### Modificar un artículo

Dirección: `http://localhost:8080/articles/update`

Body ejemplo:

![image](https://user-images.githubusercontent.com/60979312/172839958-2afb13a2-635a-46c7-b618-9bc21ea955c0.png)

Salida:

![image](https://user-images.githubusercontent.com/60979312/172840009-362006c4-5a67-4044-a6f1-2bbc4ba60221.png)

Status:

`200` Correcto.

`404` No hay un artículo con ese código.

### Eliminar un artículo

Dirección: `http://localhost:8080/articles/delete`

Body ejemplo:

![image](https://user-images.githubusercontent.com/60979312/172840105-94ca9346-9d37-483a-a3c8-776ebb79489b.png)

Salida:

![image](https://user-images.githubusercontent.com/60979312/172840162-9a2ada91-f64d-4b5a-a974-a252b69a413b.png)

Status:

`200` Correcto.

`404` No hay un artículo con ese código.

## Requisitos

### Separación de paquetes

Los archivos de la aplicación se encuentran estructurados en paquetes como observamos en la siguiente imagen:

![image](https://user-images.githubusercontent.com/60979312/172840719-15d053fb-223d-4017-a99c-4e8b873fc3f3.png)

### Gestión de excepciones

Se han gestinado execepciones personalizadas en la aplicación. Por ejemplo si se hace una búsqueda de un artículo con un código que no existe lanzaría la siguiente excepción:

![image](https://user-images.githubusercontent.com/60979312/172840990-987076af-120f-4c3f-95ba-33029c527a4f.png)

![image](https://user-images.githubusercontent.com/60979312/172841048-5d1626dd-3477-4555-b478-18aae4d07f1f.png)

### Uso de bd h2 en memoria

Si introducimos la dirección `http://localhost:8080/h2-console` y nos conectamos con el username sa nos mostrará la bd en postgress:

![image](https://user-images.githubusercontent.com/60979312/172841589-789bbc4e-1a0b-4d97-acd4-404cdd29433a.png)

### Test del repositorio, servicio y controlador

He implementado test en las tres capas comprobando todas las funcionalidades de la aplicación.

### Logs de la aplicación

He empleado logs en la apliación para mostrar mensajes de lo que está ocurriendo en el servidor: 

![image](https://user-images.githubusercontent.com/60979312/172841991-9662c517-620d-4388-a251-d0e87f945114.png)









