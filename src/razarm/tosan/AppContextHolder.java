package razarm.tosan;

import razarm.tosan.controller.mapper.accommodation.AccOrderDtoToAccOrder;
import razarm.tosan.controller.mapper.accommodation.AccOrderToAccOrderDto;
import razarm.tosan.controller.mapper.accommodation.AccommodationDtoToAccommodation;
import razarm.tosan.controller.mapper.accommodation.AccommodationToAccommodationDto;
import razarm.tosan.controller.mapper.address.*;
import razarm.tosan.controller.mapper.food.*;
import razarm.tosan.controller.mapper.tour.*;
import razarm.tosan.controller.mapper.transport.VehicleDtoToVehicle;
import razarm.tosan.controller.mapper.transport.VehicleOrderDtoToVehicleOrder;
import razarm.tosan.controller.mapper.transport.VehicleOrderToVehicleOrderDto;
import razarm.tosan.controller.mapper.transport.VehicleToVehicleDto;
import razarm.tosan.controller.mapper.user.UserDtoToUser;
import razarm.tosan.controller.mapper.user.UserToUserDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.*;
import razarm.tosan.repository.inMemoryImpl.auth.UserRepositoryInMemoryImpl;
import razarm.tosan.repository.inMemoryImpl.auth.UserSessionRepositoryInMemoryImpl;
import razarm.tosan.repository.inMemoryImpl.food.FoodOrderRepositoryImpl;
import razarm.tosan.repository.inMemoryImpl.location.AddressRepositoryImpl;
import razarm.tosan.repository.inMemoryImpl.tour.BookingRepositoryImpl;
import razarm.tosan.repository.inMemoryImpl.tour.TourRepositoryImpl;
import razarm.tosan.repository.inMemoryImpl.transport.VehicleOrderRepositoryImpl;
import razarm.tosan.repository.inStorageImpl.accommodation.AccommodationOrderInStorageImpl;
import razarm.tosan.repository.inStorageImpl.auth.UserRepositoryInStorageImpl;
import razarm.tosan.repository.mapper.BookingDataToBooking;
import razarm.tosan.repository.mapper.BookingToBookingData;
import razarm.tosan.repository.mapper.TravelerDataToTraveler;
import razarm.tosan.repository.mapper.TravelerToTravelerData;
import razarm.tosan.repository.mapper.accommodation.AccOrderDataToAccOrder;
import razarm.tosan.repository.mapper.accommodation.AccOrderToAccOrderData;
import razarm.tosan.repository.mapper.accommodation.AccommodationDataToAccommodation;
import razarm.tosan.repository.mapper.accommodation.AccommodationToAccommodationData;
import razarm.tosan.repository.mapper.auth.UserDataToUser;
import razarm.tosan.repository.mapper.auth.UserSessionDataToUserSession;
import razarm.tosan.repository.mapper.auth.UserSessionToUserSessionData;
import razarm.tosan.repository.mapper.auth.UserToUserData;
import razarm.tosan.repository.mapper.food.*;
import razarm.tosan.repository.mapper.location.*;
import razarm.tosan.repository.mapper.tour.*;
import razarm.tosan.repository.mapper.transport.VehicleDataToVehicle;
import razarm.tosan.repository.mapper.transport.VehicleOrderDataToVehicleOrder;
import razarm.tosan.repository.mapper.transport.VehicleOrderToVehicleOrderData;
import razarm.tosan.repository.mapper.transport.VehicleToVehicleData;
import razarm.tosan.service.*;
import razarm.tosan.service.impl.*;
import razarm.tosan.service.tour.BookingService;
import razarm.tosan.service.tour.TourService;
import razarm.tosan.utility.PasswordEncoder;

public final class AppContextHolder {



    private static final UserDataToUser userDataToUser =  new UserDataToUser();
    private static final UserToUserData userToUserData = new UserToUserData();
    private static  UserRepository userRepository  ;

    private static final UserDtoToUser userDtoToUser = new UserDtoToUser();
    private static final UserToUserDto userToUserDto = new UserToUserDto();

    private static final UserSessionDataToUserSession userSessionDataToUserSession =  new UserSessionDataToUserSession();
    private static final UserSessionToUserSessionData userSessionToUserSessionData = new UserSessionToUserSessionData();
    private static final UserSessionRepository userSessionRepository = new UserSessionRepositoryInMemoryImpl(userSessionDataToUserSession, userSessionToUserSessionData);

