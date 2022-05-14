package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.CityData;
import razarm.tosan.repository.domain.location.City;

public class CityDataToCity implements Mapper<CityData, City> {
    private final CountryDataToCountry countryDataToCountry;

    public CityDataToCity(CountryDataToCountry countryDataToCountry) {
        this.countryDataToCountry = countryDataToCountry;
    }

    @Override
    public City convert(CityData cityData) {
        return City.CityBuilder.aCity()
                .id(cityData.getId())
                .name(cityData.getName())
                .zipCode(cityData.getZipCode())
                .country(countryDataToCountry.convert(cityData.getCountry()))
                .createdAt(cityData.getCreatedAt())
                .modifiedAt(cityData.getModifiedAt())
                .createdBy(cityData.getCreatedBy())
                .modifiedBy(cityData.getModifiedBy())
                .build();
    }
}
