package razarm.tosan.controller.commandline;

import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.controller.dto.tour.BookingDto;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.service.tour.BookingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingTourHandler extends QuestionHandler{
    public static final String NAME = "BOOKING TOUR";
    private final BookingService bookingService;

    public BookingTourHandler(Map<String, QuestionHandler> questionHandlers, BookingService bookingService) {
        super(questionHandlers);
        this.bookingService = bookingService;
    }

    @Override
    public void run(Map<String, Object> values) {
        final TourDto tour = (TourDto) values.get("tour");
        final TravelerDto traveler = (TravelerDto) values.get("traveler");
        System.out.println("Booking Tour:");
        var description = QuestionFactory.askSimpleQuestion("Enter description:");
        var date = QuestionFactory.createDate("Enter Tour Date:");

        BookingDto bookingDto = BookingDto.BookingDtoBuilder.aBookingDto()
                .travelers(Set.of(traveler))
                .tour(tour)
                .date(date.toZonedDateTime())
                .description(description)
                .build();

        TableGenerator tableGenerator = new TableGenerator();

        List<String> headersList = new ArrayList<>();
        headersList.add("Tour Name");
        headersList.add("Date");
        headersList.add("From");
        headersList.add("To");
        headersList.add("Traveler");
        headersList.add("Description");

        List<List<String>> rowsList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            List<String> row = new ArrayList<>();
            row.add(tour.getName());
            row.add(bookingDto.getDate().toString());
            row.add(tour.getSchedulePlans().stream().findFirst().get().getSource().getCity().getName());
            row.add(tour.getSchedulePlans().stream().findFirst().get().getDestination().getCity().getName());
            row.add(traveler.getName());
            row.add(description);
            rowsList.add(row);
        }

        System.out.println("Booking Details:");
        System.out.println(tableGenerator.generateTable(headersList, rowsList));

        var result = QuestionFactory.confirmationQuestion("Are you sure you want to book this tour?");
        if(!result) {
            var  selectedIndex = QuestionFactory.selectOptionsIndex("Choose Your Next Step Please:"
                    , new String[]{ "TOUR SELECTION", "ADD TRAVELER", "BACK", "EXIT"});
            if(selectedIndex == 0) this.next= this.getQuestionHandlers().get(SelectTourTypeHandler.NAME);
            if(selectedIndex == 1) this.next = this.getQuestionHandlers().get(AddTravelerHandler.NAME);
            if(selectedIndex == 2) this.next = prev;
            if(selectedIndex == 3) System.exit(1);
            nextQuestion(values);
            return;
        }
        try {
            var savedBooking = bookingService.bookingNewTour((String) values.get("username"), bookingDto);
            values.put("booking", savedBooking);
            nextQuestion(values);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}
