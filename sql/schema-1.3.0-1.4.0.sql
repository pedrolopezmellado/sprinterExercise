CREATE TABLE public.tableros (
     id bigint NOT NULL,
     contador_tareas integer NOT NULL,
     nombre character varying(255) NOT NULL,
     usuario_id bigint
);

ALTER TABLE public.tableros OWNER TO mads;

CREATE SEQUENCE public.tableros_id_seq
     START WITH 1
     INCREMENT BY 1
     NO MINVALUE
     NO MAXVALUE
     CACHE 1;
     
ALTER TABLE public.tableros_id_seq OWNER TO mads;

ALTER SEQUENCE public.tableros_id_seq OWNED BY public.tableros.id;

ALTER TABLE public.tareas
 ADD COLUMN fecha date,
 ADD COLUMN terminada boolean,
 ADD COLUMN equipo_id bigint,
 ADD COLUMN tablero_id bigint;

ALTER TABLE ONLY public.tableros ALTER COLUMN id SET DEFAULT nextval('public.tableros_id_seq'::regclass);

ALTER TABLE ONLY public.tableros
 ADD CONSTRAINT tableros_pkey PRIMARY KEY (id);
 
ALTER TABLE ONLY public.tareas
 ADD CONSTRAINT fk7a7bbe0arnbqnrekrryoab7je FOREIGN KEY (equipo_id) REFERENCES public.equipos(id) ON DELETE CASCADE;

ALTER TABLE ONLY public.tableros
 ADD CONSTRAINT fko6lw5x303hytm2gxdmndryyy0 FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);

ALTER TABLE ONLY public.tareas
 ADD CONSTRAINT fksqj5mtew63jjlb55n4yfxqq0 FOREIGN KEY (tablero_id) REFERENCES public.tableros(id);
