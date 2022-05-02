package razarm.tosan.service;

import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.repository.domain.location.City;

import java.util.List;

public interface CountryService extends CrudService<CountryDto, String> {
    CountryDto findByName(String name);
    void addCity(String countryId, City city);
    void removeCity(String countryId, String cityId);

    List<CityDto> getAllCountryCities(String countryName);
    List<CityDto> findAllCities(String name);



}