    private static final  PasswordEncoder passwordEncoder = new PasswordEncoder();
    private static  AuthService authService ;
///////////////////////////////////////////////////////ADDRESS/////////////////////////////////////////////////////

    private static final CountryDtoToCountry countryDtoToCountry = new CountryDtoToCountry();
    private static final CountryToCountryDto countryToCountryDto =  new CountryToCountryDto();

    private static final CityToCityDto cityToCityDto = new CityToCityDto(countryToCountryDto);
    private static final CityDtoToCity cityDtoToCity =  new CityDtoToCity(countryDtoToCountry);

    private static final AddressToAddressDto addressToAddressDto = new AddressToAddressDto(cityToCityDto);
    private static final AddressDtoToAddress addressDtoToAddress = new AddressDtoToAddress(cityDtoToCity);

    private static final CountryToCountryData countryToCountryData = new CountryToCountryData();
    private static final CountryDataToCountry countryDataToCountry = new CountryDataToCountry();
    private static final CityToCityData cityToCityData = new CityToCityData(countryToCountryData);
    private static final CityDataToCity cityDataToCity = new CityDataToCity(countryDataToCountry);
    private static final AddressToAddressData addressToAddressData =  new AddressToAddressData(cityToCityData);
    private static final AddressDataToAddress addressDataToAddress =  new AddressDataToAddress(cityDataToCity);
    private static final AddressRepositoryImpl addressRepository;

    private static final AddressService addressService;
///////////////////////////////////////////////////////FOOD/////////////////////////////////////////////////////
private static final FoodProviderDataToFoodProvider foodProviderDataToFoodProvider = new FoodProviderDataToFoodProvider();
    private static final  FoodProviderToFoodProviderData foodProviderToFoodProviderData =  new FoodProviderToFoodProviderData();

    private static final  FoodDataToFood foodDataToFood =  new FoodDataToFood(foodProviderDataToFoodProvider);
    private static final  FoodToFoodData foodToFoodData = new FoodToFoodData(foodProviderToFoodProviderData);

    private static final  FoodOrderDataToFoodOrder foodOrderDataToFoodOrder = new FoodOrderDataToFoodOrder(foodDataToFood);
    private static final  FoodOrderToFoodOrderData foodOrderToFoodOrderData = new FoodOrderToFoodOrderData(foodToFoodData);
    private static final FoodOrderRepository foodOrderRepository;

    private static final FoodProviderToFoodProviderDto foodProviderToFoodProviderDto = new FoodProviderToFoodProviderDto();
    private static final FoodProviderDtoToFoodProvider foodProviderDtoToFoodProvider = new FoodProviderDtoToFoodProvider();

    private static final FoodToFoodDto foodToFoodDto =  new FoodToFoodDto(foodProviderToFoodProviderDto);
    private static final FoodDtoToFood foodDtoToFood =  new FoodDtoToFood(foodProviderDtoToFoodProvider);

    private static final  FoodOrderToFoodOrderDto foodOrderToFoodOrderDto = new FoodOrderToFoodOrderDto(foodToFoodDto);
    private static final  FoodOrderDtoToFoodOrder foodOrderDtoToFoodOrder = new FoodOrderDtoToFoodOrder(foodDtoToFood);

    private static final FoodOrderService foodOrderService;
///////////////////////////////////////////////////////ACCOMMODATION/////////////////////////////////////////////////////
private static final AccommodationDataToAccommodation accommodationDataToAccommodation = new AccommodationDataToAccommodation();
    private static final AccommodationToAccommodationData accommodationToAccommodationData = new AccommodationToAccommodationData();

    private static final AccOrderDataToAccOrder accOrderDataToAccOrder = new AccOrderDataToAccOrder(accommodationDataToAccommodation);
    private static final  AccOrderToAccOrderData accOrderToAccOrderData = new AccOrderToAccOrderData(accommodationToAccommodationData);

    private static  AccommodationOrderRepository accommodationOrderRepository;
    private static final AccommodationToAccommodationDto accommodationToAccommodationDto = new AccommodationToAccommodationDto();
    private static final AccommodationDtoToAccommodation accommodationDtoToAccommodation = new AccommodationDtoToAccommodation();
    private static final AccOrderToAccOrderDto accOrderToAccOrderDto = new AccOrderToAccOrderDto(accommodationToAccommodationDto);
    private static final AccOrderDtoToAccOrder accOrderDtoToAccOrder = new AccOrderDtoToAccOrder(accommodationDtoToAccommodation);

