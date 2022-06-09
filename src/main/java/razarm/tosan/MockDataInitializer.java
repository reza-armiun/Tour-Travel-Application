package razarm.tosan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
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
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.domain.accommodation.AccommodationType;
import razarm.tosan.repository.domain.auth.Admin;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.domain.food.FoodType;
import razarm.tosan.repository.domain.tour.ActivityType;
import razarm.tosan.repository.domain.tour.TourType;
import razarm.tosan.service.*;
import razarm.tosan.service.tour.BookingService;
import razarm.tosan.service.tour.TourRateService;
import razarm.tosan.service.tour.TourService;

import javax.naming.directory.InvalidAttributeValueException;
import java.math.BigInteger;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Set;


@Component
@Slf4j
public class MockDataInitializer implements CommandLineRunner {
    private final AuthService authService;
    private final UserRepository userRepository;
    private final FoodOrderService foodOrderService;
    private final AccommodationOrderService accommodationOrderService;
    private final VehicleOrderService vehicleOrderService;
    private final AddressService addressService;
    private final TourRateService tourRateService;
    private final BookingService bookService;
    private final TourService tourService;
    private final PasswordEncoder passwordEncoder;
    private final PremiumUser reza;

    public MockDataInitializer(AuthService authService, UserRepository userRepository, FoodOrderService foodOrderService, AccommodationOrderService accommodationOrderService, VehicleOrderService vehicleOrderService, AddressService addressService, TourRateService tourRateService, BookingService bookService, TourService tourService, PasswordEncoder passwordEncoder) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.foodOrderService = foodOrderService;
        this.accommodationOrderService = accommodationOrderService;
        this.vehicleOrderService = vehicleOrderService;
        this.addressService = addressService;
        this.tourRateService = tourRateService;
        this.bookService = bookService;
        this.tourService = tourService;
        this.passwordEncoder = passwordEncoder;
        this.reza =
                PremiumUser.PremiumUserBuilder.aPremiumUser()
                        .name("reza")
                        .email("reza@gmail")
                        .authorities(
                                Set.of(
                                        Authority.AuthorityBuilder.anAuthority()
                                                .name("ADMIN")
                                                .build()))
                        .username("reza")
                        .nationalId(1565656156L)
                        .phone("125116484968")
                        .password(passwordEncoder.encode("12345678"))
                        .imageUrl(
                                "data:image/jpeg;base64,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")
                        .isEnabled(true)
                        .isExpired(false)
                        .isCredentialsNonExpired(true)
                        .validEmail(true)
                        .build();
    }

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
                            .fromStation("station 1")
                            .toStation("station 2")
                                                     .ticketNumber("321317892y7171")
                            .price(new BigInteger("1000"))
                            .departure(Instant.now().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .arrival(Instant.now().plus(1 , ChronoUnit.DAYS).atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                    .name("razarm company")
                                    .email("razarm@gmail.com")
                                    .build())
                            .build())
                    .build();

    private  final VehicleOrderDto vehicleOrder2 =
            VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
                    .name("new order 2")
                    .discount(2)
                    .vehicle(PlaneDto.PlaneDtoBuilder.aPlaneDto()
                            .name("razarm plan2")
                            .price(new BigInteger("1000"))
                            .allowedLuggage(2)
                            .fromStation("terminal 1")
                            .toStation("terminal 2")
                                                     .ticketNumber("865456453")
                                                     .departure(Instant.now().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .arrival(Instant.now().plus(1 , ChronoUnit.DAYS).atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                            .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                    .name("razarm company")
                                    .email("razarm@gmail.com")

                                    .build())
                            .build())
                    .build();

    private  final VehicleOrderDto vehicleOrder3 =
            VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
                                                  .name("new order 3")
                                                  .discount(2)
                                                  .vehicle(PlaneDto.PlaneDtoBuilder.aPlaneDto()
                                                                                   .name("razarm bus 3")
                                                                                   .price(new BigInteger("1000"))
                                                                                   .allowedLuggage(2)
                                                                                   .ticketNumber("2131415457785678")
                                                                                   .fromStation("terminal 1")
                                                                                   .toStation("terminal 2")
                                                                                   .departure(Instant.now().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                                                   .arrival(Instant.now().plus(1 , ChronoUnit.DAYS).atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                                                   .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                                                                                                                                .name("razarm company")
                                                                                                                                                .email("razarm@gmail.com")

                                                                                                                                                .build())
                                                                                   .build())
                                                  .build();

    private final AddressDto address1 =
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
    private final AddressDto address2 =
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
    private  final AddressDto address3 =
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




    private  final FoodOrderDto foodOrder1 = FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
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

    private  final FoodOrderDto foodOrder2 = FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
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

    private  final AccommodationOrderDto accommodationOrder1 =
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

    private  final AccommodationOrderDto accommodationOrder2 =
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
    private  final TravelerDto mockTraveler =
            TravelerDto.TravelerDtoBuilder.aTravelerDto()
                    .name("reza")
                    .phone("312312312")
                    .email("razarm@gmail.com")
                    .nationalId(34021123123L)
                    .build();
    private  final TravelerDto mockTraveler2 =
            TravelerDto.TravelerDtoBuilder.aTravelerDto()
                    .name("armin")
                    .phone("231391")
                    .email("armin@gmail.com")
                    .nationalId(1111111L)
                    .build();
    private  final TourismManagerDto mockTourismManager =
            TourismManagerDto.TourismManagerDtoBuilder.aTourismManagerDto()
                    .name("reza")
                    .phone("12311231")
                    .email("razarm@gmail.com")
                    .nationalId(34021123123L)
                    .build();



    public  void initialize() throws InvalidAttributeValueException, UserNotFoundException {
        getMockAddresses();
        getMockVehicles();
        getMockAccommodations();
        getMockFoods();
        getMockUsers();
        getMockBookings();
    }



    private  List<UserDto> getMockUsers() throws InvalidAttributeValueException {


//        this.authService.signup(signupRequest1);
        authService.signup(signupRequest2);
        authService.signup(signupRequest3);

        this.userRepository
                .save(
                        PremiumUser.PremiumUserBuilder.aPremiumUser()
                                .name("reza")
                                .email("reza@gmail")
                                .authorities(
                                        Set.of(Authority.AuthorityBuilder.anAuthority().name("ADMIN").build()))
                                .username("admin")
                                .password(passwordEncoder.encode("12345678"))
                                .imageUrl("data:image/jpeg;base64,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")
                                .isEnabled(true)
                                .isExpired(false)
                                .isCredentialsNonExpired(true)
                                .validEmail(true)
                                .build());

        this.userRepository
                .save(reza);


        return authService.findAllUsers();

    }




    private  List<BookingDto> getMockBookings() throws UserNotFoundException {
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
                        .vehicleOrders(Set.of(vehicleOrder.get(0), vehicleOrder.get(1), vehicleOrder.get(3)))
                                                      .activities(Set.of(ActivityDto.ActivityDtoBuilder.anActivityDto()
                                                                                                       .name("activity1")
                                                                                                       .type(ActivityType.MUSEUM_VISITATION)
                                                                                                       .startAt(ZonedDateTime.now())
                                                                                                       .endAt(ZonedDateTime.now())
                                                                                                       .build(),
                                                                         ActivityDto.ActivityDtoBuilder.anActivityDto()
                                                                                                       .name("activity 2")
                                                                                                       .type(ActivityType.SWIMMING)
                                                                                                       .startAt(ZonedDateTime.now())
                                                                                                       .endAt(ZonedDateTime.now())
                                                                                                       .build()))
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
        var tour1 = tourService.create(mockTour);
        var tour2 = tourService.create(mockTour2);
        var tour3 = tourService.create(mockTour3);
        var savedTour1 = tourService.create(tour1);
        var savedTour2 = tourService.create(tour2);
        var savedTour3 = tourService.create(tour3);



        tourRateService.rateTour(reza.getUsername(), savedTour1.getId(), 10);
        tourRateService.rateTour(signupRequest2.getUsername(), savedTour1.getId(), 5);
        tourRateService.rateTour(signupRequest3.getUsername(), savedTour1.getId(), 7);

        bookService.bookingTour(reza.getUsername(), savedTour1.getId(), mockBooking);
        bookService.bookingTour(signupRequest2.getUsername(), savedTour2.getId(), mockBooking2);
        bookService.bookingTour(signupRequest2.getUsername(), savedTour3.getId(), mockBooking3);
        return bookService.findAllBooking();
    }

    private  List<FoodOrderDto> getMockFoods() {


        foodOrderService.create(foodOrder1);
        foodOrderService.create(foodOrder2);

        return foodOrderService.findAll();
    }

    private  List<AccommodationOrderDto> getMockAccommodations() {

        accommodationOrderService.create(accommodationOrder1);
        accommodationOrderService.create(accommodationOrder2);

        return accommodationOrderService.findAll();

    }


    private  List<VehicleOrderDto> getMockVehicles() {


        vehicleOrderService.create(vehicleOrder1);
        vehicleOrderService.create(vehicleOrder2);
        vehicleOrderService.create(vehicleOrder3);

        return vehicleOrderService.findAll();
    }


    public  List<AddressDto> getMockAddresses () {

        addressService.create(address1);
        addressService.create(address2);
        addressService.create(address3);


        return addressService.findAll();
    }


    @Override
    public void run(String... args) throws Exception {
        this.initialize();

    }
}
