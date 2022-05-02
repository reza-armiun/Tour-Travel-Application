package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.location.Country;

import java.time.ZoneId;

public class CountryToCountryDto implements Mapper<Country, CountryDto> {
    private final CityToCityDto cityToCityDto;

    public CountryToCountryDto(CityToCityDto cityToCityDto) {
        this.cityToCityDto = cityToCityDto;
    }

    @Override
    public CountryDto convert(Country country) {
        return CountryDto.CountryDtoBuilder.aCountryDto()
                .id(country.getId())
                .name(country.getName())
                .countryCode(country.getCountryCode())
//                .cities(
//                        country.getCities() != null
//                                ? country.getCities().stream()
//                                        .map(cityToCityDto::convert)
//                                        .collect(Collectors.toUnmodifiableSet())
//                                : null)
                .createdAt(country.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(country.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(country.getCreatedBy())
                .modifiedBy(country.getModifiedBy())
                .build();
    }
}
