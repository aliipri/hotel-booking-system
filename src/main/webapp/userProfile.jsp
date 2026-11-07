<%-- @elvariable id="userReservations" type="java.util.List<hotel.model.Reservation>" --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет</title>
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
<c:out value="${userReservations}" />

<h1>Добро пожаловать, ${sessionScope.username}!</h1>
<p>Ваши бронирования:</p>
<table>
    <thead>
    <tr>
        <th>Номер комнаты</th>
        <th>Описание комнаты</th>
        <th>Дата заезда</th>
        <th>Дата выезда</th>
        <th>Дата бронирования</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reservation" items="${userReservations}">
        <tr>
            <td>${reservation.room.roomNumber}</td>
            <td>${reservation.room.description}</td>
            <td>${reservation.checkInDate}</td>
            <td>${reservation.checkOutDate}</td>
            <td>${reservation.reservationDate}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty userReservations}">
        <tr>
            <td colspan="5">У вас пока нет активных бронирований.</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
