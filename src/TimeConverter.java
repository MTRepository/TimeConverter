import java.util.Scanner;

public class TimeConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalSeconds;

        System.out.println("To exit the program type in \"exit\"");
        System.out.println("");

        while (true) {

            System.out.println("Give a number of seconds you want to convert into readable form: ");
            String input = scanner.nextLine();

            if(input.equals("exit")) {
                System.out.println("You're out.");
                break;
            } else {
                totalSeconds = Integer.parseInt(input);
                System.out.println(formatDuration(totalSeconds));
            }
        }
    }

    public static String formatDuration(int seconds) {

        if(seconds == 0) return "now";

        int remainder;
        boolean inYears;
        int numOfYears;
        boolean inDays;
        int numOfDays;
        boolean inHours;
        int numOfHours;
        boolean inMinutes;
        int numOfMinutes;

        StringBuilder sb = new StringBuilder();

        inYears = seconds / (365 * 24 * 60 * 60) > 0;
        numOfYears = (int) seconds / (365 * 24 * 60 * 60);
        if(inYears) {
            sb.append(numOfYears + " year");
            if(numOfYears > 1) sb.append("s");
            sb.append(", ");
        }

        remainder = seconds - numOfYears * 365 * 24 * 60 * 60;

        inDays = remainder / (24 * 60 * 60) > 0;
        numOfDays = (int) remainder / (24 * 60 * 60);
        if(inDays) {
            sb.append(numOfDays + " day");
            if(numOfDays > 1) sb.append("s");
            sb.append(", ");
        }

        remainder = remainder - numOfDays * 24 * 60 * 60;

        inHours = remainder / (60 * 60) > 0;
        numOfHours = (int) remainder / (60 * 60);
        if(inHours) {
            sb.append(numOfHours + " hour");
            if(numOfHours > 1) sb.append("s");
            sb.append(", ");
        }

        remainder = remainder - numOfHours * 60 * 60;

        inMinutes = remainder / 60 > 0;
        numOfMinutes = (int) remainder / 60;
        if(inMinutes) {
            sb.append(numOfMinutes + " minute");
            if(numOfMinutes > 1) sb.append("s");
            sb.append(", ");
        }

        remainder = remainder - numOfMinutes * 60;

        if(remainder > 0) {
            sb.append(remainder + " second");
            if(remainder > 1) sb.append("s");
            sb.append(", ");
        }

        sb.deleteCharAt(sb.toString().length()-1);
        sb.deleteCharAt(sb.toString().length()-1);

        String result;

        if(sb.toString().contains(",")) {
            int andPosition = sb.toString().lastIndexOf(",");
            result = sb.toString().substring(0,andPosition)
                    + sb.toString().substring(andPosition).replace(","," and");
        } else {
            result = sb.toString();
        }

        return result;

    }

}
