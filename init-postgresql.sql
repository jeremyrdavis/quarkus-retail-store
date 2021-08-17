DROP SCHEMA IF EXISTS retail CASCADE ;
CREATE SCHEMA retail AUTHORIZATION retailuser;

alter table if exists InvoiceRecord
    drop constraint if exists FKaywo2rhq6hrv7o8ebvnq47ql;

alter table if exists InvoiceRecord_InvoiceLine
    drop constraint if exists FKq9y7d1ot5ji810bfa25yxuiql;

alter table if exists InvoiceRecord_InvoiceLine
    drop constraint if exists FK3qghceljrvdm3wojrft6ocjvy;

drop table if exists InvoiceHeader cascade;

drop table if exists InvoiceLine cascade;

drop table if exists InvoiceRecord cascade;

drop table if exists InvoiceRecord_InvoiceLine cascade;

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;

create table InvoiceHeader (
                               id int8 not null,
                               date timestamp,
                               numberOfLines int4 not null,
                               storeId varchar(255),
                               totalDollarAmount float8,
                               primary key (id)
);
create table InvoiceLine (
                             id int8 not null,
                             billQuantity int4 not null,
                             extendedPrice float8,
                             productDescripiton varchar(255),
                             skuId varchar(255),
                             unitOfMeasure int4,
                             unitPrice float8,
                             primary key (id)
);

create table InvoiceRecord (
                               id int8 not null,
                               customerName varchar(255),
                               invoiceHeader_id int8,
                               primary key (id)
);

create table InvoiceRecord_InvoiceLine (
                                           InvoiceRecord_id int8 not null,
                                           invoiceLines_id int8 not null
);

alter table if exists InvoiceRecord_InvoiceLine
    add constraint UK_54y2ilxw0auooty9nbef19lbv unique (invoiceLines_id);

alter table if exists InvoiceRecord
    add constraint FKaywo2rhq6hrv7o8ebvnq47ql
    foreign key (invoiceHeader_id)
    references InvoiceHeader;

alter table if exists InvoiceRecord_InvoiceLine
    add constraint FKq9y7d1ot5ji810bfa25yxuiql
    foreign key (invoiceLines_id)
    references InvoiceLine;

alter table if exists InvoiceRecord_InvoiceLine
    add constraint FK3qghceljrvdm3wojrft6ocjvy
    foreign key (InvoiceRecord_id)
    references InvoiceRecord;
