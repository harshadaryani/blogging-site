
import java.util.*;
import java.util.stream.Collectors;

public class PostService {
    private List<Post> posts = new ArrayList<Post>();


    public void add(Post addObj) {
        if(addObj != null && addObj.title != null) {
            addObj.id = java.util.UUID.randomUUID().toString();
            posts.add(addObj);
        }
    }

    public List<Post> getAll() {
        return posts;
    }

    public void deleteById(String id) {
        if(posts.isEmpty()) {
            System.out.println("Empty List");
        }
        else {
            Iterator<Post> postsIterator = posts.iterator();
            while (postsIterator.hasNext()) {
                Post currentElement = postsIterator.next();
                if(currentElement.id == id) {
                    System.out.println("Deleting posts: ");
                    System.out.println(currentElement);
                    postsIterator.remove();
                }
            }
        }
    }

    public void printAll(List<Post> posts) {
        for(Post data : posts) {
            System.out.println("Post data object: ");
            System.out.println("\t * ID: '" + data.id + "',  ");
            System.out.println("\t * Title: '" + data.title + "',  ");
            System.out.println("\t * Category: '" + data.category + "',  ");
            System.out.println("\t * Description: '" + data.description + "',  ");
            System.out.println("\t * Author: '" + data.author + "',  ");
            System.out.println("\t * Date: '" + data.date + "',  ");
            System.out.println("\t * Content: '" + data.content + "',  ");
            System.out.println("\t * Keywords: '" + data.keywords + "',  ");
            System.out.println("\t * Claps: '" + data.claps + "',  \n");
        }
    }

    public List<Post> getPostsByClaps(int count) {
        List<Post> postsListByClaps = new ArrayList<Post>();

        postsListByClaps = posts.stream()
                .filter(p -> p.claps >= count)
                .collect(Collectors.toList());

        /*for(Post data : posts) {
            if(data.claps > count) {
                postsListByClaps.add(data);
            }
        }*/
        return postsListByClaps;
    }

    public List<Post> getPostsByCategory(String category) {
        List<Post> postsListByClaps = new ArrayList<Post>();
        for(Post data : posts) {
            if(data.category.equals(category)) {
                postsListByClaps.add(data);
            }
        }
        return postsListByClaps;
    }

    public HashMap<Integer, String> getPostsListByUniqueClaps() {
        HashMap<Integer, String> UniqueClapMap = new HashMap<Integer, String>();

        for(Post data: posts) {
            if(UniqueClapMap.containsKey(data.claps)) {
                UniqueClapMap.put(data.claps, UniqueClapMap.get(data.claps) + ", " + data.title);
            }
            else {
                UniqueClapMap.put(data.claps, data.title);
            }
        }
        return UniqueClapMap;
    }

    public HashMap<String, List> getPostsListByUniqueCategory() {
        HashMap<String, List> UniqueCategoryMap = new HashMap<String, List>();

        for(Post data: posts) {
            List<Post> listByCategory = new ArrayList<Post>();

            if(UniqueCategoryMap.containsKey(data.category)) {
                listByCategory = UniqueCategoryMap.get(data.category);

            }
            listByCategory.add(data);
            UniqueCategoryMap.put(data.category, listByCategory);
        }
        return UniqueCategoryMap;
    }
}
