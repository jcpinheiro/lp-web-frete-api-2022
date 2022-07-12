create table cidade (
   id integer not null auto_increment,
   nome varchar(255) not null,
   uf char(2) not null,
   taxa decimal(12,2) not null,

   primary key (id)
)