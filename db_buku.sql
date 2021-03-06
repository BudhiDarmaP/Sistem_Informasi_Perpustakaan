--------------------------------------------------------
--  File created - Wednesday-April-12-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PTI_BUKU
--------------------------------------------------------

  CREATE TABLE "SIA"."PTI_BUKU" 
   (	"ISBN" VARCHAR2(14 BYTE), 
	"JUDUL" VARCHAR2(250 BYTE), 
	"PENULIS" VARCHAR2(50 BYTE), 
	"TAHUN_TERBIT" VARCHAR2(4 BYTE), 
	"PENERBIT" VARCHAR2(50 BYTE), 
	"KETERSEDIAAN" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SIA.PTI_BUKU
SET DEFINE OFF;
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9781476763262','Dark Territory: The Secret History of Cyber War','Fred Kaplan','2017','Simon & Schuster',1);
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9780596000950','Programming Web Services with SOAP','James Snell, Doug Tidwell, Pavel Kulchenko','2001','O''Reilly Media',2);
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9780596529260','RESTful Web Services ','Leonard Richardson, Sam Ruby','2007','O''Reilly Media',1);
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9781449356569','PHP Web Services','Lorna Jane Mitchell','2013','O''Reilly Media',2);
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9781455539741','Hamilton: The Revolution','Lin-Manuel Miranda','2016','Grand Central',1);
Insert into SIA.PTI_BUKU (ISBN,JUDUL,PENULIS,TAHUN_TERBIT,PENERBIT,KETERSEDIAAN) values ('9781484225820','Building a 2D Game Physics Engine: Using HTML5 and JavaScript','Michael Tanaya, Hua Ming Chen, dkk','2017','Apress',1);
--------------------------------------------------------
--  DDL for Index PTI_BUKU_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SIA"."PTI_BUKU_PK" ON "SIA"."PTI_BUKU" ("ISBN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PTI_BUKU
--------------------------------------------------------

  ALTER TABLE "SIA"."PTI_BUKU" ADD CONSTRAINT "PTI_BUKU_PK" PRIMARY KEY ("ISBN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("KETERSEDIAAN" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("PENERBIT" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("TAHUN_TERBIT" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("PENULIS" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("JUDUL" NOT NULL ENABLE);
  ALTER TABLE "SIA"."PTI_BUKU" MODIFY ("ISBN" NOT NULL ENABLE);
