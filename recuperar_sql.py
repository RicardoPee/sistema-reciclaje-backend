import json
import os

transcript_path = r"C:\Users\JAIRA\.gemini\antigravity\brain\b1fb7332-34a1-4b3f-b2f3-38fb0bde7c6f\.system_generated\logs\transcript_full.jsonl"
output_path = r"C:\Users\JAIRA\Documents\Arqui\Trabajo_Final\BACKEND-ARQUIWEB-main\datos_iniciales.sql"

found = False
if os.path.exists(transcript_path):
    with open(transcript_path, 'r', encoding='utf-8') as f:
        for line in f:
            data = json.loads(line)
            content = data.get('content', '')
            if 'INSERT INTO rol' in content and '-- 10. TABLA: reclamaciones' in content:
                # Extract the SQL part
                start = content.find('```sql')
                if start != -1:
                    start += 6
                    end = content.find('```', start)
                    sql = content[start:end].strip()
                    with open(output_path, 'w', encoding='utf-8') as out:
                        out.write(sql)
                    found = True
                    print("SQL guardado en datos_iniciales.sql")
                    break
if not found:
    print("No se encontró el script")
