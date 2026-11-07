<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить товар в корзину</title>
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
<h1>Добавить товар в корзину</h1>
<form action="addToCart" method="POST">
    <label for="product_id">ID товара:</label>
    <input type="number" id="product_id" name="product_id" value="1" required>

    <label for="quantity">Количество:</label>
    <input type="number" id="quantity" name="quantity" value="1" required>

    <button type="submit">Добавить в корзину</button>
</form>


<a href="cart">Перейти к корзине</a>
</body>
</html>
