# challengue
challengue Alura
Este proyecto es una API REST básica de un foro desarrollada con Java y Spring Boot. Permite crear, listar, actualizar y eliminar tópicos.

Se implementó autenticación con JWT, por lo que algunas rutas requieren un token para poder usarse.

🔧 Funcionalidades

Crear, ver, actualizar y eliminar tópicos

Login de usuario y generación de token JWT

Protección de rutas con autenticación

Validación de datos

Manejo de errores (400, 401, 404, etc.)


Autenticación

Para acceder a las rutas protegidas:

Hacer login en /auth/login

Copiar el token

Enviar el token como Bearer Token en las peticiones

🚀 Tecnologías usadas

Java

Spring Boot

Spring Security

JWT

JPA (Hibernate)

H2 Database
