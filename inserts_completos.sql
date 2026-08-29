-- SCRIPT DE IMPORTACION MASIVA CORREGIDO Y COMPLETO CON DATOS MUESTRA

-- TABLA: rol
INSERT INTO rol (id_rol, nombre_rol) VALUES (1, 'ADMIN'), (2, 'CLIENTE'), (3, 'RECICLADOR') ON CONFLICT (id_rol) DO NOTHING;

-- TABLA: tipo_de_actividad
INSERT INTO tipo_de_actividad (id_tipo_actividad, "descripción") VALUES
(1, 'Plástico PET'), (2, 'Cartón Corrugado'), (3, 'Vidrio Transparente'), (4, 'Vidrio Color'),
(5, 'Papel Blanco'), (6, 'Periódico y Revistas'), (7, 'Latas de Aluminio'), (8, 'Chatarra Ferrosa'),
(9, 'Pilas Alcalinas'), (10, 'Baterías de Litio'), (11, 'Residuos Electrónicos (RAEE)'), (12, 'Aceite Usado'),
(13, 'Madera y Parihuelas'), (14, 'Ropa Usada'), (15, 'Tapitas Plásticas')
ON CONFLICT (id_tipo_actividad) DO NOTHING;

-- TABLA: centro_reciclaje
INSERT INTO centro_reciclaje (id_centro_reciclaje, latitud, longitud, direccion) VALUES
(1, -12.1219, -77.0298, 'Av. Larco 400, Miraflores'),
(2, -12.1245, -77.0012, 'Ovalo Higuereta, Surco'),
(3, -12.0863, -76.9765, 'Jockey Plaza, Surco'),
(4, -12.122, -77.03, 'Parque Kennedy, Miraflores'),
(5, -12.0964, -77.0069, 'Ovalo Quiñones, San Borja'),
(6, -12.0876, -77.0023, 'La Rambla, San Borja'),
(7, -12.0433, -76.9242, 'Real Plaza Puruchuco, Ate'),
(8, -12.0456, -76.9532, 'Mercado Productores, Santa Anita'),
(9, -12.0765, -77.0765, 'Plaza San Miguel, San Miguel'),
(10, -12.0712, -77.0865, 'Parque de las Leyendas, San Miguel'),
(11, -12.0567, -77.0367, 'Centro Cívico, Cercado'),
(12, -12.0623, -77.0365, 'Parque de la Exposición, Cercado'),
(13, -12.0067, -77.0589, 'Plaza Norte, Independencia'),
(14, -11.9934, -77.0621, 'MegaPlaza, Independencia'),
(15, -12.0456, -77.1098, 'Minka, Callao'),
(16, -12.0567, -77.0987, 'Mall Plaza Bellavista, Callao'),
(17, -12.1765, -77.0123, 'Plaza Lima Sur, Chorrillos'),
(18, -12.1654, -77.0234, 'Malecón Grau, Chorrillos'),
(19, -12.0987, -77.0321, 'Bosque El Olivar, San Isidro'),
(20, -12.1023, -77.0345, 'Ovalo Gutierrez, San Isidro'),
(21, -12.0678, -77.0423, 'Campo de Marte, Jesus Maria'),
(22, -12.089, -77.0512, 'Real Plaza Salaverry, Jesus Maria'),
(23, -12.0888, -77.0399, 'Parque Castilla, Lince'),
(24, -12.0834, -77.0345, 'Plaza Vea Risso, Lince'),
(25, -11.9321, -77.0456, 'Mercado Central, Comas'),
(26, -11.9212, -77.0512, 'Parque Sinchi Roca, Comas'),
(27, -11.9425, -76.7028, 'Plaza de Armas, Lurigancho-Chosica'),
(28, -11.9761, -76.7681, 'Parque Principal, Chaclacayo'),
(29, -12.0812, -77.0167, 'Estación Cultura, La Victoria'),
(30, -12.0654, -77.0143, 'Gamarra, La Victoria')
ON CONFLICT (id_centro_reciclaje) DO NOTHING;

