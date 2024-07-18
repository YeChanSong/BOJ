import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String[] words;
    private static int num = 9;

    public static void main(String[] args) throws IOException {
        settingInput();
        HashMap<Character, Long> weightedChar = weightCalculator();
        long answer = addWords(weightedChar);
        System.out.println(answer);
        br.close();
    }
    private static void settingInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for(int i=0;i<N;i++) words[i] = br.readLine();
    }
    private static HashMap<Character, Long> weightCalculator() {
        HashMap<Character, Long> weightedChar = new HashMap<>();

        Arrays.stream(words).forEach( word -> {
            for (int i=word.length()-1 ; i >= 0 ; i--) {
                char character = word.charAt(word.length()-1 - i);
                weightedChar.putIfAbsent(character, 0L);
                weightedChar.put(character, weightedChar.get(character) + Double.valueOf(Math.pow(10, i)).longValue());
            }
        });
        return weightedChar;
    }
    private static long addWords(HashMap<Character, Long> weightedChar) {
        ArrayList<Map.Entry<Character, Long>> listedChar = new ArrayList<>(weightedChar.entrySet());
        listedChar.sort( (a, b) -> Long.compare(b.getValue(), a.getValue()) );
        HashMap<Character, Integer> charValue = new HashMap<>();
        listedChar.forEach( character -> charValue.put(character.getKey(), num--));
        long answer = 0;
        for (int i=0;i<words.length;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) sb.append(charValue.get(words[i].charAt(j)));
            answer += Long.parseLong(sb.toString());
        }
        return answer;
    }

}