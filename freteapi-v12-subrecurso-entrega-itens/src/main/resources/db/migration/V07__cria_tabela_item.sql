create table item (
   id INT not null auto_increment,
   entrega_id INT not null,
   descricao varchar(255) not null,

   primary key(id)
);

alter table item add constraint fk_item_entrega
    foreign key (entrega_id) references entrega (id);