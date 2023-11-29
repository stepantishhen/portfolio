<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
  <head>
    <title>Портфолио фотографа</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="<c:url value="/images/favicon-camera.png"/>" />
    <link href="https://fonts.googleapis.com/css?family=Arbutus+Slab|Open+Sans:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/fonts/icomoon/style.css" />">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/jquery-ui.css" />">
    <link rel="stylesheet" href="<c:url value="/css/owl.carousel.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/owl.theme.default.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/owl.theme.default.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/jquery.fancybox.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-datepicker.css" />">
    <link rel="stylesheet" href="<c:url value="/fonts/flaticon/font/flaticon.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/aos.css" />">
    <link rel="stylesheet" href="<c:url value="/css/style.css" />">
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  <div class="site-wrap">
    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
    <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">
      <div class="container-fluid">
        <div class="row align-items-center justify-content-center">
          <div class="">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#home-section" class="nav-link">Главная</a></li>
                <li><a href="#services-section" class="nav-link">Направления</a></li>
                <li><a href="#about-section" class="nav-link">Обо мне</a></li>
              </ul>
            </nav>
          </div>
          <div class="text-center mx-5">
            <c:if test="${sessionScope.user != null}">
              <a href="<c:url value="/profile/edit"/>" class="btn btn-primary btn-sm px-4 py-2">
                ${sessionScope.user.username}
              </a>
            </c:if>
            <c:if test="${sessionScope.user == null}">
              <a href="<c:url value="/signin"/>" class="btn btn-primary btn-sm px-4 py-2">
                Войти
              </a>
            </c:if>
          </div>
          <div class="text-left">
            <nav class="site-navigation position-relative" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#portfolio-section" class="nav-link">Портфолио</a></li>
                <li><a href="#review-add-section" class="nav-link">Отзывы</a></li>
                <li><a href="#clients-section" class="nav-link">Клиенты</a></li>
              </ul>
            </nav>
            <div class="d-inline-block d-lg-none" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle float-right"><span class="icon-menu h3"></span></a></div>
          </div>
        </div>
      </div>
    </header>
    <div class="site-blocks-cover overlay bg-light" id="home-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-12 mt-lg-5 text-left align-self-center text-intro">
            <div class="row">
              <div class="col-lg-6">
                <h1 class="text-black">Я Степан Тищенко</h1>
                <p class="lead">Фотограф из Казани</p>
                <p><a href="#portfolio-section" class="btn smoothscroll btn-primary">К портфолио</a></p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <img src="<c:url value="/images/face-new.png"/>" alt="Image" class="img-face" data-aos="fade">
    </div>
    <div class="site-section" id="services-section">
      <div class="container">
        <div class="row ">
          <div class="col-12 mb-5 position-relative">
            <h2 class="section-title text-center mb-5">Направления съёмки</h2>
          </div>
          <div class="col-md-6 mb-4">
            <div class="service d-flex h-100">
              <div class="service-number mr-4"><span class="icon-style"></span></div>
              <div class="service-about">
                <h3>Пейзажная</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4">
            <div class="service d-flex h-100">
              <div class="service-number mr-4"><span class="icon-business_center"></span></div>
              <div class="service-about">
                <h3>Портретная</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4">
            <div class="service d-flex h-100">
              <div class="service-number mr-4"><span class="icon-desktop_windows"></span></div>
              <div class="service-about">
                <h3>Репортажная</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
              </div>
            </div>
          </div>
          <div class="col-md-6 mb-4">
            <div class="service d-flex h-100">
              <div class="service-number mr-4"><span class="icon-layers"></span></div>
              <div class="service-about">
                <h3>Предметная</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="site-section" id="about-section">
      <div class="container">
        <div class="row ">
          <div class="col-12 mb-4 position-relative">
            <h2 class="section-title">Обо мне</h2>
          </div>
          <div class="col-lg-4 order-1 order-lg-2 mb-4 mb-lg-0">
            <div class="bg-light pt-5">
            <img src="<c:url value="/images/face-new.png"/>" alt="Image" class="img-fluid" height="100px">
            </div>
          </div>
          <div class="col-lg-4 order-2 order-lg-1">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
          </div>
          <div class="col-lg-4 order-3 order-lg-3">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis ipsum error eligendi molestiae eaque quas, ducimus sequi excepturi?</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aperiam qui maiores, ipsa quibusdam distinctio! Expedita ipsum ex porro obcaecati.</p>
            <p><a href="#review-section" class="btn smoothscroll btn-primary">Отзывы</a></p>
          </div>
        </div>
      </div>
    </div>
    <section class="site-section block__62272" id="portfolio-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-12 position-relative">
            <h2 class="section-title text-center mb-5">Портфолио</h2>
          </div>
        </div>
        <div id="posts" class="row no-gutter">
          <c:forEach items="${files}" var="file">
            <div class="item web col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-4">
              <a href="<c:url value="/uploaded/files?id=${file.id}"/>" class="item-wrap fancybox">
                <span class="icon-search2"></span>
                <img class="img-fluid" src="<c:url value="/uploaded/files?id=${file.id}"/>">
              </a>
            </div>
          </c:forEach>
        </div>
      </div>
    </section>
    <c:choose>
      <c:when test="${sessionScope.user == null}">
        <section class="site-section" id="review-add-section">
        <div class="container">
          <div class="row">
            <div class="col-12 mb-5 position-relative">
              <h2>Чтобы оставить отзыв</h2>
              <p>войдите или зарегистрируйтесь на сайте</p>
              <a href="<c:url value="/signin"/>" class="btn btn-primary">Войти</a>
              <a href="<c:url value="/register"/>" class="btn btn-primary">Зарегистрироваться</a>
            </div>
          </div>
        </div>
        </section>
      </c:when>
      <c:otherwise>
        <section class="site-section" id="review-add-section">
          <div class="container">
            <div class="row">
              <div class="col-12 mb-5 position-relative">
                <h2 class="section-title text-center mb-5">Оставить отзыв</h2>
              </div>
            </div>
            <form action="<c:url value="/review/create" />" method="post" class="form">
              <div class="row mb-4">
                <div class="rating-area">
                  <input type="radio" id="star-5" name="rating" value="5">
                  <label for="star-5" title="Оценка «5»"></label>
                  <input type="radio" id="star-4" name="rating" value="4">
                  <label for="star-4" title="Оценка «4»"></label>
                  <input type="radio" id="star-3" name="rating" value="3">
                  <label for="star-3" title="Оценка «3»"></label>
                  <input type="radio" id="star-2" name="rating" value="2">
                  <label for="star-2" title="Оценка «2»"></label>
                  <input type="radio" id="star-1" name="rating" value="1">
                  <label for="star-1" title="Оценка «1»"></label>
                </div>
              </div>
              <div class="row mb-4">
                <div class="form-group col-12">
                  <textarea name="text" id="" cols="30" rows="10" class="form-control" placeholder="Сообщение"></textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <input type="submit" class="btn btn-primary" value="Отправить сообщение">
                </div>
              </div>
            </form>
          </div>
        </section>
      </c:otherwise>
    </c:choose>
    <section class="site-section bg-dark" id="review-section">
      <div class="container">
        <div class="row">
          <div class="col-12 mb-5 position-relative">
            <h2 class="section-title text-center mb-5 text-white">Реальные отзывы</h2>
          </div>
        </div>
        <div class="owl-carousel slide-one-item">
          <c:forEach items="${reviews}" var="review">
            <div class="slide">
              <blockquote>
                <!-- получить имя пользователя по review.id -->
                <p>${review.text}</p>
                <p>Оценка - ${review.rating}</p>
              </blockquote>
            </div>
          </c:forEach>
        </div>
      </div>
    </section>
    <section class="site-section"  id="clients-section">
      <div class="container">
        <div class="row">
          <div class="col-12 mb-5 position-relative">
            <h2 class="section-title text-center">Клиенты</h2>
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_1.jpg"/>" alt="Image" class="img-fluid">
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_2.jpg"/>" alt="Image" class="img-fluid">
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_3.jpg"/>" alt="Image" class="img-fluid">
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_4.jpg"/>" alt="Image" class="img-fluid">
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_5.jpg"/>" alt="Image" class="img-fluid">
          </div>
          <div class="col-6 col-sm-6 col-md-4 col-lg-4 text-center">
            <img src="<c:url value="/images/logo_6.jpg"/>" alt="Image" class="img-fluid">
          </div>
        </div>
      </div>
    </section>
    <footer class="site-section bg-light footer">
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved</p>
          </div>
        </div>
      </div>
    </footer>
  </div>
  <style>
    .rating-area {
      overflow: hidden;
      width: 265px;
      margin: 0 auto;
    }
    .rating-area:not(:checked) > input {
      display: none;
    }
    .rating-area:not(:checked) > label {
      float: right;
      width: 42px;
      padding: 0;
      cursor: pointer;
      font-size: 32px;
      line-height: 32px;
      color: lightgrey;
      text-shadow: 1px 1px #bbb;
    }
    .rating-area:not(:checked) > label:before {
      content: '★';
    }
    .rating-area > input:checked ~ label {
      color: gold;
      text-shadow: 1px 1px #c60;
    }
    .rating-area:not(:checked) > label:hover,
    .rating-area:not(:checked) > label:hover ~ label {
      color: gold;
    }
    .rating-area > input:checked + label:hover,
    .rating-area > input:checked + label:hover ~ label,
    .rating-area > input:checked ~ label:hover,
    .rating-area > input:checked ~ label:hover ~ label,
    .rating-area > label:hover ~ input:checked ~ label {
      color: gold;
      text-shadow: 1px 1px goldenrod;
    }
    .rate-area > label:active {
      position: relative;
    }
  </style>
  <script src="<c:url value="/js/jquery-3.3.1.min.js" />"></script>
  <script src="<c:url value="/js/jquery-ui.js" />"></script>
  <script src="<c:url value="/js/popper.min.js" />"></script>
  <script src="<c:url value="/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/js/owl.carousel.min.js" />"></script>
  <script src="<c:url value="/js/jquery.easing.1.3.js" />"></script>
  <script src="<c:url value="/js/aos.js" />"></script>
  <script src="<c:url value="/js/jquery.fancybox.min.js" />" ></script>
  <script src="<c:url value="/js/jquery.sticky.js" />"></script>
  <script src="<c:url value="/js/isotope.pkgd.min.js" />"></script>
  <script src="<c:url value="/js/main.js" />"></script>
  </body>
</html>