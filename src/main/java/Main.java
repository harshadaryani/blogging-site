import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        PostService postService = new PostService();

        System.out.println("************************************");
        System.out.println("Adding 4 posts");

        // Pass data to add new Post
        postService.add(new Post("The most important skill a programmer can learn",
                "development",
                "Knowing when not to code is possibly the most important skill a programmer can learn.",
                "Harsha", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime, \n" +
                        " you will have to deal with different kinds of code requests. \n" +
                        "Each request will force you to make difficult decisions. \n" +
                        "That all is OKAY. Nothing wrong with that. \n" +
                        "This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Programming", "Productivity"},
                10));

        postService.add(new Post("Learn clean code in 20ish mins",
                "development",
                "Knowing when not to code is possibly the most important skill a programmer can learn.",
                "Harsha",
                "24/5/19",
                "As a programmer, writing code is the biggest part of your job." + "/\n" +
                        "In your programming lifetime, you will have to deal with different kinds of code requests. \n" +
                        "Each request will force you to make difficult decisions. That all is OKAY. \n" +
                        "Nothing wrong with that. This is what everyone expects from you, as a programmer: Writing code. " +
                        "However, here is a question: Should you write all the code that is requested from you?", new String[]{"Programming", "Productivity"}, 10));


        postService.add(new Post("I Have 15 ideas To Change Your Life. Do you Have 5 Minutes?",
                "Life",
                "I’m the last person to say that life is easy.",
                "Darius Foroux", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime, \n" +
                        " you will have to deal with different kinds of code requests. \n" +
                        "Each request will force you to make difficult decisions. \n" +
                        "That all is OKAY. Nothing wrong with that. \n" +
                        "This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Life goals", "Lifestyle"},
                17));

        postService.add(new Post("How White People Handle Diversity Training in the Workplace",
                "Office",
                "Confronted with their own shortcomings, white employees often shut down the dialogue—or frame themselves as victims",
                "Robin DiAngelo", "24/5/19",
                "As a programmer, writing code is the biggest part of your job. In your programming lifetime,\n" +
                        " you will have to deal with different kinds of code requests. \n" +
                        "Each request will force you to make difficult decisions. \n" +
                        "That all is OKAY. Nothing wrong with that. \n" +
                        "This is what everyone expects from you, as a programmer: Writing code. \n" +
                        "However, here is a question: Should you write all the code that is requested from you?",
                new String[]{"Office", "Productivity"},
                20));

        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts");
        System.out.println(postService.getAll().toString());
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts with claps equal to 15");
        System.out.println(postService.getPostsByClaps(15).toString());
        System.out.println("************************************");
        System.out.println("\n");

        System.out.println("************************************");
        System.out.println("Displaying all posts with cateory equal to Office");
        System.out.println(postService.getPostsByCategory("Office").toString());
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


    }
}
