<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Главная страница</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Swiper CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css">
    <!-- Custom Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Arsenal:ital,wght@0,400;0,700;1,400;1,700&family=Roboto:ital,wght@0,100..900;1,100..900&family=Zen+Antique+Soft&display=swap" rel="stylesheet">

</head>
<body>
<!-- Header -->
<header class="text-white">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-4 col-lg-2">
                <a href="${pageContext.request.contextPath}/" class="nav-logo">
                    <img src="${pageContext.request.contextPath}/images/logo.svg" alt="Логотип" class="img-fluid">
                </a>
            </div>
            <nav class="col-8 col-lg-10">
                <div class="row">
                    <div class="col-12 col-lg d-flex justify-content-center">
                        <a class="about" href="#about">О компании</a>
                    </div>
                    <div class="col-12 col-lg d-flex justify-content-center">
                        <a class="reviews" href="#reviews">Отзывы</a>
                    </div>
                    <div class="col-12 col-lg d-flex justify-content-center">
                        <a class="rooms" href="#rooms">Ознакомиться с номерами</a>
                    </div>
                    <div class="col-12 col-lg text-center header-contact">
                        г. Москва, ул. Примерная, д.1
                    </div>
                    <div class="col-12 col-lg text-center header-contact">
                        Тел: +7 (495) 123-45-67
                    </div>
                    <div class="col-12 col-lg text-center">
                        <a class="btn btn-outline-primary btn-sm me-2" href="${pageContext.request.contextPath}/start.jsp">Личный кабинет</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</header>

<!-- Slider -->
<section class="page">
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/slide1.jpg" class="img-fluid" alt="Слайд 1"></div>
            <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/slide2.jpg" class="img-fluid" alt="Слайд 2"></div>
            <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/slide3.jpg" class="img-fluid" alt="Слайд 3"></div>
        </div>
        <!-- Pagination -->
        <div class="swiper-pagination"></div>
        <!-- Navigation -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
    </div>
</section>

