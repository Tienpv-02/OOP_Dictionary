import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement{

  public void showAllWords() {
    System.out.println("No        |English             |Vietnamese          ");
    super.show();
  }

  public void dictionaryBasic() throws IOException {
    super.insertFromCommandline();
    showAllWords();
  }

  public void dictionaryAdvanced() throws IOException {
    super.insertFromFile(  "dictionaries.txt");
    super.editDictionary();
    showAllWords();
  }
  public void run() throws IOException, InterruptedException {
    super.insertFromFile("dictionaries.txt");
    while (true) {
      //Runtime.getRuntime().exec("cls");
      System.out.println("0. Tra cứu từ\n1. Tìm kiếm từ\n2. Thêm từ mới\n3. Chỉnh sửa\n4. Xoá từ\n"
        + "5. Hiển thị danh sách từ\n6. Thoát");
      Scanner in = new Scanner(System.in);
      int chooseFunction = in.nextInt();
      switch (chooseFunction) {
        case 0 -> super.dictionaryLookUp();
        case 1 -> super.dictionarySearcher();
        case 2 -> {
          super.insertFromCommandline();
          super.dictionaryExportToFile();
        }
        case 3 -> {
          super.editDictionary();
          super.dictionaryExportToFile();
        }
        case 4 -> {
          super.removeWordFromCL();
          super.dictionaryExportToFile();
        }
        case 5 -> showAllWords();
        case 6 -> {
          super.writeToFile();
          System.exit(1);
        }
        default -> System.out.println("không hợp lệ!!!");
      }
      Thread.sleep(3000);
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    DictionaryCommandLine dcl = new DictionaryCommandLine();
    dcl.run();
  }
}
