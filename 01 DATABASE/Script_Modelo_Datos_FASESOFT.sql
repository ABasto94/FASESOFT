
-- Generado por Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   en:        2019-09-20 16:02:52 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_accesos CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_accesos (
    id_acceso     NUMBER(18) NOT NULL,
    nombre        VARCHAR2(20 CHAR) NOT NULL,
    componente          VARCHAR2(250 CHAR) NOT NULL,
    descripcion   VARCHAR2(250 CHAR)
);

ALTER TABLE fas_accesos ADD CONSTRAINT fas_accesos_pk PRIMARY KEY ( id_acceso );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_afiliados CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_afiliados (
    correo                    VARCHAR2(40 CHAR) NOT NULL,
    nombre                    VARCHAR2(20 CHAR) NOT NULL,
    apellido                  VARCHAR2(20 CHAR) NOT NULL,
    telefono                  NUMBER(18),
    direccion                 VARCHAR2(30 CHAR),
    identificacion            NUMBER(18) NOT NULL,
    tipo_id                   VARCHAR2(4) NOT NULL,
    fecha_retiro              DATE,
    fecha_ingreso             DATE,
    cuenta_bancaria           VARCHAR2(15 BYTE) NOT NULL,
    total_otros_ahorros       NUMBER(10),
    banco                     VARCHAR2(15 BYTE) NOT NULL,
    expedicion                VARCHAR2(15 BYTE) NOT NULL,
    ciudad                    VARCHAR2(15 BYTE) NOT NULL,
    dependencia               VARCHAR2(15 BYTE) NOT NULL,
    estado_civil              VARCHAR2(15 BYTE) NOT NULL
    
);

ALTER TABLE fas_afiliados ADD CONSTRAINT fas_afiliados_pk PRIMARY KEY ( correo );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_ahorros CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_ahorros (
    id_ahorro                   NUMBER(18) NOT NULL,
    monto                       NUMBER(18) NOT NULL,
    fecha_inicio                DATE NOT NULL,
    estado                      VARCHAR2(20 CHAR) NOT NULL,
    aporte                      NUMBER(18) NOT NULL,
    fas_afiliados_correo        VARCHAR2(40 CHAR) NOT NULL,
    fas_tipos_aho_id_tipo_aho   NUMBER(18) NOT NULL,
    fecha_solicitud             DATE,
    fecha_inicio_aporte         DATE
);

ALTER TABLE fas_ahorros ADD CONSTRAINT fas_ahorros_pk PRIMARY KEY ( id_ahorro );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_aportes CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_aportes (
    id_aporte               NUMBER(18) NOT NULL,
    beneficio               NUMBER(18) NOT NULL,
    aporte                  NUMBER(18) NOT NULL,
    fecha_aporte            DATE NOT NULL,
    fas_ahorros_id_ahorro   NUMBER(18) NOT NULL,
    aportes_ordinarios      NUMBER(18) NOT NULL,
    ahorro_permanente       NUMBER(18) NOT NULL
);

ALTER TABLE fas_aportes ADD CONSTRAINT fas_aportes_pk PRIMARY KEY ( id_aporte );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_convenios CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_convenios (
    id_convenio                  NUMBER(18) NOT NULL,
    monto                        NUMBER(18) NOT NULL,
    saldo                        NUMBER(18) NOT NULL,
    fecha_inicio_convenio        DATE,
    estado                       VARCHAR2(10 BYTE) NOT NULL,
    numero_cuotas                NUMBER(10) NOT NULL,
    mora                         NUMBER(10) NOT NULL,
    fas_tipo_conv_id_tipo_conv   NUMBER(18) NOT NULL,
    fecha_solicitud              DATE,
    fecha_inicio_pago            DATE,
    cuotas_pendientes            NUMBER(10) NOT NULL,
    couta_intereses              NUMBER(18) NOT NULL,
    couta_seguro                 NUMBER(18) NOT NULL,
    cuota_aporte                 NUMBER(18) NOT NULL,
    url_imagen                   VARCHAR2(250 BYTE),
    principal                    VARCHAR2(10 BYTE)
);

