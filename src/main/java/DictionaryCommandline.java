import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    private  DictionaryManagement dicMan = new DictionaryManagement();


    public void showAllWords() {
        int m = 1;
        System.out.printf("%-5s %-20s %-20s", "No", "| English", "| Vietnamese");
        System.out.println();
        for (Word i : dicMan.getDictionary().getWords()) {
            System.out.printf("%-5s %-20s %-20s", m, "| " + i.getWord_target(), "| " + i.getWord_explain());
            System.out.println();
            ++m;
        }
    }

    public void dictionaryBasic() {
        dicMan.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        dicMan.insertFromFile();
        showAllWords();
        dicMan.dictionaryLookup();
    }

    public void dictionarySearcher() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ban hay nhap tu muon tra: ");
        String tu = scan.nextLine();
        int j = 0;
        for (Word i : dicMan.getDictionary().getWords()) {
            String ans = i.getWord_target().substring(j, tu.length());
            if (tu.equalsIgnoreCase(ans)) {
                System.out.println(i.getWord_target());
            }
        }
    }
}
