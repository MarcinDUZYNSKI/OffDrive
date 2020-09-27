<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Featured -->
<div id="featured">
    <div class="container">
        <header>
            <h2><spring:message code="homepage.welcome"/></h2>
        </header>

        <div>
            <h3>All Tours Trips</h3><br>
            <table>
                <tr>
                    <th>Trip Data</th>
                    <th>Trip Name</th>
                    <th>Length</th>
                    <th>Time</th>
                    <th>Create Route from Trip</th>
                </tr>
                <c:forEach items="${allUserTrips}" var="trip">
                    <tr>
<%--&lt;%&ndash;                        <td><fmt:formatDate value="${trip.tripDate}" pattern="yyyy-MM-dd HH:mm"/> </td>  &ndash;%&gt;  ta metoda wyświetlała błedy, ze taka conwersja jest niemożliwa--%>
                        <td>${trip.createdDate}</td>
                        <td>${trip.name}</td>
                        <td>${trip.length}</td>
                        <td>${trip.tripTime}</td>
                        <td>
                            <a href="/index/createRoute/${trip.id}">Create</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <br>
        <hr/>
        <div class="row">
            <section class="4u">
                <span class="pennant"><span class="fa fa-briefcase"></span></span>
                <h3>Maecenas luctus lectus</h3>
                <p>Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit
                    in, mattis placerat, nulla. Sed ac leo.</p>
                <a href="#" class="button button-style1">Read More</a>
            </section>
            <section class="4u">
                <span class="pennant"><span class="fa fa-lock"></span></span>
                <h3>Maecenas luctus lectus</h3>
                <p>Donec ornare neque ac sem. Mauris aliquet. Aliquam sem leo, vulputate sed, convallis at, ultricies
                    quis, justo. Donec magna.</p>
                <a href="#" class="button button-style1">Read More</a>
            </section>
            <section class="4u">
                <span class="pennant"><span class="fa fa-globe"></span></span>
                <h3>Maecenas luctus lectus</h3>
                <p>Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit
                    in, mattis placerat, nulla. Sed ac leo.</p>
                <a href="#" class="button button-style1">Read More</a>
            </section>
        </div>
        <!-- Main -->
        <div id="main">
            <div id="content" class="container">

                <div class="row">
                    <section class="6u">
                        <a href="#" class="image full"><img src="/images/pic01.jpg" alt=""></a>
                        <header>
                            <h2>Mauris vulputate dolor</h2>
                        </header>
                        <p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra
                            vulputate enim. Aliquam erat volutpat. Donec leo, vivamus fermentum nibh in augue praesent a lacus
                            at urna congue rutrum.</p>
                    </section>
                    <section class="6u">
                        <a href="#" class="image full"><img src="/images/pic02.jpg" alt=""></a>
                        <header>
                            <h2>Mauris vulputate dolor</h2>
                        </header>
                        <p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra
                            vulputate enim. Aliquam erat volutpat. Donec leo, vivamus fermentum nibh in augue praesent a lacus
                            at urna congue rutrum.</p>
                    </section>
                </div>

                <div class="row">
                    <section class="6u">
                        <a href="#" class="image full"><img src="/images/pic03.jpg" alt=""></a>
                        <header>
                            <h2>Mauris vulputate dolor</h2>
                        </header>
                        <p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra
                            vulputate enim. Aliquam erat volutpat. Donec leo, vivamus fermentum nibh in augue praesent a lacus
                            at urna congue rutrum.</p>
                    </section>
                    <section class="6u">
                        <a href="#" class="image full"><img src="/images/pic04.jpg" alt=""></a>
                        <header>
                            <h2>Mauris vulputate dolor</h2>
                        </header>
                        <p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra
                            vulputate enim. Aliquam erat volutpat. Donec leo, vivamus fermentum nibh in augue praesent a lacus
                            at urna congue rutrum.</p>
                    </section>
                </div>

            </div>
        </div>

        <!-- Tweet -->
        <div id="tweet">
            <div class="container">
                <section>
                    <blockquote>&ldquo;In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque
                        viverra vulputate enim. Aliquam erat volutpat.&rdquo;
                    </blockquote>
                </section>
            </div>
        </div>
    </div>
</div>

