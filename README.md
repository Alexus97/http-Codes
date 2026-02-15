Creacion de API REST FUll donde vamos a evidenciar un crud con los Metodos GET, GET(All) POST, PUT, DELETE. Utilizamos la arquitectura por capas.
Donde manejamos las siguientes: --> Controller: Aqui consumiremos los recursos (urls o endpoints). --> Model: Contenemos las entidades). 
--> Service: Manejamos toda la logica de negocio donde realizamos la inyeccion de dependencias por medio de constructor y no por anotacion para que en el momento de realizar las pruebas unitarias
no tenga que levantar todo el servidor. 
-Como buena practica utilizamos minimo 2 class donde se implementa una para la inyeccion de dependencias y la otra(MemoryBookService), como un servicio que me contiene los datos en memoria. 
--> Repository: Donde creamos la conexion a la base de datos, en este caso implementamos postgres sql y realizando persistencia con ERD y union de tablas intermedias, manejando datos con JSONAlias y JSOnIgnoresProperties.

se realiza mejoras en cuanto a la centralizacion de excepciones(capa de manejo de errores global que intercepta las excepciones a medida que ocurren, las procesa y devuelve una respuesta HTTP estandarizada, todo desde un único lugar)
y se dejan todas las exceptios en GlobalExceptionHandler utilizando anotaciones como @ControllerAdvice y @ExceptionHandler.

Otra mejora importante es el usar la anotacion @ResponseEstatus para tener un codigo mas limpio combinado con la centralizacion de excepiciones, evitando que el codigo sea tan verboso, se aclara que el response entity nos da mas libertar, pero como
queremos un codigo usamos el @ResponseEstatus para metodos donde el resultado es predecible.


Mejoras Por Realizar. -> Crear Diagrama ERD. -> Aplicar Principios SOLID o mejorarlos. -> Documentar con swagger. -> Agregar Capa de controllers. -> Agregar capa de seguridad.
