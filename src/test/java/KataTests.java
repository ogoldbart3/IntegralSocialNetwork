import model.User;
import model.Yell;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class KataTests {

    @Test
    public void publishingTest() {
        User alice = new User("Alice");
        alice.postYell("I love the weather today.");

        Assert.assertEquals(alice.getPersonalTimeline().size(), 1);
        Assert.assertEquals(alice.getPersonalTimeline().get(0).getStatement(), "I love the weather today.");
    }

    @Test
    public void timelineTest() throws Exception {
        User alice = new User("Alice");

        User bob = new User("Bob");
        bob.postYell("Darn! We lost!");
        TimeUnit.SECONDS.sleep(1);
        bob.postYell("Good game though.");

        List<Yell> bobTimeline = alice.getTimelineByUser(bob);
        Assert.assertEquals(bobTimeline.size(), 2);
        Assert.assertEquals(bobTimeline.get(0).getStatement(), "Good game though.");
        Assert.assertEquals(bobTimeline.get(1).getStatement(), "Darn! We lost!");
    }

    @Test
    public void followingTest() throws Exception {
        User alice = new User("Alice");
        alice.postYell("I love the weather today.");
        TimeUnit.SECONDS.sleep(1);

        User bob = new User("Bob");
        bob.postYell("Damn! We lost!");
        TimeUnit.SECONDS.sleep(1);
        bob.postYell("Good game though.");
        TimeUnit.SECONDS.sleep(1);

        User charlie = new User("Charlie");
        charlie.postYell("I'm in New York today! Anyone wants to have a coffee?");
        TimeUnit.SECONDS.sleep(1);

        charlie.follow(alice);
        charlie.follow(bob);

        List<Yell> charlieFollowing = charlie.getTimelineAllFollowing();
        Assert.assertEquals(charlieFollowing.size(), 4);
        Assert.assertEquals(charlieFollowing.get(0).getCreatedBy(), "Charlie");
        Assert.assertEquals(charlieFollowing.get(0).getStatement(), "I'm in New York today! Anyone wants to have a coffee?");
        Assert.assertEquals(charlieFollowing.get(1).getCreatedBy(), "Bob");
        Assert.assertEquals(charlieFollowing.get(1).getStatement(), "Good game though.");
        Assert.assertEquals(charlieFollowing.get(2).getCreatedBy(), "Bob");
        Assert.assertEquals(charlieFollowing.get(2).getStatement(), "Damn! We lost!");
        Assert.assertEquals(charlieFollowing.get(3).getCreatedBy(), "Alice");
        Assert.assertEquals(charlieFollowing.get(3).getStatement(), "I love the weather today.");
    }
}
