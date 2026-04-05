-- =====================================================
-- MIGRACIÓN: Sistema de Notificaciones Cruzadas AUTO
-- Ejecutar UNA SOLA VEZ contra la base de datos
-- =====================================================

-- 1. Agregar columna id_centro_reciclaje a Noticias (opcional)
ALTER TABLE noticias ADD COLUMN IF NOT EXISTS id_centro_reciclaje INTEGER;
ALTER TABLE noticias ADD CONSTRAINT IF NOT EXISTS fk_noticias_centro
    FOREIGN KEY (id_centro_reciclaje) REFERENCES centro_reciclaje(id_centro_reciclaje)
    ON DELETE SET NULL;

-- 2. Agregar columna id_user a Notificaciones (a quién va dirigida)
ALTER TABLE notificaciones ADD COLUMN IF NOT EXISTS id_user INTEGER;
ALTER TABLE notificaciones ADD CONSTRAINT IF NOT EXISTS fk_notificaciones_user
    FOREIGN KEY (id_user) REFERENCES usuario(id_user)
    ON DELETE CASCADE;

-- 3. Agregar columna id_noticias a Notificaciones (de qué noticia provino)
ALTER TABLE notificaciones ADD COLUMN IF NOT EXISTS id_noticias INTEGER;
ALTER TABLE notificaciones ADD CONSTRAINT IF NOT EXISTS fk_notificaciones_noticias
    FOREIGN KEY (id_noticias) REFERENCES noticias(id_noticias)
    ON DELETE SET NULL;

-- Verificación final
SELECT 
    column_name, data_type 
FROM information_schema.columns 
WHERE table_name = 'notificaciones' 
ORDER BY ordinal_position;
