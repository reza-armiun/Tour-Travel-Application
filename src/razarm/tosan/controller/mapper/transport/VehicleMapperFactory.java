package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.*;
import razarm.tosan.repository.domain.transport.VehicleType;

public class VehicleMapperFactory {
    private static final CountryToCountryDto countryToCountryDto = new CountryToCountryDto();
    private static final CountryDtoToCountry countryDtoToCountry = new CountryDtoToCountry();

    private static final CityToCityDto cityToCityDto = new CityToCityDto(countryToCountryDto);
    private static final CityDtoToCity cityDtoToCity = new CityDtoToCity(countryDtoToCountry);

    private static final AddressToAddressDto addressToAddressDto = new AddressToAddressDto(cityToCityDto);
    private static final AddressDtoToAddress addressDtoToAddress = new AddressDtoToAddress(cityDtoToCity);

    private static final VehicleProviderToVehicleProviderDto vehicleProviderToVehicleProviderDto = new VehicleProviderToVehicleProviderDto(addressToAddressDto);
    private static final VehicleProviderDtoToVehicleProvider vehicleProviderDtoToVehicleProvider= new VehicleProviderDtoToVehicleProvider(addressDtoToAddress);

    private static final PlaneToPlaneDto planeToPlaneDto= new PlaneToPlaneDto(vehicleProviderToVehicleProviderDto);
    private static final PlaneDtoToPlane planeDtoToPlane = new PlaneDtoToPlane(vehicleProviderDtoToVehicleProvider);

    private static final BusToBusDto busToBusDto =  new BusToBusDto(vehicleProviderToVehicleProviderDto);
    private static final BusDtoToBus busDtoToBus = new BusDtoToBus(vehicleProviderDtoToVehicleProvider);




    private VehicleMapperFactory(){ }


    public static  Mapper createVehicleMapper(VehicleType type) {
        switch (type){
            case PLANE:
                return planeToPlaneDto;
            case BUS:
                return busToBusDto;
            default:
                throw new IllegalArgumentException("invalid vehicle type");
        }
    }
    public static Mapper createVehicleDtoMapper(VehicleType type) {
        switch (type){
            case PLANE:
                return planeDtoToPlane;
            case BUS:
                return busDtoToBus;
            default:
                throw new IllegalArgumentException("invalid vehicle type");
        }
    }


}
