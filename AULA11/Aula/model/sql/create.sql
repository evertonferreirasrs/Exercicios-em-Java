CREATE TABLE categoria(
    id BIGSERIAL NOT NULL,
    nome VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE produto(
	id BIGSERIAL NOT NULL,
	nome VARCHAR(100) NOT NULL,
	preco DECIMAL(20,2),
	categoria_fk BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL,
	PRIMARY KEY(id) 	
);

CREATE TABLE usuario(
	id BIGSERIAL NOT NULL,
        nome VARCHAR(200) NOT NULL,
        email TEXT UNIQUE NOT NULL,
        senha VARCHAR(100) NOT NULL,
	PRIMARY KEY(id) 
);

CREATE TABLE administrador(
	usuario_fk BIGINT NOT NULL,
	PRIMARY KEY(usuario_fk) 
);

CREATE TABLE cliente(
	usuario_fk BIGINT NOT NULL,
	PRIMARY KEY(usuario_fk) 
);

CREATE TABLE cliente_produto(
	cliente_fk BIGINT NOT NULL,
	produto_fk BIGINT NOT NULL,
	PRIMARY KEY(cliente_fk, produto_fk)
);

CREATE TABLE usuario_img (
        usuario_fk BIGINT NOT NULL,
        img bytea NOT NULL, --bytea de byte array.
        PRIMARY KEY (usuario_fk)
);

--TODO: Adicionar restrições de integridade
ALTER TABLE produto ADD CONSTRAINT produto_categoria_fk
FOREIGN KEY(categoria_fk) REFERENCES categoria(id); 