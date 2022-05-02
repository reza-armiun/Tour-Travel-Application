package razarm.tosan.controller.commandline;

import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.repository.domain.location.Country;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class SchedulePlanBuilderHandler extends QuestionHandler {
    private final String question = "Build your schedule plan";


    @Override
    public void run(Object... values) {
//        var schedulePlane = SchedulePlanDto.SchedulePlanDtoBuilder.aSchedulePlanDto()
//                                                                  .build();

        System.out.println(BoldOn + TEXT_YELLOW + "Enter Plane Name: " + BoldOff + TEXT_BLACK);
        var name = QuestionFactory.askSimpleQuestion();

//        System.out.println(BoldOn + TEXT_YELLOW + "Enter Start Time: " + BoldOff + TEXT_BLACK);
//        var startTime = QuestionFactory.createDate("Start Time: ");
//        System.out.println(BoldOn + TEXT_YELLOW + "Enter Arrival Time: "  + BoldOff + TEXT_BLACK);
//        var arrivalTime = QuestionFactory.createDate("Arrival Time: ");

        var iran  = CountryDto.CountryDtoBuilder.aCountryDto().name("Iran").build();
        var boushehr = CityDto.CityDtoBuilder.aCityDto().name("Boushehr").country(iran).build();
        var tehran= CityDto.CityDtoBuilder.aCityDto().name("Tehran").country(iran).build();
        var shiraz= CityDto.CityDtoBuilder.aCityDto().name("Shiraz").country(iran).build();

        var ukraine =  CountryDto.CountryDtoBuilder.aCountryDto().name("Ukraine").build();
        var Kyiv = CityDto.CityDtoBuilder.aCityDto().name("Kyiv").country(ukraine).build();
        var Kharkiv = CityDto.CityDtoBuilder.aCityDto().name("Kharkiv").country(ukraine).build();
        var Lviv = CityDto.CityDtoBuilder.aCityDto().name("Lviv").country(ukraine).build();

        var turkey =   CountryDto.CountryDtoBuilder.aCountryDto().name("Turkey").build();
        var Istanbul = CityDto.CityDtoBuilder.aCityDto().name("Istanbul").country(turkey).build();
        var Ankara = CityDto.CityDtoBuilder.aCityDto().name("Ankara").country(turkey).build();
        var Izmir = CityDto.CityDtoBuilder.aCityDto().name("Izmir").country(turkey).build();

        var source = QuestionFactory.createAddress("Enter Source Address:", Set.of(boushehr, tehran, shiraz, Kyiv, Kharkiv, Lviv, Istanbul, Ankara, Izmir));

        System.out.println(source);
    }



    public AddressDto createAddress(String desc) {
        return null;
    }


}
