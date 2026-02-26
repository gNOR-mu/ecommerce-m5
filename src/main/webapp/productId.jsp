<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>${product.name}</title>
    <%@ include file="/components/head.jsp" %>

    <link rel="stylesheet" href="assets/css/productId.css">

</head>

<body>
<!-- header -->
<%@ include file="/components/header.jsp" %>

<main>
    <section class="container my-5">
        <div class="row mx-0 gy-sm-3">
            <img src="${product.urlImage}" class="img-product shadow-lg p-0">
            <div class="col">
                <h1 class="col">${product.name}</h1>
                <h5 class="col">${product.shortDescription}</h5>
                <h6 class="col">${product.price}</h6>
            </div>
        </div>

        <div class="accordion  my-4 ">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
                            aria-controls="panelsStayOpen-collapseOne">
                        Descripción
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                    <div class="accordion-body">
                        <span>${product.description}</span>
                    </div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
                            aria-controls="panelsStayOpen-collapseTwo">
                        Características
                    </button>
                </h2>
                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                    <div class="accordion-body">
                        <ul class="list-group list-group-flush mb-4 ms-3">
                            <c:forEach items="${product.features}" var="feature">
                                <li>
                                    <strong class="text-capitalize">${feature.key}: </strong> <span class="text-capitalize">${feature.value}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- footer -->
<%@ include file="/components/footer.jsp" %>

<!-- scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>

</body>

</html>