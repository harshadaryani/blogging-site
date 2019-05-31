import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PostService {
    private List<Post> posts = new ArrayList<Post>();
    private List<Post> postsListByClaps = new ArrayList<Post>();


    public void add(Post addObj) {
        addObj.id = java.util.UUID.randomUUID();;
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

    public List<Post> getPostsByClaps(int count) {
        for(Post data : posts) {
            if(data.claps > count) {
                postsListByClaps.add(data);
            }
        }
        return postsListByClaps;
    }

    public List<Post> getPostsByCategory(String category) {
        for(Post data : posts) {
            if(data.category == category) {
                postsListByClaps.add(data);
            }
        }
        return postsListByClaps;
    }
}
