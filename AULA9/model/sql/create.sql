CREATE TABLE categoria(
    id BIGSERIAL NOT NULL,
    nome VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE produto(
    id BIGSERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL (20,2),
    categoria_fk BIGINT NOT NULL,
    ativo BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE produto ADD CONSTRAINT  produto_categoria_fk FOREIGN KEY (categoria_fk) REFERENCES categoria(id);