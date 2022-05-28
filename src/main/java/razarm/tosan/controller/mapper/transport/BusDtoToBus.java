package razarm.tosan.controller.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.transport.BusDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Bus;

@Component
public class BusDtoToBus implements Mapper<BusDto, Bus> {
    private final VehicleProviderDtoToVehicleProvider vehicleProviderDtoToVehicleProvider;

    public BusDtoToBus(VehicleProviderDtoToVehicleProvider vehicleProviderDtoToVehicleProvider) {
        this.vehicleProviderDtoToVehicleProvider = vehicleProviderDtoToVehicleProvider;
    }

    @Override
    public Bus convert(BusDto busDto) {
        return Bus.BusBuilder.aBus()
            .id(busDto.getId())
            .name(busDto.getName())
            .fromStation(busDto.getFromStation())
            .toStation(busDto.getToStation())
            .ticketNumber(busDto.getTicketNumber())
            .price(busDto.getPrice())
            //                             .discountRate(busDto.getDiscountRate())
            .busModel(busDto.getBusModel())
            .departure(busDto.getDeparture().toInstant())
            .arrival(busDto.getArrival().toInstant())
            .vehicleProvider(vehicleProviderDtoToVehicleProvider.convert(busDto.getVehicleProvider()))
            .createdAt(busDto.getCreatedAt().toInstant())
            .modifiedAt(busDto.getModifiedAt().toInstant())
            .createdBy(busDto.getCreatedBy())
            .modifiedBy(busDto.getModifiedBy())
            .build();
    }
}
