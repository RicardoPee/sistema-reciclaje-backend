--
-- PostgreSQL database dump
--

\restrict 6BTu33kYFP37l4roYabkfxe3sMQzuIBVyI3ZWARn5xwIgGW0PYZN7IdlnfsyKHb

-- Dumped from database version 17.6
-- Dumped by pg_dump version 17.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: centro_reciclaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (1, -12.1219, -77.0298, 'Av. Larco 400, Miraflores');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (2, -12.1245, -77.0012, 'Ovalo Higuereta, Surco');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (3, -12.0863, -76.9765, 'Jockey Plaza, Surco');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (4, -12.122, -77.03, 'Parque Kennedy, Miraflores');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (5, -12.0964, -77.0069, 'Ovalo Quiñones, San Borja');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (6, -12.0876, -77.0023, 'La Rambla, San Borja');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (7, -12.0433, -76.9242, 'Real Plaza Puruchuco, Ate');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (8, -12.0456, -76.9532, 'Mercado Productores, Santa Anita');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (9, -12.0765, -77.0765, 'Plaza San Miguel, San Miguel');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (10, -12.0712, -77.0865, 'Parque de las Leyendas, San Miguel');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (11, -12.0567, -77.0367, 'Centro Cívico, Cercado');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (12, -12.0623, -77.0365, 'Parque de la Exposición, Cercado');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (13, -12.0067, -77.0589, 'Plaza Norte, Independencia');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (14, -11.9934, -77.0621, 'MegaPlaza, Independencia');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (15, -12.0456, -77.1098, 'Minka, Callao');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (16, -12.0567, -77.0987, 'Mall Plaza Bellavista, Callao');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (17, -12.1765, -77.0123, 'Plaza Lima Sur, Chorrillos');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (18, -12.1654, -77.0234, 'Malecón Grau, Chorrillos');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (19, -12.0987, -77.0321, 'Bosque El Olivar, San Isidro');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (20, -12.1023, -77.0345, 'Ovalo Gutierrez, San Isidro');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (21, -12.0678, -77.0423, 'Campo de Marte, Jesus Maria');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (22, -12.089, -77.0512, 'Real Plaza Salaverry, Jesus Maria');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (23, -12.0888, -77.0399, 'Parque Castilla, Lince');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (24, -12.0834, -77.0345, 'Plaza Vea Risso, Lince');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (25, -11.9321, -77.0456, 'Mercado Central, Comas');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (26, -11.9212, -77.0512, 'Parque Sinchi Roca, Comas');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (27, -11.9425, -76.7028, 'Plaza de Armas, Lurigancho-Chosica');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (28, -11.9761, -76.7681, 'Parque Principal, Chaclacayo');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (29, -12.0812, -77.0167, 'Estación Cultura, La Victoria');
INSERT INTO public.centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES (30, -12.0654, -77.0143, 'Gamarra, La Victoria');


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rol (id_rol, nombre_rol) VALUES (1, 'ADMINISTRADOR');
INSERT INTO public.rol (id_rol, nombre_rol) VALUES (2, 'USUARIO');


