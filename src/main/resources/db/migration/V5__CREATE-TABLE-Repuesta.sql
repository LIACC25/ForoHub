CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico BIGINT,
    fechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor BIGINT,
    solucion TEXT,
    FOREIGN KEY (topico) REFERENCES Topico(id),
    FOREIGN KEY (autor) REFERENCES Usuario(id)
);