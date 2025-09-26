# NovaTechZeo — Proyecto Firma

Nosotros, NovaTech Zeo, hemos realizado un programa para poder aceptar los términos y condiciones establecidos en el reto.

## ¿Qué hace el programa?
El programa muestra las condiciones y términos establecidos por el grupo y permite a los usuarios firmarlos. Además incluye un formulario que los usuarios pueden contestar y cuyos resultados pueden ser vistos por el administrador.

---

## ¿Cómo funciona?
**Paso 1:** Ingresar el nombre de usuario.

**Paso 2:** Si el usuario ingresa `admin` se le pedirá la contraseña de administrador (`1234`) —máximo 3 intentos—. Si la contraseña es correcta accederá al menú de administrador.  
Si se ingresa un nombre de usuario que coincide con un miembro del equipo (`Odei`, `Gari`, `Iker`, `Kristian`, `Jon`) se accederá al menú de usuario.

**Paso 3:** Según el usuario, se irá al **Menú de Usuario** o al **Menú de Administrador**.

### Menú de Usuario (para `Odei`, `Gari`, `Iker`, `Kristian`, `Jon`)
El menú de usuario contiene las siguientes opciones:

1. **Mostrar contrato** — Muestra el contenido del archivo `charter.json`.  
2. **Firmar** — Permite aceptar los términos y guardar una firma en `signatures.json`.  
3. **Cerrar Sesión** — Vuelve al prompt para ingresar el nombre de usuario.  
4. **Contestar formulario** — Muestra las preguntas del `formulario.json` y guarda las respuestas en `respuestas.json`.  
5. **Acceder al menú de administrador** — Pide la contraseña de administrador (`1234`, máximo 3 intentos). Si es correcta, el usuario entra al menú de administrador.
6. **Salir** — Cierra el programa.  

> Nota: la opción 5 permite que un usuario normal intente entrar al menú de administrador introduciendo la contraseña correcta.

### Menú de Administrador
El menú de administrador contiene las siguientes opciones:

1. **Ver todas las firmas** — Muestra el contenido de `signatures.json`.  
2. **Cerrar Sesión** — Vuelve al prompt para ingresar el nombre de usuario.  
3. **Ver respuestas del formulario** — Muestra las respuestas guardadas en `respuestas.json`.  
4. **Salir** — Cierra el programa.

---

# NovaTechZeo — Proyecto Formulario (versión dos)

En esta versión añadimos la opción **Contestar formulario** al menú de usuario: recoge las respuestas del usuario y las guarda en un archivo JSON; otra opción en el menú de administrador permite ver las respuestas guardadas.

### ¿Cómo funciona?
(Ver la sección anterior — la lógica de acceso y menús es la misma; lo nuevo es la opción **Contestar formulario** en el menú de usuario y **Ver respuestas del formulario** en el menú de administrador.)

---

## Formato del archivo del formulario (`formulario.json`)

El archivo contiene un **array JSON de strings**. Cada elemento es una pregunta que se mostrará al usuario en el orden del array.

Si una cadena comienza con `---` se trata como un separador o texto de presentación: se **muestra** en pantalla pero **no** solicita respuesta.

### Ejemplo `formulario.json`

```json
[
  "--- Bienvenido al formulario de satisfacción ---",
  "¿Cuál es tu nombre?",
  "¿Qué te ha parecido el servicio?",
  "¿Sugerencias?"
]
```

---

## Formato de las respuestas (`respuestas.json`)

Las respuestas se guardan como un **array** de objetos `Respuesta`. Cada objeto contiene:

- `usuario` (String)  
- `fecha` (String en formato ISO_LOCAL_DATE_TIME, p. ej. `2025-09-26T14:30:00`)  
- `respuestas` (objeto / map con cada pregunta como clave y la respuesta como valor)

### Ejemplo (estructura)

```json
[
  {
    "usuario": "juan",
    "fecha": "2025-09-26T14:30:00",
    "respuestas": {
      "¿Cuál es tu nombre?": "Juan Pérez",
      "¿Qué te ha parecido el servicio?": "Muy bueno",
      "¿Sugerencias?": "Nada por ahora"
    }
  }
]
```
