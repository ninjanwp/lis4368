<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
      name="description"
      content="My online portfolio that illustrates skills acquired while working through various project requirements."
    />
    <meta name="author" content="Nicholas Pfeffer" />
    <link rel="icon" href="./global/favicon.ico" />

    <title>My Online Portfolio</title>

    <%@ include file="/css/include_css.jsp" %>

    <!-- Carousel styles -->
    <style type="text/css">

:root {
	--clr-primary: #7b0ae4;
}

      h2 {
        margin: 0;
        color: #666;
        padding-top: 50px;
        font-size: 52px;
        font-family: "trebuchet ms", sans-serif;
      }
      .item {
        background: #333;
        text-align: center;
        height: 500px !important;
      }
      .carousel {
        margin: 0;
      }
      .bs-example {
        margin: 20px;
      }

      .carousel-caption {
        background: rgba(0, 0, 0, 0.5);
        border-radius: 2rem;
        opacity: 0;
		transform: translateY(100%);
        transition: all 0.3s ease;
		width: auto;
		padding: 15px;
        margin-bottom: 30px;
		border: 1px solid rgba(255, 255, 255, 0.3);
		box-shadow: 0 0 30px rgba(0, 0, 0, 0.5);
		backdrop-filter: blur(5px);
      }

      .carousel:hover .carousel-caption {
        opacity: 1;
		transform: translateY(0);
      }

	  .link-button {
		background: none;
		padding: 5px 15px;
		text-decoration: none;
		color: white;
		transition: all 0.3s ease !important;
		border: 1px solid var(--clr-primary);
		border-radius: 5px;
	  }

	  .link-button:hover {
		text-decoration: none !important;
		color: white;
		background: var(--clr-primary);
	}

    </style>
  </head>
  <body>
    <%@ include file="/global/nav_global.jsp" %>

    <div class="container">
      <div class="starter-template">
        <div class="page-header"><%@ include file="/global/header.jsp" %></div>

        <!-- Start Bootstrap Carousel  -->
        <div class="bs-example">
          <div
            id="myCarousel"
            class="carousel slide"
            data-interval="3000"
            data-pause="hover"
            data-wrap="true"
            data-keyboard="true"
            data-ride="carousel"
          >
            <!-- Carousel indicators -->
            <ol class="carousel-indicators">
              <li
                data-target="#myCarousel"
                data-slide-to="0"
                class="active"
              ></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- Carousel items -->
            <div class="carousel-inner">
              <div
                class="active item"
                style="
                  background: url(img/bitbucket.png) no-repeat left center;
                  background-size: cover;
                "
              >
                <div class="container">
                  <div class="carousel-caption">
                    <h3>Bitbucket</h3>
                    <p>Link to my remote Bitbucket repository for LIS4368</p>
                    <a
                      class="link-button"
                      href="https://bitbucket.org/np22i/lis4368/src/master/"
                      >Learn more</a
                    >
                  </div>
                </div>
              </div>

              <div
                class="item"
                style="
                  background: url(img/github.png) no-repeat left center;
                  background-size: cover;
                "
              >
                <div class="container">
                  <div class="carousel-caption">
                    <h3>Github</h3>
                    <p>Link to my GitHub profile</p>
                    <a
                      class="link-button"
                      href="https://github.com/ninjanwp"
                      >Learn more</a
                    >
                  </div>
                </div>
              </div>

              <div
                class="item"
                style="
                  background: url(img/portfolio.jpg) no-repeat left center;
                  background-size: cover;
                "
              >
                <div class="container">
                  <div class="carousel-caption">
                    <h3>Personal Website</h3>
                    <p>
                      Link to my personal domain/website that showcases my
                      digital portfolio
                    </p>
                    <a
                      class="link-button"
                      href="https://nickpfeffer.com/"
                      >Learn more</a
                    >
                  </div>
                </div>
              </div>
            </div>
            <!-- Carousel nav -->
            <a
              class="carousel-control left"
              href="#myCarousel"
              data-slide="prev"
            >
              <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a
              class="carousel-control right"
              href="#myCarousel"
              data-slide="next"
            >
              <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
          </div>
        </div>
        <!-- End Bootstrap Carousel  -->

        <%@ include file="/global/footer.jsp" %>
      </div>
      <!-- end starter-template -->
    </div>
    <!-- end container -->

    <%@ include file="/js/include_js.jsp" %>
  </body>
</html>
