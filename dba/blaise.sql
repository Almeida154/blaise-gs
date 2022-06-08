-- David Almeida | 96033

CREATE TABLE CARGOS (
    cargo_id NUMBER(*,0) CONSTRAINT PK_CARGO PRIMARY KEY
    ,cargo_nome VARCHAR2(24) NOT NULL
    ,cargo_desc VARCHAR2(48) NOT NULL
    ,cargo_hora_salario_teto NUMBER(6,2) NOT NULL
);

CREATE TABLE CONTATO_TIPOS (
    contato_tipo_id NUMBER(*,0) CONSTRAINT PK_CONTATO_TIPO PRIMARY KEY
    ,contato_tipo_nome VARCHAR2(16) NOT NULL -- email, telefone, celular etc
);

CREATE TABLE FUNCIONARIOS (
    func_cpf VARCHAR2(11) CONSTRAINT PK_FUNCIONARIO PRIMARY KEY
    ,func_nome VARCHAR2(48) NOT NULL
    ,func_idade NUMBER(*,0) NOT NULL
    ,func_sexo CHAR(1) NOT NULL
    ,func_hora_salario NUMBER(6,2) NOT NULL
    ,cargo_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT FK_FUNCIONARIO_CARGO
        FOREIGN KEY(cargo_id)
        REFERENCES CARGOS(cargo_id)
);

CREATE TABLE FUNCIONARIO_CONTATOS (
    func_contato_id NUMBER(*,0) CONSTRAINT PK_FUNCIONARIO_CONTATO PRIMARY KEY
    ,func_contato_desc VARCHAR2(24) NOT NULL -- dado do contato
    ,contato_tipo_id NUMBER(*,0) NOT NULL
    ,func_cpf VARCHAR2(11) NOT NULL
    
    ,CONSTRAINT FK_FUNCIONARIO_CONTATO_CONTATO_TIPO
        FOREIGN KEY(contato_tipo_id)
        REFERENCES CONTATO_TIPOS(contato_tipo_id)
    
    ,CONSTRAINT FK_FUNCIONARIO_CONTATO_FUNCIONARIO
        FOREIGN KEY(func_cpf)
        REFERENCES FUNCIONARIOS(func_cpf)
);

CREATE TABLE EMBALAGENS (
    embalagem_id NUMBER(*,0) CONSTRAINT PK_EMBALAGEM PRIMARY KEY
    ,embalagem_tamanho VARCHAR(16) NOT NULL
    ,embalagem_material VARCHAR(32) NOT NULL
);

CREATE TABLE FABRICANTES (
    fabricante_cnpj VARCHAR2(14) CONSTRAINT PK_FABRICANTE PRIMARY KEY
    ,fabricante_nome VARCHAR2(48) NOT NULL
    ,fabricante_seguimento VARCHAR2(32) NOT NULL
);

CREATE TABLE FORNECEDORES (
    fornecedor_cnpj VARCHAR2(14) CONSTRAINT PK_FORNECEDOR PRIMARY KEY
    ,fornecedor_nome VARCHAR2(48) NOT NULL
    ,fornecedor_seguimento VARCHAR2(32) NOT NULL
);

CREATE TABLE EMPRESA_CONTATOS (
    empresa_contato_id NUMBER(*,0) CONSTRAINT PK_EMPRESA_CONTATO PRIMARY KEY
    ,empresa_contato_desc VARCHAR2(24) NOT NULL -- dado do contato
    ,contato_tipo_id NUMBER(*,0) NOT NULL
    ,empresa_cnpj VARCHAR2(14) NOT NULL
    
    ,CONSTRAINT FK_EMPRESA_CONTATO_CONTATO_TIPO
        FOREIGN KEY(contato_tipo_id)
        REFERENCES CONTATO_TIPOS(contato_tipo_id)
    
    ,CONSTRAINT FK_EMPRESA_CONTATO_FORNECEDOR
        FOREIGN KEY(empresa_cnpj)
        REFERENCES FORNECEDORES(fornecedor_cnpj)
    
    ,CONSTRAINT FK_EMPRESA_CONTATO_FABRICANTE
        FOREIGN KEY(empresa_cnpj)
        REFERENCES FABRICANTES(fabricante_cnpj)
);

CREATE TABLE PRODUTOS (
    produto_id NUMBER(*,0) CONSTRAINT PK_PRODUTO PRIMARY KEY
    ,produto_nome VARCHAR2(32) NOT NULL
    ,embalagem_id NUMBER(*,0) NOT NULL
    ,fabricante_cnpj VARCHAR(14) NOT NULL
    ,fornecedor_cnpj VARCHAR(14) NOT NULL
    
    ,CONSTRAINT FK_PRODUTO_EMBALAGEM
        FOREIGN KEY(embalagem_id)
        REFERENCES EMBALAGENS(embalagem_id)
    
    ,CONSTRAINT FK_PRODUTO_FABRICANTE
        FOREIGN KEY(fabricante_cnpj)
        REFERENCES FABRICANTES(fabricante_cnpj)
    
    ,CONSTRAINT FK_PRODUTO_FORNECEDOR
        FOREIGN KEY(fornecedor_cnpj)
        REFERENCES FORNECEDORES(fornecedor_cnpj)
);