    private static   AccommodationOrderService accommodationOrderService;
///////////////////////////////////////////////////////VEHICLE/////////////////////////////////////////////////////
private static final VehicleToVehicleData vehicleToVehicleData = new VehicleToVehicleData();
    private static final VehicleDataToVehicle vehicleDataToVehicle =  new VehicleDataToVehicle();
    private static final VehicleOrderToVehicleOrderData vehicleOrderToVehicleOrderData = new VehicleOrderToVehicleOrderData(vehicleToVehicleData);
    private static final VehicleOrderDataToVehicleOrder vehicleOrderDataToVehicleOrder = new VehicleOrderDataToVehicleOrder(vehicleDataToVehicle);
    private static  VehicleOrderRepositoryImpl vehicleOrderRepository;

    private static final VehicleDtoToVehicle vehicleDtoToVehicle = new VehicleDtoToVehicle();
    private static final VehicleToVehicleDto vehicleToVehicleDto = new VehicleToVehicleDto();
    private  static final VehicleOrderDtoToVehicleOrder vehicleOrderDtoToVehicleOrder  = new VehicleOrderDtoToVehicleOrder(vehicleDtoToVehicle) ;
    private static final VehicleOrderToVehicleOrderDto vehicleOrderToVehicleOrderDto = new VehicleOrderToVehicleOrderDto(vehicleToVehicleDto);

    private static   VehicleOrderService vehicleOrderService;
///////////////////////////////////////////////////////TOUR/////////////////////////////////////////////////////
    private static final ActivityDataToActivity activityDataToActivity = new ActivityDataToActivity();
    private static final ActivityToActivityData activityToActivityData = new ActivityToActivityData();

    private static final TourismManagerDataToTourismManager tourismManagerDataToTourismManager = new TourismManagerDataToTourismManager(addressDataToAddress);
    private static final TourismManagerToTourismManagerData tourismManagerToTourismManagerData = new TourismManagerToTourismManagerData(addressToAddressData);

    private static final SchedulePlanDataToSchedulePlan schedulePlanDataToSchedulePlan = new SchedulePlanDataToSchedulePlan(addressDataToAddress, activityDataToActivity);
    private static final  SchedulePlanToSchedulePlanData schedulePlanToSchedulePlanData = new SchedulePlanToSchedulePlanData(addressToAddressData, activityToActivityData);

    private static final  TourToTourData tourToTourData = new TourToTourData(tourismManagerToTourismManagerData , schedulePlanToSchedulePlanData);
    private static final  TourDataToTour tourDataToTour = new TourDataToTour(tourismManagerDataToTourismManager, schedulePlanDataToSchedulePlan);

    private static  TourRepository tourRepository ;

    private static final TravelerToTravelerData travelerToTravelerData = new TravelerToTravelerData(addressToAddressData);
    private static final TravelerDataToTraveler travelerDataToTraveler = new TravelerDataToTraveler(addressDataToAddress);
    private static final BookingToBookingData bookingToBookingData =  new BookingToBookingData(travelerToTravelerData);
    private static final BookingDataToBooking bookingDataToBooking = new BookingDataToBooking(travelerDataToTraveler);
    private static  BookingRepository bookingRepository;


    private static final TravelerDtoToTraveler travelerDtoToTraveler = new TravelerDtoToTraveler(addressDtoToAddress);
    private static final TravelerToTravelerDto travelerToTravelerDto = new TravelerToTravelerDto(addressToAddressDto);

    private static final TourismManagerToTourismManagerDto tourismManagerToTourismManagerDto = new TourismManagerToTourismManagerDto(addressToAddressDto);
    private static final TourismManagerDtoToTourismManager tourismManagerDtoToTourismManager =  new TourismManagerDtoToTourismManager(addressDtoToAddress);

    private static final ActivityDtoToActivity activityDtoToActivity = new ActivityDtoToActivity();
    private static final ActivityToActivityDto activityToActivityDto = new ActivityToActivityDto();

    private static final SchedulePlanDtoToSchedulePlan schedulePlanDtoToSchedulePlan = new SchedulePlanDtoToSchedulePlan(activityDtoToActivity, accOrderDtoToAccOrder, vehicleOrderDtoToVehicleOrder, foodOrderDtoToFoodOrder, addressDtoToAddress);
    private static final SchedulePlanToSchedulePlanDto schedulePlanToSchedulePlanDto = new SchedulePlanToSchedulePlanDto(addressToAddressDto, accOrderToAccOrderDto, foodOrderToFoodOrderDto, vehicleOrderToVehicleOrderDto, activityToActivityDto);

