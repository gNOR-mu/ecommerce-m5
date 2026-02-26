<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Productos</title>
    <%@ include file="/components/head.jsp" %>

</head>

<body>
<!-- header -->
<%@ include file="/components/header.jsp" %>

<main>
    <section class="container my-5">
        <h1>Listado de productos</h1>

        <div class="row mt-5 gap-3 justify-content-center">
            <c:forEach items="${products}" var="product">
                <article class="col-12 col-md-6 col-lg-3">
                    <a href="${pageContext.request.contextPath}/products?id=${product.id}"
                       class="card p-0 product-card h-100 text-decoration-none text-dark d-flex flex-column">

                        <img src="${product.urlImage}"
                             class="card-img-top product-card-img"
                             alt="Producto: ${product.name}">

                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.shortDescription}</p>

                            <div class="mt-auto text-start">
                            <span class="text-primary fs-5">
                                <strong><fmt:formatNumber value="${product.price}" type="currency"/></strong>
                            </span>
                            </div>
                        </div>
                    </a>
                </article>
            </c:forEach>
        </div>
    </section>
</main>

<!-- footer -->
<%@ include file="/components/footer.jsp" %>

<script src="${pageContext.request.contextPath}/assets/js/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>


</html>