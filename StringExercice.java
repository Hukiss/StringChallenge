import java.util.*;


public class StringExercice {

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new LinkedList<>();
        List<Stacker> stacker = new LinkedList<>();

        System.out.println("Escreva o texto:");
        String[] texto = scanner.nextLine().toLowerCase().split(" ");

        for (String text : texto)
            deletarSimbolos(text, lines);

        Collections.sort(lines);
        calcularFrenquencia(lines, stacker);

        System.out.printf("%nResultado: %n%n%-19s%15s%n%n", "Palavras", "Frequência");
        for (Stacker stack : stacker)
            System.out.print(stack.toString());
    }

    private static void deletarSimbolos (String characters, List<String> list)
    {
        char[] sinal = {'.', ',', '!', '?', '(', ')', '{', '}', '[', ']',';', '>', '<', '\"', '\'', '*', '\\'};
        char[] letter = characters.toCharArray();

        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < letter.length; i++)
        {
            int count = 0;

            for ( char c : sinal )
            {
                if (count == sinal.length - 1 && c != letter[i])
                    newWord.append(letter[i]);

                if ( letter[i] == c )
                    break;
                count++;
            }
        }

        list.add(newWord.toString());
    }

    private static void calcularFrenquencia(List<String> list, List<Stacker> stackers)
    {
        String[] words = list.toArray(new String[list.size()]);

        for ( String word : words)
            if (list.contains(word))
            {
                int value = Collections.frequency(list, word);
                stackers.add(new Stacker(word, value));

                while (list.contains(word))
                    list.remove(word);
            }
    }
}

