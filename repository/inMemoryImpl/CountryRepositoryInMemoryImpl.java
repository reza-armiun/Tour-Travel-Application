package razarm.tosan.repository.inMemoryImpl;

import razarm.tosan.repository.CountryRepository;
import razarm.tosan.repository.domain.location.Country;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CountryRepositoryInMemoryImpl implements CountryRepository {
    private Map<String , Country>  countryMap = new HashMap<>();

    @Override
    public Country save(Country country) {
        final String id = UUID.randomUUID().toString() ;
        final var co =
                Country.CountryBuilder.aCountry()
                        .id(id)
                        .name(country.getName())
                        .countryCode(country.getCountryCode())
                        .cities(country.getCities())
                        .createdAt(country.getCreatedAt())
                        .modifiedAt(country.getModifiedAt())
                        .createdBy(country.getCreatedBy())
                        .modifiedBy(country.getModifiedBy())
                        .build();
        countryMap.put(id, co);
        return co;
    }

    @Override
    public void update(Country country) {
        countryMap.put(country.getId(), country);
    }

    @Override
    public void deleteById(String s) {
        countryMap.remove(s);
    }

    @Override
    public Country findById(String s) {
        return countryMap.get(s);
    }

    @Override
    public List<Country> findAll() {
        return List.copyOf(countryMap.values());
    }

    @Override
    public Country findByName(String name) {
        return List.copyOf(countryMap.values()).stream()
                .filter(country -> country.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
