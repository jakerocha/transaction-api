CREATE TABLE IF NOT EXISTS public.todos
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    nome character varying(255) COLLATE pg_catalog."default",
    prioridade integer NOT NULL,
    realizado boolean NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT todos_pkey PRIMARY KEY (id)
)