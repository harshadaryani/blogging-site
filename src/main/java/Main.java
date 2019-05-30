public class Main {

    public static void main(String[] args) {
        Post post = new Post("The most important skill a programmer can learn", "Knowing when not to code is possibly the most important skill a programmer can learn.", "Harsha", "24/5/19", "As a programmer, writing code is the biggest part of your job. In your programming lifetime, you will have to deal with different kinds of code requests. Each request will force you to make difficult decisions. That all is OKAY. Nothing wrong with that. This is what everyone expects from you, as a programmer: Writing code. However, here is a question: Should you write all the code that is requested from you?",    new String[]{"Programming", "Productivity"}, 10);
        System.out.println(post.toString());

        PostService postService = new PostService();
        postService.add((["The most important skill a programmer can learn", "Knowing when not to code is possibly the most important skill a programmer can learn.", "Harsha", "24/5/19", "As a programmer, writing code is the biggest part of your job. In your programming lifetime, you will have to deal with different kinds of code requests. Each request will force you to make difficult decisions. That all is OKAY. Nothing wrong with that. This is what everyone expects from you, as a programmer: Writing code. However, here is a question: Should you write all the code that is requested from you?",    new String[]{"Programming", "Productivity"}, 10]));
    }
}
