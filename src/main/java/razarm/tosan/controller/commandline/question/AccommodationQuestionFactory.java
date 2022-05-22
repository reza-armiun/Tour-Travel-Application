package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.dto.accommodation.AccommodationDto;
import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.dto.accommodation.AccommodationProviderDto;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.math.BigInteger;
import java.util.Arrays;

public class AccommodationQuestionFactory extends QuestionFactory{


    public static AccommodationOrderDto createAccommodationOrder() {
        System.out.println(BoldOn + TEXT_BLUE + "Create Accommodation order:" + BoldOff + TEXT_BLACK);

        return AccommodationOrderDto.AccommodationOrderDtoBuilder.anAccommodationOrderDto()
                .accommodation(createAccommodationDto())
                .build();
    }

    public static AccommodationDto createAccommodationDto() {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation name:" + BoldOff + TEXT_BLACK);
        var name = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation Type:" + BoldOff + TEXT_BLACK);
        var type = selectOptions(Arrays.stream(AccommodationType.values()).map(Enum::toString).toArray(String[]::new));
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation price:" + BoldOff + TEXT_BLACK);
        var price = new BigInteger(askSimpleQuestion());
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation time:" + BoldOff + TEXT_BLACK);
        var time = Long.valueOf(askSimpleQuestion());

        var provider = createAccommodationProvider();


        return AccommodationDto.AccommodationDtoBuilder.anAccommodationDto()
                .name(name)
                .type(AccommodationType.valueOf(type))
                .price(price)
                .time(time)
                .accommodationProvider(provider)
                .build();
    }

    public static AccommodationProviderDto createAccommodationProvider() {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation Provider Name:" + BoldOff + TEXT_BLACK);
        var name  = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation Provider Email:" + BoldOff + TEXT_BLACK);
        var email  = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation Provider Phone:" + BoldOff + TEXT_BLACK);
        var phone  = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Enter Accommodation Provider Description:" + BoldOff + TEXT_BLACK);
        var description  = askSimpleQuestion();

        return AccommodationProviderDto.AccommodationProviderDtoBuilder.anAccommodationProviderDto()
                .name(name)
                .email(email)
                .phone(phone)
                .description(description)
                .build();
    }


}
