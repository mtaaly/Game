--<ScriptOptions statementTerminator=";"/>

ALTER TABLE JOINPERSONTOEVENT DROP CONSTRAINT FKADE892A05A3D6D00;

ALTER TABLE JOINPERSONTOEVENT DROP CONSTRAINT FKADE892A09222F74;

ALTER TABLE PERSONDETAIL DROP CONSTRAINT FKC88F60269222F74;

ALTER TABLE PERSON DROP CONSTRAINT SQL141217015748500;

ALTER TABLE EVENTTYP DROP CONSTRAINT SQL141224123825940;

ALTER TABLE PERSONINFO DROP CONSTRAINT SQL141224123826030;

ALTER TABLE PERSONDETAIL DROP CONSTRAINT SQL141224123826000;

ALTER TABLE REGISTRATION DROP CONSTRAINT SQL141221041937410;

ALTER TABLE EMPLOYEE DROP CONSTRAINT SQL141217015607950;

DROP INDEX SQL141224123826080;

DROP INDEX SQL141224123826130;

DROP INDEX SQL141224123826030;

DROP INDEX SQL141224123826000;

DROP INDEX SQL141217015748500;

DROP INDEX SQL141224123825940;

DROP INDEX SQL141221041937410;

DROP INDEX SQL141217015607950;

DROP INDEX SQL141224123826110;

DROP TABLE EVENTTB;

DROP TABLE JOINPERSONTOEVENT;

DROP TABLE EMPLOYEE;

DROP TABLE REGISTRATION;

DROP TABLE PERSONINFO;

DROP TABLE PERSONDETAIL;

DROP TABLE EVENTTYP;

DROP TABLE HIBERNATE_UNIQUE_KEY;

DROP TABLE PERSON;

CREATE TABLE EVENTTB (
		EVENTKEY VARCHAR(255),
		SEQUENCE_NEXT_HI_VALUE INTEGER
	);

CREATE TABLE JOINPERSONTOEVENT (
		PERSONID INTEGER NOT NULL,
		EVENTID INTEGER NOT NULL
	);

CREATE TABLE EMPLOYEE (
		EMPLOYEID INTEGER NOT NULL,
		EMPLOYENAME VARCHAR(255)
	);

CREATE TABLE REGISTRATION (
		REGISTRATIONID INTEGER NOT NULL,
		ADRESSE VARCHAR(255),
		BIRTHDAY DATE,
		EMAIL VARCHAR(255) NOT NULL,
		FIRSTNAME VARCHAR(255),
		LASTNAME VARCHAR(255)
	);

CREATE TABLE PERSONINFO (
		PERSONID INTEGER NOT NULL,
		FIRSTNAME VARCHAR(255),
		LASTNAME VARCHAR(255)
	);

CREATE TABLE PERSONDETAIL (
		ADRESSE VARCHAR(255),
		EMAIL VARCHAR(255),
		NUMBER BIGINT,
		PERSONID INTEGER NOT NULL
	);

CREATE TABLE EVENTTYP (
		EVENTID INTEGER NOT NULL,
		EVENTNAME VARCHAR(255)
	);

CREATE TABLE HIBERNATE_UNIQUE_KEY (
		NEXT_HI INTEGER
	);

CREATE TABLE PERSON (
		PERSONID INTEGER NOT NULL,
		ADRESSE VARCHAR(255),
		EMAIL VARCHAR(255),
		FIRSTNAME VARCHAR(255),
		LASTNAME VARCHAR(255),
		NUMBER BIGINT NOT NULL
	);

CREATE INDEX SQL141224123826080 ON JOINPERSONTOEVENT (EVENTID ASC);

CREATE INDEX SQL141224123826130 ON PERSONDETAIL (PERSONID ASC);

CREATE UNIQUE INDEX SQL141224123826030 ON PERSONINFO (PERSONID ASC);

CREATE UNIQUE INDEX SQL141224123826000 ON PERSONDETAIL (PERSONID ASC);

CREATE UNIQUE INDEX SQL141217015748500 ON PERSON (PERSONID ASC);

CREATE UNIQUE INDEX SQL141224123825940 ON EVENTTYP (EVENTID ASC);

CREATE UNIQUE INDEX SQL141221041937410 ON REGISTRATION (REGISTRATIONID ASC);

CREATE UNIQUE INDEX SQL141217015607950 ON EMPLOYEE (EMPLOYEID ASC);

CREATE INDEX SQL141224123826110 ON JOINPERSONTOEVENT (PERSONID ASC);

ALTER TABLE PERSON ADD CONSTRAINT SQL141217015748500 PRIMARY KEY (PERSONID);

ALTER TABLE EVENTTYP ADD CONSTRAINT SQL141224123825940 PRIMARY KEY (EVENTID);

ALTER TABLE PERSONINFO ADD CONSTRAINT SQL141224123826030 PRIMARY KEY (PERSONID);

ALTER TABLE PERSONDETAIL ADD CONSTRAINT SQL141224123826000 PRIMARY KEY (PERSONID);

ALTER TABLE REGISTRATION ADD CONSTRAINT SQL141221041937410 PRIMARY KEY (REGISTRATIONID);

ALTER TABLE EMPLOYEE ADD CONSTRAINT SQL141217015607950 PRIMARY KEY (EMPLOYEID);

ALTER TABLE JOINPERSONTOEVENT ADD CONSTRAINT FKADE892A05A3D6D00 FOREIGN KEY (EVENTID)
	REFERENCES EVENTTYP (EVENTID);

ALTER TABLE JOINPERSONTOEVENT ADD CONSTRAINT FKADE892A09222F74 FOREIGN KEY (PERSONID)
	REFERENCES PERSONINFO (PERSONID);

ALTER TABLE PERSONDETAIL ADD CONSTRAINT FKC88F60269222F74 FOREIGN KEY (PERSONID)
	REFERENCES PERSONINFO (PERSONID);

