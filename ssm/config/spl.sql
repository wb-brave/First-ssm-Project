drop database if exists ssm;
create database ssm default character set utf8;
use ssm;
drop table if exists account;
drop table if exists goods;
drop table if exists store_house;
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
/* Table: goods                                                 */
/*==============================================================*/
/*
goods_Id         ��Ʒ���
   goods_name           ��Ʒ����
   goods_unit          ��Ʒ����
   goods_type           ����
   goods_color          ��ɫ,
   goods_store          �������,
   goods_limit          ��Ч���޸�ʱ��,
   goods_commission     ���,
   goods_producer       ������
   goods_remark         ��ע,
   goods_sel_price        �ۼ�
   goods_buy_price         ����
                                               */
/*==============================================================*/
create table goods
(
   goods_Id             varchar(36) not null,
   goods_name           varchar(20),
   goods_unit           varchar(10),
   goods_type           varchar(10),
   goods_color          varchar(10),
   goods_store          int,
   goods_limit          int,
   goods_commission     decimal(2,2),
   goods_producer       varchar(50),
   goods_remark         varchar(100),
   goods_sel_price      decimal(12,2),
   goods_buy_price      decimal(12,2),
   primary key (goods_Id)
);


/*==============================================================*/
/* Table: store_house                                           */
/*
   sh_id                �ֿ���,
   sh_name              �ֿ�����,
   sh_responsible       ������,
   sh_phone             ��ϵ�绰,
   sh_address           ��ϵ��ַ,
   sh_type              �ֿ�����,
   sh_remark            ��ע,
*/
/*==============================================================*/
create table store_house
(
   sh_id                varchar(10) not null,
   sh_name              varchar(20),
   sh_responsible       varchar(20),
   sh_phone             varchar(11),
   sh_address           varchar(50),
   sh_type              varchar(10),
   sh_remark            varchar(100),
   primary key (sh_id)
);

/*==============================================================*/
/* Table: supplier                                              */  
/*==============================================================*/
/*                   
sup_id               ���,
   sup_name             ��Ӧ������,
   sup_linkman          ��ϵ��,
   sup_phone            �绰,
   sup_address          ��ַ,
   sup_remark           ��ע,
   sup_pay              �ڳ�Ӧ��,
   sup_type             ����,
*/ 
/*==============================================================*/
/*==============================================================*/
create table supplier
(
   sup_id               int not null,
   sup_name             varchar(20),
   sup_linkman          varchar(20),
   sup_phone            varchar(11),
   sup_address          varchar(100),
   sup_remark           varchar(100),
   sup_pay              decimal(12,2),
   sup_type             varchar(10),
   primary key (sup_id)
);

/* ����ʻ�����, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* ��ӹ�Ӧ������, */
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (1,'ƻ����Ӧ��','С��','12388888887','���ݻ���','��ͨ��Ӧ��',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (2,'���ǹ�Ӧ��','С��','12388888888','��������','��ͨ��Ӧ��',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (3,'��Ϊ��Ӧ��','С��','12388888889','�㶫����','һ����Ӧ��',0,2);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (4,'TCL��Ӧ��','С��','12388888666','��������','��ͨ��Ӧ��',0,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (5,'Nokia��Ӧ��','С��','12388888777','�㶫����','һ����Ӧ��',0,2);
/*�����Ʒ��Ϣ*/
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('1','note4','��','1','red note4',2500.00,2000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('2','note5','��','5','red note5',3500.00,3000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('3','note6','��','6','blue note5',4500.00,4000.00);
/*��Ӳֿ���Ϣ*/
insert into store_house(sh_id,sh_name,sh_address) values('1','���ֿ�','�㶫ʡ������');
insert into store_house(sh_id,sh_name,sh_address) values('2','���ڷֲֿ�','�㶫ʡ������');



select * from account;
select * from supplier;
select * from goods;
select * from store_house;
