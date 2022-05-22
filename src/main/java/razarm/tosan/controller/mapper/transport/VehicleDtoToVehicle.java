package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Vehicle;

public class VehicleDtoToVehicle<S extends  VehicleDto, T extends Vehicle> implements Mapper<S, T> {

    @Override
    public T convert(S vehicleDto) {
        final Mapper<S, T> mapper = VehicleMapperFactory.createVehicleDtoMapper(vehicleDto.getType());
        return mapper.convert(vehicleDto);
    }
}
