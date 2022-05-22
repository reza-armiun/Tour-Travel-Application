<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="razarm.tosan.controller.dto.tour.TourDto" %>
<style>
    <%@ include file="../../css/booking-form.css" %>
</style>

<jsp:useBean id="tour" type="razarm.tosan.controller.dto.tour.TourDto" scope="session"/>

<div class="container" >
    <h1 class="header">Booking Ticket</h1>
    <div class="booking__container">
        <div class="traveler">
            <form class="form" method="post" action="${pageContext.request.contextPath}/booking/tour/${tour.id}">
                <div class="form__header">Traveler details</div>
                <div class="fields">
                    <div class="fields__item">
                        <label>First Name<span class="required">*</span></label>
                        <input name="firstName"  required type="text">
                    </div>

                    <div class="fields__item">
                        <label>Last Name<span class="required">*</span></label>
                        <input name="lastName" required type="text">
                    </div>
                    <div class="fields__item">
                        <label>Email Address<span class="required">*</span></label>
                        <input name="email" required type="email">
                    </div>
                    <div class="fields__item">
                        <label>Phone Number<span class="required">*</span></label>
                        <input name="phone" required type="text">
                    </div>
                    <div class="fields__item">
                        <label>National Id<span class="required">*</span></label>
                        <input name="nationalId" required type="number">
                    </div>
                    <div class="fields__item">
                        <label>Description<span class="required">*</span></label>
                        <textarea name="description" required  maxlength="300"></textarea>
                    </div>
                </div>
                <div class="segment">
                    <div class="segment__header">Cancellation policy</div>
                    <div class="segment__description">
                        The free cancellation period for this booking has already passed, so it's no longer possible to get a refund if you cancel.
                    </div>
                </div>
                <div class="segment">
                    <div class="segment__header">Digital ticket</div>
                    <div class="segment__description">
                        Print tickets at home or show them on your phone at the venue
                    </div>
                </div>

                <button type="submit" class="submit-button">Next</button>

            </form>

        </div>
        <div class="tour">
            <div class="tour__details">
                <div class="tour__photo"><img  class="tour__image" src="<%=tour.getImgUrl()%>"></div>
                <div class="tour__body">
                    <div class="tour__header">
                        <c:out value="${tour.name}" />
                    </div>
                    <div class="tour__description"><c:out value="${tour.description}" /></div>
                    <div class="price"><c:out value="${tour.price}" /></div>
                </div>
            </div>
            <div class="ticket">
                <hr class="divider"/>
                <c:forEach items="${tour.schedulePlans}" var="plan">
                    <div class="ticket__item">
                        <div class="ticket__detail"><c:out value="${plan.name}" /></div>
                        <div class="ticket__price"><c:out value="${plan.calculatePrice()}" />$</div>
                    </div>
                </c:forEach>
                <div class="ticket__total">
                    <div class="ticket__detail">Total Price</div>
                    <div class="ticket__price">${tour.price}$</div>
                </div>
            </div>
            <form style="width: 100%" method="post" action="${pageContext.request.contextPath}/booking/tour/${tour.id}">
                <button type="submit" class="submit-button">Next</button>
            </form>
        </div>
    </div>
</div>