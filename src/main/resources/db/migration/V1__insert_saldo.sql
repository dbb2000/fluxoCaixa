create sequence hibernate_sequence start with 1 increment by 1;

create table lancamentos (
  id_lancamento bigint not null, 
  data_lancamento timestamp, 
  descricao varchar(255), 
  tipo_entrada varchar(255), 
  valor numeric(19, 2), 
  primary key (id_lancamento)
);
create table saldo (
  id integer not null, 
  saldo numeric(19, 2), 
  primary key (id)
);

insert into SALDO (id,saldo) values(1,0);