package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.VehicleType;

public class transportMapperFactory {
    private static final VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData = new VehicleProviderToVehicleProviderData();
    private static final VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider = new VehicleProviderDataToVehicleProvider();

    private static final PlaneDataToPlane planeDataToPlane = new PlaneDataToPlane(vehicleProviderDataToVehicleProvider);
    private static final PlaneToPlaneData planeToPlaneData = new PlaneToPlaneData(vehicleProviderToVehicleProviderData);

    private static final BusDataToBus busDataToBus = new BusDataToBus(vehicleProviderDataToVehicleProvider);
    private static final BusToBusData busToBusData = new BusToBusData(vehicleProviderToVehicleProviderData);

    private transportMapperFactory() {
    }

    public static Mapper createVehicleMapper(VehicleType type) {
        switch (type){
            case PLANE:
                return planeToPlaneData;
            case BUS:
                return busToBusData;
            default:
                throw new IllegalArgumentException("invalid vehicle type");
        }
    }
    public static Mapper createVehicleDataMapper(VehicleType type) {
        switch (type){
            case PLANE:
                return planeDataToPlane;
            case BUS:
                return busDataToBus;
            default:
                throw new IllegalArgumentException("invalid vehicle type");
        }
    }


    public static Mapper createVehicleProviderMapper () {
        return  vehicleProviderToVehicleProviderData;
    }
    public Mapper createVehicleProviderDataMapper() {
        return vehicleProviderDataToVehicleProvider;
    }
}
