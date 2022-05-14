package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Vehicle;

public class VehicleDtoToVehicle implements Mapper<VehicleDto, Vehicle> {

    @Override
    public Vehicle convert(VehicleDto vehicleDto) {
        final Mapper<VehicleDto, Vehicle> mapper = VehicleMapperFactory.createVehicleDtoMapper(vehicleDto.getType());
        return mapper.convert(vehicleDto);
    }
}
