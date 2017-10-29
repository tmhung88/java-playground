-- drop TABLE department;
create table department(
  id numeric,
  name  varchar(14),
  location    varchar(13),
  constraint pk_dept primary key ( id )
);



insert into department values( 10, 'ACCOUNTING', 'NEW YORK' );
insert into department values( 20, 'RESEARCH', 'DALLAS' );
insert into department values( 30, 'SALES', 'CHICAGO' );
insert into department values( 40, 'OPERATIONS', 'BOSTON' );

