<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Личный кабинет</title>
    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
    >
    <!-- Ваши стили -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<header style="background-color:#f3522d;" class="text-white py-3">
    <!-- Шапка сайта -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col-4 col-lg-2">
                <a href="${pageContext.request.contextPath}/" class="nav-logo">
                    <img src="${pageContext.request.contextPath}/images/logo.svg"
                         alt="Логотип" class="img-fluid">
                </a>
            </div>
            <nav class="col-8 col-lg-10">
                <div class="row">
                    <div class="col-12 col-lg"><a class="text-white" href="#about">О компании</a></div>
                    <div class="col-12 col-lg"><a class="text-white" href="#reviews">Отзывы</a></div>
                    <div class="col-12 col-lg"><a class="text-white" href="#rooms">Ознакомиться с номерами</a></div>
                    <div class="col-12 col-lg text-center header-contact">г. Москва, ул. Примерная, д. 1</div>
                    <div class="col-12 col-lg text-center header-contact">Тел: +7 (495) 123-45-67</div>
                    <div class="col-12 col-lg text-center">
                        <a class="text-white" href="${pageContext.request.contextPath}/start.jsp">Личный кабинет</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</header>

<div class="container">
    <!-- Приветствие -->
    <div class="profile-header my-4 text-center">
        <h1 class="display-5 text-coral">Добро пожаловать, ${sessionScope.currentUser.username}!</h1>
        <p class="text-muted">Вы успешно вошли в систему.</p>
    </div>

    <!-- Навигация -->
    <div class="nav-links mb-4 text-center">
        <a href="reserveRoom" class="btn btn-primary me-3">Сделать бронирование</a>
        <a href="${pageContext.request.contextPath}/rooms" class="btn btn-primary">Ознакомиться с номерами</a>
    </div>

    <!-- Административная секция: таблица всех бронирований -->
    <c:if test="${not empty sessionScope.currentUser && sessionScope.currentUser.role == 'admin'}">
        <div class="admin-section mb-5">
            <h3 class="text-coral text-center mb-3">Административная панель</h3>

            <!-- Кнопки -->
            <div class="d-flex justify-content-center mb-4">
                <a href="${pageContext.request.contextPath}/uploadPhotoForm" class="btn btn-secondary me-3">
                    Загрузить фото
                </a>
                <a href="${pageContext.request.contextPath}/admin/reservations"
                   class="btn btn-danger"
                   download="reservations.json">
                    Скачать все бронирования (JSON)
                </a>

            </div>

            <!-- Простая табличка со ВСЕМИ бронированиями -->
            <c:if test="${empty allReservations}">
                <p class="text-center">Пока нет ни одного бронирования.</p>
            </c:if>
            <c:if test="${not empty allReservations}">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped reservations-table text-center">
                        <thead class="table-dark">
                        <tr>
                            <th>№ брони</th>
                            <th>Номер комнаты</th>
                            <th>Описание комнаты</th>
                            <th>Гость (ID)</th>
                            <th>Дата заезда</th>
                            <th>Дата выезда</th>
                            <th>Дата бронирования</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="res" items="${allReservations}">
                            <tr>
                                <td>${res.id}</td>
                                <td>${res.room.roomNumber}</td>
                                <td>${res.room.description}</td>
                                <td>${res.guest.id}</td>
                                <td>${res.checkInDate}</td>
                                <td>${res.checkOutDate}</td>
                                <td>${res.reservationDate}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </c:if>

    <!-- Секция личных бронирований пользователя -->
    <c:if test="${not empty sessionScope.currentUser}">
        <div class="reservations-section mb-5">
            <h3 class="text-coral text-center mb-3">Мои активные бронирования:</h3>

            <c:if test="${empty userReservations}">
                <p class="text-center">У вас пока нет активных бронирований.</p>
            </c:if>
            <c:if test="${not empty userReservations}">
                <div class="table-responsive">
                    <table class="table table-striped reservations-table text-center">
                        <thead class="table-light">
                        <tr>
                            <th>№ брони</th>
                            <th>№ комнаты</th>
                            <th>Описание комнаты</th>
                            <th>Дата заезда</th>
                            <th>Дата выезда</th>
                            <th>Дата бронирования</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="reservation" items="${userReservations}">
                            <tr>
                                <td>${reservation.id}</td>
                                <td>${reservation.room.roomNumber}</td>
                                <td>${reservation.room.description}</td>
                                <td>${reservation.checkInDate}</td>
                                <td>${reservation.checkOutDate}</td>
                                <td>${reservation.reservationDate}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </c:if>

    <!-- Кнопка «Выйти» -->
    <div class="text-center mb-4">
        <a href="logout" class="btn btn-danger">Выйти</a>
    </div>
</div>

<footer class="footer text-center py-4">
    <div class="container">
        <p>© 2005-2025 ООО «КурортМакс»</p>
        <p>Разработала: Прилепо А.А.</p>
    </div>
</footer>

<!-- Bootstrap JS и свои скрипты -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
</script>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
