import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {
  private ArrayList<Word> words = new ArrayList<>();

  void addWord(Word newWord) {
    if (newWord != null) {
      words.add(newWord);
    }
  }
  void addWord(String word_target, String word_explain) {
    Word newWord = new Word(word_target,word_explain);
    words.add(newWord);
  }


  void removeWord(String word_target) {
    Word tmpWord = lookUp(word_target);
    if (tmpWord != null) {
      words.remove(tmpWord);
    }
  }

  void editWord(Word word, String newExplain) {
    if (word != null) {
      word.setWord_explain(newExplain);
    }
  }

  public void preSearcher(String prefix) {
    for (Word word : words) {
      if (word.getWord_target().startsWith(prefix)) {
        System.out.println(word);
      }
    }
  }

  public Word lookUp(String word_target) {
    for (Word word : words){
      if (Objects.equals(word.getWord_target(), word_target)) {
        return word;
      }
    }
    return null;
  }

  public String formatDictionary() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Word word : words) {
      String line = String.format("%s%s", word.getWord_target() + "\t", word.getWord_explain()+'\n');
      stringBuilder.append(line);
    }
    return stringBuilder.toString();
  }
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < words.size(); i++) {
      String line = String.format("%-10s%s%n", i+1, words.get(i).toString());
      stringBuilder.append(line);
    }
    return stringBuilder.toString();
  }
}
