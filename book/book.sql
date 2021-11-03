create table bookTBL(
   code varchar2(4) primary key,
   title nvarchar2(50) not null,
   writer nvarchar2(10) not null,
   price number(8)
);

insert into bookTBL values('1001', '이것이 자바다.','신용균',28000);
insert into bookTBL values('1002', '이것이 오라클이다.','오재남',29000);
insert into bookTBL values('1003', '자바의 신','강신용',30000);
insert into bookTBL values('1004', '자바 1000제','김용만',31000);
insert into bookTBL values('1005', 'spring','이민호',32000);

select* from bookTBL;