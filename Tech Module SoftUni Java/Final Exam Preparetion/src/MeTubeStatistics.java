import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Integer> meTube = new LinkedHashMap<>();
        Map<String, Integer> likesDislikes = new LinkedHashMap<>();

        while (!"stats time".equals(input = scanner.nextLine())) {
            if (input.contains("-")) {
                String[] data = input.split("-");
                String video = data[0];
                int views = Integer.parseInt(data[1]);

                if (!meTube.containsKey(video)) {
                    meTube.put(video, views);
                    likesDislikes.put(video, 0);
                } else {
                    meTube.put(video, meTube.get(video) + views);
                }

            } else if (input.contains(":")) {
                String[] emotion = input.split(":");
                String disOrLike = emotion[0];
                String video = emotion[1];

                if (disOrLike.equals("like")) {
                    if (meTube.containsKey(video)) {
                        likesDislikes.put(video, likesDislikes.get(video) + 1);
                    }
                } else if (disOrLike.equals("dislike")) {
                    if (meTube.containsKey(video)) {
                        likesDislikes.put(video, likesDislikes.get(video) - 1);
                    }
                }
            }

        }
        String sort = scanner.nextLine();


        if (sort.equals("by views")) {

            meTube.entrySet().stream()
                    .sorted((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()))
                    .forEach(video ->
                        System.out.println(String.format("%s - %d views - %d likes",video.getKey(), video.getValue()
                        ,(likesDislikes.get(video.getKey())))));



        } else if (sort.equals("by likes")) {

            likesDislikes.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(clip -> {
                        System.out.println(String.format("%s - %d views - %d likes"
                        ,clip.getKey(), (meTube.get(clip.getKey())), clip.getValue()));
                    });



        }

    }
}
