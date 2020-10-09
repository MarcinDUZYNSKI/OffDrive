<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>OffDrive</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
          crossorigin="anonymous">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">

                <h1>Are you sure You want to delete:  ${trip.name}</h1><br>
                    <c:if test="${trip != null}">
                   Trip: <br> ${trip.name}
                    </c:if>
                    <c:if test="${route != null}">
                   Route: <br> ${route.name}
                    </c:if>
                </h1><br>

              <button>
                <c:if test="${trip != null}">
                    <a href="/index/deleteTripConfirm/${trip.id}">YES</a>
                </c:if>
                <c:if test="${route != null}">
                    <a href="/index/deleteRouteConfirm/${route.id}">YES</a>
                </c:if>
                </button>
                <button>
                <c:if test="${trip != null}">
                   <a href="/index/user_trips">NO</a>
                </c:if>
                <c:if test="${route != null}">
                    <a href="/index">NO</a>
                </c:if>
                </button>


            </div>
        </div>
    </div>
</section>
</body>
</html>