package razarm.tosan.controller.commandline;

import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionFactory {
    public final static String ESC = "\u001B";
    public final static String GS = "\u001D";
    public final static String InitializePrinter = ESC + "@";
    //    public final static String BoldOn = ESC + "E" + "\u0001";
    public final static String BoldOn = "\033[0;1m";
    //    public final static String BoldOff = ESC + "E" + "\0";
    public final static String BoldOff ="\033[0;0m";
    public final static String DoubleOn = GS + "!" + "\u0011";  // 2x sized text (double-high + double-wide)
    public final static String DoubleOff = GS + "!" + "\0";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private QuestionFactory() {}

    public static OffsetDateTime createDate(String desc) {
        var scanner = SimpleScanner.getScanner();

        int sec = 0;
        int min = 0;
        int hr = 0;
        int day = 0;
        int month = 0;
        int year = 0;
        while (true) {
            try {
                System.out.println(BoldOn + TEXT_BLUE + "Enter year:" + BoldOff + TEXT_BLACK);
                year = scanner.nextInt();
                if (year >= 2100 || year < 1800) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter month:" + BoldOff + TEXT_BLACK);
                month = scanner.nextInt();
                if (month >= 12 || month < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter day:" + BoldOff + TEXT_BLACK);
                day = scanner.nextInt();
                if (day >= 30 || day < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter hour:" + BoldOff + TEXT_BLACK);
                hr = scanner.nextInt();
                if (hr >= 24 || hr < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter minute:" + BoldOff + TEXT_BLACK);
                min = scanner.nextInt();
                if (min >= 60 || min < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter second:" + BoldOff + TEXT_BLACK);
                sec = scanner.nextInt();
                if (sec >= 60 || sec < 0) throw new IllegalArgumentException();
                var date = OffsetDateTime.of(year, month, day, hr, min, sec, 0, ZoneOffset.UTC);
                System.out.println(BoldOn + TEXT_YELLOW + desc + date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + BoldOff + TEXT_BLACK);
                return date;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input");
            }
        }
    }

    public  static String askSimpleQuestion() {
        var scanner = SimpleScanner.getScanner();
        return scanner.next();
    }


    public static AddressDto createAddress(String desc, Set<CityDto> cities ) {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Address:" + BoldOff + TEXT_BLACK);

        System.out.println(BoldOn + TEXT_BLUE + "Select Country:" + BoldOff + TEXT_BLACK);
        List<CountryDto> countries = cities.stream().map(CityDto::getCountry).distinct().collect(Collectors.toUnmodifiableList());
        IntStream.range(0, countries.size())
                 .mapToObj(i ->  BoldOn + i + "." + BoldOff + TEXT_YELLOW + countries.get(i).getName() + TEXT_BLACK + " ")
                 .forEach(System.out::print);
        var selection = Integer.valueOf(askSimpleQuestion());
        var selectedCountry = countries.get(selection);
        var cityOptions = cities.stream().filter(cityDto -> cityDto.getCountry().getName().equals(selectedCountry.getName())).collect(Collectors.toUnmodifiableList());

        System.out.println("Select City: ");
        IntStream.range(0, cityOptions.size())
                 .mapToObj(i ->  BoldOn + i + "." + BoldOff + TEXT_YELLOW + cityOptions.get(i).getName() + TEXT_BLACK + " ")
                 .forEach(System.out::print);
        var citySelection = Integer.valueOf(askSimpleQuestion());
        var selectedCity = cityOptions.get(citySelection);

      return AddressDto.AddressDtoBuilder.anAddressDto()
                                      .city(selectedCity)
//                                    .postalCode(postalCode)
//                                    .street(street)
//                                    .city()
                                    .build();
    }
}
