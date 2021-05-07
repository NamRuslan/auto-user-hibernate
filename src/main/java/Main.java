import model.Auto;
import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();

        User user1 = new User("User1", 25);
        User user2 = new User("User2", 44);
        User user3 = new User("User3", 34);

        //Save user with no autos
        userService.save(user1);
        System.out.println("\nUser 1 raw: " + userService.findById(user1.getId()));

        Auto auto1 = new Auto("Ferrari", "Red");
        Auto auto2 = new Auto("Ford", "Black");
        Auto auto3 = new Auto("Lambo", "Yellow");
        Auto auto4 = new Auto("Mitsu", "White");
        Auto auto5 = new Auto("BMW", "Blue");
        Auto auto6 = new Auto("Audi", "Green");

        auto1.setUser(user1);
        auto2.setUser(user1);
        auto3.setUser(user2);
        auto4.setUser(user2);
        auto5.setUser(user2);
        auto6.setUser(user3);

        user1.addAuto(auto1);
        user1.addAuto(auto2);
        user2.addAuto(auto3);
        user2.addAuto(auto4);
        user2.addAuto(auto5);
        user3.addAuto(auto6);

        //updating user: adding autos
        userService.update(user1);
        System.out.println("\nUser 1 with autos: " + userService.findById(user1.getId()));

        userService.save(user2);
        userService.save(user3);

        System.out.println("\nAll users: ");
        for (User user : userService.getAll()) System.out.println(user);

        userService.delete(user3);

        System.out.println("\nDeleted user3: ");
        for (User user : userService.getAll()) System.out.println(user);

        System.out.println("\nFind user 2 by id: " + userService.findById(user2.getId()));

        System.out.println("\nFind auto 4 by id: " + userService.getAutoById(auto4.getId()));

        System.out.println("\nAll user2's autos: ");
        for (Auto auto : userService.getAllAutoByUserId(user2.getId())) System.out.println(auto);

    }
}
