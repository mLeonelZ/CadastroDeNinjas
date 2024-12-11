-- V2: Migration para add a coluna de rank2 na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank2 VARCHAR(50);