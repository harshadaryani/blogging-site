public class Main {

    public static void main(String[] args) {
        Post post = new Post("The most important skill a programmer can learn",
                "development",
                "Knowing when not to code is possibly the most important skill a programmer can learn.",
                "Harsha",
                "24/5/19",
                "As a programmer, writing code is the biggest part of your job." + "/\n" +
                        "In your programming lifetime, you will have to deal with different kinds of code requests. \n" +
                        "Each request will force you to make difficult decisions. That all is OKAY. \n" +
                        "Nothing wrong with that. This is what everyone expects from you, as a programmer: Writing code. " +
                        "However, here is a question: Should you write all the code that is requested from you?", new String[]{"Programming", "Productivity"}, 10);

        PostService postService = new PostService();

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
        //System.out.println(postService.getAll().toString());

        //System.out.println(postService.getPostsByClaps(15).toString());
        System.out.println(postService.getPostsByCategory("Office").toString());


    }
}
