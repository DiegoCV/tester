## Tester App
Aplicacion Tester para implementar una api rest con con spring boot para una aplicacion de examenes

### Get started

Docker version 23.0.2 or later.
SpringBoot version 3.2.3
Java 17
Postgresql version 12.2

### Aplicacion java con spring boot, 

Estructura del proyecto:
```
.
├── Tester_db
│   └── BaseDatos.sql
├── Tester_doc
│   └── ...
├── tester
│   ├── Dockerfile
│   └── ...
├── .env
├── docker-compose.yaml
└── README.md
```

El archivo compose define una aplicacion `teter` corriendo en el puerto 8080. Adicional, se levanta un servicio postgresql en el puerto 5432.

## Deploy with docker compose

```
$ docker compose up -d
```

## Postman 
Dentro de la carpeta de doc se puede encontrar el postman con las apis habilitadas para funcionar.

A continuación un resumen de las operaciones:

```
-   crearEstudiante
-   crearExamen
-   setFechaExamen
-   calificarExamen
```