<!-- Main Content -->
<main class="container">
    <!-- О компании -->
    <section id="about">
        <div class="ideas" style="padding:86px 0; background:url('${pageContext.request.contextPath}/images/about-us-numbers.jpg') center center / cover no-repeat;">
            <div class="ideas__numbers container">
                <div class="row">
                    <div class="col-xl-3">
                        <div class="ideas__numbers-item">
                            <div class="ideas__numbers-number"><span data-number="15">15</span>+</div>
                            <div class="ideas__numbers-text">Лет на рынке</div>
                        </div>
                    </div>
                    <div class="col-xl-3">
                        <div class="ideas__numbers-item">
                            <div class="ideas__numbers-number"><span data-number="10">10</span>к+</div>
                            <div class="ideas__numbers-text">Объектов</div>
                        </div>
                    </div>
                    <div class="col-xl-3">
                        <div class="ideas__numbers-item">
                            <div class="ideas__numbers-number"><span data-number="100">100</span>к+</div>
                            <div class="ideas__numbers-text">Туристов</div>
                        </div>
                    </div>
                    <div class="col-xl-3">
                        <div class="ideas__numbers-item">
                            <div class="ideas__numbers-number"><span data-number="24">24</span>/<span data-number="7">7</span></div>
                            <div class="ideas__numbers-text">Мы работаем</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about-us-text my-5">
            <p>Компания основана <b>в 2008 году</b>, динамично развивается и имеет репутацию надежной и стабильной. При оснащении современными автоматическими системами для работы, основным приоритетом компании являются люди, а именно <b>«живое» общение сотрудников</b> с туристами, вместо чат-ботов, оперативное решение вопросов в реальном времени, индивидуальный подход к каждому клиенту.</p>
            <p>Вот ещё несколько аргументов:</p>
            <ul>
                <li>более 15 лет на рынке</li>
                <li>широкий ассортимент предложений</li>
                <li>более 10000 объектов размещения</li>
                <li>безопасное бронирование с заключением договора</li>
                <li>персональный менеджер</li>
            </ul>
            <p><b>Курортмакс</b> - ваш профессиональный помощник в подборе и бронировании отелей, санаториев и любых других средств размещения <b>по всей России.</b></p>
        </div>
    </section>

    <section class="news">
        <div class="container">
            <h2 class="title news__title">новости и акции</h2>
            <ul class="news__list">
                <li id="bx_1373509569_12858398" class="news-item news-item_1 wow animate__ animate__fadeInLeft animated" style="background: url(${pageContext.request.contextPath}/images/Banner-vertikalnyy-NOVOSTI-1.png); visibility: visible; animation-name: fadeInLeft;">

                    <!-- <div class="news-top"></div> -->
                    <div class="news-bottom">
                        <div class="news-bottom__date"></div>
                        <div class="news-bottom__text">
                            <ul>
                                <li><span style="font-size: 12pt;"><b><span style="font-size: 13pt;"><br>
	</span></b></span></li>
                                <li><span style="font-size: 12pt;"><b><span style="font-size: 13pt;">Групповое размещение</span></b></span></li>
                                <li><span style="font-size: 12pt;"><b><span style="font-size: 13pt;">Отдых&nbsp;и лечение для сотрудников</span></b></span></li>
                                <li><span style="font-size: 12pt;"><b><span style="font-size: 13pt;">Конференц-услуги для мероприятий</span></b></span></li>
                            </ul>
                            <span style="font-size: 13pt;"> </span><span style="font-size: 12pt;"><b><span style="font-size: 13pt;"> </span></b></span><span style="font-size: 13pt;"> </span>
                            <p>
                                <br>
                            </p>            </div>

                    </div>
                </li>
                <li id="bx_1373509569_12858390" class="news-item news-item_2 bum_news wow animate__ animate__fadeInRight animated" style="visibility: visible; animation-name: fadeInRight;">
                    <div class="news-item__left">
                        <div class="news-item__content">
                            <div class="news-item__content-title">
                                Бронируй прямо сейчас!             </div>
                            <div class="news-item__content-text">
                                <br>            </div>
                        </div>
                    </div>
                    <div class="news-item__right">
                        <img class="news-item__image" src="${pageContext.request.contextPath}/images/Frame-1m.png" alt="">
                    </div>
                </li>
                <li id="bx_1373509569_12858396" class="news-item news-item_3 bum_news wow animate__ animate__fadeInRight animated" style="visibility: visible; animation-name: fadeInRight;">
                    <div class="news-item__left">
                        <div class="news-item__content">
                            <div class="news-item__content-title">
                                Забронировать тур с сертификатом МОСГОРТУР            </div>
                            <div class="news-item__content-text">
                                <br>            </div>
                        </div>
                    </div>
                    <div class="news-item__right">
                        <img class="news-item__image" src="${pageContext.request.contextPath}/images/Frame-2p.png" alt="">
                    </div>
                </li>
            </ul>

        </div>
    </section>

    <!-- Блок «Отзывы» с чистой разметкой Swiper -->
    <section class="feedback-slider" id="reviews">
        <div class="container">
            <h2 class="feedback-slider__title">Отзывы</h2>
            <div class="feedback-slider__outer">
                <div class="swiper feedbackSwiper">
                    <div class="swiper-wrapper">
                        <!-- 1-й отзыв -->
                        <div class="swiper-slide">
                            <div class="feedback-item">
                                <div class="feedback-item__name">Мария Дуйкова</div>
                                <div class="feedback-item__info">
                                    <span>28.06.24</span>
                                </div>
                                <div class="feedback-item__desc">
                                    Все очень понравилось! Спасибо за организацию
                                </div>
                            </div>
                        </div>

                        <!-- 2-й отзыв -->
                        <div class="swiper-slide">
                            <div class="feedback-item">
                                <div class="feedback-item__name">Максим Савинов</div>
                                <div class="feedback-item__info">
                                    <span>04.06.25</span>
                                </div>
                                <div class="feedback-item__desc">
                                    Спасибо за поездку. Я узнал много нового.
                                </div>
                            </div>
                        </div>

                        <!-- 3-й отзыв -->
                        <div class="swiper-slide">
                            <div class="feedback-item">
                                <div class="feedback-item__name">Алексей Смирнов</div>
                                <div class="feedback-item__info">
                                    <span>15.05.25</span>
                                </div>
                                <div class="feedback-item__desc">
                                    Не соответствовало описанию, ожидал большего.
                                </div>
                            </div>
                        </div>

                        <!-- 4-й отзыв -->
                        <div class="swiper-slide">
                            <div class="feedback-item">
                                <div class="feedback-item__name">Ирина Кузнецова</div>
                                <div class="feedback-item__info">
                                    <span>12.03.25</span>
                                </div>
                                <div class="feedback-item__desc">
                                    В целом впечатления положительные, но было жарко.
                                </div>
                            </div>
                        </div>

                        <!-- 5-й отзыв -->
                        <div class="swiper-slide">
                            <div class="feedback-item">
                                <div class="feedback-item__name">Денис Попов</div>
                                <div class="feedback-item__info">
                                    <span>01.02.25</span>
                                </div>
                                <div class="feedback-item__desc">
                                    Спасибо за прекрасно организованное путешествие!
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>


    <!-- Номера -->
    <section id="rooms" class="section-block text-center">
        <h2>Ознакомиться с номерами</h2>
        <p><a href="${pageContext.request.contextPath}/rooms" class="btn btn-success">Перейти к номерам</a></p>
    </section>
</main>

<!-- Footer -->
<footer class="footer text-center">
    <div class="container">
        <p>© 2005-2025 ООО «КурортМакс». ИНН 7700000000, ОГРН 1027700000000</p>
        <p>Разработала: Прилепо А.А.</p>
    </div>
</footer>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function () {
new Swiper('.feedbackSwiper', {
slidesPerView: 1,
spaceBetween: 20,
loop: true,
navigation: {
nextEl: '.swiper-button-next',
prevEl: '.swiper-button-prev',
},
pagination: {
el: '.swiper-pagination',
clickable: true,
},
breakpoints: {
768: {
slidesPerView: 2,
},
1200: {
slidesPerView: 3,
},
},
autoplay: {
delay: 5000,
},
});
});
</script>

</body>
</html>
