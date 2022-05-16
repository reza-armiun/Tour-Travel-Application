package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.BusData;
import razarm.tosan.repository.domain.transport.Bus;

public class BusToBusData implements Mapper<Bus, BusData> {
    private final VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData;

    public BusToBusData(VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData) {
        this.vehicleProviderToVehicleProviderData = vehicleProviderToVehicleProviderData;
    }

    @Override
    public BusData convert(Bus bus) {
        return BusData.BusDataBuilder.aBusData()
                                     .id(bus.getId())
                                     .name(bus.getName())
                                     .type(bus.getType())
                                     .fromStation(bus.getFromStation())
                                     .toStation(bus.getToStation())
                                     .ticketNumber(bus.getTicketNumber())
                                     .price(bus.getPrice())
                                     .departure(bus.getDeparture())
                                     .arrival(bus.getArrival())
                                     .vehicleProvider(this.vehicleProviderToVehicleProviderData.convert(bus.getVehicleProvider()))
                                     .busModel(bus.getBusModel())
                                     .createdAt(bus.getCreatedAt())
                                     .modifiedAt(bus.getModifiedAt())
                                     .createdBy(bus.getCreatedBy())
                                     .modifiedBy(bus.getModifiedBy())
                                     .build();
    }
}
