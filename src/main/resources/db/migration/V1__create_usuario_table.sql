-- V1__create_usuario_table.sql
-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS foro_hub CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Seleccionar la base de datos
USE foro_hub;

-- Crear la tabla 'curso' para normalizar los cursos relacionados
CREATE TABLE IF NOT EXISTS curso (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- ID único, incremento automático
    nombre VARCHAR(100) NOT NULL UNIQUE,       -- Nombre del curso (único)
    descripcion TEXT,                          -- Descripción opcional del curso
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- Fecha de creación
);

-- Crear la tabla 'usuario'
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,      -- ID del usuario, autoincrementable
    nombre VARCHAR(255) NOT NULL,              -- Nombre del usuario
    email VARCHAR(255) NOT NULL UNIQUE,        -- Correo electrónico único
    contraseña VARCHAR(255) NOT NULL,          -- Contraseña del usuario (debe ser cifrada en la aplicación)
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de registro
    estado BOOLEAN DEFAULT TRUE                -- Estado del usuario (activo o inactivo)
);

-- Crear la tabla 'temas'
CREATE TABLE IF NOT EXISTS topico (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- ID único, incremento automático
    titulo VARCHAR(255) NOT NULL,              -- Título del tópico
    mensaje TEXT NOT NULL,                     -- Mensaje (contenido del tópico)
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    status ENUM('activo', 'inactivo') DEFAULT 'activo', -- Estado del tópico
    autor_id BIGINT NOT NULL,                  -- Relación con la tabla usuario
    curso_id INT NOT NULL,                     -- Relación con la tabla curso

    -- Definir claves foráneas
    CONSTRAINT fk_topico_usuario FOREIGN KEY (autor_id) REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_topico_curso FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_titulo ON topico (titulo);
CREATE INDEX idx_fecha_creacion ON topico (fecha_creacion);
CREATE INDEX idx_autor_id ON topico (autor_id);
CREATE INDEX idx_curso_id ON topico (curso_id);

-- Verificar las tablas creadas
SHOW TABLES;

-- Verificar la estructura de cada tabla
DESCRIBE curso;
DESCRIBE usuario;
DESCRIBE topico;
