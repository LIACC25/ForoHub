CREATE TABLE Usuario (
     id BIGINT NOT NULL AUTO_INCREMENT,
     nombre VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     contrasena VARCHAR(255) NOT NULL,
     perfiles BIGINT NULL,
     CONSTRAINT fk_usuario_perfil
         FOREIGN KEY (perfiles)
         REFERENCES Perfil(id)
         ON DELETE SET NULL,
     PRIMARY KEY (id)
 );