--
-- Data for Name: tipo_de_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (1, 'Plástico PET');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (2, 'Cartón Corrugado');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (3, 'Vidrio Transparente');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (4, 'Vidrio Color');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (5, 'Papel Blanco');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (6, 'Periódico y Revistas');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (7, 'Latas de Aluminio');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (8, 'Chatarra Ferrosa');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (9, 'Pilas Alcalinas');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (10, 'Baterías de Litio');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (11, 'Residuos Electrónicos (RAEE)');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (12, 'Aceite Usado');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (13, 'Madera y Parihuelas');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (14, 'Ropa Usada');
INSERT INTO public.tipo_de_actividad (id_tipo_actividad, "descripción") VALUES (15, 'Tapitas Plásticas');


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario (edad, enabled, id_user, puntos_acumulados, rol_id, dni, genero, telefono, apellidos, nombres, username, correo, distrito, password) VALUES (30, true, 1, 0, 1, '12345678', 'Masculino', '999999999', 'General', 'Admin', 'admin', 'admin@reciclaje.pe', 'Lima', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu');


--
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: favoritos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: noticias; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-01', 1, 1, 'Trae botellas este fin de semana.', 'Campaña PET');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-02', 2, 2, 'Abrimos acopio en Miraflores.', 'Nuevo Local');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-03', 3, 3, 'Marcha ecológica en toda la ciudad.', 'Día del Vidrio');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-04', 9, 4, 'San Miguel cerrado el viernes.', 'Cierre Temporal');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-07', 3, 7, 'Superamos la meta del mes.', 'Récord en Surco');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-08', 24, 8, 'Módulos en supermercados.', 'Alianza Metro');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-09', 14, 9, 'Recicla tapitas plásticas.', 'Ayuda a Niños');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-10', 21, 10, 'Acopio de electrónicos viejos.', 'Campaña RAEE');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-11', NULL, 11, 'Impacto de la ley actual.', 'No al Tecnopor');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-12', 25, 12, 'Convertidas en canchas.', 'Llantas Usadas');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-13', 19, 13, 'Taller este sábado.', 'Compost Urbano');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-14', 18, 14, 'Limpieza de playa Costa Verde.', 'Voluntariado');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-16', 5, 16, 'No las tires a la basura.', 'Pilas Seguras');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-17', 20, 17, 'Campaña para empresas.', 'Papel de Oficina');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-20', 10, 20, 'Hazlos con envolturas.', 'Eco-Ladrillos');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-21', 4, 21, 'Reconocimiento facial activado.', 'Módulo VIP');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-23', 11, 23, 'Eventos programados.', 'Día de la Tierra');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-24', 15, 24, 'Acopio en el Callao.', 'Chatarra Férrea');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-25', 13, 25, 'Nuevos tachos disponibles.', 'Tetra Pak');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-27', 29, 27, 'Campaña de invierno.', 'Ropa Usada');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-29', 22, 29, 'No lo tires al lavadero.', 'Aceite Usado');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-05', NULL, 31, 'Gana el doble de puntos reciclando plastico en cualquiera de los centro. ¡Corre y recicla ya!', 'El plastico vale el doble hoy.');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-05', 3, 5, 'Aprende a separar residuos.', 'Tips en Casa');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-06', 3, 6, 'Nuevo catálogo de recompensas.', 'Premios 2026');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-15', 3, 15, 'Ropa hecha de plástico PET.', 'Moda Sostenible');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-18', 3, 18, 'Descarga la nueva versión.', 'App Actualizada');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-19', 3, 19, 'Cómo nos ayuda el reciclaje.', 'Huella de Carbono');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-22', 3, 22, 'Participa reciclando cartón.', 'Sorteo Bici');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-26', 3, 26, 'Resultados del primer trimestre.', 'Metas Logradas');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-28', 3, 28, 'Juguetes reciclados.', 'Mascotas Eco');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-30', 3, 30, 'Cerramos el mes con éxito.', 'Gracias a Todos');
INSERT INTO public.noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES ('2026-04-05', NULL, 32, 'Gana el doble de puntos reciclando plastico. ¡Corre y recicla ya!', 'Campaña especial: El plástico vale el doble hoy');


