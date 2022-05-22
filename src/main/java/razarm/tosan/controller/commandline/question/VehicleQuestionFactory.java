package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.util.Arrays;

public class VehicleQuestionFactory extends QuestionFactory{

    public static VehicleOrderDto createVehicleOrder() {
        System.out.println(BoldOn + TEXT_BLUE + "Create Vehicle Order:" + BoldOff + TEXT_BLACK);
        System.out.println(BoldOn + TEXT_BLUE + "Enter Order Name:" + BoldOff + TEXT_BLACK);
        var name = askSimpleQuestion();
        var vehicle = createVehicle();

        return VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
                .name(name)
                .vehicle(vehicle)
                .build();
    }

  public static VehicleOrderDto createVehicleOrder(VehicleDto vehicle) {
      System.out.println(BoldOn + TEXT_BLUE + "Create Vehicle Order:" + BoldOff + TEXT_BLACK);
      System.out.println(BoldOn + TEXT_BLUE + "Enter Order Name:" + BoldOff + TEXT_BLACK);
      var name = askSimpleQuestion();
      return VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
              .name(name)
              .vehicle(vehicle)
              .build();
  }

    public static VehicleDto createVehicle() {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Name:" + BoldOff + TEXT_BLACK);
        var name = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Select Vehicle Type:" + BoldOff + TEXT_BLACK);
        var type = VehicleType.valueOf(selectOptions((String[]) Arrays.stream(VehicleType.values()).map(Enum::toString).toArray()));
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Start Point:" + BoldOff + TEXT_BLACK);
        var fromState = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Destination Of Movement:" + BoldOff + TEXT_BLACK);
        var toStation = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Ticket Number" + BoldOff + TEXT_BLACK);
        var ticketNumber = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Price" + BoldOff + TEXT_BLACK);
        var price = new BigInteger(askSimpleQuestion());

        var departure = createDate("Enter Vehicle Departure");
        var arrival  = createDate("Enter Vehicle Arrival");

        var provider = createVehicleProvider();

        return VehicleDto.VehicleDtoBuilder.aVehicleDto()
                .name(name)
                .type(type)
                .fromStation(fromState)
                .toStation(toStation)
                .ticketNumber(ticketNumber)
                .price(price)
                .departure(departure.toZonedDateTime())
                .arrival(arrival.toZonedDateTime())
                .vehicleProvider(provider)
                .build();
    }

    public static VehicleProviderDto createVehicleProvider() {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Provider Name:" + BoldOff + TEXT_BLACK);
        var name = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Provider Phone:" + BoldOff + TEXT_BLACK);
        var phone = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Provider email:" + BoldOff + TEXT_BLACK);
        var email = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Provider description:" + BoldOff + TEXT_BLACK);
        var desc = askSimpleQuestion();

//        System.out.println(BoldOn + TEXT_BLUE + "Enter Vehicle Provider Address:" + BoldOff + TEXT_BLACK);
//        var name = createAddress("Enter Vehicle Provider Address:", )

        return VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                .name(name)
                .email(email)
                .phone(phone)
                .description(desc)
                .build();
    }

}
