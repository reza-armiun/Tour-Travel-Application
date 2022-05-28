package razarm.tosan.repository.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.PlaneData;
import razarm.tosan.repository.domain.transport.Plane;

@Component
public class PlaneDataToPlane implements Mapper<PlaneData, Plane> {
    private final VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider;

    public PlaneDataToPlane(VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider) {
        this.vehicleProviderDataToVehicleProvider = vehicleProviderDataToVehicleProvider;
    }

    @Override
    public Plane convert(PlaneData planeData) {
        return Plane.PlaneBuilder.aPlane()
                                 .id(planeData.getId())
                                 .name(planeData.getName())
                                 .type(planeData.getType())
                                 .fromStation(planeData.getFromStation())
                                 .toStation(planeData.getToStation())
                                 .ticketNumber(planeData.getTicketNumber())
                                 .price(planeData.getPrice())
                                 .departure(planeData.getDeparture())
                                 .arrival(planeData.getArrival())
                                 .vehicleProvider(this.vehicleProviderDataToVehicleProvider.convert(planeData.getVehicleProvider()))
                                 .allowedLuggage(planeData.getAllowedLuggage())
                                 .cabinClass(planeData.getCabinClass())
                                 .planeNumber(planeData.getPlaneNumber())
                                 .type(planeData.getType())
                                 .createdAt(planeData.getCreatedAt())
                                 .modifiedAt(planeData.getModifiedAt())
                                 .createdBy(planeData.getCreatedBy())
                                 .modifiedBy(planeData.getModifiedBy())
                                 .build();
    }
}
