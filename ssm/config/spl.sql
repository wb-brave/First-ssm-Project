drop table if exists supplier;


/*============================*/
/* Table: ����Ա��ṹ 		  */
/*============================*/
create table account
(
   /* ����Ա���,�Զ����� */
   acc_id                  int not null auto_increment,
   /* ����Ա��¼��  */
   acc_login               varchar(20),
   /* ����Ա����  */
   acc_name                varchar(20),
   /* ����Ա���� */
   acc_pass                varchar(20),
   /* ���ñ��Ϊ���� */
   primary key (acc_id)
);

/*==============================================================*/
/* Table: ��Ӧ�̱�	                                        */
/*==============================================================*/

create table supplier
(
   sup_id               int not null auto_increment,
   sup_name             varchar(20),
   sup_linkman          varchar(20),
   sup_phone            varchar(11),
   sup_address          varchar(100),
   sup_remark           varchar(200),
   primary key (sup_id)
);

/* ��ӹ���Ա����, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* ��ӹ�Ӧ������, */
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark) values ('ƻ����Ӧ��','С��','12388888887','���ݻ���','��ͨ��Ӧ��');
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark) values ('���ǹ�Ӧ��','С��','12388888888','��������','��ͨ��Ӧ��');
insert into supplier (sup_name,sup_linkman,sup_phone,sup_address,sup_remark) values ('��Ϊ��Ӧ��','С��','12388888889','�㶫����','һ����Ӧ��');
--delete t.* from supplier t where t.sup_id in (4,5);

select * from account;
select * from supplier;