CREATE TABLE AMEACA_TIPOS (
    ameaca_tipo_id NUMBER(*,0) CONSTRAINT PK_AMEACA_TIPO PRIMARY KEY
    ,ameaca_tipo_nome VARCHAR2(32) NOT NULL
    ,ameaca_tipo_desc VARCHAR2(66) NOT NULL
);

CREATE TABLE AMEACAS (
    ameaca_id NUMBER(*,0) CONSTRAINT PK_AMEACA PRIMARY KEY
    ,ameaca_nome VARCHAR2(32) NOT NULL
    ,ameaca_tipo_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT FK_AMEACA_AMEACA_TIPO
        FOREIGN KEY(ameaca_tipo_id)
        REFERENCES AMEACA_TIPOS(ameaca_tipo_id)
);

CREATE TABLE DEPARTAMENTOS (
    depto_id NUMBER(*,0) CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY
    ,depto_nome VARCHAR2(32) NOT NULL
    ,depto_desc VARCHAR2(64) NOT NULL
);

CREATE TABLE PROJETOS (
    projeto_id NUMBER(*,0) CONSTRAINT PK_PROJETO PRIMARY KEY
    ,projeto_nome VARCHAR2(32) NOT NULL
    ,projeto_inicio_dt DATE NOT NULL
    ,projeto_fim_dt DATE
    ,depto_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT PK_PROJETO_DEPARTAMENTO
        FOREIGN KEY(depto_id)
        REFERENCES DEPARTAMENTOS(depto_id)
);

CREATE TABLE RECURSOS_HUMANOS (
    rh_id NUMBER(*,0) CONSTRAINT PK_RECURSOS_HUMANOS PRIMARY KEY
    ,hr_horas_trabalhadas NUMBER(*,0) NOT NULL
    ,func_cpf VARCHAR2(11) NOT NULL
    ,projeto_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT FK_RECURSOS_HUMANOS_FUNCIONARIO
        FOREIGN KEY(func_cpf)
        REFERENCES FUNCIONARIOS(func_cpf)
    
    ,CONSTRAINT FK_RECURSOS_HUMANOS_PROJETOS
        FOREIGN KEY(projeto_id)
        REFERENCES PROJETOS(projeto_id)
);

CREATE TABLE PESQUISAS (
    pesquisa_id NUMBER(*,0) CONSTRAINT PK_PESQUISA PRIMARY KEY
    ,pesquisa_lider_func_cpf VARCHAR2(11) NOT NULL
    ,projeto_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT PK_PESQUISA_PROJETO
        FOREIGN KEY(projeto_id)
        REFERENCES PROJETOS(projeto_id)
);

CREATE TABLE TESTES (
    teste_id NUMBER(*,0) CONSTRAINT PK_TESTE PRIMARY KEY
    ,teste_resultado VARCHAR2(128)
    ,teste_dt DATE NOT NULL
    ,produto_id NUMBER(*,0) NOT NULL
    ,ameaca_id NUMBER(*,0) NOT NULL
    ,pesquisa_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT FK_TESTE_PRODUTO
        FOREIGN KEY(produto_id)
        REFERENCES PRODUTOS(produto_id)
    
    ,CONSTRAINT FK_TESTE_AMEACA
        FOREIGN KEY(ameaca_id)
        REFERENCES AMEACAS(ameaca_id)
    
    ,CONSTRAINT FK_TESTE_PESQUISA
        FOREIGN KEY(pesquisa_id)
        REFERENCES PESQUISAS(pesquisa_id)
);

CREATE TABLE COMPRAS (
    compra_id NUMBER(*,0) CONSTRAINT PK_COMPRA PRIMARY KEY
    ,compra_dt DATE NOT NULL
    ,compra_quantidade NUMBER(*,0) NOT NULL
    ,compra_unitario_preco NUMBER(8,2) NOT NULL
    ,depto_id NUMBER(*,0) NOT NULL
    ,produto_id NUMBER(*,0) NOT NULL
    
    ,CONSTRAINT FK_COMPRA_DEPARTAMENTO
        FOREIGN KEY(depto_id)
        REFERENCES DEPARTAMENTOS(depto_id)
    
    ,CONSTRAINT FK_COMPRA_PRODUTO
        FOREIGN KEY(depto_id)
        REFERENCES PRODUTOS(produto_id)
);