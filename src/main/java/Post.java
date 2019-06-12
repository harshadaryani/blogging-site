import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Post {
    String id;
    String title;
    String category;
    String description;
    String author;
    String date;
    String content;
    String[] keywords;
    int claps;

    public Post(String title, String category, String description, String author, String date, String content, String[] keywords, int claps) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.author = author;
        this.date = date;
        this.content = content;
        this.keywords = keywords;
        this.claps = claps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getClaps() {
        return claps;
    }

    public void setClaps(int claps) {
        this.claps = claps;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + "', \n "  +
                "title='" + title + "', \n "  +
                "category='" + category + "', \n "  +
                "description='" + description + "', \n " +
                "author='" + author + "', \n " +
                "date='" + date + "', \n " +
                "content='" + content + "', \n " +
                "keywords=" + Arrays.toString(keywords) + "', \n " +
                "claps=" + claps +
                '}';
    }
}
