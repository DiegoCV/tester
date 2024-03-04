
CREATE TABLE IF NOT EXISTS examen (
  id uuid NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  fechaPresentacion TIMESTAMP WITH TIME ZONE,
  CONSTRAINT pk_examen PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS pregunta (
    id uuid NOT NULL,
    enunciado VARCHAR(255) NOT NULL,
    opcionA VARCHAR(255) NOT NULL,
    opcionB VARCHAR(255) NOT NULL,
    opcionC VARCHAR(255) NOT NULL,
    opcionD VARCHAR(255) NOT NULL,
    opcionCorrecta VARCHAR(255) NOT NULL,
    puntos INT NOT NULL,
    examen_id uuid NOT NULL,
    CONSTRAINT pk_pregunta PRIMARY KEY (id),
    FOREIGN KEY (examen_id) REFERENCES examen(id)
);

CREATE TABLE IF NOT EXISTS estudiante (
    id uuid NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    zonaHoraria VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    CONSTRAINT pk_estudiante PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS examen_estudiante (
	id uuid NOT NULL,
	examen_id uuid NOT NULL,
	estudiante_id uuid NOT NULL,
	CONSTRAINT examen_estudiante_pk PRIMARY KEY (id),
	CONSTRAINT examen_id_fk0 FOREIGN KEY (examen_id)
    	REFERENCES examen(id) MATCH SIMPLE        
        ON DELETE CASCADE,
	CONSTRAINT estudiante_id_fk1 FOREIGN KEY (estudiante_id)
    	REFERENCES estudiante(id) MATCH SIMPLE        
        ON DELETE CASCADE
);