<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Корзина</title>
</head>
<body>
<header style="background-color:#f3522d;" class="text-white">
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
<h1>Корзина</h1>
<table border="1">
    <tr>
        <th>Номер комнаты</th>
        <th>Количество</th>
        <th>Действия</th>
    </tr>
    <c:forEach var="item" items="${cartItems}">
        <tr>
            <td>${item.room.roomNumber}</td>
            <td>${item.quantity}</td>
            <td>
                <form action="removeFromCart" method="post">
                    <input type="hidden" name="cartItemId" value="${item.id}" />
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="rooms">Вернуться к номерам</a>
</body>
</html>
