Implementación de la funcionalidad de Denuncias

   Funcionalidad desarrollada

Se ha implementado una funcionalidad compuesta por dos nuevas pantallas dentro de la app:

   1.  Pantalla de Reporte de Denuncia 
- Actividad:  ReportIssueActivity.java 
- Formulario que permite rellenar los siguientes campos:
  - Fecha (autogenerada con la actual)
  - Título de la denuncia
  - Mensaje explicativo
  - Nombre del remitente
- Al pulsar "Enviar":
  - Se realiza una petición  POST /issue  al backend usando  Retrofit  con un interceptor que añade el  token de autenticación .
  - Se muestra un mensaje de confirmación si la denuncia se envía correctamente.

   2.  Pantalla de Visualización de Denuncias 
- Actividad:  IssueListActivity.java 
- Usa  RecyclerView  para mostrar un listado de todas las denuncias enviadas al backend.
- Realiza una petición  GET /issue  usando Retrofit.
- Muestra los datos de cada denuncia: título, mensaje, remitente y fecha.

   3.Acceso desde el menú

- Se ha añadido un  botón de acceso  a ambas funcionalidades dentro del menú de navegación ( NavigationBottomSheet ) para facilitar el acceso desde cualquier parte de la app.
- El usuario puede abrir el menú y:
  - Ver la lista de denuncias.
  - Ir al formulario de denuncia.
- De esta forma, la funcionalidad está integrada de forma intuitiva y accesible.

   Qué funciona correctamente

-   Envío de denuncias mediante formulario ( POST /issue ).
-   Inclusión automática del token JWT mediante un  Interceptor  de OkHttp.
-   Visualización dinámica de todas las denuncias existentes ( GET /issue ).
-   Comunicación exitosa entre la app Android y el backend (modo dummy).
-   Formato visual correcto y responsivo.
