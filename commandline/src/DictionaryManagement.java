import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement {
  private Dictionary dictionary = new Dictionary();

  public void insertFromCommandline()  {
    Scanner in = new Scanner(System.in);
    System.out.print("Nhập số lượng từ cần thêm:");
    int n = Integer.parseInt(in.nextLine());
    System.out.println("Nhập danh sách các từ:");
    while (n > 0) {
      String word_target = in.nextLine();
      String word_explain = in.nextLine();
      Word newWord = new Word(word_target, word_explain);
      dictionary.addWord(newWord);
      n--;
    }
    System.out.println("Thêm từ thành công!");
  }

  public void insertFromFile(String path) {
    String line;
    String[] str;

    try {
      InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path),
          StandardCharsets.UTF_8);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      while ((line = bufferedReader.readLine()) != null) {
        str = line.split("\t", 2);
        Word newWord = new Word(str[0], str[1]);
        dictionary.addWord(newWord);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Could not open file at"+path);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void removeWordFromCL() {
    Scanner in = new Scanner(System.in);
    System.out.print("Nhập số lượng từ cần xoá:");
    int n = Integer.parseInt(in.nextLine());
    System.out.println("Nhập danh sách các từ:");
    while (n > 0) {
      String word_target = in.nextLine();
      dictionary.removeWord(word_target);
      n--;
    }
    System.out.println("Xoá thành công!");
  }

  public void editDictionary() {
    System.out.print("Nhập từ cần sửa:");
    Scanner sc = new Scanner(System.in);
    String word_target = sc.nextLine().trim().toLowerCase();
    Word word = dictionary.lookUp(word_target);
    if (word == null) {
      System.out.println("Không tìm thấy từ");
    } else {
      System.out.print("Nhập giải thích nghĩa mới:");
      String newExplain = sc.nextLine().trim().toLowerCase();
      dictionary.editWord(word,newExplain);
      System.out.println("Sửa thành công!");
    }
  }

  public void dictionaryLookUp() {
    Scanner in = new Scanner(System.in);
    System.out.print("Nhập từ muốn tra: ");
    String word_target = in.nextLine().trim().toLowerCase();
    Word result = dictionary.lookUp(word_target);
    if (result != null) {
      System.out.println(result);
    } else {
      System.out.println("Không có dữ liệu");
    }
  }

  public void dictionarySearcher() {
    System.out.println("Nhập từ: ");
    Scanner sc = new Scanner(System.in);
    String prefix = sc.nextLine().trim().toLowerCase();
    System.out.println("|English             |Vietnamese          ");
    dictionary.preSearcher(prefix);
  }

  public void dictionaryExportToFile() throws IOException {
    FileWriter writer = new FileWriter("outDictionaries.txt");
    BufferedWriter bw = new BufferedWriter(writer);
    bw.write(dictionary.toString());
    bw.close();
  }

  void writeToFile() throws IOException {
    FileWriter writer = new FileWriter("dictionaries.txt");
    BufferedWriter bw = new BufferedWriter(writer);
    bw.write(dictionary.formatDictionary());
    bw.close();
  }

  public void show() {
    System.out.println(dictionary);
  }
}
