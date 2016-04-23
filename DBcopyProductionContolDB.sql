--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-01-14 20:44:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16674)
-- Name: ProductionControl; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "ProductionControl";


ALTER SCHEMA "ProductionControl" OWNER TO postgres;

SET search_path = "ProductionControl", pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 202 (class 1259 OID 16690)
-- Name: CookTechnology; Type: TABLE; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

CREATE TABLE "CookTechnology" (
    "Id" integer NOT NULL,
    "Name" character varying(200),
    "Description" text,
    "MainTheses" character varying(100)
);


ALTER TABLE "CookTechnology" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16688)
-- Name: CookTechnology_Id_seq; Type: SEQUENCE; Schema: ProductionControl; Owner: postgres
--

CREATE SEQUENCE "CookTechnology_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "CookTechnology_Id_seq" OWNER TO postgres;

--
-- TOC entry 2106 (class 0 OID 0)
-- Dependencies: 201
-- Name: CookTechnology_Id_seq; Type: SEQUENCE OWNED BY; Schema: ProductionControl; Owner: postgres
--

ALTER SEQUENCE "CookTechnology_Id_seq" OWNED BY "CookTechnology"."Id";


--
-- TOC entry 204 (class 1259 OID 16701)
-- Name: Product; Type: TABLE; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

CREATE TABLE "Product" (
    "Id" integer NOT NULL,
    "LeavenStartDate" date,
    "LeavenEndDate" date,
    "Recipt" integer,
    "CookTechnology" integer,
    "DistillationStartDate" date,
    "DistillationEndDate" date,
    "Name" character varying(100),
    "Description" text
);


ALTER TABLE "Product" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16699)
-- Name: Product_Id_seq; Type: SEQUENCE; Schema: ProductionControl; Owner: postgres
--

CREATE SEQUENCE "Product_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Product_Id_seq" OWNER TO postgres;

--
-- TOC entry 2107 (class 0 OID 0)
-- Dependencies: 203
-- Name: Product_Id_seq; Type: SEQUENCE OWNED BY; Schema: ProductionControl; Owner: postgres
--

ALTER SEQUENCE "Product_Id_seq" OWNED BY "Product"."Id";


--
-- TOC entry 200 (class 1259 OID 16677)
-- Name: Recipt; Type: TABLE; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

CREATE TABLE "Recipt" (
    "Id" integer NOT NULL,
    "Name" character varying(200),
    "Description" text,
    "MainIngredients" character varying(250),
    "Water" character varying(100)
);


ALTER TABLE "Recipt" OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16675)
-- Name: Recipt_Id_seq; Type: SEQUENCE; Schema: ProductionControl; Owner: postgres
--

CREATE SEQUENCE "Recipt_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Recipt_Id_seq" OWNER TO postgres;

--
-- TOC entry 2108 (class 0 OID 0)
-- Dependencies: 199
-- Name: Recipt_Id_seq; Type: SEQUENCE OWNED BY; Schema: ProductionControl; Owner: postgres
--

ALTER SEQUENCE "Recipt_Id_seq" OWNED BY "Recipt"."Id";


--
-- TOC entry 1976 (class 2604 OID 16693)
-- Name: Id; Type: DEFAULT; Schema: ProductionControl; Owner: postgres
--

ALTER TABLE ONLY "CookTechnology" ALTER COLUMN "Id" SET DEFAULT nextval('"CookTechnology_Id_seq"'::regclass);


--
-- TOC entry 1977 (class 2604 OID 16704)
-- Name: Id; Type: DEFAULT; Schema: ProductionControl; Owner: postgres
--

ALTER TABLE ONLY "Product" ALTER COLUMN "Id" SET DEFAULT nextval('"Product_Id_seq"'::regclass);


--
-- TOC entry 1975 (class 2604 OID 16680)
-- Name: Id; Type: DEFAULT; Schema: ProductionControl; Owner: postgres
--

ALTER TABLE ONLY "Recipt" ALTER COLUMN "Id" SET DEFAULT nextval('"Recipt_Id_seq"'::regclass);


