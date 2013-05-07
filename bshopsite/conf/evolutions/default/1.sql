# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table appointment (
  id                        bigint not null,
  notes                     varchar(255),
  datetime                  timestamp,
  req_barber_username       varchar(255),
  req_customer_username     varchar(255),
  constraint pk_appointment primary key (id))
;

create table catalogitem (
  id                        bigint not null,
  title                     varchar(255),
  description               varchar(255),
  image_url                 varchar(255),
  author_username           varchar(255),
  constraint pk_catalogitem primary key (id))
;

create table user (
  username                  varchar(255) not null,
  usertype                  varchar(1),
  password                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  phone                     varchar(255),
  constraint ck_user_usertype check (usertype in ('C','E','A')),
  constraint pk_user primary key (username))
;

create sequence appointment_seq;

create sequence catalogitem_seq;

create sequence user_seq;

alter table appointment add constraint fk_appointment_reqBarber_1 foreign key (req_barber_username) references user (username) on delete restrict on update restrict;
create index ix_appointment_reqBarber_1 on appointment (req_barber_username);
alter table appointment add constraint fk_appointment_reqCustomer_2 foreign key (req_customer_username) references user (username) on delete restrict on update restrict;
create index ix_appointment_reqCustomer_2 on appointment (req_customer_username);
alter table catalogitem add constraint fk_catalogitem_author_3 foreign key (author_username) references user (username) on delete restrict on update restrict;
create index ix_catalogitem_author_3 on catalogitem (author_username);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists appointment;

drop table if exists catalogitem;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists appointment_seq;

drop sequence if exists catalogitem_seq;

drop sequence if exists user_seq;

