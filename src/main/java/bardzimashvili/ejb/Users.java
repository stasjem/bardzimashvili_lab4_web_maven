package bardzimashvili.ejb;

public class Users
{
    private String name;
    private String tag;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }



    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Users{" +
            "name='" + name + '\'' +
            ", tag='" + tag + '\'' +
            '}';
    }
}