    private static final TourToTourDto tourToTourDto = new TourToTourDto(tourismManagerToTourismManagerDto, schedulePlanToSchedulePlanDto);
    private static final TourDtoToTour tourDtoToTour = new TourDtoToTour(tourismManagerDtoToTourismManager, schedulePlanDtoToSchedulePlan);

    private static final TourService tourService ;

    private static final BookingToBookingDto bookingToBookingDto ;
    private static final BookingDtoToBooking bookingDtoToBooking;
    private static  final BookingService bookingService;


    static {
        bookingDtoToBooking = new BookingDtoToBooking(travelerDtoToTraveler, tourDtoToTour, userDtoToUser);
        bookingToBookingDto = new BookingToBookingDto(travelerToTravelerDto, tourToTourDto, userToUserDto);

        if(AppProperties.STORAGE_TYPE == "IN_MEMORY") {
            userRepository =  new UserRepositoryInMemoryImpl(userToUserData, userDataToUser);
        }else {
            userRepository = new UserRepositoryInStorageImpl(userToUserData, userDataToUser);
        }

        addressRepository = new AddressRepositoryImpl(
                addressToAddressData,
                addressDataToAddress
        );
        authService = new AuthServiceImpl(userRepository, userSessionRepository, passwordEncoder, userToUserDto);
        foodOrderRepository = new FoodOrderRepositoryImpl(
                foodOrderDataToFoodOrder, foodOrderToFoodOrderData
        );
        accommodationOrderRepository = new AccommodationOrderInStorageImpl(accOrderToAccOrderData, accOrderDataToAccOrder);
        vehicleOrderRepository = new VehicleOrderRepositoryImpl(
                vehicleOrderToVehicleOrderData,
                vehicleOrderDataToVehicleOrder
        );
        tourRepository =  new TourRepositoryImpl(tourToTourData, tourDataToTour, schedulePlanDataToSchedulePlan, accommodationOrderRepository, vehicleOrderRepository, foodOrderRepository);
        bookingRepository = new BookingRepositoryImpl(bookingToBookingData ,bookingDataToBooking, tourRepository, userRepository);



        addressService  = new AddressServiceImpl(
                addressRepository, addressDtoToAddress, addressToAddressDto
        );
        foodOrderService = new FoodOrderServiceImpl(
                foodOrderRepository, foodOrderToFoodOrderDto, foodOrderDtoToFoodOrder);
        accommodationOrderService = new AccommodationOrderServiceImpl(accommodationOrderRepository, accOrderToAccOrderDto, accOrderDtoToAccOrder);
        vehicleOrderService = new VehicleOrderServiceImpl(
                vehicleOrderRepository,vehicleOrderDtoToVehicleOrder, vehicleOrderToVehicleOrderDto
        );
        tourService = new TourServiceImpl(tourRepository, tourToTourDto, tourDtoToTour);
        bookingService =  new BookingServiceImpl(userRepository, bookingRepository, tourRepository, bookingDtoToBooking, bookingToBookingDto);
    }


    private AppContextHolder() {}


    public static VehicleOrderRepository getVehicleOrderRepository() {
        return vehicleOrderRepository;
    }
    public static VehicleOrderService getVehicleOrderService() {
        return vehicleOrderService;
    }


    public static AccommodationOrderRepository getAccommodationOrderRepository() {
        return accommodationOrderRepository;
    }
    public static AccommodationOrderService getAccommodationOrderService() {
        return accommodationOrderService;
    }

    public static FoodOrderRepository getFoodOrderRepository() {
        return foodOrderRepository;
    }

    public static FoodOrderService getFoodOrderService() {
        return foodOrderService;
    }

    public static AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public static AddressService getAddressService() {
        return addressService;
    }



    public static TourRepository getTourRepository() {
        return tourRepository;
    }

    public static BookingRepository getBookingRepository() {
        return bookingRepository;
    }
    public static TourService getTourService() {
        return tourService;
    }

    public static BookingService getBookingService() {
        return bookingService;
    }



    public static UserSessionRepository getUserSessionRepository() {
        return userSessionRepository;
    }
    public static UserRepository getUserRepository(){
       return userRepository;
    }
    public static AuthService getAuthService() {
        return authService;
    }



    public static UserToUserData getUserToUserData() {
        return userToUserData;
    }


}
