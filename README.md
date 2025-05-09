# Documentación Sistema de Gestión de Tareas

## 1. Introducción

El Sistema de Gestión de Tareas es una aplicación Java diseñada para administrar tareas en proyectos de desarrollo de software. Permite la creación, asignación, seguimiento y exportación de tareas de diferentes tipos (desarrollo, diseño y pruebas) asignadas a empleados.

## 2. Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

```
├── Empleado.java               # Modelo de empleado
├── EstadoTarea.java            # Enumeración de estados de tareas
├── ExportadorTareas.java       # Funcionalidades de exportación a archivos
├── Main.java                   # Clase principal y ejemplo de uso
├── Planificador.java           # Gestión de colecciones de tareas
├── RecursoMultimedia.java      # Modelo de recursos asociados a tareas
├── Tarea.java                  # Clase abstracta base para tareas
├── TareaDesarrollo.java        # Especialización para tareas de desarrollo
├── TareaDiseño.java            # Especialización para tareas de diseño
└── TareaPruebas.java           # Especialización para tareas de pruebas
```

## 3. Componentes del Sistema

### 3.1 Clase `Empleado`

Representa a un miembro del equipo al que se le pueden asignar tareas.

#### Atributos:
- `nombre` (String): Nombre completo del empleado
- `id` (String): Identificador único
- `puesto` (String): Posición en la empresa
- `email` (String): Correo electrónico de contacto

#### Métodos principales:
- Constructor: `Empleado(String nombre, String id, String puesto, String email)`
- Getters para cada atributo
- `setEmail(String email)`: Actualiza el correo electrónico
- `toString()`: Devuelve una representación en cadena del empleado

### 3.2 Enumeración `EstadoTarea`

Define los posibles estados de una tarea.

#### Valores:
- `EN_CURSO`: Tarea que se está realizando actualmente
- `PENDIENTE`: Tarea aún no iniciada
- `FINALIZADA`: Tarea completada

### 3.3 Clase `ExportadorTareas`

Proporciona funcionalidades para exportar tareas a archivos de texto.

#### Métodos:
- `exportarTareas(List<Tarea> tareas, String rutaArchivo, String filtro)`: Método base que genera un archivo con la lista de tareas
- `exportarPorEstado(Planificador planificador, EstadoTarea estado, String rutaArchivo)`: Exporta tareas filtradas por estado
- `exportarPorResponsable(Planificador planificador, Empleado responsable, String rutaArchivo)`: Exporta tareas filtradas por responsable
- `exportarTodasLasTareas(Planificador planificador, String rutaArchivo)`: Exporta todas las tareas

### 3.4 Clase `Main`

Clase principal con el método `main`. Contiene ejemplos de uso del sistema.

#### Funcionalidades demostradas:
- Creación de empleados
- Definición de fechas
- Creación de recursos multimedia
- Creación de tareas y asignación de recursos
- Uso del planificador
- Cambio de estado de tareas
- Búsqueda por diferentes criterios
- Exportación de tareas a archivos

### 3.5 Clase `Planificador`

Gestiona la colección de tareas y proporciona métodos de búsqueda y manipulación.

#### Atributos:
- `tareas` (List<Tarea>): Lista de todas las tareas gestionadas

#### Métodos:
- `agregarTarea(Tarea nuevaTarea)`: Añade una tarea a la colección
- `eliminarTarea(String idTarea)`: Elimina una tarea por su ID
- `buscarPorEstado(EstadoTarea estado)`: Devuelve tareas con el estado especificado
- `buscarPorResponsable(Empleado responsable)`: Devuelve tareas asignadas al empleado
- `obtenerTareasPorFecha(Date fecha)`: Devuelve tareas activas en una fecha específica
- `listarProximasTareas()`: Devuelve tareas que iniciarán en los próximos 7 días
- `generarInformeAvance()`: Calcula el porcentaje de tareas completadas
- `getTodasLasTareas()`: Devuelve todas las tareas

### 3.6 Clase `RecursoMultimedia`

Representa archivos o documentos asociados a las tareas.

#### Atributos:
- `id` (String): Identificador único
- `nombre` (String): Nombre del recurso
- `tipo` (String): Formato del archivo (PDF, PNG, etc.)
- `ruta` (String): Ubicación del archivo
- `tamaño` (long): Tamaño en bytes
- `fechaCreacion` (Date): Fecha de creación

#### Métodos:
- Constructor: `RecursoMultimedia(String id, String nombre, String tipo, String ruta, Date fechaCreacion)`
- `getInformacion()`: Devuelve información formateada del recurso
- `formatoTamaño(long bytes)`: Convierte bytes a formato legible (KB, MB, GB)
- Getters para todos los atributos
- `setRuta(String ruta)`: Actualiza la ubicación del recurso

### 3.7 Clase abstracta `Tarea`

Define la estructura común para todos los tipos de tareas.

