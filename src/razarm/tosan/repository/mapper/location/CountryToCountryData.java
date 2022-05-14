package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.CountryData;
import razarm.tosan.repository.domain.location.Country;

public class CountryToCountryData implements Mapper<Country, CountryData> {
    @Override
    public CountryData convert(Country country) {
        return CountryData.CountryDataBuilder.aCountryData()
                .id(country.getId())
                .name(country.getName())
                .countryCode(country.getCountryCode())
                .createdAt(country.getCreatedAt())
                .modifiedAt(country.getModifiedAt())
                .createdBy(country.getCreatedBy())
                .modifiedBy(country.getModifiedBy())
                .build();
    }
}
