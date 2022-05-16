<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="razarm.tosan.controller.dto.tour.BookingDto" %>
<style>
    <%@ include file="../../css/booking-success.css"%>
</style>

<jsp:useBean id="booking" type="razarm.tosan.controller.dto.tour.BookingDto" scope="session" />
<jsp:useBean id="principal" type="razarm.tosan.repository.domain.auth.UserDetails" scope="session" />

<div id="blue_segment"/>
<div class="container">
    <div class="card">
        <div class="info">
            <div class="booking__header">Your booking is done</div>
            <div class="booking__description">Your trip id is <b><c:out value="${booking.id}" /></b> All details will be sent to
                <c:out value="${principal.email}" /> </div>
            <div class="booking__sub">Thank you for booking with Rezatrip, Use the above trip id in all your communications</div>
        </div>
        <div class="details">
            <div class="details__header">YOU JUST BOOKED</div>
            <div class="details__body">
                <div class="booking__name">${booking.tour.name}</div>
                <div class="booking__locations">
                    <c:forEach items="${booking.tour.schedulePlans}" var="plan">
                        <div class="location__item">
                            <div class="booking__source">${plan.source.city.country.name} ---></div>
                            <div class="booking__dest">${plan.destination.city.country.name}</div>
                        </div>
                    </c:forEach>
                    <div class="booking__time">${booking.date}</div>
                </div>
            </div>
        </div>
        <hr/>
        <div class="travelers">
            <div class="travelers__header">TRAVELERS IN THIS TRIP</div>
            <div class="travelers__body">
                <c:forEach items="${booking.travelers}" var="traveler">
                    <div class="travelers__item">
                        <div class="traveler__name">${traveler.name}</div>
                        <div class="traveler__contact">
                            <div class="traveler__email">${traveler.email}</div>
                            <div class="traveler__phone">${traveler.phone}</div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>
