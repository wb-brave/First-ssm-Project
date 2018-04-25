drop database if exists ssm;

create database ssm default character set utf8;

use ssm;

drop table if exists account;

drop table if exists sys_param;

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
/*====================================ϵͳ������==============================*/
/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   sys_param_id         bigint  auto_increment,
   sys_param_field      varchar(50),
   sys_param_value      varchar(500),
   sys_param_text       varchar(50),
   sys_param_type       varchar(2),   
   primary key (sys_param_id)
);
insert into sys_param(sys_param_field,sys_param_value,sys_param_type) values('shId','select s.sh_id as sys_param_value,s.sh_name as sys_param_text from store_house s','1');


insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','1','һ����Ӧ��');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','2','������Ӧ��');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','3','��ͨ��Ӧ��');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','1','��ɫ');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','2','��ɫ');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','3','��ɫ');
select * from sys_param;


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
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (6,'Nokia��Ӧ��','С��','12388888777','�㶫���ڴ�Ӫ˪Ҷ��Ӫ����ҪҪ����Ͷ��޹���','һ����Ӧ��',0,2);

/*�����Ʒ��Ϣ*/
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('1','note4','��','1','red note4',2500.00,2000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('2','note5','��','5','red note5',3500.00,3000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('3','note6','��','6','blue note5',4500.00,4000.00);

/*��Ӳֿ���Ϣ*/
insert into store_house (sh_id,sh_name,sh_address) values('1','���ֿ�','����');
insert into store_house (sh_id,sh_name,sh_address) values('2','�ֲֿ�','����');

select * from account;
select * from supplier;
select * from goods;
select * from store_house;

/*=================================����ģ��===================================*/

drop table if exists account_records;

drop table if exists buy_order;

drop table if exists buy_order_detail;

drop table if exists return_order;

drop table if exists return_order_deatil;

/*==============================================================*/
/* Table: account_records   
���		ar_id,
�����̱��	sup_id��
����		ar_date��
����(��ͬ���͵��Ų�һ����ad_order_id��
����(ҵ�����ͣ�ar_bus_type��
Ӧ��		ar_payable��
ʵ��		ar_paid��
Ƿ��		ar_arrears��
�Żݽ��	ar_discount��
������		ar_attn��
����Ա		ar_operator��
��ע		ar_remark
                                    */
/*==============================================================*/
create table account_records
(
   ar_id                varchar(36) not null,
   sup_id               int,
   ar_date              date,
   ar_order_id          varchar(36),
   ar_bus_type          varchar(10),
   ar_payable           decimal(12,2),
   ar_paid              decimal(12,2),
   ar_arrears           decimal(12,2),
   ar_discount          decimal(12,2),
   ar_attn              varchar(20),
   ar_operator          int,
   ar_remark            varchar(100),
   primary key (ar_id)
);

/*==============================================================*/
/* Table: buy_order  
����     	bo_id��
������  	sup_id��
�ֿ�      	sh_id��
�ջ�����  	bo_date��
Ӧ����ʵ��+Ƿ��+�Żݣ�bo_payable��
ʵ��      	bo_paid��
Ƿ��		bo_Arrears��
ԭʼ����	bo_original_id��
��ע		bo_remark��
������		bo_attn��
����Ա		operator

                                           */
/*==============================================================*/
create table buy_order
(
   bo_id                varchar(36) not null,
   sup_id               int,
   sh_id                varchar(10),
   bo_date              date,
   bo_payable           decimal(12,2),
   bo_paid              decimal(12,2),
   bo_arrears           decimal(12,2),
   bo_original          varchar(20),
   bo_remark            varchar(100),
   bo_attn              varchar(20),
   bo_operator          int,
   primary key (bo_id)
);

/*==============================================================*/
/* Table: buy_order_detail     
���		bod_id��
��ƷID	goods_id������
 goods_name           varchar(20),
   goods_type           varchar(10),
   goods_color          varchar(10),
��λ		goods_unit��
���� 		bod_amount��
����		bod_buy_price��
�ܽ����ޣ�bod_total_price��
 �ɹ�����	bo_id��
�ֻ������б�##�ָ���bod_IMEI_list
                                 */
/*==============================================================*/
create table buy_order_detail
(
   bod_id               varchar(36) not null,
   goods_id             varchar(36),
   goods_name           varchar(20),
   goods_unit           varchar(10),
   goods_type           varchar(10),
   goods_color          varchar(10),
   bod_amount           int,
   bod_buy_price        decimal(12,2),
   bod_total_price     decimal(12,2),
   bo_id                varchar(36),
   bod_imei_list        text,
   primary key (bod_id)
);

/*==============================================================*/
/* Table: return_order   
����		roId��
������	sup_id��
�ֿ�		sh_id��
�˻�����	ro_date��
Ӧ�˽��	ro_payable��
ʵ�˽��	ro_Paid��
��ע��	ro_remark,
������	ro_attn��
����Ա	ro_operator


                                       */
/*==============================================================*/
create table return_order
(
   ro_id                varchar(36) not null,
   sup_id               int,
   sh_id                varchar(10),
   ro_date              date,
   ro_payable           decimal(12,2),
   ro_paid              decimal(12,2),
   ro_remark            varchar(100),
   ro_attn              varchar(20),
   ro_operator          int,
   primary key (ro_id)
);

/*==============================================================*/
/* Table: return_order_deatil      
���		rod_id��
��Ʒ		goods_id��//����
 goods_name           varchar(20),
   goods_type           varchar(10),
   goods_color          varchar(10),
��λ		goods_unit��
����		rod_amount��
�˻�����	rod_return_price��
�ܽ����ޣ�rod_total_price��
 �ֻ������б�##�ָ���rod_imei_list
                             */
/*==============================================================*/
create table return_order_detail
(
   rod_id              varchar(36) not null,
   goods_id             varchar(36),
   goods_unit           varchar(10),
    goods_name           varchar(20),
   goods_type           varchar(10),
   goods_color          varchar(10),
   rod_amount           int,
   rod_return_price     decimal(12,2),
   rod_total_price      decimal(12,2),
   rod_imei_list        text,
   ro_id                varchar(36),
   primary key (rod_id)
);

drop table if exists user;

/*============================*/
/* Table: �û���ṹ 		  */
/*============================*/
create table user
(
   /* �û����,�Զ����� */
   user_id                  int not null ,
   /* �û���¼��  */
   user_login               varchar(20),
   /* �û�����  */
   user_name                varchar(20),
   /* �û����� */
   user_pass                varchar(20),
   user_phone            varchar(11),
   user_address          varchar(100),
   user_remark           varchar(100),
   user_type             varchar(10),
   /* ���ñ��Ϊ���� */
   primary key (user_id)
);


insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (1,'xz','zxz','123456','12388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (2,'xm','С��','223456','22388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (3,'xw','С��','323456','32388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (4,'xq','С��','423456','42388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (5,'xw','С��','523456','52388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (6,'xb','С��','623456','62388888887','���ݻ���','Ա��',1);

insert into user(user_id,user_login,user_name,user_pass,user_phone,user_address,user_remark,user_type)
values (7,'xt','С��','723456','72388888887','���ݻ���','Ա��',1);

select * from account;
select * from supplier;
select * from goods;
select * from sys_param;
select * from store_house;
select * from account_records;
select * from buy_order;
select * from buy_order_detail;
select * from return_order;
select * from return_order_detail;

	select sum(ar_payable) total,sup_name from account_records inner join supplier 
  	on account_records.sup_id=supplier.sup_id 
  	where ar_date >#{start} and ar_date<=#{end} and ar_bus_type='bo' 
  	group by sup_name;

select * from sys_param;
select s.sh_id as sys_param_value,s.sh_name as sys_param_text from store_house s