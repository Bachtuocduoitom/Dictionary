import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords(ArrayList<Word> words) {
        int m = 1;
        System.out.printf("%-5s %-20s %-20s", "No", "| English", "| Vietnamese");
        for (Word i : words) {
            System.out.printf("%-5s %-20s %-20s", m, "| " + i.getWord_target(), "| " + i.getWord_explain());
            ++m;
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        Dictionary dictionary = new Dictionary();
        dictionary.addWord(dictionaryManagement.insertFromCommandline());
        showAllWords(dictionary.getWords());
    }

    public void dictionaryAdvanced() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        Dictionary dictionary = new Dictionary();
        dictionary.addWord(dictionaryManagement.insertFromCommandline());
        showAllWords(dictionary.getWords());
        dictionaryManagement.dictionaryLookup(dictionary.getWords());
    }

    public void dictionarySearcher(ArrayList<Word> words) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ban hay nhap tu muon tra: ");
        String tu = scan.nextLine();
        int j = 0;
        for (Word i : words) {
            String ans = i.getWord_target().substring(j, tu.length());
            if (tu.equalsIgnoreCase(ans)) {
                System.out.println(i.getWord_target());
            }
        }
    }
}
