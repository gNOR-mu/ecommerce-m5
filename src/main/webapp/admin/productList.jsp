<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Listado productos</title>
    <%@ include file="/components/head.jsp" %>
</head>

<body class="d-flex flex-column min-vh-100">
<!-- header -->
<%@ include file="/components/header.jsp" %>

<main class="container-fluid p-0 ">

    <section class="container my-5">
        <h3 class="d-flex align-items-center mb-4">
            <c:choose>
                <c:when test="${not empty param.searchText}">
                    ${fn:length(products)} Resultados para: &nbsp;
                    <a href="${pageContext.request.contextPath}/admin/products"
                       title="Volver"
                       class="badge bg-dark rounded-pill text-bg-primary text-decoration-none d-inline-flex
                       align-items-center px-3 py-2 shadow-sm">
                        <span class="fw-normal me-2">${param.searchText}</span>
                        <i class="bi bi-x-circle-fill text-white opacity-75"></i>
                    </a>
                </c:when>
                <c:otherwise>
                    Lista de Productos
                </c:otherwise>
            </c:choose>

            <a href="${pageContext.request.contextPath}/admin/products?action=create"
               class="btn btn-success shadow-sm ms-auto">
                <i class="bi bi-plus-circle me-2"></i>Agregar Producto
            </a>
        </h3>

        <form method="get" action="${pageContext.request.contextPath}/admin/products" class="mb-3">
            <input type="hidden" name="action" value="search"/>
            <div class="input-group">
                <input type="text" name="searchText" class="form-control" placeholder="Buscar por producto/categoría">
                <button class="btn btn-dark">Buscar</button>
            </div>
        </form>

        <!--        Tabla de productos-->
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Marca</th>
                <th scope="col">Categoría</th>
                <th scope="col">Precio</th>
                <th scope="col">Stock</th>
                <th scope="col" class="text-center">Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.brandName}</td>
                    <td>${product.categoryName}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td class="d-flex justify-content-center">
                        <a class="btn" title="Ver"
                           href="${pageContext.request.contextPath}/products?id=${product.id}">
                            <i class="bi bi-eye"></i>
                        </a>
                        <a class="btn" title="Editar"
                           href="${pageContext.request.contextPath}/admin/products?action=edit&id=${product.id}">
                            <i class="bi bi-pencil"></i>
                        </a>

                        <form action="${pageContext.request.contextPath}/admin/products" method="POST"
                              onsubmit="return confirm('¿Estás seguro de que deseas eliminar ${product.name}? Esta acción no se puede deshacer.');">

                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${product.id}">

                            <button type="submit" class="btn btn-sm btn-danger" title="Eliminar">
                                <i class="bi bi-trash3"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

</main>

<!-- footer -->
<%@ include file="/components/footer.jsp" %>


<!-- scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>

</body>

</html>