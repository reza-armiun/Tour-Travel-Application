package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.dto.tour.SchedulePlanDto;
import razarm.tosan.controller.dto.tour.TourDto;
import razarm.tosan.controller.dto.tour.TourismManagerDto;
import razarm.tosan.controller.dto.tour.TravelerDto;
import razarm.tosan.repository.domain.tour.TourType;

import java.util.HashSet;
import java.util.Set;

public class BookingQuestionFactory extends QuestionFactory{


    public static TravelerDto  createTraveler() {
        System.out.println(BoldOn + TEXT_YELLOW + "Create Traveler: " + BoldOff + TEXT_WHITE);
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Name: " + BoldOff + TEXT_WHITE);
        var name = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Email: " + BoldOff + TEXT_WHITE);
        var email = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Phone: " + BoldOff + TEXT_WHITE);
        var phone = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter National Id: " + BoldOff + TEXT_WHITE);
        var nationalId = askSimpleNumberQuestion();

        return TravelerDto.TravelerDtoBuilder.aTravelerDto()
                .name(name)
                .email(email)
                .nationalId(nationalId)
                .phone(phone)
                .build();
    }

    public static TourismManagerDto createTourismManager() {
        System.out.println(BoldOn + TEXT_YELLOW + "Create Tourism Manager: " + BoldOff + TEXT_WHITE);
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Name: " + BoldOff + TEXT_WHITE);
        var name = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Email: " + BoldOff + TEXT_WHITE);
        var email = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Phone: " + BoldOff + TEXT_WHITE);
        var phone = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter National Id: " + BoldOff + TEXT_WHITE);
        var nationalId = Long.valueOf(askSimpleQuestion());


        return TourismManagerDto.TourismManagerDtoBuilder.aTourismManagerDto()
                .name(name)
                .email(email)
                .phone(phone)
                .nationalId(nationalId)
                .build();
    }

    public static TourDto createCustomTour() {
        System.out.println(BoldOn + TEXT_YELLOW + "Create Tour: " + BoldOff + TEXT_WHITE);
        System.out.println(BoldOn + TEXT_YELLOW + "Enter Name: " + BoldOff + TEXT_WHITE);
        var name = askSimpleQuestion();

       return TourDto.TourDtoBuilder.aTourDto()
               .name(name)
               .type(TourType.CITY)
               .tourismManager(createTourismManager())
               .schedulePlans(createPlans())
                .build();
    }

    private static Set<SchedulePlanDto> createPlans() {
        final String ADD_NEW_PLAN = "Add New Plan";
        final String GO_NEXT = "Go Next";
        var plans = new HashSet<SchedulePlanDto>();
        System.out.println("Creating Schedule Plans");
        while (true) {
            var selection = selectOptions(new String[]{ADD_NEW_PLAN, GO_NEXT});
            if(selection.equals(GO_NEXT)) return plans;
            var plan = SchedulePlanQuestionFactory.createSchedulePlan();
            plans.add(plan);
        }
    }


}
