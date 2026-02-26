-- DATOS INICIALES
INSERT INTO
    CUSTOMERS (NAME, RUT, EMAIL, CELLPHONE, PASS_HASH)
VALUES
    (
        'Juan',
        '12345678-9',
        'correo1@seed.cl',
        '+56911111111',
        '3$2#alskd2#G'
    );

INSERT INTO
    CATEGORIES (NAME)
VALUES
    ('Ropa'),
    ('Expedición'),
    ('Accesorios'),
    ('Deporte');

INSERT INTO
    BRANDS (NAME)
VALUES
    ('Maui'),
    ('Head'),
    ('Ray-Ban'),
    ('Totem');

INSERT INTO
    PRODUCTS (
        CATEGORY_ID,
        BRAND_ID,
        URL_IMAGE,
        STOCK,
        NAME,
        FEATURES,
        PRICE,
        DESCRIPTION,
        SHORT_DESCRIPTION
    )
VALUES
    -- Mochila de expedición, Categoría: Expedición, Marca: Head
    (
        2,
        2,
        'https://c.pxhere.com/photos/e1/74/backpack_hiking_backpack_hiking_mountains_forest_vietnam_nature_water_bottle-1395064.jpg!d',
        15,
        'Mochila Head Trekking 60L',
        '{"capacidad": "60 Litros", "impermeable": true, "bolsillos": 5}',
        85000.0,
        'Esta mochila de expedición está diseñada para los aventureros más exigentes. Confeccionada en Nylon de alta resistencia, garantiza durabilidad y protección
    contra los elementos. Su capacidad de 60 litros te permite llevar todo lo necesario para tus travesías, mientras que su diseño ergonómico asegura una distribución
    equilibrada del peso y un confort óptimo durante largas caminatas. El color azul vibrante no solo le da un toque de estilo, sino que también mejora la visibilidad en
    entornos naturales. Además, cuenta con múltiples compartimentos y correas ajustables para organizar tu equipo de manera eficiente. Ya sea para un trekking de varios días
    o una escalada desafiante, esta mochila es tu compañera ideal.',
        'Mochila de expedición de 60L. Ideal para viajes largos.'
    ),
    -- Bicicleta mountain bike Categoría: Deporte, Marca: Totem
    (
        4,
        4,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Orbea_Occam_2020.jpg/1024px-Orbea_Occam_2020.jpg',
        5,
        'Bicicleta Totem W860 Aro 29',
        '{"aro": 29, "frenos": "Hidráulico", "velocidades": 27, "cuadro": "Aluminio"}',
        320000.0,
        'Esta Mountain Bike está diseñada para los amantes de la aventura y la velocidad. Con un cuadro de Aluminio ligero y resistente, esta bicicleta te ofrece la agilidad y
    durabilidad que necesitas para conquistar cualquier sendero. Equipada con 27 velocidades, te permite adaptar tu pedaleo a cualquier tipo de terreno, desde subidas empinadas
    hasta descensos rápidos. Los frenos de Disco Hidráulico garantizan una frenada potente y segura en todas las condiciones climáticas, mientras que su suspensión delantera
    y trasera absorbe los impactos, proporcionando un viaje suave y controlado. Con un rodado de 29 pulgadas, esta bicicleta te ofrece una mayor estabilidad y tracción,
    ideal para explorar nuevos caminos y superar tus límites.',
        'Bicicleta de montaña rodado 29, 27 velocidades, frenos de disco hidráulicos'
    ),
    --  Gafas de sol Categoría: Accesorios, Marca: Ray-Ban
    (
        3,
        3,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Beach-sand-summer-46710.jpg/1024px-Beach-sand-summer-46710.jpg',
        30,
        'Gafas Ray-Ban Aviator',
        '{"polarizado": true, "filtro": "UV400", "color_cristal": "Verde", "material_marco": "Metal"}',
        115000.0,
        'El diseño clásico que nunca pasa de moda. Protección total contra los rayos UV con un estilo inconfundible.',
        'Gafas de sol con protección UV400, lentes de policarbonato y marco de plástico'
    ),
    -- Tienda de campaña (Categoría: Expedición, Marca: Maui
    (
        2,
        1,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Husky_Tent_near_scout_camp_near_Kouty%2C_T%C5%99eb%C3%AD%C4%8D_District.jpg/1024px-Husky_Tent_near_scout_camp_near_Kouty%2C_T%C5%99eb%C3%AD%C4%8D_District.jpg',
        8,
        'Carpa Maui 4 Personas',
        '{"capacidad": 4, "estaciones": 3, "columnas_agua": "3000mm", "peso": "4.5kg"}',
        145000.0,
        'Carpa tipo iglú resistente a vientos moderados y lluvias. Fácil de armar e ideal para acampar en familia o con amigos en la naturaleza.',
        'Tienda de campaña resistente a lluvias'
    ),
    -- Chaqueta Categoría: Ropa, Marca: Head
    (
        1,
        2,
        'https://assets.thenorthface.eu/images/t_img/f_auto,h_462,e_sharpen:60,w_462/dpr_2.0/v1753206753/NF0A7QAW4GU-ALT20/Mens-Alta-Vista-Rain-Jacket.jpg',
        20,
        'Chaqueta The North Face Cortavientos',
        '{"talla": "L", "color": "Gris", "impermeable": true, "bolsillos_con_cierre": 2}',
        45000.0,
        'Chaqueta ligera y resistente al agua, perfecta para actividades al aire libre o para protegerse del clima cambiante.',
        'Chaqueta resistente al agua'
    );

INSERT INTO
    ORDERS (CUSTOMER_ID, CREATION_DATE, TOTAL)
VALUES
    (1, '2026-02-26', 520000),
    (1, '2026-02-26', 85000);

INSERT
    ORDERS_ITEM (ORDER_ID, PRODUCT_ID, UNIT_PRICE, QUANTITY)
VALUES
    (1, 1, 85000, 1),
    (1, 2, 320000, 1),
    (1, 3, 115000, 1),
    (2, 1, 85000, 1);

