import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Scanner scan;

    public ArrayList<Word> insertFromCommandline() {
        this.scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Word> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word_target = scan.nextLine();
            String word_explain = scan.nextLine();
            Word newword = new Word(word_target, word_explain);
            words.add(newword);
        }
        return words;
    }

    public ArrayList<Word> insertFromFile()  {
        String fileAddress = "src\\dictionaries.txt";
        ArrayList<Word> words = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileAddress);
            this.scan = new Scanner(fileInputStream);
            while (scan.hasNextLine()) {
                String[] tu = scan.nextLine().split("\t", 2);
                String word_target = tu[0];
                String word_explain = tu[1];
                Word newword = new Word(word_target, word_explain);
                words.add(newword);
            }
        } catch (IOException ex) {
            System.out.println("ERROR!");
        }
        return words;
    }

    public void dictionaryLookup(ArrayList<Word> words) {
        scan = new Scanner(System.in);
        System.out.print("Ban hay nhap tu can tra cuu: ");
        String wordNeed = scan.nextLine();
        for (Word i : words) {
            if (i.getWord_target().equalsIgnoreCase(wordNeed)) {
                System.out.println("Nghia: " + i.getWord_explain());
            } else if (i.getWord_explain().equalsIgnoreCase(wordNeed)) {
                System.out.println("Nghia: " + i.getWord_target());
            }
        }

    }

    public void addNewWord(ArrayList<Word> words) {
        scan = new Scanner(System.in);
        System.out.print("Ban hay nhap tu tieng Anh muon them: ");
        String word_target = scan.nextLine();
        System.out.print("Ban hay nhap nghia tieng Viet: ");
        String word_explain = scan.nextLine();
        Word newword = new Word(word_target, word_explain);
        words.add(newword);
    }

    public void deleteWord(ArrayList<Word> words) {
        scan = new Scanner(System.in);
        System.out.print("Ban hay nhap tu muon xoa");
        String wordSelectedToDelete = scan.nextLine();
        for (Word i : words) {
            if (i.getWord_target().equalsIgnoreCase(wordSelectedToDelete)) {
                words.remove(i);
            }
            else if (i.getWord_explain().equalsIgnoreCase(wordSelectedToDelete)) {
                words.remove(i);
            }
            break;
        }
    }

    public void wordCorrection(ArrayList<Word> words) {
        scan = new Scanner(System.in);
        System.out.print("De sua nghia tieng Anh nhap \"Anh\". ");
        System.out.print("De sua nghia tieng Viet nhap \"Viet\": ");
        String choose = scan.nextLine();
        String Anh = "Anh";
        String Viet = "Viet";
        if (choose.equalsIgnoreCase(Anh)) {
            System.out.print("Ban hay nhap tu tieng Viet: ");
            String word_explain = scan.nextLine();
            boolean flag = true;
            for (Word i : words) {
                if (i.getWord_explain().equalsIgnoreCase(word_explain)) {
                    System.out.print("Sua nghia tieng Anh thanh: ");
                    String word_target = scan.nextLine();
                    i.setWord_target(word_target);
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println("Khong tim thay tu ban nhap.");
            }
        } else if (choose.equalsIgnoreCase(Viet)) {
            System.out.print("Ban hay nhap tu tieng Anh: ");
            String word_target = scan.nextLine();
            boolean flag = true;
            for (Word i : words) {
                if (i.getWord_explain().equalsIgnoreCase(word_target)) {
                    System.out.print("Sua nghia tieng Anh thanh: ");
                    String word_explain = scan.nextLine();
                    i.setWord_target(word_explain);
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println("Khong tim thay tu ban nhap.");
            }
        }
    }

    public void dictionaryExportToFile(ArrayList<Word> words) throws IOException {
        String fileAddress = "src:\\dictionariesout.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileAddress);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        for (Word i : words) {
            outputStreamWriter.write(i.getWord_target() + " ");
            outputStreamWriter.write(i.getWord_explain() + "\n");
        }
        outputStreamWriter.flush();
    }


}
