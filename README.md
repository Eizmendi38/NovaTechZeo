# NovaTechZeo Proyecto Firma
Nosotros, NovaTech Zeo, hemos realizado un programa para poder aceptar términos y condiciones establecidos anteriormente en el reto. 

## ¿Qué hace el programa?
Nuestro programa muestra las condiciones y términos establecidos por el grupo para poder firmar y aceptar estos acuerdos.

### ¿Cómo funciona?
**Paso 1:** Ingresar el nombre de usuario.

**Paso 2:** Elige el rol con el que quieres ingresar al programa.

**Paso 3:** Dependiendo de la respuesta, irás al menú de *Usuario* o al de *Administrardor*.

    Menú de Usuario: Solamente hay tres opciones, "Ver contrato", "Firmar" y "Sali".
    
    Menú de Administrador:  Solamente hay dos opciones, "Ver Firmas" y "Salir".

---


# NovaTechZeo Proyecto Formulario (versión dos)

En esta nueva versón, añadimos una nueva opción al menú llamada Contestar Formulario, recoge las respuestas del usuario y las guarda en un archivo JSON; otra opción permite al administrador ver las respuestas guardadas.

### ¿Cómo funciona?
**Paso 1:** Ingresar el nombre de usuario.

**Paso 2:** Elige el rol con el que quieres ingresar al programa.

**Paso 3:** Dependiendo de la respuesta, irás al menú de *Usuario* o al de *Administrardor*.

    Menú de Usuario: Solamente hay tres opciones, "Ver contrato", "Firmar", "Responder Formulario" y "Sali".
    
    Menú de Administrador:  Solamente hay dos opciones, "Ver Firmas", "Ver respuestas del formulario" y "Salir".

---

## Formato del archivo del formulario (`formulario.json`)

El archivo contiene un **array JSON de strings**. Cada elemento es una pregunta que se mostrará al usuario en el orden del array.

Además, si una cadena comienza con `---` se trata como un separador o texto de presentación: se **muestra** en pantalla pero **no** solicita respuesta.

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
