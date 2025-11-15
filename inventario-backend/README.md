# Sistema de Gestión de Inventario - Backend

Backend para un sistema de gestión de inventario desarrollado con Java 21 y Spring Boot 3.

## Stack Tecnológico

- **Lenguaje**: Java 21
- **Framework**: Spring Boot 3.3.0
- **Build**: Apache Maven
- **Base de Datos**: PostgreSQL
- **Migraciones**: Flyway
- **Documentación API**: Springdoc OpenAPI (Swagger)
- **Pruebas**: JUnit 5, Testcontainers

## Requisitos

- JDK 21 o superior
- Apache Maven 3.8+
- Docker y Docker Compose (para la base de datos)

## Puesta en Marcha (Desarrollo Local)

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd inventario-backend
    ```

2.  **Levantar la Base de Datos:**
    Desde la raíz del proyecto, ejecutar el siguiente comando para iniciar un contenedor de PostgreSQL con la configuración necesaria.
    ```bash
    docker-compose up -d
    ```

3.  **Configurar Variables de Entorno:**
    La aplicación se configura para usar las credenciales por defecto del `docker-compose.yml`. Si usas una base de datos externa, necesitarás configurar las siguientes variables de entorno:
    - `DB_URL`: URL de conexión JDBC. Ej: `jdbc:postgresql://localhost:5432/inventario_db`
    - `DB_USERNAME`: Usuario de la base de datos.
    - `DB_PASSWORD`: Contraseña del usuario.

4.  **Ejecutar la Aplicación:**
    Usa el wrapper de Maven para compilar y ejecutar la aplicación.
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación se iniciará en `http://localhost:8080`.

## API y Documentación

Una vez que la aplicación está en ejecución, puedes acceder a la documentación de la API generada por Swagger UI en la siguiente URL:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI Spec (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Ejecución de Pruebas

Para ejecutar las pruebas de integración (que utilizan Testcontainers para levantar una base de datos efímera), ejecuta:
```bash
./mvnw test
```

## Endpoints Principales

- `POST /api/productos`: Crea un nuevo producto.
- `GET /api/productos`: Lista todos los productos (paginado).
- `POST /api/movimientos/entrada`: Registra una entrada de stock.
- `POST /api/movimientos/salida`: Registra una salida de stock.
- `GET /api/movimientos`: Historial de movimientos con filtros.
- `GET /api/inventario`: Consulta el stock actual con filtros.
- `GET /api/inventario/totales`: Consulta el stock total por producto.
- `GET /api/bodegas`: Lista todas las bodegas.
- `GET /api/proveedores`: Lista todos los proveedores.
