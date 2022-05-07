package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleData;
import razarm.tosan.repository.domain.transport.Vehicle;

public class VehicleDataToVehicle implements Mapper<VehicleData, Vehicle> {
    @Override
    public Vehicle convert(VehicleData vehicleData) {
        final Mapper<VehicleData, Vehicle> mapper = VehicleDataMapperFactory.createVehicleDataMapper(vehicleData.getType());
        return mapper.convert(vehicleData);
    }
}
