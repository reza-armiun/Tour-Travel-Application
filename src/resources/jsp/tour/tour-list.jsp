
<style>
    <%@ include file="../../css/tour-list.css" %>
    <%@ include file="../../css/components.css" %>
</style>
<jsp:useBean id="tourList" scope="request" type="java.util.List<razarm.tosan.controller.dto.tour.TourDto>"/>




<div class="container">
    <div class="categories">
        <div class="category__item" >Our Top Picks</div>
        <div class="category__item" >Lowest Price First</div>
        <div class="category__item" >Star rating and price</div>
        <div class="category__item" >Top Reviewed</div>
    </div>
    <div class="filters">
        <div class="filters__header">Filter By:</div>
        <hr />
        <div class="filter-segment">
            <div class="filter-segment__header">Star Rating</div>
            <div class="filter-segment__body">
                <div class="filter-segment__item"><input type="checkbox">filter1</div>
                <div class="filter-segment__item"><input type="checkbox">filter1filter2</div>
                <div class="filter-segment__item"><input type="checkbox">filter1filter3</div>
            </div>
        </div>
        <div class="filter-segment">
            <div class="filter-segment__header">Review Score</div>
            <div class="filter-segment__body">
                <div class="filter-segment__item"><input type="checkbox">filter1Good</div>
                <div class="filter-segment__item"><input type="checkbox">filter1Pleasant</div>
                <div class="filter-segment__item"><input type="checkbox">filter1Very Good</div>
            </div>
        </div>
    </div>
    <div class="tours">

        <c:forEach items="${tourList}"  var="tour">
         <div class="tour">
             <div class="tour__photo">
                 <img src="${tour.imgUrl}" >
             </div>
             <div class="tour__container">
                 <div class="tour__content">
                     <div class="tour__content-main">
                         <div class="tour__content-header"><c:out value="${tour.name}"/></div>
                         <div class="tour__content-text">
                             <c:out value="${tour.description}"/>
                         </div>
                     </div>
                     <div class="tour__content-review">
                         <div class="tour__score">
                             Very Good
                             <div class="label blue" >
                                 <c:out value="${!Float.isNaN(tour.rating) ? tour.rating : 0}"/>
                             </div>
                         </div>
                         <div class="tour__price">
                             Price From
                             <div class="currency"><c:out value="${tour.price}"/></div></div>
                     </div>
                 </div>
                 <div class="tour__container-book">
                     <a class="bui-button" href="${pageContext.request.contextPath}/booking/tour/${tour.id}" >Book Now</a>
                 </div>
             </div>
         </div>
        </c:forEach>
    </div>

</div>