ALTER TABLE fas_convenios ADD CONSTRAINT fas_convenios_pk PRIMARY KEY ( id_convenio );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_creditos CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_creditos (
    id_credito                     NUMBER(18) NOT NULL,
    tasa_real                      NUMBER(2, 2) NOT NULL,
    monto                          NUMBER(18) NOT NULL,
    saldo                          NUMBER(18) NOT NULL,
    fecha_inicio                   DATE,
    estado                         VARCHAR2(20 CHAR) NOT NULL,
    fas_afiliados_correo           VARCHAR2(40 CHAR) NOT NULL,
    fas_tipos_de_credito_id_tipo   NUMBER(18) NOT NULL,
    numero_cuotas                  NUMBER(18) NOT NULL,
    fecha_solicitud                DATE NOT NULL,
    mora                           NUMBER(18),
    fecha_desembolso               DATE,
    fecha_inicio_pago              DATE,
    cuotas_pendientes              NUMBER(10) NOT NULL
);

ALTER TABLE fas_creditos ADD CONSTRAINT fas_creditos_pk PRIMARY KEY ( id_credito );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_extractos CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_extractos (
    id_extracto            NUMBER(18) NOT NULL,
    url_extracto           VARCHAR2(250 BYTE) NOT NULL,
    nombre_extracto        VARCHAR2(50 BYTE),
    fecha_extracto         DATE NOT NULL,
    fas_afiliados_correo   VARCHAR2(40 CHAR) NOT NULL
);

ALTER TABLE fas_extractos ADD CONSTRAINT fas_extractos_pk PRIMARY KEY ( id_extracto );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_pagos CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_pagos (
    id_pago                   NUMBER(18) NOT NULL,
    cuota_total               NUMBER(18, 2) NOT NULL,
    fecha_de_pago             DATE NOT NULL,
    saldo                     NUMBER(18, 2) NOT NULL,
    fas_creditos_id_credito   NUMBER(18) NOT NULL,
    cuota_intereses           NUMBER(18, 2) NOT NULL,
    cuota_seguro              NUMBER(18, 2) NOT NULL,
    cuota_deuda               NUMBER(18, 2) NOT NULL
);

