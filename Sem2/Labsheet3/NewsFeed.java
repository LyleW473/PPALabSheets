import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application.
 * 
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class NewsFeed
{
    private ArrayList<Post> posts;

    public static void main(String[] args) {

        String author = "Lyle";
        NewsFeed newsFeed1 = new NewsFeed();

        EventPost eventPost1 = new EventPost(author);
        eventPost1.addComment("Hi " + author);
        eventPost1.display();
        eventPost1.like();
        eventPost1.like();
        eventPost1.unlike();
        eventPost1.display();
        eventPost1.addDescription("Lyle is Lyle.");
        System.out.println(eventPost1.getDescription());

        MessagePost messagePost1 = new MessagePost("Lyle", "Hi my name is " + author);
        messagePost1.addComment("Nice to meet you!");

        PhotoPost photoPost1 = new PhotoPost(author, "selfie.png", "Me");
        for (int i = 0; i < 3; i++)
        {
            photoPost1.like();
        }
        System.out.println(photoPost1.getCaption());
        System.out.println(photoPost1.getImageFile());
        System.out.println(photoPost1.getTimeStamp());

        newsFeed1.addPost(photoPost1);
        newsFeed1.addPost(messagePost1);
        newsFeed1.addPost(eventPost1);

        newsFeed1.show();

    }

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();
    }

    /**
     * Add a post to the news feed.
     * 
     * @param post  The post to be added.
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // display all posts
        for(Post post : posts) {
            post.display();
            System.out.println();   // empty line between posts
        }
    }
}
