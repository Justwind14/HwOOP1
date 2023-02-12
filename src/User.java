public class User {
    int credit = 100;
    String name;
    Auto mod;
    public Integer bet;

    public User(String name) {
        this.name = name;
    }

    public void Choise(Auto mod) {
        this.mod = mod;
    }

    public int getCredit() {
        return credit;
    }

    public int setCredit(Integer credit)
    {
        this.credit += credit;
        return credit;
    }
}
