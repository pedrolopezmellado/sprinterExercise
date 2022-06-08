--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4 (Debian 13.4-4.pgdg110+1)
-- Dumped by pg_dump version 13.4 (Debian 13.4-4.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: equipo_usuario; Type: TABLE; Schema: public; Owner: mads
--

CREATE TABLE public.equipo_usuario (
    fk_equipo bigint NOT NULL,
    fk_usuario bigint NOT NULL
);


ALTER TABLE public.equipo_usuario OWNER TO mads;

--
-- Name: equipos; Type: TABLE; Schema: public; Owner: mads
--

CREATE TABLE public.equipos (
    id bigint NOT NULL,
    descripcion character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.equipos OWNER TO mads;

--
-- Name: equipos_id_seq; Type: SEQUENCE; Schema: public; Owner: mads
--

CREATE SEQUENCE public.equipos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipos_id_seq OWNER TO mads;

--
-- Name: equipos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mads
--

ALTER SEQUENCE public.equipos_id_seq OWNED BY public.equipos.id;


--
-- Name: tableros; Type: TABLE; Schema: public; Owner: mads
--

CREATE TABLE public.tableros (
    id bigint NOT NULL,
    contador_tareas integer NOT NULL,
    nombre character varying(255) NOT NULL,
    usuario_id bigint
);


ALTER TABLE public.tableros OWNER TO mads;

--
-- Name: tableros_id_seq; Type: SEQUENCE; Schema: public; Owner: mads
--

CREATE SEQUENCE public.tableros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tableros_id_seq OWNER TO mads;

--
-- Name: tableros_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mads
--

ALTER SEQUENCE public.tableros_id_seq OWNED BY public.tableros.id;


--
-- Name: tareas; Type: TABLE; Schema: public; Owner: mads
--

CREATE TABLE public.tareas (
    id bigint NOT NULL,
    fecha date,
    terminada boolean,
    titulo character varying(255) NOT NULL,
    equipo_id bigint,
    tablero_id bigint,
    usuario_id bigint NOT NULL
);


ALTER TABLE public.tareas OWNER TO mads;

--
-- Name: tareas_id_seq; Type: SEQUENCE; Schema: public; Owner: mads
--

CREATE SEQUENCE public.tareas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tareas_id_seq OWNER TO mads;

--
-- Name: tareas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mads
--

ALTER SEQUENCE public.tareas_id_seq OWNED BY public.tareas.id;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: mads
--

CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    administrador boolean NOT NULL,
    bloqueado boolean NOT NULL,
    email character varying(255) NOT NULL,
    fecha_nacimiento date,
    nombre character varying(255),
    password character varying(255)
);


ALTER TABLE public.usuarios OWNER TO mads;

--
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: mads
--

CREATE SEQUENCE public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_seq OWNER TO mads;

--
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mads
--

ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;


--
-- Name: equipos id; Type: DEFAULT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.equipos ALTER COLUMN id SET DEFAULT nextval('public.equipos_id_seq'::regclass);


--
-- Name: tableros id; Type: DEFAULT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tableros ALTER COLUMN id SET DEFAULT nextval('public.tableros_id_seq'::regclass);


--
-- Name: tareas id; Type: DEFAULT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tareas ALTER COLUMN id SET DEFAULT nextval('public.tareas_id_seq'::regclass);


--
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);


--
-- Name: equipo_usuario equipo_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.equipo_usuario
    ADD CONSTRAINT equipo_usuario_pkey PRIMARY KEY (fk_equipo, fk_usuario);


--
-- Name: equipos equipos_pkey; Type: CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.equipos
    ADD CONSTRAINT equipos_pkey PRIMARY KEY (id);


--
-- Name: tableros tableros_pkey; Type: CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tableros
    ADD CONSTRAINT tableros_pkey PRIMARY KEY (id);


--
-- Name: tareas tareas_pkey; Type: CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT tareas_pkey PRIMARY KEY (id);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- Name: tareas fk7a7bbe0arnbqnrekrryoab7je; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT fk7a7bbe0arnbqnrekrryoab7je FOREIGN KEY (equipo_id) REFERENCES public.equipos(id) ON DELETE CASCADE;


--
-- Name: tareas fkdmoaxl7yv4q6vkc9h32wvbddr; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT fkdmoaxl7yv4q6vkc9h32wvbddr FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- Name: equipo_usuario fkk4y9gec15ccnirp3r7w29o66p; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.equipo_usuario
    ADD CONSTRAINT fkk4y9gec15ccnirp3r7w29o66p FOREIGN KEY (fk_equipo) REFERENCES public.equipos(id);


--
-- Name: tableros fko6lw5x303hytm2gxdmndryyy0; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tableros
    ADD CONSTRAINT fko6lw5x303hytm2gxdmndryyy0 FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- Name: equipo_usuario fksabsvjgvfuen6hmyg7gn7oq4v; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.equipo_usuario
    ADD CONSTRAINT fksabsvjgvfuen6hmyg7gn7oq4v FOREIGN KEY (fk_usuario) REFERENCES public.usuarios(id);


--
-- Name: tareas fksqj5mtew63jjlb55n4yfxqq0; Type: FK CONSTRAINT; Schema: public; Owner: mads
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT fksqj5mtew63jjlb55n4yfxqq0 FOREIGN KEY (tablero_id) REFERENCES public.tableros(id);


--
-- PostgreSQL database dump complete
--

