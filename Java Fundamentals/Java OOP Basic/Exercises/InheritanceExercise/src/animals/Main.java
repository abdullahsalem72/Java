package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String type;
        while (true) {
            if ("Beast!".equalsIgnoreCase(type = reader.readLine())) {
                break;
            }
            String[] tokens = reader.readLine().split("\\s+");

            try {
                Animal animal = getAnimal(type, tokens);

                System.out.println(animal);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }
    }

    private static Animal getAnimal(String type, String[] tokens) {
        switch (type) {
            case "Cat":
                return new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            case "Dog":
                return new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            case "Frog":
                return new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            case "Kitten":
                return new Kitten(tokens[0], Integer.parseInt(tokens[1]));
            case "Tomcat":
                return new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
            default:
                throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_ERROR_MESSAGE);
        }
    }
}
