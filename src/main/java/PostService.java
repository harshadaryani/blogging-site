import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PostService {
    private List<Post> posts = new ArrayList<Post>();

    public void add(Post addObj) {

        posts.add(addObj);
    }

    public List<Post> getAll() {
        return posts;
    }

    public void delete(Post deleteObj) {
        if(posts.isEmpty()) {
            System.out.println("Empty List");
        }
        else {
            posts.remove(deleteObj);
        }
    }
}
