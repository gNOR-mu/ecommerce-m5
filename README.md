# ecommerce-m5

Ejercicio práctico del curso de desarrollo de aplicaciones Full Stack con Java para el módulo 5

Enlace del repositorio de GitHub: https://github.com/gNOR-mu/ecommerce-m5

# CONSIDERACIONES

- Se utiliza MySQL
- El nombre de la base de datos es mvp_m5_gnorambuena ([creada en el schema.sql](docs/schema.sql))
- En [schema.sql](docs/schema.sql) SE CREA un usuario sobre la base de datos a utilizar.
- Credenciales necesarias para el acceso a la base de datos definidas en [database.properties](src/main/resources/database.properties).
  (son las del usuario que se crea en schema.sql)

```
    -- Usuario  : mvp_m5
    -- Pass     : mvp_m5_1234
    -- BD       : jdbc:mysql://localhost:3306
```

# Instrucciones de ejecución

- Crear la base de datos
- Poblar la base de datos
- Compilar con: mvn clean package
- Mover .war generado a tomcat/webapps
- Luego, con el servidor Tomcat en ejecución, acceder a http://localhost:8080/mvp_m5-1.0-SNAPSHOT

# Rutas principales

- http://localhost:8080/mvp_m5-1.0-SNAPSHOT (inicio)
- http://localhost:8080/mvp_m5-1.0-SNAPSHOT/admin/products (panel de administración de productos)
- http://localhost:8080/mvp_m5-1.0-SNAPSHOT/products (página con todos los productos)

# Propósito

Implementar las vistas JSP y los CRUD de productos (listar, crear, editar, eliminar)
conectados a BD vía JDBC/DAO, bajo MVC, y desplegados en Tomcat. Este entregable se
centra en las capacidades del Administrador; la compra y roles de usuario quedan para el
módulo siguiente.

# Alcance (MVP — Admin)

- Listado de productos con búsqueda por nombre y filtro por categoría.
- Crear producto mediante formulario con validaciones (campos obligatorios; precio > 0).
- Editar producto con precarga de datos y validaciones.
- Eliminar producto con confirmación.
- Mensajes de éxito/error visibles en las vistas.
- Reutilización de frontend: adapta tu Bootstrap de M2 a JSP (server-rendered).

Tablas para considerar en el diseño: products, categories, customers, orders, order_items

# Requisitos funcionales

- Rutas/servlets sugeridos (ajustables):
    - GET /admin/products (lista + búsqueda/filtro)
    - GET /admin/products/new · POST /admin/products (crear)
    - GET /admin/products/edit?id=... · POST /admin/products/update (editar)
    - POST /admin/products/delete (eliminar con confirmación)
- Validaciones: id existente para editar/eliminar; campos obligatorios; precio numérico >
- Manejo de errores: mensajes claros y retorno a la vista con los campos ingresados
  cuando corresponda.

# Requisitos técnicos

- JSP + JSTL (<c:forEach>, <c:out>, <c:if>).
- Servlets con RequestDispatcher.forward para vistas y sendRedirect donde aplique
  (POST/Redirect/GET).
- DAO/JDBC: conexión Singleton, consultas con PreparedStatement, cierre de recursos
  adecuado.
- MVC: DTO/clases de modelo (modelo), DAO (datos), Servlets (control), JSP (vista).
- Despliegue: WAR + web.xml en Tomcat

