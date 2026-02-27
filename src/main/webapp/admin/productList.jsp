<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Listado productos</title>
    <%@ include file="/components/head.jsp" %>
</head>

<body>
<!-- header -->
<%@ include file="/components/header.jsp" %>

<main class="container-fluid p-0 ">
    <section class="container my-5">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Marca</th>
                <th scope="col">Categoría</th>
                <th scope="col">Precio</th>
                <th scope="col">Stock</th>
                <th scope="col">Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <th scope="col">${product.id}</th>
                    <td>${product.name}</td>
                    <td>${product.brandName}</td>
                    <td>${product.categoryName}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td>
                        <a class="btn" th:href="@{/productos/editar/{id}(id=${p.id})}">Editar</a>

                        <form action="${pageContext.request.contextPath}/admin/products" method="POST"
                              onsubmit="return confirm('¿Estás seguro de que deseas eliminar ${product.name}? Esta acción no se puede deshacer.');">

                            <input type="hidden" name="action" value="eliminar">
                            <input type="hidden" name="id" value="${product.id}">

                            <button type="submit" class="btn btn-sm btn-danger">
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