package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Vehicle;

public class VehicleToVehicleDto implements Mapper<Vehicle, VehicleDto> {


    @Override
    public VehicleDto convert(Vehicle vehicle) {
        final Mapper<Vehicle, VehicleDto> mapper = VehicleMapperFactory.createVehicleMapper(vehicle.getType());
        return mapper.convert(vehicle);
    }
}
