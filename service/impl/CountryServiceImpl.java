package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.controller.mapper.address.CityToCityDto;
import razarm.tosan.controller.mapper.address.CountryDtoToCountry;
import razarm.tosan.controller.mapper.address.CountryToCountryDto;
import razarm.tosan.repository.CountryRepository;
import razarm.tosan.repository.domain.location.City;
import razarm.tosan.repository.domain.location.Country;
import razarm.tosan.service.CountryService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryToCountryDto countryToCountryDto;
    private final CountryDtoToCountry countryDtoToCountry;
    private final CityToCityDto cityToCityDto;

    public CountryServiceImpl(CountryRepository countryRepository, CountryToCountryDto countryToCountryDto
            , CountryDtoToCountry countryDtoToCountry, CityToCityDto cityToCityDto) {
        this.countryRepository = countryRepository;
        this.countryToCountryDto = countryToCountryDto;
        this.countryDtoToCountry = countryDtoToCountry;
        this.cityToCityDto = cityToCityDto;
    }


    @Override
    public CountryDto findByName(String name) {
        if(name == null || name.length() == 0) throw new IllegalArgumentException("invalid name value");
        return this.countryToCountryDto.convert(this.countryRepository.findByName(name));
    }

    @Override
    public void addCity(String countryId, City city) {
        var country = countryRepository.findById(countryId);
        var newCities = new HashSet<>(country.getCities());
        newCities.add(city);
        var newCountry =
                Country.CountryBuilder.aCountry()
                        .id(country.getId())
                        .name(country.getName())
                        .countryCode(country.getCountryCode())
                        .createdAt(country.getCreatedAt())
                        .modifiedAt(country.getModifiedAt())
                        .createdBy(country.getCreatedBy())
                        .modifiedBy(country.getModifiedBy())
                        .cities(newCities)
                        .build();
        this.countryRepository.update(country);
    }

    @Override
    public void removeCity(String countryId, String cityId) {
        if(countryId == null || cityId == null) throw new NullPointerException("null id");
        var country = countryRepository.findById(countryId);
        var newCities = new HashSet<>(country.getCities());
        newCities.removeIf(city -> city.getId().equals(cityId));
        var newCountry =
                Country.CountryBuilder.aCountry()
                                      .id(country.getId())
                                      .name(country.getName())
                                      .countryCode(country.getCountryCode())
                                      .createdAt(country.getCreatedAt())
                                      .modifiedAt(country.getModifiedAt())
                                      .createdBy(country.getCreatedBy())
                                      .modifiedBy(country.getModifiedBy())
                                      .cities(newCities)
                                      .build();
        countryRepository.update(newCountry);
    }

    @Override
    public List<CityDto> getAllCountryCities(String countryName) {
        if(countryName == null || countryName.length() == 0) throw new NullPointerException("invalid country name");
        var country = this.countryRepository.findByName(countryName);

        return country.getCities().stream().map(cityToCityDto::convert).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<CityDto> findAllCities(String name) {
        return this.countryRepository.findAll().stream()
                                     .flatMap(country -> country.getCities().stream().map(cityToCityDto::convert).collect(Collectors.toUnmodifiableList()).stream())
                                     .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CountryDto create(CountryDto countryDto) {
        if(countryDto == null) throw new NullPointerException("null country");
        var country = this.countryRepository.save(this.countryDtoToCountry.convert(countryDto));
        return this.countryToCountryDto.convert(country);
    }

    @Override
    public void update( CountryDto countryDto) {
        if(countryDto == null || countryDto.getId() == null) throw new NullPointerException("null country");
        var countryToEdit  = this.countryDtoToCountry.convert(countryDto);
        this.countryRepository.update(countryToEdit);
    }

    @Override
    public CountryDto findById(String s) {
        return this.countryToCountryDto.convert(this.countryRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        this.countryRepository.deleteById(s);
    }

    @Override
    public List<CountryDto> findAll() {
        return this.countryRepository.findAll().stream()
                .map(countryToCountryDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }
}