#### Atributos:
- `id` (String): Identificador único
- `titulo` (String): Título descriptivo
- `descripcion` (String): Detalles de la tarea
- `responsable` (String): Nombre del responsable
- `empleado` (Empleado): Objeto del empleado asignado
- `fechaInicio` (Date): Fecha de inicio planificada
- `fechaFin` (Date): Fecha de finalización planificada
- `estado` (EstadoTarea): Estado actual (por defecto: PENDIENTE)
- `recursosAsociados` (List<RecursoMultimedia>): Recursos vinculados

#### Métodos:
- Constructor: `Tarea(String id, String titulo, String descripcion, String responsable, Date fechaInicio, Date fechaFin)`
- `ejecutar()`: Método abstracto implementado por las subclases
- `cambiarEstado(EstadoTarea nuevoEstado)`: Actualiza el estado
- `agregarRecurso(RecursoMultimedia recurso)`: Asocia un recurso
- `actualizarFechas(Date inicio, Date fin)`: Modifica las fechas planificadas
- `getResumen()`: Genera un resumen de la tarea
- Getters y setters para los atributos

### 3.8 Clase `TareaDesarrollo`

Especialización para tareas de programación y desarrollo.

#### Atributos adicionales:
- `lenguaje` (String): Lenguaje de programación utilizado

#### Métodos:
- Constructor: `TareaDesarrollo(String id, String titulo, String descripcion, String lenguaje, Empleado empleado, String responsable, Date fechaInicio, Date fechaFin)`
- `ejecutar()`: Implementación específica para tareas de desarrollo
- `getLenguaje()`: Devuelve el lenguaje utilizado
- `getEmpleado()`: Devuelve el empleado asignado

### 3.9 Clase `TareaDiseño`

Especialización para tareas de diseño gráfico o interfaces.

#### Atributos adicionales:
- `herramienta` (String): Software de diseño utilizado

#### Métodos:
- Constructor: `TareaDiseño(String id, String titulo, String descripcion, Empleado empleado, String responsable, Date fechaInicio, Date fechaFin, String herramienta)`
- `ejecutar()`: Implementación específica para tareas de diseño
- `getHerramienta()`: Devuelve la herramienta utilizada
- `getEmpleado()`: Devuelve el empleado asignado

### 3.10 Clase `TareaPruebas`

Especialización para tareas de prueba y verificación.

#### Atributos adicionales:
- `tipoPrueba` (String): Tipo de prueba (unitaria, integración, etc.)

#### Métodos:
- Constructor: `TareaPruebas(String id, String titulo, String descripcion, String responsable, Date fechaInicio, Date fechaFin, String tipoPrueba)`
- `ejecutar()`: Implementación específica para tareas de pruebas
- `getTipoPrueba()`: Devuelve el tipo de prueba
- `setTipoPrueba(String tipoPrueba)`: Actualiza el tipo de prueba

## 4. Flujo de Trabajo Típico

1. Crear instancias de empleados
2. Crear fechas para las tareas
3. Definir recursos multimedia (opcional)
4. Crear tareas específicas (desarrollo, diseño o pruebas)
5. Asociar recursos a las tareas (opcional)
6. Añadir las tareas al planificador
7. Gestionar el ciclo de vida de las tareas cambiando su estado
8. Buscar tareas por diferentes criterios
9. Exportar informes a archivos de texto

## 5. Relaciones entre Clases

- `Tarea` es la clase base abstracta para `TareaDesarrollo`, `TareaDiseño` y `TareaPruebas`
- `Planificador` administra una colección de objetos `Tarea`
- `Tarea` puede tener una lista de objetos `RecursoMultimedia`
- `Tarea` tiene una relación con `Empleado` (responsable)
- `ExportadorTareas` utiliza `Planificador` para obtener y exportar tareas

## 6. Validaciones y Control de Errores

- Validación de fechas: La fecha de inicio debe ser anterior a la de finalización
- Control de recursos nulos al agregarlos a una tarea
- Manejo de excepciones en la exportación de archivos
- Control de errores en la conversión de fechas

## 7. Consideraciones y Posibles Mejoras

### 7.1 Errores detectados:
- En `ExportadorTareas.java`, línea 44: La condición para verificar si la lista de recursos está vacía utiliza `isEmpty()` con una negación incorrecta. Debería ser: `if(tarea.recursosAsociados != null && !tarea.recursosAsociados.isEmpty())`.

### 7.2 Mejoras sugeridas:
- Implementar persistencia de datos (base de datos o serialización)
- Añadir más validaciones (IDs únicos, formatos de email)
- Desarrollar una interfaz gráfica de usuario
- Implementar notificaciones para tareas próximas a vencer
- Añadir sistema de dependencias entre tareas
- Implementar funcionalidades de colaboración y comentarios
- Mejorar la gestión de recursos y documentación

## 8. Conclusión

El Sistema de Gestión de Tareas proporciona una estructura sólida para administrar tareas en proyectos de desarrollo, con un diseño orientado a objetos que facilita la extensibilidad y el mantenimiento. Ofrece funcionalidades básicas pero completas para la gestión de tareas, recursos y empleados, así como la generación de informes.
