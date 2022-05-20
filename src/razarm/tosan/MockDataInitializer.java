package razarm.tosan;

import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.dto.accommodation.AccommodationProviderDto;
import razarm.tosan.controller.dto.accommodation.HotelDto;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.controller.dto.tour.*;
import razarm.tosan.controller.dto.transport.PlaneDto;
import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.accommodation.AccommodationType;
import razarm.tosan.repository.domain.auth.Admin;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.domain.food.FoodType;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.utility.PasswordEncoder;

import javax.naming.directory.InvalidAttributeValueException;
import java.math.BigInteger;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

public class MockDataInitializer {
    private static final SignupRequest signupRequest1 = SignupRequest.SignupRequestBuilder.aSignupRequest()
            .name("reza armiun")
            .username("reza")
            .email("razarm@gmail.com")
            .password("12345678")
            .rePassword("12345678")
            .build();
    private static final SignupRequest signupRequest2 = SignupRequest.SignupRequestBuilder.aSignupRequest()
            .name("reza armin")
            .username("razarm2@gmail.com")
            .email("razarm2@gmail.com")
            .password("12345678")
            .rePassword("12345678")
            .build();

    private static final SignupRequest signupRequest3 =
            SignupRequest.SignupRequestBuilder.aSignupRequest()
                    .name("razarm")
                    .username("armin@gmail.com")
                    .email("armin@gmail.com")
                    .password("12345678")
                    .rePassword("12345678")
                    .build();

