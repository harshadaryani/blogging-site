import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.geometry.Pos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        PostService postService = new PostService();

        System.out.println("************************************");
        System.out.println("Adding 4 posts");

        // Pass data to add new Post
        postService.add(new Post("The most important skill a programmer can learn",
                "development",
                "Knowing when not to code is possibly the most important skill a programmer can learn.",
                "Harsha", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime, \n" +
                        "\t you will have to deal with different kinds of code requests. \n" +
                        "\t Each request will force you to make difficult decisions. \n" +
                        "\t That all is OKAY. Nothing wrong with that. \n" +
                        "\t This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "\t However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Programming", "Productivity"},
                10));

        postService.add(new Post("Learn clean code in 20ish mins",
                "development",
                "Knowing when not to code is possibly the most important skill a programmer can learn.",
                "Harsha",
                "24/5/19",
                "As a programmer, writing code is the biggest part of your job." + "/\n" +
                        "\t In your programming lifetime, you will have to deal with different kinds of code requests. \n" +
                        "\t Each request will force you to make difficult decisions. That all is OKAY. \n" +
                        "\t Nothing wrong with that. This is what everyone expects from you, as a programmer: Writing code. " +
                        "\t However, here is a question: Should you write all the code that is requested from you?", new String[]{"Programming", "Productivity"}, 10));


        postService.add(new Post("I Have 15 ideas To Change Your Life. Do you Have 5 Minutes?",
                "Life",
                "I’m the last person to say that life is easy.",
                "Darius Foroux", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime, \n" +
                        "\t you will have to deal with different kinds of code requests. \n" +
                        "\t Each request will force you to make difficult decisions. \n" +
                        "\t That all is OKAY. Nothing wrong with that. \n" +
                        "\t This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "\t However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Life goals", "Lifestyle"},
                17));

        postService.add(new Post("How White People Handle Diversity Training in the Workplace",
                "Office",
                "Confronted with their own shortcomings, white employees often shut down the dialogue—or frame themselves as victims",
                "Robin DiAngelo", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime,\n" +
                        "\t you will have to deal with different kinds of code requests. \n" +
                        "\t Each request will force you to make difficult decisions. \n" +
                        "\t That all is OKAY. Nothing wrong with that. \n" +
                        "\t This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "\t However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Office", "Productivity"},
                20));

        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts");
        postService.printAll(postService.getAll());
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Delete Post by ID");
        Post deletePost = postService.getAll().get(0);
        postService.deleteById(deletePost.id);
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("After delete");
        postService.printAll(postService.getAll());
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Again add deleted post");
        postService.add(deletePost);
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts with claps equal to or greater than 15");
        postService.printAll(postService.getPostsByClaps(15));
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts with cateory equal to Office");
        postService.printAll(postService.getPostsByCategory("Office"));
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying claps vs posts with same no. of claps");
        HashMap<Integer, String> uniqueClapsposts = new HashMap<Integer, String>();
        uniqueClapsposts = postService.getPostsListByUniqueClaps();
        for(HashMap.Entry<Integer, String> entry: uniqueClapsposts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println("************************************");

        System.out.println("************************************");
        System.out.println("Displaying category vs posts with same category");
        HashMap<String, List> uniqueCategoryPosts = new HashMap<String, List>();
        uniqueCategoryPosts = postService.getPostsListByUniqueCategory();
        for(HashMap.Entry<String, List> entry: uniqueCategoryPosts.entrySet()) {
            System.out.println(entry.getKey() + ": " );
            postService.printAll(entry.getValue());
        }
        System.out.println();
        System.out.println("************************************");

        List<Post> postListCsv = postService.getAll();


        /*FileWriter writer = new FileWriter("new.csv");

        List<List<String>> rows = Arrays.asList(
                Arrays.asList("Jean", "author", "Java"),
                Arrays.asList("David", "editor", "Python"),
                Arrays.asList("Scott", "editor", "Node.js")
        );




        System.out.println(rows);

        FileWriter csvWriter = new FileWriter("new.csv");
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Role");
        csvWriter.append(",");
        csvWriter.append("Topic");
        csvWriter.append("\n");

        for (List<String> data : rows) {
            csvWriter.append(String.join(",", data));
            csvWriter.append("\n");
        }



        csvWriter.flush();
        csvWriter.close();*/

        FileWriter writer = new FileWriter("new.csv");
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Post.class);
        String[] columns = new String[] { "title", "category", "descripton", "author", "date", "content", "keywords", "claps" };
        mappingStrategy.setColumnMapping(columns);

        StatefulBeanToCsvBuilder<Post> builder = new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

        // Write list to StatefulBeanToCsv object
        System.out.println("post object csv");
        System.out.println(postListCsv);
        beanWriter.write(postListCsv);

        writer.close();

    }
}
