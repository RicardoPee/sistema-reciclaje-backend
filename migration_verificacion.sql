-- =====================================================
-- MIGRACIÓN: Sistema de Verificación de Actividades
-- Ejecutar UNA SOLA VEZ contra la base de datos
-- =====================================================

-- 1. Agregar columna estado (si no existe ya)
ALTER TABLE actividad ADD COLUMN IF NOT EXISTS estado VARCHAR(20) NOT NULL DEFAULT 'APROBADA';

-- 2. Agregar columna codigo_reserva (si no existe ya)
ALTER TABLE actividad ADD COLUMN IF NOT EXISTS codigo_reserva VARCHAR(15);

-- 3. Las actividades históricas ya subieron puntos en el insert anterior,
--    por eso las marcamos directamente como APROBADA (NO volver a sumar puntos)
UPDATE actividad SET estado = 'APROBADA' WHERE estado IS NULL OR estado = '';

-- 4. Crear el rol EMPLEADO (si no existe)
INSERT INTO rol (nombre_rol)
SELECT 'EMPLEADO'
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE nombre_rol = 'EMPLEADO');

-- Verificación final
SELECT 
  COUNT(*) AS total_actividades,
  SUM(CASE WHEN estado = 'APROBADA' THEN 1 ELSE 0 END) AS aprobadas,
  SUM(CASE WHEN estado = 'PENDIENTE' THEN 1 ELSE 0 END) AS pendientes
FROM actividad;
