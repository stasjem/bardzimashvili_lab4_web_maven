package bardzimashvili.ejb;

public class UsersEJB implements UserEJBRemote
{
    private String name;
    private String tag;

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