    private static final VehicleOrderDto vehicleOrder1 =
            VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
                    .name("new order 1")
                    .discount(2)
                    .vehicle(PlaneDto.PlaneDtoBuilder.aPlaneDto()
                            .name("razarm plan1")
                            .allowedLuggage(2)
                            .price(new BigInteger("1000"))
                            .departure(Instant.now().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .arrival(Instant.now().plus(1 , ChronoUnit.DAYS).atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                    .name("razarm company")
                                    .email("razarm@gmail.com")
                                    .build())
                            .build())
                    .build();

    private static final VehicleOrderDto vehicleOrder2 =
            VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
                    .name("new order 2")
                    .discount(2)
                    .vehicle(PlaneDto.PlaneDtoBuilder.aPlaneDto()
                            .name("razarm plan2")
                            .price(new BigInteger("1000"))
                            .allowedLuggage(2)
                            .departure(Instant.now().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .arrival(Instant.now().plus(1 , ChronoUnit.DAYS).atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                    .name("razarm company")
                                    .email("razarm@gmail.com")

                                    .build())
                            .build())
                    .build();



    private static AddressDto address1 =
            AddressDto.AddressDtoBuilder.anAddressDto()
                    .street("street 1")
                    .postalCode("postal code 12345")
                    .city(
                            CityDto.CityDtoBuilder.aCityDto()
                                    .name("city name 1")
                                    .zipCode(2131231)
                                    .country(CountryDto.CountryDtoBuilder.aCountryDto()
                                            .name("country name 1")
                                            .countryCode("3123")
                                            .build())
                                    .build())
                    .build();
    private static AddressDto address2 =
            AddressDto.AddressDtoBuilder.anAddressDto()
                    .street("street 2")
                    .postalCode("postal code 123123345")
                    .city(
                            CityDto.CityDtoBuilder.aCityDto()
                                    .name("city name 2")
                                    .zipCode(231231231)
                                    .country(CountryDto.CountryDtoBuilder.aCountryDto()
                                            .name("country name 2")
                                            .countryCode("312322")
                                            .build())
                                    .build())
                    .build();
    private static AddressDto address3 =
            AddressDto.AddressDtoBuilder.anAddressDto()
                    .street("street 3")
                    .postalCode("postal code 213123")
                    .city(
                            CityDto.CityDtoBuilder.aCityDto()
                                    .name("city name 3")
                                    .zipCode(231231231)
                                    .country(CountryDto.CountryDtoBuilder.aCountryDto()
                                            .name("country name3")
                                            .countryCode("31232ewqeq2")
                                            .build())
                                    .build())
                    .build();




    private static final FoodOrderDto foodOrder1 = FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
            .date(ZonedDateTime.now())
            .discount(2)
            .food(FoodDto.FoodDtoBuilder.aFoodDto()
                    .name("pizza")
                    .type(FoodType.PROTEIN)
                    .price(new BigInteger("2000"))
                    .cookTime(22L)
                    .provider(FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                            .name("razarm company")
                            .phone("113123123")
                            .email("razarm@gmail.com")
                            .description("description")
                            .address("address")
                            .build())
                    .build())
            .build();

    private static final FoodOrderDto foodOrder2 = FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
            .date(ZonedDateTime.now())
            .discount(2)
            .food(FoodDto.FoodDtoBuilder.aFoodDto()
                    .name("pizza2")
                    .type(FoodType.PROTEIN)
                    .price(new BigInteger("2000"))
                    .cookTime(12L)
                    .provider(FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                            .name("razarm company")
                            .phone("213444")
                            .email("razarm@gmail.com")
                            .description("description 2")
                            .address("address2")
                            .build())
                    .build())
            .build();

    private static final AccommodationOrderDto accommodationOrder1 =
            AccommodationOrderDto.AccommodationOrderDtoBuilder.anAccommodationOrderDto()
                    .date(ZonedDateTime.now())
                    .discount(2)
                    .accommodation(
                            HotelDto.HotelDtoBuilder.aHotelDto()
                                    .name("hotel1")
                                    .type(AccommodationType.HOTEL)
                                    .price(new BigInteger("3000"))
                                    .time(213L)
                                    .addressDto(address1)
                                    .accommodationProvider(
                                            AccommodationProviderDto.AccommodationProviderDtoBuilder
                                                    .anAccommodationProviderDto()
                                                    .name("razarm company")
                                                    .phone("2131231")
                                                    .email("razarm@gmail.com")
                                                    .description("desc")
                                                    .build())
                                    .build())
                    .build();

    private static final AccommodationOrderDto accommodationOrder2 =
            AccommodationOrderDto.AccommodationOrderDtoBuilder.anAccommodationOrderDto()
                    .date(ZonedDateTime.now())
                    .discount(2)
                    .accommodation(
                            HotelDto.HotelDtoBuilder.aHotelDto()
                                    .name("hotel2")
                                    .type(AccommodationType.HOTEL)
                                    .price(new BigInteger("3000"))
                                    .time(213L)
                                    .addressDto(address1)
                                    .accommodationProvider(
                                            AccommodationProviderDto.AccommodationProviderDtoBuilder
                                                    .anAccommodationProviderDto()
                                                    .name("razarm company")
                                                    .phone("2131231")
                                                    .email("razarm@gmail.com")
                                                    .description("desc")
                                                    .build())
                                    .build())
                    .build();
    //////////////////////////////////////////////////////BOOKING////////////////////////////////////////////////////////////
    private static final TravelerDto mockTraveler =
            TravelerDto.TravelerDtoBuilder.aTravelerDto()
                    .name("reza")
                    .phone("312312312")
                    .email("razarm@gmail.com")
                    .nationalId(34021123123L)
                    .build();
    private static final TravelerDto mockTraveler2 =
            TravelerDto.TravelerDtoBuilder.aTravelerDto()
                    .name("armin")
                    .phone("231391")
                    .email("armin@gmail.com")
                    .nationalId(1111111L)
                    .build();
    private static final TourismManagerDto mockTourismManager =
            TourismManagerDto.TourismManagerDtoBuilder.aTourismManagerDto()
                    .name("reza")
                    .phone("12311231")
                    .email("razarm@gmail.com")
                    .nationalId(34021123123L)
                    .build();



    public static void initialize() throws InvalidAttributeValueException, UserNotFoundException {
        getMockAddresses();
        getMockVehicles();
        getMockAccommodations();
        getMockFoods();
        getMockUsers();
        getMockBookings();
    }



    private static List<UserDto> getMockUsers() throws InvalidAttributeValueException {

        var authService = AppContextHolder.getAuthService();

        authService.signup(signupRequest1);
        authService.signup(signupRequest2);
        authService.signup(signupRequest3);

        AppContextHolder.getUserRepository()
                .save(
                        PremiumUser.PremiumUserBuilder.aPremiumUser()
                                .name("reza")
                                .email("reza@gmail")
                                .authorities(
                                        Set.of(Authority.AuthorityBuilder.anAuthority().name("ADMIN").build()))
                                .username("admin")
                                .password(new PasswordEncoder().encrypt("12345678".toCharArray()))
                                .build());

        return authService.findAllUsers();

    }




    private static List<BookingDto> getMockBookings() throws UserNotFoundException {
        var accommodationOrder = getMockAccommodations();
        var vehicleOrder = getMockVehicles();
        var foodOrder = getMockFoods();
        final SchedulePlanDto mockSchedulePlan =
                SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
                        .name("iran to turkey")
                        .startTime(ZonedDateTime.now())
                        .arrivalTime(ZonedDateTime.now().plusDays(1))
                        .source(address1)
                        .destination(address2)
                        .accommodationOrder(accommodationOrder.get(0))
                        .foodOrders(Set.of(foodOrder.get(0)))
                        .vehicleOrders(Set.of(vehicleOrder.get(0)))
                        .build();

        final SchedulePlanDto mockSchedulePlan2 =
                SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
                        .name("turkey to ukraine")
                        .startTime(ZonedDateTime.now())
                        .arrivalTime(ZonedDateTime.now().plusDays(1))
                        .source(address2)
                        .destination(address3)
                        .accommodationOrder(accommodationOrder.get(0))
                        .foodOrders(Set.of(foodOrder.get(1)))
                        .vehicleOrders(Set.of(vehicleOrder.get(1)))
                        .build();
        final SchedulePlanDto mockSchedulePlan3 =
                SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
                        .name("turkey to ukraine")
                        .startTime(ZonedDateTime.now())
                        .arrivalTime(ZonedDateTime.now().plusDays(1))
                        .source(address2)
                        .destination(address3)
                        .accommodationOrder(accommodationOrder.get(0))
                        .foodOrders(Set.of(foodOrder.get(1)))
                        .vehicleOrders(Set.of(vehicleOrder.get(1)))
                        .build();

        final TourDto mockTour = TourDto.TourDtoBuilder.aTourDto()
                .schedulePlans(Set.of(mockSchedulePlan))
                .tourismManager(mockTourismManager)
                .type(TourType.CITY)
                .date(ZonedDateTime.now())
                .imgUrl("https://th.bing.com/th/id/OIP.YPTa9g7VLfC2rRjD4VQrMAHaE8?pid=ImgDet&rs=1")
                .name("Razarm City Tour")
                .description("Special tour for cool  guys")
                .build();
        final TourDto mockTour2 = TourDto.TourDtoBuilder.aTourDto()
                .schedulePlans(Set.of(mockSchedulePlan2))
                .tourismManager(mockTourismManager)
                .type(TourType.VILLAGE)
                .imgUrl("https://th.bing.com/th/id/OIP.dHJ2e7OgXAVpbj38MxihIAHaE8?pid=ImgDet&rs=1")
                .date(ZonedDateTime.now())
                .name("Armin Village Tour")
                .description("Special tour for cool village guys")
                .build();
        final TourDto mockTour3 = TourDto.TourDtoBuilder.aTourDto()
                .schedulePlans(Set.of(mockSchedulePlan2))
                .tourismManager(mockTourismManager)
                .imgUrl("https://th.bing.com/th/id/OIP.haDqsmP5az2jk01FXuTPowHaE8?pid=ImgDet&rs=1")
                .type(TourType.VILLAGE)
                .date(ZonedDateTime.now())
                .name("Razarm Village Tour")
                .description("Special Village tour")
                .build();

        final BookingDto mockBooking =
                BookingDto.BookingDtoBuilder.aBookingDto()
                        .date(OffsetDateTime.now().toZonedDateTime())
                        .travelers(Set.of(mockTraveler))
                        .tour(mockTour)
                        .description("mock Booking ")
                        .build();

        final BookingDto mockBooking2 =
                BookingDto.BookingDtoBuilder.aBookingDto()
                        .date(OffsetDateTime.now().toZonedDateTime())
                        .travelers(Set.of(mockTraveler2))
                        .tour(mockTour2)
                        .description("mock Booking 2")
                        .build();
        final BookingDto mockBooking3 =
                BookingDto.BookingDtoBuilder.aBookingDto()
                        .date(OffsetDateTime.now().toZonedDateTime())
                        .travelers(Set.of(mockTraveler2))
                        .tour(mockTour3)
                        .description("mock Booking 3")
                        .build();
        var tourRateService = AppContextHolder.getTourRateService();
        var bookService = AppContextHolder.getBookingService();
        var tourService = AppContextHolder.getTourService();
        var tour1 =tourService.create(mockTour);
        var tour2 = tourService.create(mockTour2);
        var tour3 = tourService.create(mockTour3);
        var savedTour1 = tourService.create(tour1);
        var savedTour2 = tourService.create(tour2);
        var savedTour3 = tourService.create(tour3);



        tourRateService.rateTour(signupRequest1.getUsername(), savedTour1.getId(), 10);
        tourRateService.rateTour(signupRequest2.getUsername(), savedTour1.getId(), 5);
        tourRateService.rateTour(signupRequest3.getUsername(), savedTour1.getId(), 7);

        var book1 = bookService.bookingTour(signupRequest1.getUsername(), savedTour1.getId(), mockBooking);
        var book2 = bookService.bookingTour(signupRequest2.getUsername(), savedTour2.getId(), mockBooking2);
        var book3 =bookService.bookingTour(signupRequest2.getUsername(), savedTour3.getId(), mockBooking3);
        return bookService.findAllBooking();
    }

    private static List<FoodOrderDto> getMockFoods() {

        var orderService = AppContextHolder.getFoodOrderService();

        orderService.create(foodOrder1);
        orderService.create(foodOrder2);

        return orderService.findAll();
    }

    private static List<AccommodationOrderDto> getMockAccommodations() {

        var accommodationOrderService = AppContextHolder.getAccommodationOrderService();
        accommodationOrderService.create(accommodationOrder1);
        accommodationOrderService.create(accommodationOrder2);

        return accommodationOrderService.findAll();

    }


    private static List<VehicleOrderDto> getMockVehicles() {

        var vehicleOrderService = AppContextHolder.getVehicleOrderService();

        vehicleOrderService.create(vehicleOrder1);
        vehicleOrderService.create(vehicleOrder2);

        return vehicleOrderService.findAll();
    }


    public static List<AddressDto> getMockAddresses () {
        var addressService = AppContextHolder.getAddressService();

        addressService.create(address1);
        addressService.create(address2);
        addressService.create(address3);


        return addressService.findAll();
    }



}
