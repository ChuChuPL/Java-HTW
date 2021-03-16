import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class DiceWare {
    private List<String> lines = new ArrayList<>();

    private Map<String, String> map;

    public DiceWare() throws FileNotFoundException {
        // you may want to change the path to the file
        String fileName = "/Users/chuchu/diceware_german.txt";
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        // putting the key-value pairs into the map
        map = new HashMap<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            map.put(words[0],words[1]);
        }
    }

    public String generatePassword() {
        String code;
        String word;
        String pass = "";
        for (int i = 0; i < 7; i++){
            code = generateCode();
            word = map.get(code);
            pass = pass + word;
        }
        return pass;
    }

    private String generateCode() {
        int c=0;
        int random=0;
        Random r=new Random();
        while(c<5){
            /*random=r.nextInt(6)+1;
            s= String.valueOf(random);
            s2+=s;*/
            random = random * 10 +(r.nextInt(6)+1);
            c++;
        }
        return String.valueOf(random);
    }

    public static void main(String[] args) throws FileNotFoundException {
        DiceWare diceWare = new DiceWare();
        for (int i = 0; i < 20; i++) {
            System.out.println(diceWare.generatePassword());
        }
    }
}
