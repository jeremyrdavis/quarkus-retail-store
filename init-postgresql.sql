DROP SCHEMA IF EXISTS retail CASCADE ;
CREATE SCHEMA retail AUTHORIZATION retailuser;

alter table if exists Inventory
drop constraint if exists FKe8d7b0luyty2opvmeo1x34dcr
Hibernate:

alter table if exists InvoiceRecord
drop constraint if exists FKaywo2rhq6hrv7o8ebvnq47ql
Hibernate:

alter table if exists InvoiceRecord_InvoiceLine
drop constraint if exists FKq9y7d1ot5ji810bfa25yxuiql
Hibernate:

alter table if exists InvoiceRecord_InvoiceLine
drop constraint if exists FKf8pp5qkad3bbjuow8s27x2y7v
Hibernate:

alter table if exists Supplier
drop constraint if exists FKnbhhssg9ymhg745xxj0mvtxap
Hibernate:

alter table if exists Supplier
drop constraint if exists FKnjq1be3bo3roe58bj11u6dfoy
Hibernate:

alter table if exists Supplier
drop constraint if exists FK5mrlj4ard2kgby8llosdtwo5u
Hibernate:

drop table if exists Address cascade
    Hibernate:

drop table if exists Inventory cascade
    Hibernate:

drop table if exists InvoiceHeader cascade
    Hibernate:

drop table if exists InvoiceLine cascade
    Hibernate:

drop table if exists InvoiceRecord cascade
    Hibernate:

drop table if exists InvoiceRecord_InvoiceLine cascade
    Hibernate:

drop table if exists ProductMaster cascade
    Hibernate:

drop table if exists Supplier cascade
    Hibernate:

drop sequence if exists hibernate_sequence
    Hibernate: create sequence hibernate_sequence start 1 increment 1
Hibernate:

create table Address (
                         id int8 not null,
                         primary key (id)
)
    Hibernate:

create table Inventory (
                           id int8 not null,
                           backOrderQuantity int4 not null,
                           inStockQuantity int4 not null,
                           lastSaleDate timestamp,
                           lastStockDate timestamp,
                           maxRetailPrice numeric(19, 2),
                           maximumQuantity int4 not null,
                           minimumQuantity int4 not null,
                           orderQuantity int4 not null,
                           unitCost numeric(19, 2),
                           productMaster_product_id varchar(255),
                           primary key (id)
)
    Hibernate:

create table InvoiceHeader (
                               id int8 not null,
                               date timestamp,
                               numberOfLines int4 not null,
                               storeId varchar(255),
                               totalDollarAmount float8,
                               primary key (id)
)
    Hibernate:

create table InvoiceLine (
                             id int8 not null,
                             billQuantity numeric(19, 2),
                             extendedPrice numeric(19, 2),
                             productDescripiton varchar(255),
                             skuId varchar(255),
                             unitOfMeasure int4,
                             unitPrice float8,
                             primary key (id)
)
    Hibernate:

create table InvoiceRecord (
                               invoice_id varchar(255) not null,
                               customerName varchar(255),
                               invoiceHeader_id int8,
                               primary key (invoice_id)
)
    Hibernate:

create table InvoiceRecord_InvoiceLine (
                                           InvoiceRecord_invoice_id varchar(255) not null,
                                           invoiceLines_id int8 not null
)
    Hibernate:

create table ProductMaster (
                               product_id varchar(255) not null,
                               description varchar(255),
                               primary key (product_id)
)
    Hibernate:

create table Supplier (
                          id int8 not null,
                          name varchar(255),
                          billingAddress_id int8,
                          mailingAddress_id int8,
                          shippingAddress_id int8,
                          primary key (id)
)
    Hibernate:

alter table if exists InvoiceRecord_InvoiceLine
    add constraint UK_54y2ilxw0auooty9nbef19lbv unique (invoiceLines_id)
    Hibernate:

alter table if exists Inventory
    add constraint FKe8d7b0luyty2opvmeo1x34dcr
    foreign key (productMaster_product_id)
    references ProductMaster
    Hibernate:

alter table if exists InvoiceRecord
    add constraint FKaywo2rhq6hrv7o8ebvnq47ql
    foreign key (invoiceHeader_id)
    references InvoiceHeader
    Hibernate:

alter table if exists InvoiceRecord_InvoiceLine
    add constraint FKq9y7d1ot5ji810bfa25yxuiql
    foreign key (invoiceLines_id)
    references InvoiceLine
    Hibernate:

alter table if exists InvoiceRecord_InvoiceLine
    add constraint FKf8pp5qkad3bbjuow8s27x2y7v
    foreign key (InvoiceRecord_invoice_id)
    references InvoiceRecord
    Hibernate:

alter table if exists Supplier
    add constraint FKnbhhssg9ymhg745xxj0mvtxap
    foreign key (billingAddress_id)
    references Address
    Hibernate:

alter table if exists Supplier
    add constraint FKnjq1be3bo3roe58bj11u6dfoy
    foreign key (mailingAddress_id)
    references Address
    Hibernate:

alter table if exists Supplier
    add constraint FK5mrlj4ard2kgby8llosdtwo5u
    foreign key (shippingAddress_id)
    references Address
/** Insert Data **/
insert into