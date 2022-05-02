package razarm.tosan.controller.commandline;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AddressBuilderQuestionHandler extends QuestionHandler {
    private final String countryQ = "Select Country:";
    private final String cityQ = "Select City:";

    private final Map<String, String[]> options = new HashMap<>() {{
        this.put("Iran", new String[]{"Boushehr", "Tehran", "Shiraz"});
        this.put("Turkey", new String[]{"Istanbul", "Ankara", "Izmir"});
        this.put("Netherlands", new String[]{"(Amsterdam", " Rotterdam", "Utrecht"});
        this.put("Ukraine", new String[]{"Kyiv", "Kharkiv", "Lviv"});
    }};


    @Override
    public void run(Object... values) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println(countryQ);
            IntStream.range(0, options.size())
//                     .mapToObj(i ->  BoldOn + i + "." + BoldOff+ TEXT_YELLOW+  options.get(i).trim() + TEXT_BLACK + " ")
                     .forEach(System.out::print);

        }catch (Exception e){

        }
    }
}
