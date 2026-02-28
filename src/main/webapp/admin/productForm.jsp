<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <title>Agregar producto</title>
    <%@ include file="/components/head.jsp" %>
</head>

<body class="d-flex flex-column min-vh-100">
<!-- header -->
<%@ include file="/components/header.jsp" %>

<main class="container-fluid p-0 ">
    <section class="container my-5">
        <!--Formulario-->
        <form method="post" action="${pageContext.request.contextPath}/admin/products">
            <input type="hidden" name="action" value="save"/>

            <!--            ID-->
            <input type="hidden" name="id" value="${product.id}"/>

            <!--            NOMBRE-->
            <div class="mb-3">
                <label class="fw-bold">Nombre</label>
                <input type="text" name="name" value="${product.name}" class="form-control" required>
            </div>


            <div class="d-flex flex-row">

                <!--            CATEGORÍA-->
                <div class="col mb-3">
                    <label for="category" class="form-label fw-bold">Categoría</label>

                    <select name="categoryId" id="category" class="form-select" required>

                        <option value="" disabled ${product== null ? 'selected' : ''}>
                        -- Selecciona una categoría --
                        </option>

                        <c:forEach items="${categories}" var="cat">

                            <option value="${cat.id}" ${product !=null and product.categoryId== cat.id ?
                            'selected' : ''}>
                            ${cat.name}
                            </option>

                        </c:forEach>

                    </select>
                </div>

                <!--            MARCA-->
                <div class="col ms-auto">
                    <label for="brand" class="form-label fw-bold">Marca</label>

                    <select name="brandId" id="brand" class="form-select" required>

                        <option value="" disabled ${product== null ? 'selected' : ''}>
                        -- Selecciona una marca --
                        </option>

                        <c:forEach items="${brands}" var="brand">

                            <option value="${brand.id}" ${product !=null and product.brandId== brand.id ? 'selected' : ''}>
                            ${brand.name}
                            </option>

                        </c:forEach>

                    </select>
                </div>
            </div>

            <!--            URL IMAGEN-->
            <div class="mb-3">
                <label class="fw-bold">URL imagen</label>
                <input type="text" name="urlImage" value="${product.urlImage}" class="form-control" required>
            </div>

            <!--            DESCRIPCIÓN LARGA-->
            <div class="mb-3">
                <label class="fw-bold">Descripción</label>
                <input type="text" name="description" value="${product.description}" class="form-control" required>
            </div>

            <!--            DESCRIPCIÓN CORTA-->
            <div class="mb-3">
                <label class="fw-bold">Descripción corta</label>
                <input type="text" name="shortDescription" value="${product.shortDescription}" class="form-control" required>
            </div>

            <!--            PRECIO-->
            <div class="mb-3">
                <label class="fw-bold">Precio</label>
                <input type="number" name="price" value="${product.price}" class="form-control" min="0.0" required>
            </div>

            <!--            STOCK-->
            <div class="mb-3">
                <label class="fw-bold">Stock</label>
                <input type="number" name="anio" value="${product.stock}" class="form-control" min="0.0" required>
            </div>

            <!--            CARACTERÍSTICAS-->
            <div id="features-container">
                <label class="fw-bold">Características</label>

                <c:forEach items="${product.features}" var="feature">

                    <div class="row mb-2 feature-row">

                        <div class="col-5">
                            <input type="text" name="featureKeys" class="form-control"
                                   value="${feature.key}" required>
                        </div>

                        <div class="col-5">
                            <input type="text" name="featureValues" class="form-control"
                                   value="${feature.value}" required>
                        </div>

                        <div class="col-2">
                            <button type="button" class="btn btn-danger w-100"
                                    onclick="this.closest('.feature-row').remove()" title="Eliminar fila">
                                <i class="bi bi-trash"></i>
                            </button>
                        </div>

                    </div>

                </c:forEach>
            </div>
            <button type="button" class="btn btn-outline-primary mt-2" onclick="addFeatureRow()">
                <i class="bi bi-plus-circle me-1"></i> Agregar característica
            </button>

            <button class="btn btn-success">Guardar</button>
            <a href="${pageContext.request.contextPath}/admin/products" class="btn btn-secondary">Cancelar</a>


        </form>
    </section>

</main>

<!-- footer -->
<%@ include file="/components/footer.jsp" %>


<!-- scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.7.1.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/productForm.js"></script>

</body>

</html>