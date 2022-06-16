package razarm.tosan.repository.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.BusData;
import razarm.tosan.repository.domain.transport.Bus;

@Component
public class BusDataToBus implements Mapper<BusData, Bus> {
    private final VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider;

    public BusDataToBus(VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider) {
        this.vehicleProviderDataToVehicleProvider = vehicleProviderDataToVehicleProvider;
    }

    @Override
    public Bus convert(BusData busData) {
        return Bus.BusBuilder.aBus()
                .id(busData.getId())
                .name(busData.getName())
                .fromStation(busData.getFromStation())
                .toStation(busData.getToStation())
                .ticketNumber(busData.getTicketNumber())
                .price(busData.getPrice())
                .departure(busData.getDeparture())
                .arrival(busData.getArrival())
                .vehicleProvider(
                        busData.getVehicleProvider() != null
                                ? this.vehicleProviderDataToVehicleProvider.convert(
                                        busData.getVehicleProvider())
                                : null)
                .busModel(busData.getBusModel())
                .createdAt(busData.getCreatedAt())
                .modifiedAt(busData.getModifiedAt())
                .createdBy(busData.getCreatedBy())
                .modifiedBy(busData.getModifiedBy())
                .build();
    }
}