ALTER TABLE fas_pagos ADD CONSTRAINT fas_pagos_pk PRIMARY KEY ( id_pago );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_perfiles CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_perfiles (
    id_perfil   NUMBER(18) NOT NULL,
    tipo        VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE fas_perfiles ADD CONSTRAINT fas_perfiles_pk PRIMARY KEY ( id_perfil );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_permisos CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_permisos (
    id_permiso               NUMBER(18) NOT NULL,
    fas_perfiles_id_perfil   NUMBER(18) NOT NULL,
    fas_accesos_id_acceso    NUMBER(18) NOT NULL
);

ALTER TABLE fas_permisos ADD CONSTRAINT fas_permisos_pk PRIMARY KEY ( id_permiso );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_roles CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_roles (
    id_rol                    NUMBER(18) NOT NULL,
    fas_perfiles_id_perfil    NUMBER(18) NOT NULL,
    fas_usuarios_id_usuario   NUMBER(18) NOT NULL
);

ALTER TABLE fas_roles ADD CONSTRAINT fas_roles_pk PRIMARY KEY ( id_rol );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_sol_convenios CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_sol_convenios (
    id_solicitud                NUMBER(18) NOT NULL,
    fas_afiliados_correo        VARCHAR2(40 CHAR),
    fas_convenios_id_convenio   NUMBER(18) NOT NULL
);

ALTER TABLE fas_sol_convenios ADD CONSTRAINT fas_sol_convenios_pk PRIMARY KEY ( id_solicitud );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_tipos_convenio CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_tipos_convenio (
    id_tipo_convenio   NUMBER(18) NOT NULL,
    tipo               VARCHAR2(50 BYTE) NOT NULL,
    tasa               NUMBER(2, 2) NOT NULL,
    estado             VARCHAR2(10 BYTE) NOT NULL,
    descripcion        VARCHAR2(250 BYTE),
    url_convenio        VARCHAR2(250 BYTE)
);

ALTER TABLE fas_tipos_convenio ADD CONSTRAINT fas_tipos_convenio_pk PRIMARY KEY ( id_tipo_convenio );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_tipos_de_ahorro CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_tipos_de_ahorro (
    id_tipo_de_ahorro   NUMBER(18) NOT NULL,
    tipo                VARCHAR2(50 BYTE) NOT NULL,
    tasa                NUMBER(2, 2) NOT NULL,
    descripcion         VARCHAR2(250 BYTE)
);

ALTER TABLE fas_tipos_de_ahorro ADD CONSTRAINT fas_tipos_de_ahorro_pk PRIMARY KEY ( id_tipo_de_ahorro );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_tipos_de_credito CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_tipos_de_credito (
    id_tipo          NUMBER(18) NOT NULL,
    tipo             VARCHAR2(20 CHAR) NOT NULL,
    tasa             NUMBER(2, 2) NOT NULL,
    descripcion      VARCHAR2(250 CHAR),
    cuotas_maximas   NUMBER(18) NOT NULL,
    estado           VARCHAR2(10) NOT NULL
);

ALTER TABLE fas_tipos_de_credito ADD CONSTRAINT fas_tipos_de_credito_pk PRIMARY KEY ( id_tipo );

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE fas_usuarios CASCADE CONSTRAINT';
EXCEPTION
    WHEN OTHERS THEN
    NULL;
    END;
/

CREATE TABLE fas_usuarios (
    id_usuario             NUMBER(18) NOT NULL,
    contraseña             VARCHAR2(30 BYTE),
    estado                 VARCHAR2(10 BYTE),
    fecha_cracion          DATE,
    fas_afiliados_correo   VARCHAR2(40 CHAR) NOT NULL
);

CREATE UNIQUE INDEX fas_usuarios__idx ON
    fas_usuarios (
        fas_afiliados_correo
    ASC );

ALTER TABLE fas_usuarios ADD CONSTRAINT fas_usuarios_pk PRIMARY KEY ( id_usuario );


ALTER TABLE fas_ahorros
    ADD CONSTRAINT fas_ahor_fas_tipos_aho_fk FOREIGN KEY ( fas_tipos_aho_id_tipo_aho )
        REFERENCES fas_tipos_de_ahorro ( id_tipo_de_ahorro );

ALTER TABLE fas_ahorros
    ADD CONSTRAINT fas_ahorros_fas_afiliados_fk FOREIGN KEY ( fas_afiliados_correo )
        REFERENCES fas_afiliados ( correo );

ALTER TABLE fas_aportes
    ADD CONSTRAINT fas_aportes_fas_ahorros_fk FOREIGN KEY ( fas_ahorros_id_ahorro )
        REFERENCES fas_ahorros ( id_ahorro );

ALTER TABLE fas_convenios
    ADD CONSTRAINT fas_conv_fas_tipo_conv_fk FOREIGN KEY ( fas_tipo_conv_id_tipo_conv )
        REFERENCES fas_tipos_convenio ( id_tipo_convenio );

ALTER TABLE fas_creditos
    ADD CONSTRAINT fas_cred_fas_tipo_cred_fk FOREIGN KEY ( fas_tipos_de_credito_id_tipo )
        REFERENCES fas_tipos_de_credito ( id_tipo );

ALTER TABLE fas_creditos
    ADD CONSTRAINT fas_creditos_fas_afiliados_fk FOREIGN KEY ( fas_afiliados_correo )
        REFERENCES fas_afiliados ( correo );

ALTER TABLE fas_extractos
    ADD CONSTRAINT fas_extractos_fas_afiliados_fk FOREIGN KEY ( fas_afiliados_correo )
        REFERENCES fas_afiliados ( correo );

ALTER TABLE fas_pagos
    ADD CONSTRAINT fas_pagos_fas_creditos_fk FOREIGN KEY ( fas_creditos_id_credito )
        REFERENCES fas_creditos ( id_credito );

ALTER TABLE fas_permisos
    ADD CONSTRAINT fas_permisos_fas_accesos_fk FOREIGN KEY ( fas_accesos_id_acceso )
        REFERENCES fas_accesos ( id_acceso );

ALTER TABLE fas_permisos
    ADD CONSTRAINT fas_permisos_fas_perfiles_fk FOREIGN KEY ( fas_perfiles_id_perfil )
        REFERENCES fas_perfiles ( id_perfil );

ALTER TABLE fas_roles
    ADD CONSTRAINT fas_roles_fas_perfiles_fk FOREIGN KEY ( fas_perfiles_id_perfil )
        REFERENCES fas_perfiles ( id_perfil );

ALTER TABLE fas_roles
    ADD CONSTRAINT fas_roles_fas_usuarios_fk FOREIGN KEY ( fas_usuarios_id_usuario )
        REFERENCES fas_usuarios ( id_usuario );

ALTER TABLE fas_sol_convenios
    ADD CONSTRAINT fas_sol_conv_fas_afili_fk FOREIGN KEY ( fas_afiliados_correo )
        REFERENCES fas_afiliados ( correo );

ALTER TABLE fas_sol_convenios
    ADD CONSTRAINT fas_sol_conv_fas_conv_fk FOREIGN KEY ( fas_convenios_id_convenio )
        REFERENCES fas_convenios ( id_convenio );

ALTER TABLE fas_usuarios
    ADD CONSTRAINT fas_usuarios_fas_afiliados_fk FOREIGN KEY ( fas_afiliados_correo )
        REFERENCES fas_afiliados ( correo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            16
-- CREATE INDEX                             2
-- ALTER TABLE                             32
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
INSERT INTO FAS_AFILIADOS VALUES( 'aclavijo@asesoftware.com','Andres', 'Clavijo', 8622936, 'AV PRADILLA #2-00',1072707304,
                                'CC',NULL,TO_DATE('29/07/2019','DD/MM/YYYY'),'AA-102039',100000);
INSERT INTO FAS_USUARIOS VALUES( 1, 'RRSEM1203', 'ACTIVO', TO_DATE('29/07/2019','DD/MM/YYYY'), 'aclavijo@asesoftware.com');
INSERT INTO FAS_PERFILES VALUES( 1,'ADMINISTRADOR');
INSERT INTO FAS_ROLES VALUES (1,1,1);
INSERT INTO FAS_ACCESOS VALUES(1, 'AFILIADOS', '/layout/fas-afiliados/base','AFILIADOS');
INSERT INTO FAS_ACCESOS VALUES(2, 'ACCESOS', '/layout/fas-accesos/base','ACCESOS');
INSERT INTO FAS_ACCESOS VALUES(3, 'AFILIADOS', '/layout/fas-afiliados/base','AFILIADOS');
INSERT INTO FAS_ACCESOS VALUES(4, 'AHORROS', '/layout/fas-ahorros/base','AHORROS');
INSERT INTO FAS_ACCESOS VALUES(5, 'APORTES', '/layout/fas-aportes/base','APORTES');
INSERT INTO FAS_ACCESOS VALUES(6, 'CONVENIOS', '/layout/fas-convenios/base','CONVENIOS');
INSERT INTO FAS_ACCESOS VALUES(7, 'CREDITOS', '/layout/fas-creditos/base','CREDITOS');
INSERT INTO FAS_ACCESOS VALUES(8, 'PAGOS', '/layout/fas-pagos/base','PAGOS');
INSERT INTO FAS_ACCESOS VALUES(9, 'EXTRACTOS', '/layout/fas-extractos/fas-extractos-list','EXTRACTOS');
INSERT INTO FAS_ACCESOS VALUES(10, 'INICIO', '/layout/home','INICIO');
INSERT INTO FAS_PERMISOS VALUES(1,1,1);
INSERT INTO FAS_PERMISOS VALUES(2,1,2);
INSERT INTO FAS_PERMISOS VALUES(3,1,3);
INSERT INTO FAS_PERMISOS VALUES(4,1,4);
INSERT INTO FAS_PERMISOS VALUES(5,1,5);
INSERT INTO FAS_PERMISOS VALUES(6,1,6);
INSERT INTO FAS_PERMISOS VALUES(7,1,7);
INSERT INTO FAS_PERMISOS VALUES(8,1,8);
INSERT INTO FAS_PERMISOS VALUES(9,1,9);
INSERT INTO FAS_PERMISOS VALUES(10,1,10);
