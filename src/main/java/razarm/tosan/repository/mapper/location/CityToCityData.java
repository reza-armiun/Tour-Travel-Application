package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.CityData;
import razarm.tosan.repository.domain.location.City;

public class CityToCityData implements Mapper<City, CityData> {
    private final CountryToCountryData countryToCountryData;

    public CityToCityData(CountryToCountryData countryToCountryData) {
        this.countryToCountryData = countryToCountryData;
    }

    @Override
    public CityData convert(City city) {
        return CityData.CityDataBuilder.aCityData()
                .id(city.getId())
                .name(city.getName())
                .zipCode(city.getZipCode())
                .country(countryToCountryData.convert(city.getCountry()))
                .createdAt(city.getCreatedAt())
                .modifiedAt(city.getModifiedAt())
                .createdBy(city.getCreatedBy())
                .modifiedBy(city.getModifiedBy())
                .build();
    }
}
