package razarm.tosan.repository;

import razarm.tosan.repository.domain.location.Country;

public interface CountryRepository extends CrudRepository<Country, String>{

    Country findByName(String name);

}
