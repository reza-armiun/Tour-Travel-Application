package razarm.tosan.controller.commandline;


import razarm.tosan.controller.dto.tour.*;
import java.util.*;
import java.util.stream.IntStream;

public class DisplayTourTicketHandler extends QuestionHandler {
  public static final String NAME = "DISPLAY TOUR TICKET";

  public DisplayTourTicketHandler(Map<String, QuestionHandler> questionHandlers) {
    super(questionHandlers);
  }

  @Override
  public void run(Map<String, Object> values) {
    BookingDto booking = (BookingDto) values.get("booking");
    var traveler = booking.getTravelers().stream().findFirst().get();
    var tour = booking.getTour();
    var tourismManager =  tour.getTourismManager();
    var schedulePlan = tour.getSchedulePlans().stream().findFirst().get();
    var accommodation = schedulePlan.getAccommodationOrder();
    var vehicleOrder = schedulePlan.getVehicleOrders().stream().findFirst().get();
    var foodOrder = schedulePlan.getFoodOrders().stream().findFirst().get();


    TableGenerator travelerTable = new TableGenerator();

    List<String> headersList = new ArrayList<>();
    headersList.add("Name");
    headersList.add("Phone");
    headersList.add("Email");
    headersList.add("National Id");

    List<List<String>> rowsList = new ArrayList<>();

    for (int i = 0; i < 1; i++) {
      List<String> row = new ArrayList<>();
      row.add(traveler.getName());
      row.add(traveler.getPhone());
      row.add(traveler.getEmail());
      row.add(traveler.getNationalId().toString());

      rowsList.add(row);
    }
    System.out.println("Traveler Info");
    System.out.println(travelerTable.generateTable(headersList, rowsList));

////////////////////////////////////////////////////////////////////////////////////////

    TableGenerator tourismManagerTable = new TableGenerator();

    List<String> tourismManagerHeadersList = new ArrayList<>();
    tourismManagerHeadersList.add("Name");
    tourismManagerHeadersList.add("Phone");
    tourismManagerHeadersList.add("Email");
    tourismManagerHeadersList.add("National Id");

    List<List<String>> tourismManagerRowsList = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<String> row = new ArrayList<>();
      row.add(tourismManager.getName());
      row.add(tourismManager.getPhone());
      row.add(tourismManager.getEmail());
      row.add(tourismManager.getNationalId().toString());

      tourismManagerRowsList.add(row);
    }
    System.out.println("Tourism Manager Info");
    System.out.println(tourismManagerTable.generateTable(tourismManagerHeadersList, tourismManagerRowsList));

////////////////////////////////////////////////////////////////////////////////////////
    TableGenerator tourTable = new TableGenerator();

    List<String> tourHeadersList = new ArrayList<>();
    tourHeadersList.add("Name");
    tourHeadersList.add("Date");
    tourHeadersList.add("Description");
    tourHeadersList.add("Guide");

    List<List<String>> tourRowsList = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<String> row = new ArrayList<>();
      row.add(tour.getName() != null ? tour.getName() : "" );
      row.add(tour.getDate() != null ? tour.getDate().toString() : "");
      row.add(tour.getDescription() != null ? tour.getDescription() : "");
      row.add(tour.getGuide() != null ? tour.getGuide() : "");

      tourRowsList.add(row);
    }
    System.out.println("Tour Info");
    System.out.println(tourTable.generateTable(tourHeadersList, tourRowsList));
////////////////////////////////////////////////////////////////////////////////////////
    TableGenerator schedulePlanTable = new TableGenerator();

    List<String> planHeadersList = new ArrayList<>();
    planHeadersList.add("Name");
    planHeadersList.add("Source");
    planHeadersList.add("Destination");
    planHeadersList.add("Start Time");
    planHeadersList.add("Arrival Time");

    List<List<String>> planRowsList = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<String> row = new ArrayList<>();
      row.add(schedulePlan.getName());
      row.add(schedulePlan.getSource().getCity().getName());
      row.add(schedulePlan.getDestination().getCity().getName());
      row.add(schedulePlan.getStartTime().toString());
      row.add(schedulePlan.getArrivalTime().toString());

      planRowsList.add(row);
    }
    System.out.println("Schedule Plan Info");
    System.out.println(schedulePlanTable.generateTable(planHeadersList, planRowsList));
////////////////////////////////////////////////////////////////////////////////////////
    TableGenerator accommodationTable = new TableGenerator();

    List<String> accommodationHeadersList = new ArrayList<>();
    accommodationHeadersList.add("Name");
    accommodationHeadersList.add("Discount");
    accommodationHeadersList.add("Date");

    List<List<String>> accommodationRowsList = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<String> row = new ArrayList<>();
      row.add(accommodation.getAccommodation().getName());
      row.add(accommodation.getDiscount().toString());
      row.add(accommodation.getDate() != null ?accommodation.getDate().toString() : null);

      accommodationRowsList.add(row);
    }
    System.out.println("Accommodation Info");
    System.out.println(accommodationTable.generateTable(accommodationHeadersList, accommodationRowsList));
////////////////////////////////////////////////////////////////////////////////////////


  }

  @Override
  public String getName() {
    return NAME;
  }
}
