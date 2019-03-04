CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(32) NOT NULL,
	logradouro VARCHAR(32),
	numero VARCHAR(8),
	complemento VARCHAR(32),
	bairro VARCHAR(16),
	cep VARCHAR(9),
	cidade VARCHAR(32),
	estado VARCHAR(32),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38400-112', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Daniel Queiroz', 'Rua Icoracy', '23', null, 'Brasil', '38220-232', 'Santarem', 'PA', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Luiza Martins', 'Rua dos Anjos', '102', null, 'Brasil', '30400-120', 'São Paulo', 'SP', true);
