public class Word {
  private String word_target;
  private String word_explain;

  public Word() {
  }
  public Word(String word_target, String word_explain) {
    if (word_target.isEmpty() || word_explain.isEmpty()) {
      throw new IllegalArgumentException("empty string");
    }
    this.word_target = word_target.trim().toLowerCase();
    this.word_explain = word_explain.trim().toLowerCase();
  }

  public void setWord_target(String word_target) {
    if (!word_target.isEmpty()) {
      this.word_target = word_target.trim().toLowerCase();
    }
  }
  public void setWord_explain(String word_explain) {
    if (!word_explain.isEmpty()) {
      this.word_explain = word_explain.trim().toLowerCase();
    }
  }

  public String getWord_target() {
    return this.word_target;
  }
  public String getWord_explain() {
    return this.word_explain;
  }

  public String toString() {
    return String.format("|%-20s|%-20s", word_target, word_explain);
  }
}