--
-- Data for Name: notificaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: recompensas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (500, '2026-12-31', 1, 100, 'Válido en Plaza Vea o Metro', 'Vale S/20 Metro');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (600, '2026-05-15', 4, 40, 'Botella térmica 500ml', 'Tomatodo de Bambú');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (800, '2026-12-31', 5, -1, 'Suscripción básica 30 días', 'Mes de Streaming');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (250, '2026-12-31', 6, 80, 'Bambú con funda', 'Set de Cubiertos');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (200, '2026-12-31', 7, 300, 'Movistar, Claro o Entel', 'Recarga S/10');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (400, '2026-12-31', 9, 30, 'Ajuste general', 'Mantenimiento Bici');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (350, '2026-12-31', 10, 50, '1 semana gratis', 'Pase Gimnasio');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (180, '2026-12-31', 11, 120, '100 hojas recicladas', 'Libreta Ecológica');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (100, '2026-12-31', 12, 200, 'Cartón reciclado', 'Set 5 Lapiceros');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (1200, '2026-12-31', 13, 15, 'Hecha de botellas', 'Mochila PET');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (700, '2026-12-31', 14, 40, 'Vale S/30 descuento', 'Restaurante Vegano');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (300, '2026-12-31', 15, -1, '1 mes gratis', 'Curso Online');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (220, '2026-12-31', 16, 60, 'Saco de 5kg', 'Abono Orgánico');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (150, '2026-12-31', 17, 150, 'Tomate y albahaca', 'Semillas Huerto');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (280, '2026-12-31', 18, 80, 'Set de 3 unidades', 'Macetas Bio');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (200, '2026-12-31', 19, 100, 'Paquete de 4', 'Cepillos Bambú');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (120, '2026-12-31', 20, 150, 'Ingredientes naturales', 'Jabón Artesanal');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (180, '2026-12-31', 21, 140, 'Sin empaque', 'Champú Sólido');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (250, '2026-12-31', 22, 90, 'Diseño Héroe Reciclaje', 'Taza Cerámica');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (900, '2026-12-31', 23, 25, 'Material reciclado', 'Audífonos Eco');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (600, '2026-12-31', 24, 45, 'Fieltro reciclado', 'Funda Laptop');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (500, '2026-12-31', 25, -1, 'Ayuda a la selva S/20', 'Donación ONG');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (500, '2026-12-31', 26, -1, 'Donación de S/20', 'Refugio Animal');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (100, '2026-12-01', 27, 1000, '1 Ticket diciembre', 'Sorteo Scooter');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (150, '2026-12-31', 28, 200, '30% en locales', 'Descuento Café');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (400, '2026-12-31', 29, 100, 'Suscripción 6 meses', 'Revista Eco');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (250, '2026-12-31', 30, 300, 'Recarga S/10', 'Metropolitano');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (150, '2026-06-30', 2, 49, 'Bolsa de tela 100% algodón', 'Bolsa Ecológica');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (300, '2026-10-31', 3, 19, 'Entrada Cineplanet', 'Entrada Cine 2D');
INSERT INTO public.recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES (150, '2026-12-31', 8, 99, '15% en tiendas afiliadas', 'Descuento Ropa Eco');


--
-- Data for Name: reclamaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: actividad_id_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.actividad_id_actividad_seq', 1, false);


--
-- Name: centro_reciclaje_id_centro_reciclaje_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.centro_reciclaje_id_centro_reciclaje_seq', 30, true);


--
-- Name: favoritos_id_favorito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.favoritos_id_favorito_seq', 1, false);


--
-- Name: noticias_id_noticias_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.noticias_id_noticias_seq', 32, true);


--
-- Name: notificaciones_id_notificaciones_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notificaciones_id_notificaciones_seq', 1, false);


--
-- Name: reclamaciones_id_reclamacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reclamaciones_id_reclamacion_seq', 1, false);


--
-- Name: recompensas_id_recompensas_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recompensas_id_recompensas_seq', 30, true);


--
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 2, true);


--
-- Name: tipo_de_actividad_id_tipo_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_de_actividad_id_tipo_actividad_seq', 15, true);


--
-- Name: usuario_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_user_seq', 1, true);


--
-- PostgreSQL database dump complete
--

\unrestrict 6BTu33kYFP37l4roYabkfxe3sMQzuIBVyI3ZWARn5xwIgGW0PYZN7IdlnfsyKHb

