<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список номеров</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Swiper CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css">
    <!-- Custom Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Arsenal:ital,wght@0,400;0,700;1,400;1,700&family=Roboto:ital,wght@0,100..900;1,100..900&family=Zen+Antique+Soft&display=swap" rel="stylesheet">
</head>
<body>
<header  class="text-white">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-4 col-lg-2">
                <a href="${pageContext.request.contextPath}/" class="nav-logo">
                    <img src="${pageContext.request.contextPath}/images/logo.svg" alt="Логотип" class="img-fluid">
                </a>
            </div>
            <nav class="col-8 col-lg-10">
                <div class="row">
                    <div class="col-12 col-lg">
                        <a class="text-white text-decoration-none" href="#about">О компании</a>
                    </div>
                    <div class="col-12 col-lg">
                        <a class="text-white text-decoration-none" href="#reviews">Отзывы</a>
                    </div>
                    <div class="col-12 col-lg">
                        <a class="text-white text-decoration-none" href="#rooms">Ознакомиться с номерами</a>
                    </div>
                    <div class="col-12 col-lg text-center header-contact">
                        г. Москва, ул. Примерная, д.1
                    </div>
                    <div class="col-12 col-lg text-center header-contact">
                        Тел: +7 (495) 123-45-67
                    </div>
                    <div class="col-12 col-lg text-center">
                        <a class="text-white text-decoration-none" href="${pageContext.request.contextPath}/start.jsp">Личный кабинет</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</header>
<h1>Список номеров</h1>
<div>
    <c:forEach var="room" items="${rooms}">
        <div class="room-card">
            <h2>Номер: ${room.roomNumber}</h2>
            <p>Описание: ${room.description}</p>
            <p>Стоимость: ${room.price} руб.</p>

            <c:if test="${not empty room.photos}">
                <!-- Показываем все фото; можно ограничить до одной, если нужно -->
                <c:forEach var="photo" items="${room.photos}">
                    <img src="data:image/jpeg;base64,${photo.base64Photo}"
                         class="room-photo"
                         alt="Фото номера ${room.roomNumber}" />
                </c:forEach>
            </c:if>

            <!-- Проверяем, залогинен ли пользователь -->
            <c:choose>
                <c:when test="${not empty currentUser}">
                    <!-- Кнопка “Перейти к бронированию” (ReserveRoomServlet) -->
                    <a href="${pageContext.request.contextPath}/reserveRoom?roomId=${room.id}"
                       class="reserve-button">
                        Перейти к бронированию
                    </a>

                    <!-- Кнопка “Добавить в корзину” (AddToCartServlet) -->
                    <form action="${pageContext.request.contextPath}/addToCart" method="post"
                          style="display: inline-block; margin-left: 8px;">
                        <input type="hidden" name="roomId" value="${room.id}" />
                        <!-- Если нужна возможность задать количество, можно добавить поле -->
                        <input type="hidden" name="quantity" value="1" />
                        <button type="submit" class="cart-button">Добавить в корзину</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="login-prompt">
                        Чтобы забронировать или добавить в корзину,
                        <a href="${pageContext.request.contextPath}/start.jsp">войдите или зарегистрируйтесь</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:forEach>
</div>
</body>
</html>
