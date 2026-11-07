document.addEventListener('DOMContentLoaded', function () {
    var swiper = new Swiper('.mySwiper', {
        loop: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        autoplay: {
            delay: 5000,
        },
    });

    const toggle = document.querySelector('.nav-toggle');
    const menu = document.querySelector('nav ul');
    if (toggle && menu) {
        toggle.addEventListener('click', function () {
            toggle.classList.toggle('active');
            menu.classList.toggle('active');
        });
    }

    const items = document.querySelectorAll('.fade-on-scroll');
    const observer = new IntersectionObserver(function (entries, obs) {
        entries.forEach(function (entry) {
            if (entry.isIntersecting) {
                entry.target.classList.add('appear');
                obs.unobserve(entry.target);
            }
        });
    }, {threshold: 0.2, rootMargin: '0px 0px -50px 0px'});
    items.forEach(function (el) {
        observer.observe(el);
    });
});


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




    document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.room-swiper').forEach(function (container) {
        const slides = container.querySelectorAll('.swiper-slide').length;
        const swiper = new Swiper(container, {
            slidesPerView: 1,
            loop: slides > 1,
            speed: 600,
            autoplay: slides > 1 ? {delay: 2500, disableOnInteraction: false} : false,
            navigation: {
                nextEl: container.querySelector('.swiper-button-next'),
                prevEl: container.querySelector('.swiper-button-prev')
            },
            pagination: {
                el: container.querySelector('.swiper-pagination'),
                clickable: true
            }
        });
    });
});
