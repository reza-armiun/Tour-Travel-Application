package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.VehicleType;

public class VehicleMapperFactory {
    private static final PlaneToPlaneDto planeToPlaneDto= new PlaneToPlaneDto();
    private static final PlaneDtoToPlane planeDtoToPlane = new PlaneDtoToPlane();

    private static final BusToBusDto busToBusDto =  new BusToBusDto();
    private static final BusDtoToBus busDtoToBus = new BusDtoToBus();




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
