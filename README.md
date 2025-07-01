# VollMed API

Este proyecto es una API REST para la gestión de médicos y pacientes, desarrollada en Java con Spring Boot. Permite registrar, listar, actualizar e inactivar (borrado lógico) médicos y pacientes, cumpliendo reglas de negocio como la no eliminación física de registros y la validación de campos clave.

## Funcionalidades principales
- Registro de médicos y pacientes
- Listado paginado y ordenado de médicos y pacientes (solo activos)
- Actualización de nombre, teléfono y dirección
- Inactivación lógica de médicos y pacientes (borrado lógico)

## Tecnologías utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Flyway (migraciones de base de datos)

## Uso
1. Clona el repositorio:
   ```sh
   git clone https://github.com/shigerubt/vollmed-api.git
   ```
2. Configura la base de datos en `src/main/resources/application.properties`.
3. Ejecuta la aplicación:
   ```sh
   ./mvnw spring-boot:run
   ```

## Endpoints principales
- `POST /medicos` — Registrar médico
- `GET /medicos` — Listar médicos activos
- `PUT /medicos` — Actualizar médico
- `DELETE /medicos/{id}` — Inactivar médico
- `POST /pacientes` — Registrar paciente
- `GET /pacientes` — Listar pacientes activos
- `PUT /pacientes` — Actualizar paciente
- `DELETE /pacientes/{id}` — Inactivar paciente

## Autor
shigerubt
