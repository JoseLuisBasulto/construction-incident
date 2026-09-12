import java.util.Locale;

public class Validations {

    public static Priority isValidPriority(String input){
        if(input == null){
            return null;
        }

        String cleanInput = input.trim().toUpperCase();

        try {
            return Priority.valueOf(cleanInput);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public static State isValidState(String input){
        if(input == null){
            return null;
        }

        String cleanInput = input.trim().toUpperCase();

        try {
            return State.valueOf(cleanInput);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public static boolean isValidInput(String equipment, String location,
                                       String description){
        return equipment != null && location != null && description != null;
    }
}