-- TABLA: usuario
INSERT INTO usuario (edad, enabled, id_user, puntos_acumulados, rol_id, dni, genero, telefono, apellidos, nombres, username, correo, distrito, password) VALUES
(30, 't', 1, 0, 1, 12345678, 'Masculino', 999999999, 'General', 'Admin', 'admin', 'admin@reciclaje.pe', 'Lima', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'),
(25, 't', 2, 350, 2, '23456789', 'Masculino', '987654321', 'Pérez', 'Juan', 'juan_perez', 'juan@reciclaje.pe', 'Miraflores', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'),
(28, 't', 3, 700, 2, '34567890', 'Femenino', '987654322', 'Gómez', 'María', 'maria_gomez', 'maria@reciclaje.pe', 'Surco', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'),
(40, 't', 4, 150, 3, '45678901', 'Masculino', '987654323', 'Lucas', 'Reciclador', 'reciclador_lucas', 'lucas@reciclaje.pe', 'Ate', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'),
(22, 't', 5, 120, 2, '56789012', 'Femenino', '987654324', 'López', 'Ana', 'ana_lopez', 'ana@reciclaje.pe', 'San Borja', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu')
ON CONFLICT (id_user) DO NOTHING;

-- TABLA: noticias
INSERT INTO noticias (fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo) VALUES
('2026-04-01', 1, 1, 'Trae botellas este fin de semana.', 'Campaña PET'),
('2026-04-02', 2, 2, 'Abrimos acopio en Miraflores.', 'Nuevo Local'),
('2026-04-03', 3, 3, 'Marcha ecológica en toda la ciudad.', 'Día del Vidrio'),
('2026-04-04', 9, 4, 'San Miguel cerrado el viernes.', 'Cierre Temporal'),
('2026-04-07', 3, 7, 'Superamos la meta del mes.', 'Récord en Surco'),
('2026-04-08', 24, 8, 'Módulos en supermercados.', 'Alianza Metro'),
('2026-04-09', 14, 9, 'Recicla tapitas plásticas.', 'Ayuda a Niños'),
('2026-04-10', 21, 10, 'Acopio de electrónicos viejos.', 'Campaña RAEE'),
('2026-04-11', NULL, 11, 'Impacto de la ley actual.', 'No al Tecnopor'),
('2026-04-12', 25, 12, 'Convertidas en canchas.', 'Llantas Usadas'),
('2026-04-13', 19, 13, 'Taller este sábado.', 'Compost Urbano'),
('2026-04-14', 18, 14, 'Limpieza de playa Costa Verde.', 'Voluntariado'),
('2026-04-16', 5, 16, 'No las tires a la basura.', 'Pilas Seguras'),
('2026-04-17', 20, 17, 'Campaña para empresas.', 'Papel de Oficina'),
('2026-04-20', 10, 20, 'Hazlos con envolturas.', 'Eco-Ladrillos'),
('2026-04-21', 4, 21, 'Reconocimiento facial activado.', 'Módulo VIP'),
('2026-04-23', 11, 23, 'Eventos programados.', 'Día de la Tierra'),
('2026-04-24', 15, 24, 'Acopio en el Callao.', 'Chatarra Férrea'),
('2026-04-25', 13, 25, 'Nuevos tachos disponibles.', 'Tetra Pak'),
('2026-04-27', 29, 27, 'Campaña de invierno.', 'Ropa Usada'),
('2026-04-29', 22, 29, 'No lo tires al lavadero.', 'Aceite Usado'),
('2026-04-05', NULL, 31, 'Gana el doble de puntos reciclando plastico en cualquiera de los centro. ¡Corre y recicla ya!', 'El plastico vale el doble hoy.'),
('2026-04-05', 3, 5, 'Aprende a separar residuos.', 'Tips en Casa'),
('2026-04-06', 3, 6, 'Nuevo catálogo de recompensas.', 'Premios 2026'),
('2026-04-15', 3, 15, 'Ropa hecha de plástico PET.', 'Moda Sostenible'),
('2026-04-18', 3, 18, 'Descarga la nueva versión.', 'App Actualizada'),
('2026-04-19', 3, 19, 'Cómo nos ayuda el reciclaje.', 'Huella de Carbono'),
('2026-04-22', 3, 22, 'Participa reciclando cartón.', 'Sorteo Bici'),
('2026-04-26', 3, 26, 'Resultados del primer trimestre.', 'Metas Logradas'),
('2026-04-28', 3, 28, 'Juguetes reciclados.', 'Mascotas Eco'),
('2026-04-30', 3, 30, 'Cerramos el mes con éxito.', 'Gracias a Todos'),
('2026-04-05', NULL, 32, 'Gana el doble de puntos reciclando plastico. ¡Corre y recicla ya!', 'Campaña especial: El plástico vale el doble hoy')
ON CONFLICT (id_noticias) DO NOTHING;

-- TABLA: notificaciones
INSERT INTO notificaciones (id_notificaciones, mensaje, fecha_notificacion, id_user, id_noticias) VALUES
(1, 'Campaña especial de PET iniciada en Miraflores!', '2026-06-20', 2, 1),
(2, '¡Aprovecha el doble de puntos hoy!', '2026-06-20', 3, 1)
ON CONFLICT (id_notificaciones) DO NOTHING;

-- TABLA: actividad
INSERT INTO actividad (id_actividad, fecha_recepcion, puntos, cantidad, estado, codigo_reserva, id_tipo_de_actividad, id_centro_reciclaje, id_user) VALUES
(1, '2026-06-15', 100, 10, 'APROBADA', 'REC-001-XYZ', 1, 1, 2),
(2, '2026-06-16', 50, 5, 'APROBADA', 'REC-002-ABC', 2, 2, 3),
(3, '2026-06-18', 200, 20, 'PENDIENTE', 'REC-003-DEF', 3, 3, 5)
ON CONFLICT (id_actividad) DO NOTHING;

-- TABLA: recompensas
INSERT INTO recompensas (costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa) VALUES
(500, '2026-12-31', 1, 100, 'Válido en Plaza Vea o Metro', 'Vale S/20 Metro'),
(600, '2026-05-15', 4, 40, 'Botella térmica 500ml', 'Tomatodo de Bambú'),
(800, '2026-12-31', 5, -1, 'Suscripción básica 30 días', 'Mes de Streaming'),
(250, '2026-12-31', 6, 80, 'Bambú con funda', 'Set de Cubiertos'),
(200, '2026-12-31', 7, 300, 'Movistar, Claro o Entel', 'Recarga S/10'),
(400, '2026-12-31', 9, 30, 'Ajuste general', 'Mantenimiento Bici'),
(350, '2026-12-31', 10, 50, '1 semana gratis', 'Pase Gimnasio'),
(180, '2026-12-31', 11, 120, '100 hojas recicladas', 'Libreta Ecológica'),
(100, '2026-12-31', 12, 200, 'Cartón reciclado', 'Set 5 Lapiceros'),
(1200, '2026-12-31', 13, 15, 'Hecha de botellas', 'Mochila PET'),
(700, '2026-12-31', 14, 40, 'Vale S/30 descuento', 'Restaurante Vegano'),
(300, '2026-12-31', 15, -1, '1 mes gratis', 'Curso Online'),
(220, '2026-12-31', 16, 60, 'Saco de 5kg', 'Abono Orgánico'),
(150, '2026-12-31', 17, 150, 'Tomate y albahaca', 'Semillas Huerto'),
(280, '2026-12-31', 18, 80, 'Set de 3 unidades', 'Macetas Bio'),
(200, '2026-12-31', 19, 100, 'Paquete de 4', 'Cepillos Bambú'),
(120, '2026-12-31', 20, 150, 'Ingredientes naturales', 'Jabón Artesanal'),
(180, '2026-12-31', 21, 140, 'Sin empaque', 'Champú Sólido'),
(250, '2026-12-31', 22, 90, 'Diseño Héroe Reciclaje', 'Taza Cerámica'),
(900, '2026-12-31', 23, 25, 'Material reciclado', 'Audífonos Eco'),
(600, '2026-12-31', 24, 45, 'Fieltro reciclado', 'Funda Laptop'),
(500, '2026-12-31', 25, -1, 'Ayuda a la selva S/20', 'Donación ONG'),
(500, '2026-12-31', 26, -1, 'Donación de S/20', 'Refugio Animal'),
(100, '2026-12-01', 27, 1000, '1 Ticket diciembre', 'Sorteo Scooter'),
(150, '2026-12-31', 28, 200, '30% en locales', 'Descuento Café'),
(400, '2026-12-31', 29, 100, 'Suscripción 6 meses', 'Revista Eco'),
(250, '2026-12-31', 30, 300, 'Recarga S/10', 'Metropolitano'),
(150, '2026-06-30', 2, 49, 'Bolsa de tela 100% algodón', 'Bolsa Ecológica'),
(300, '2026-10-31', 3, 19, 'Entrada Cineplanet', 'Entrada Cine 2D'),
(150, '2026-12-31', 8, 99, '15% en tiendas afiliadas', 'Descuento Ropa Eco')
ON CONFLICT (id_recompensas) DO NOTHING;

-- TABLA: reclamaciones
INSERT INTO reclamaciones (id_reclamacion, id_recompensa, id_usuario) VALUES
(1, 4, 2),
(2, 1, 3)
ON CONFLICT (id_reclamacion) DO NOTHING;

-- TABLA: favoritos
INSERT INTO favoritos (id_favorito, id_user, id_centro_reciclaje) VALUES
(1, 2, 1),
(2, 2, 4),
(3, 3, 2),
(4, 3, 3)
ON CONFLICT (id_favorito) DO NOTHING;

