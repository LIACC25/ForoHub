# ForoHub API

API REST para gestión de usuarios, perfiles, cursos, tópicos y respuestas, con autenticación JWT.

---

## Funcionalidades principales

- **Usuarios**  
  - Crear usuarios (sin token)  
  - Listar usuarios o por usuario id (requiere token válido)  

- **Tópicos**  
  - Crear, listar, editar y eliminar tópicos (requiere token válido)  
  - Listar tópicos por id o todos los tópicos  

- **Perfiles, Cursos y Respuestas**  
  - CRUD básico (requiere token válido)  

## Autenticación

Para realizar operaciones sobre tópicos, perfiles, cursos y respuestas es necesario autenticarse y obtener un **token JWT válido por 2 horas**.



