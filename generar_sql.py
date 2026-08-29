import os
import csv

input_dir = r'C:\Users\JAIRA\Documents\daotos'
output_file = r'C:\Users\JAIRA\Documents\Arqui\Trabajo_Final\BACKEND-ARQUIWEB-main\inserts_completos.sql'

def format_val(val):
    if val is None or val == '': return 'NULL'
    try: 
        float(val)
        return val
    except: 
        val = val.replace("'", "''")
        return f"'{val}'"

columns = {
    'centro_reciclaje': '(id_centro_reciclaje, latitud, longitud, direccion)',
    'recompensas': '(costo_puntos, fecha_vencimiento, id_recompensas, stock, descripcion_recompensa, nombre_recompensa)',
    'noticias': '(fecha_publicacion, id_centro_reciclaje, id_noticias, informacion, titulo)',
    'usuario': '(edad, enabled, id_user, puntos_acumulados, rol_id, dni, genero, telefono, apellidos, nombres, username, correo, distrito, password)',
    'notificaciones': '(id_notificaciones, mensaje, fecha_notificacion, id_user, id_noticias)',
    'actividad': '(id_actividad, fecha_recepcion, puntos, cantidad, estado, codigo_reserva, id_tipo_de_actividad, id_centro_reciclaje, id_user)',
    'reclamaciones': '(id_reclamacion, id_recompensa, id_usuario)',
    'favoritos': '(id_favorito, id_user, id_centro_reciclaje)'
}

pkeys = {
    'rol': 'id_rol',
    'tipo_de_actividad': 'id_tipo_actividad',
    'centro_reciclaje': 'id_centro_reciclaje',
    'usuario': 'id_user',
    'noticias': 'id_noticias',
    'notificaciones': 'id_notificaciones',
    'actividad': 'id_actividad',
    'recompensas': 'id_recompensas',
    'reclamaciones': 'id_reclamacion',
    'favoritos': 'id_favorito'
}

# Mock data for tables that are empty in the CSV
mock_data = {
    'usuario': [
        "25, 't', 2, 350, 2, '23456789', 'Masculino', '987654321', 'Pérez', 'Juan', 'juan_perez', 'juan@reciclaje.pe', 'Miraflores', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'",
        "28, 't', 3, 700, 2, '34567890', 'Femenino', '987654322', 'Gómez', 'María', 'maria_gomez', 'maria@reciclaje.pe', 'Surco', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'",
        "40, 't', 4, 150, 3, '45678901', 'Masculino', '987654323', 'Lucas', 'Reciclador', 'reciclador_lucas', 'lucas@reciclaje.pe', 'Ate', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'",
        "22, 't', 5, 120, 2, '56789012', 'Femenino', '987654324', 'López', 'Ana', 'ana_lopez', 'ana@reciclaje.pe', 'San Borja', '$2a$10$7k3HOQrX8YqCFcNJEOAy/eyi1g4p71/t5rLDeAWO9BjO5wvi7aBtu'"
    ],
    'actividad': [
        "1, '2026-06-15', 100, 10, 'APROBADA', 'REC-001-XYZ', 1, 1, 2",
        "2, '2026-06-16', 50, 5, 'APROBADA', 'REC-002-ABC', 2, 2, 3",
        "3, '2026-06-18', 200, 20, 'PENDIENTE', 'REC-003-DEF', 3, 3, 5"
    ],
    'favoritos': [
        "1, 2, 1",
        "2, 2, 4",
        "3, 3, 2",
        "4, 3, 3"
    ],
    'notificaciones': [
        "1, 'Campaña especial de PET iniciada en Miraflores!', '2026-06-20', 2, 1",
        "2, '¡Aprovecha el doble de puntos hoy!', '2026-06-20', 3, 1"
    ],
    'reclamaciones': [
        "1, 4, 2",
        "2, 1, 3"
    ]
}

with open(output_file, 'w', encoding='utf-8') as out:
    out.write('-- SCRIPT DE IMPORTACION MASIVA CORREGIDO Y COMPLETO CON DATOS MUESTRA\n\n')
    
    # 1. ROL (Hardcoded matching the 3 roles initialized in Java)
    out.write('-- TABLA: rol\n')
    out.write("INSERT INTO rol (id_rol, nombre_rol) VALUES (1, 'ADMIN'), (2, 'CLIENTE'), (3, 'RECICLADOR') ON CONFLICT (id_rol) DO NOTHING;\n\n")

    # 2. TIPO DE ACTIVIDAD (Hardcoded because the CSV was a duplicate of recompensas)
    out.write('-- TABLA: tipo_de_actividad\n')
    out.write('INSERT INTO tipo_de_actividad (id_tipo_actividad, "descripción") VALUES\n')
    out.write("(1, 'Plástico PET'), (2, 'Cartón Corrugado'), (3, 'Vidrio Transparente'), (4, 'Vidrio Color'),\n")
    out.write("(5, 'Papel Blanco'), (6, 'Periódico y Revistas'), (7, 'Latas de Aluminio'), (8, 'Chatarra Ferrosa'),\n")
    out.write("(9, 'Pilas Alcalinas'), (10, 'Baterías de Litio'), (11, 'Residuos Electrónicos (RAEE)'), (12, 'Aceite Usado'),\n")
    out.write("(13, 'Madera y Parihuelas'), (14, 'Ropa Usada'), (15, 'Tapitas Plásticas')\n")
    out.write("ON CONFLICT (id_tipo_actividad) DO NOTHING;\n\n")

    # Order of execution
    order = ['centro_reciclaje', 'usuario', 'noticias', 'notificaciones', 'actividad', 'recompensas', 'reclamaciones', 'favoritos']
    
    for file in order:
        path = os.path.join(input_dir, file)
        out.write(f'-- TABLA: {file}\n')
        
        vals = []
        # First read CSV rows if the file exists and is not empty
        if os.path.isfile(path):
            with open(path, 'r', encoding='utf-8') as f:
                rows = list(csv.reader(f))
                for r in rows:
                    if r: # Skip empty lines
                        v_str = ', '.join(format_val(v) for v in r)
                        vals.append(f'({v_str})')
        
        # Second, append mock data if configured
        if file in mock_data:
            for item in mock_data[file]:
                vals.append(f'({item})')
        
        if vals:
            cols = columns.get(file, '')
            pkey = pkeys.get(file, '')
            out.write(f'INSERT INTO {file} {cols} VALUES\n')
            out.write(',\n'.join(vals))
            if pkey:
                out.write(f'\nON CONFLICT ({pkey}) DO NOTHING;\n\n')
            else:
                out.write(';\n\n')
        else:
            out.write(f'-- (Sin registros)\n\n')

print('SQL generado exitosamente')
