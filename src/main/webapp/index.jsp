<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Система Бронирования Отеля</title>

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
    <h1>Добро пожаловать</h1>
    <h2>Вход в систему</h2>

    <!-- Форма для авторизации -->
    <form action="login" method="POST">
        <label for="username">Имя пользователя:</label>
        <input type="text" id="username" name="username" required/>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required/>

        <button type="submit">Войти</button>
    </form>

    <c:if test="${not empty param.error}">
        <p class="error-message">${param.error}</p>
    </c:if>
</div>
</body>
</html>
