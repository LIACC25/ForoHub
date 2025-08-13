CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);