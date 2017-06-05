package bardzimashvili.ejb;

import javax.ejb.*;
import java.rmi.RemoteException;

public class UsersEJB implements UsersHome
{
    private int id;
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public void createUser() throws CreateException, RemoteException
    {
    }

    @Override
    public void findUser() throws FinderException, RemoteException
    {
    }

    @Override
    public String findByPrimaryKey(String primaryKey) throws RemoteException, FinderException
    {
        return primaryKey;
    }

    @Override
    public void remove(Handle handle) throws RemoteException, RemoveException
    {

    }

    @Override
    public void remove(Object o) throws RemoteException, RemoveException
    {

    }

    @Override
    public EJBMetaData getEJBMetaData() throws RemoteException
    {
        return null;
    }

    @Override
    public HomeHandle getHomeHandle() throws RemoteException
    {
        return null;
    }
}
