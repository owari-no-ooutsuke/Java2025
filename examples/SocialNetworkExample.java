class SocialNetwork {
     private String user;

     public SocialNetwork(String user) {
         this.user = user;
     }

    //Выложить пост с тегами
    public void createPost(String content, String... tags) {
        System.out.println(user + " создает пост: " + content);
        if (tags.length > 0) {
            System.out.println("  Теги: " + String.join(", ", tags));
        }
    }

    //Выложить пост с тегами и упоминаниями пользователей
    public void createPost(String content, String[] mentions, String... tags) {
        System.out.println(user + " создает пост: " + content);
        if (mentions.length > 0) {
            System.out.println("  Упоминания: " + String.join(", ", mentions));
        }
        if (tags.length > 0) {
            System.out.println("  Теги: " + String.join(", ", tags));
        }
    }
}

public class SocialNetworkExample {
    public static void main(String[] args) {
        SocialNetwork social = new SocialNetwork("@owari-no-ooutsuke");

        //Вызываем createPost(String content, String... tags)
        social.createPost("hello!", "programming", "java");
        String[] mentions = {"@spbstu", "@someone-else"};

        //Вызываем createPost(String content, String[] mentions, String... tags)
        social.createPost("what's up?", mentions,"programming", "java");
    }
}
