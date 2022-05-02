package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.location.Country;

public class CountryDtoToCountry implements Mapper<CountryDto, Country> {
    private final CityDtoToCity cityDtoToCity;

    public CountryDtoToCountry(CityDtoToCity cityDtoToCity) {
        this.cityDtoToCity = cityDtoToCity;
    }

    @Override
    public Country convert(CountryDto countryDto) {
        return Country.CountryBuilder.aCountry()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .countryCode(countryDto.getCountryCode())
//                .cities(
//                        countryDto.getCities() != null
//                                ? countryDto.getCities().stream()
//                                        .map(cityDtoToCity::convert)
//                                        .collect(Collectors.toUnmodifiableSet())
//                                : null)
                .createdAt(countryDto.getCreatedAt().toInstant())
                .modifiedAt(countryDto.getModifiedAt().toInstant())
                .createdBy(countryDto.getCreatedBy())
                .modifiedBy(countryDto.getModifiedBy())
                .build();
    }
}
