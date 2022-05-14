package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.controller.dto.tour.SchedulePlanDto;
import razarm.tosan.controller.dto.transport.*;
import razarm.tosan.repository.domain.food.FoodType;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class  SchedulePlanQuestionFactory extends QuestionFactory {
    private static List<VehicleDto> mockVehicles = new ArrayList<>() {{
        add(BusDto.BusDtoBuilder.aBusDto()
                .name("Razarm Bus")
                .price(new BigInteger("2131231"))
                .type(VehicleType.BUS)
                .fromStation("bushehr")
                .toStation("kiev")
                .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                        .name("razarm company")
                        .phone("weqqweq")
                        .email("razarm@gmail.com")
                        .build())
                .build());
        add(PlaneDto.PlaneDtoBuilder.aPlaneDto()
                .name("Razarm Plane")
                .price(new BigInteger("2131231"))
                .type(VehicleType.PLANE)
                .fromStation("bushehr")
                .toStation("kiev")
                .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                        .name("razarm company")
                        .phone("weqqweq")
                        .email("razarm@gmail.com")
                        .build())
                .build());
        add(BusDto.BusDtoBuilder.aBusDto()
                .name("Razarm Car")
                .price(new BigInteger("2131231"))
                .type(VehicleType.CAR)
                .fromStation("bushehr")
                .toStation("kiev")
                .vehicleProvider(VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                        .name("razarm company")
                        .phone("weqqweq")
                        .email("razarm@gmail.com")
                        .build())
                .build());
    }};

    private static List<FoodDto> mockFoods = new ArrayList<>(){{
        add(FoodDto.FoodDtoBuilder.aFoodDto()
                .name("pizza")
                .type(FoodType.PROTEIN)
                .price(new BigInteger("31231231"))
                .cookTime(22 * 60L)
                .provider(FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                        .name("razarm company")
                        .phone("131231")
                        .email("razarm@gmail.com")
                        .build())
                .build());
        add(FoodDto.FoodDtoBuilder.aFoodDto()
                .name("chicken")
                .type(FoodType.PROTEIN)
                .price(new BigInteger("2222"))
                .cookTime(22 * 60L)
                .provider(FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                        .name("razarm company")
                        .phone("131231")
                        .email("razarm@gmail.com")
                        .build())
                .build());
        add(FoodDto.FoodDtoBuilder.aFoodDto()
                .name("salad")
                .type(FoodType.VEGETABLES)
                .price(new BigInteger("22222"))
                .cookTime(22 * 60L)
                .provider(FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                        .name("razarm company")
                        .phone("131231")
                        .email("razarm@gmail.com")
                        .build())
                .build());
    }};



    public static SchedulePlanDto createSchedulePlan() {
        System.out.println(BoldOn + TEXT_YELLOW + "Create Schedule Plan: " + BoldOff + TEXT_BLACK);

        System.out.println(BoldOn + TEXT_YELLOW + "Enter Name: " + BoldOff + TEXT_BLACK);
        var name = askSimpleQuestion();

        var startTime = createDate("Start Time:");
        var arrivalTime = createDate("Arrival Time");

        var source = createAddress("Create Source Address:" , getMockCities());
        var destination = createAddress("Create Destination Address:" , getMockCities());

        var accommodationOrder = AccommodationQuestionFactory.createAccommodationOrder();


        return SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
                .name(name)
                .startTime(startTime.toZonedDateTime())
                .arrivalTime(arrivalTime.toZonedDateTime())
                .source(source)
                .destination(destination)
                .accommodationOrder(accommodationOrder)
                .vehicleOrders(addVehicleOrder())
                .foodOrders(addFoodOrders())
                .build();
    }

    public static Set<VehicleOrderDto> addVehicleOrder() {
        System.out.println("Adding Schedule Plan Vehicle Orders: ");
        final String ADD_NEW = "Add New ";
        final String GO_NEXT = "Go Next";
        Set<VehicleOrderDto> vehicleOrders = new HashSet<>();
        while (true) {
            var selection = selectOptions(new String []{ADD_NEW, GO_NEXT});
            if(selection.equals(GO_NEXT)) return vehicleOrders;
//            System.out.println("Select Vehicle:");
            var vehicleList = mockVehicles.stream().map(VehicleDto::getName).collect(Collectors.toList());
            vehicleList.add("ADD NEW ");
            var result = selectOptionsIndex("Select Vehicle:", (String[]) vehicleList.toArray()); // show available vehicles
            if(result == vehicleList.size() + 1) {
                var vehicleOrder = VehicleQuestionFactory.createVehicleOrder();
                vehicleOrders.add(vehicleOrder);
            }else {
                var newOrder =  VehicleQuestionFactory.createVehicleOrder(mockVehicles.get(result));
                vehicleOrders.add(newOrder);
            }
        }
    }

    public static Set<FoodOrderDto> addFoodOrders() {
        System.out.println("Adding Schedule Plan Food Orders: ");
        final String ADD_NEW = "Add New ";
        final String GO_NEXT = "Go Next";
        Set<FoodOrderDto> foodOrders = new HashSet<>();
        while (true) {
            var selection = selectOptions(new String []{ADD_NEW, GO_NEXT});
            if(selection.equals(GO_NEXT)) return foodOrders;
//            System.out.println("Select Food:");
            var foodList = mockFoods.stream().map(FoodDto::getName).collect(Collectors.toList());
            foodList.add("ADD NEW ");
            var result = selectOptionsIndex("Select Food:", (String[]) foodList.toArray()); // show available vehicles
            if(result == foodList.size() + 1) {
                var foodOrder = FoodQuestionFactory.createFoodOrder();
                foodOrders.add(foodOrder);
            }else {
                var newOrder =  FoodQuestionFactory.createFoodOrder(mockFoods.get(result));
                foodOrders.add(newOrder);
            }

        }
    }


}
