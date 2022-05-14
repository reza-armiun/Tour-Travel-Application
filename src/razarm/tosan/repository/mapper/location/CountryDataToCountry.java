package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.CountryData;
import razarm.tosan.repository.domain.location.Country;

public class CountryDataToCountry implements Mapper<CountryData, Country> {
    @Override
    public Country convert(CountryData countryData) {
        return Country.CountryBuilder.aCountry()
                .id(countryData.getId())
                .name(countryData.getName())
                .countryCode(countryData.getCountryCode())
                .createdAt(countryData.getCreatedAt())
                .modifiedAt(countryData.getModifiedAt())
                .createdBy(countryData.getCreatedBy())
                .modifiedBy(countryData.getModifiedBy())
                .build();
    }
}
