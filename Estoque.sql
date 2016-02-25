create table produto(
id serial,
nome varchar(40),
quantidade int,
primary key (id)
)

create table nfs(
id_saida serial,
primary key (id_saida)
)
create table nfe(
id_entrada serial,
primary key (id_entrada)
)

create table nfs_produto_quantidade( 
id_saida int,
id_produto int,
quantidade int,
foreign key (id_produto) references produto (id),
foreign key (id_saida) references nfs(id_saida)
)
create table nfe_produto_quantidade( 

id_entrada int,
id_produto int,
quantidade int,
foreign key (id_produto) references produto (id),
foreign key (id_entrada) references nfe(id_entrada)
)