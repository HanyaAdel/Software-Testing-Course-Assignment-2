public class Question3 {
    String state;
    String state1;
    int m, h, D, M, Y;

    public Question3() {
        setStateToNormal();
        m=0; h=0; D=1; M=1; Y=2000;
    }
    public void setStateToNormal(){
        state= "NORMAL";
        state1= "TIME";
    }
    public void setStateToUpdate(){
        state = "UPDATE";
        state1 = "MIN";
    }
    public void setStateToAlarm(){
        state = "ALARM";
        state1 = "ALARM";
    }

    public void handleQuestion (char input) {
        switch (state) {

            case "UPDATE" -> {
                if (input == 'a') {

                    switch (state1) {
                        case "MIN" -> state1 = "HOUR";
                        case "HOUR" -> state1 = "DAY";
                        case "DAY" -> state1 = "MONTH";
                        case "MONTH" -> state1 = "YEAR";
                        case "YEAR" -> setStateToNormal();
                    }
                }

                else if (input == 'd') setStateToNormal();

                else if (input == 'b') {
                    if (state1.equals("MIN")) {
                        m++;
                        m %= 60;
                    }
                    if (state1.equals("HOUR")) {
                        h++;
                        h %= 24;
                    }
                    if (state1.equals("DAY")) {
                        D++;
                        D %= 32;
                    }
                    if (state1.equals("MONTH")) {
                        M++;
                        M %= 13;
                    }
                    if (state1.equals("YEAR")) {
                        Y++;
                    }
                }
                else {
                    System.out.println("Error");
                }
            }

            case "NORMAL" -> {

                if (input == 'c') setStateToUpdate();
                else if (input == 'b') setStateToAlarm();
                else if (input == 'a') {
                    if (state1.equals("TIME")) state1 = "DATE";
                    else state1 = "TIME";
                }
                else {
                    System.out.println("Error");
                }
            }
            case "ALARM" -> {
                if (input == 'd') setStateToNormal();
                else if (input == 'a' && state1.equals("ALARM")) state1 = "CHIME";
                else {
                    System.out.println("Error");
                }
            }
        }
    }
    public String displayDate() {
        return (Y+"-"+M+"-"+D);
    }

    public String displayTime() {
        return (h+":"+m);
    }

    public String displayCurrentState() {
        return(state + "-" + state1);
    }

}
