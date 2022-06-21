package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

        public void setDate(String year){
            $(".react-datepicker__month-select").click();
            $(byText("August")).click();
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption(year);
            $(".react-datepicker__day--002").click();
        }
    }
