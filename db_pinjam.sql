--------------------------------------------------------
--  File created - Monday-March-13-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PTI_PINJAM
--------------------------------------------------------

  CREATE TABLE "SIA"."PTI_PINJAM" 
   (	"ID_PEMINJAM" VARCHAR2(20 BYTE), 
	"ID_BUKU" NUMBER, 
	"TANGGAL_PINJAM" DATE, 
	"WAKTU_PINJAM" NUMBER, 
	"TANGGAL_KEMBALI" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SIA.PTI_PINJAM
SET DEFINE OFF;
Insert into SIA.PTI_PINJAM (ID_PEMINJAM,ID_BUKU,TANGGAL_PINJAM,WAKTU_PINJAM,TANGGAL_KEMBALI) values ('145314042',9780596529260001,to_date('13-MAR-17','DD-MON-RR'),7,to_date('20-MAR-17','DD-MON-RR'));
--------------------------------------------------------
--  Constraints for Table PTI_PINJAM
--------------------------------------------------------

  ALTER TABLE "SIA"."PTI_PINJAM" MODIFY ("WAKTU_PINJAM" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_PINJAM" MODIFY ("TANGGAL_PINJAM" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_PINJAM" MODIFY ("ID_BUKU" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_PINJAM" MODIFY ("ID_PEMINJAM" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PTI_PINJAM
--------------------------------------------------------

  ALTER TABLE "SIA"."PTI_PINJAM" ADD CONSTRAINT "PTI_PINJAM_FK1" FOREIGN KEY ("ID_PEMINJAM")
	  REFERENCES "SIA"."PTI_ANGGOTA" ("ID") ENABLE;
  ALTER TABLE "SIA"."PTI_PINJAM" ADD CONSTRAINT "PTI_PINJAM_FK2" FOREIGN KEY ("ID_BUKU")
	  REFERENCES "SIA"."PTI_BUKU" ("ID") ENABLE;
