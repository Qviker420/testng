import org.testng.annotations.Factory;

public class factoryRunner {
    @Factory
    public Object[] factory()
    {
        return new Object[] {new factoryTest("Name 1", "LN1", 1, "111@gmail.com", "1111111"),
                new factoryTest("Name 2", "LN2", 0, "222@gmail.com", "2222222"),
                new factoryTest("Name 3", "LN3", 2, "333@gmail.com", "33333333")};
    }
}