--
-- TOC entry 2098 (class 0 OID 16690)
-- Dependencies: 202
-- Data for Name: CookTechnology; Type: TABLE DATA; Schema: ProductionControl; Owner: postgres
--



--
-- TOC entry 2109 (class 0 OID 0)
-- Dependencies: 201
-- Name: CookTechnology_Id_seq; Type: SEQUENCE SET; Schema: ProductionControl; Owner: postgres
--

SELECT pg_catalog.setval('"CookTechnology_Id_seq"', 1, false);


--
-- TOC entry 2100 (class 0 OID 16701)
-- Dependencies: 204
-- Data for Name: Product; Type: TABLE DATA; Schema: ProductionControl; Owner: postgres
--



--
-- TOC entry 2110 (class 0 OID 0)
-- Dependencies: 203
-- Name: Product_Id_seq; Type: SEQUENCE SET; Schema: ProductionControl; Owner: postgres
--

SELECT pg_catalog.setval('"Product_Id_seq"', 1, false);


--
-- TOC entry 2096 (class 0 OID 16677)
-- Dependencies: 200
-- Data for Name: Recipt; Type: TABLE DATA; Schema: ProductionControl; Owner: postgres
--

INSERT INTO "Recipt" ("Id", "Name", "Description", "MainIngredients", "Water") VALUES (1, 'односолодовый виски', 'fine thing', NULL, NULL);
INSERT INTO "Recipt" ("Id", "Name", "Description", "MainIngredients", "Water") VALUES (2, 'многосолодовый виски', '76% of alcogol', NULL, NULL);
INSERT INTO "Recipt" ("Id", "Name", "Description", "MainIngredients", "Water") VALUES (3, 'самогон', 'просто самогон', NULL, NULL);
INSERT INTO "Recipt" ("Id", "Name", "Description", "MainIngredients", "Water") VALUES (7, 'some new', 'new fine recipt', NULL, NULL);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 199
-- Name: Recipt_Id_seq; Type: SEQUENCE SET; Schema: ProductionControl; Owner: postgres
--

SELECT pg_catalog.setval('"Recipt_Id_seq"', 30, true);


--
-- TOC entry 1981 (class 2606 OID 16698)
-- Name: CookTechnologyId_PK; Type: CONSTRAINT; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "CookTechnology"
    ADD CONSTRAINT "CookTechnologyId_PK" PRIMARY KEY ("Id");


--
-- TOC entry 1983 (class 2606 OID 16709)
-- Name: ProductId_PK; Type: CONSTRAINT; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Product"
    ADD CONSTRAINT "ProductId_PK" PRIMARY KEY ("Id");


--
-- TOC entry 1979 (class 2606 OID 16685)
-- Name: RECIPT_PK_ID; Type: CONSTRAINT; Schema: ProductionControl; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Recipt"
    ADD CONSTRAINT "RECIPT_PK_ID" PRIMARY KEY ("Id");


--
-- TOC entry 1985 (class 2606 OID 16715)
-- Name: ProductCookTechnology; Type: FK CONSTRAINT; Schema: ProductionControl; Owner: postgres
--

ALTER TABLE ONLY "Product"
    ADD CONSTRAINT "ProductCookTechnology" FOREIGN KEY ("CookTechnology") REFERENCES "CookTechnology"("Id") MATCH FULL;


--
-- TOC entry 1984 (class 2606 OID 16710)
-- Name: ProductRecipt_FK; Type: FK CONSTRAINT; Schema: ProductionControl; Owner: postgres
--

ALTER TABLE ONLY "Product"
    ADD CONSTRAINT "ProductRecipt_FK" FOREIGN KEY ("Recipt") REFERENCES "Recipt"("Id") MATCH FULL;


--
-- TOC entry 2105 (class 0 OID 0)
-- Dependencies: 7
-- Name: ProductionControl; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA "ProductionControl" FROM PUBLIC;
REVOKE ALL ON SCHEMA "ProductionControl" FROM postgres;
GRANT ALL ON SCHEMA "ProductionControl" TO postgres;
GRANT ALL ON SCHEMA "ProductionControl" TO PUBLIC;


-- Completed on 2016-01-14 20:44:10

--
-- PostgreSQL database dump complete
--

