create table if not exists products (
                                        id serial primary key,
                                        name varchar(50),
                                        producer varchar(50),
                                        count integer default 0,
                                        price integer
);

alter table products add column tax integer;
alter table products alter column tax set default 0;