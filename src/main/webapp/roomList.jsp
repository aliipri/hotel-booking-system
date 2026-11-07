<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ознакомиться с номерами</title>

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
<div class="container">
    <h1>Ознакомиться с номерами</h1>
    <c:forEach var="room" items="${rooms}">
        <div class="room-card">
            <img src="showPhoto?roomId=${room.id}" alt="Фото ${room.roomNumber}" class="room-photo" />
            <div class="room-info">
                <h3>Номер: ${room.roomNumber}</h3>
                <p>${room.description}</p>
                <p><strong>Цена:</strong> ${room.price} руб./ночь</p>
                <form action="bookRoom" method="post">
                    <input type="hidden" name="roomId" value="${room.id}" />
                    <label>
                        <strong>Дата заезда:</strong>
                        <input type="date" name="checkInDate" required />
                    </label>
                    <label>
                        <strong>Дата выезда:</strong>
                        <input type="date" name="checkOutDate" required />
                    </label>
                    <button type="submit">Забронировать</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
