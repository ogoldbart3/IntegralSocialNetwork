import model.User;
import model.Yell;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class MyTest {

    @Test
    public void name() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HelloWorld.print(new PrintStream(out));
        String s = out.toString();
        Assert.assertEquals("Hello, World!", s);
    }

    @Test
    public void publishingTest() throws Exception {
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
        bob.postYell("Good game though.");

        List<Yell> bobTimeline = alice.getTimelineByUser(bob);
        Assert.assertEquals(bobTimeline.size(), 2);
        Assert.assertEquals(bobTimeline.get(0).getStatement(), "Darn! We lost!");
        Assert.assertEquals(bobTimeline.get(1).getStatement(), "Good game though.");
    }

    @Test
    public void followingTest() throws Exception {
        User alice = new User("Alice");
        alice.postYell("I love the weather today.");

        User bob = new User("Bob");
        bob.postYell("Darn! We lost!");
        bob.postYell("Good game though.");

//        User charlie = new User("Charlie ");
//        charlie.postYell("I'm in New York today! Anyone wants to have a coffee?");
//        charlie.postYell("Good game though.");
//
//        User bob = new User("Bob");
//        bob.postYell("Darn! We lost!");
//
//        List<Yell> bobTimeline = alice.getTimelineByUser(bob);
//        Assert.assertEquals(bobTimeline.size(), 2);
//        Assert.assertEquals(bobTimeline.get(0).getStatement(), "Darn! We lost!");
//        Assert.assertEquals(bobTimeline.get(1).getStatement(), "Good game though.");
    }
}
