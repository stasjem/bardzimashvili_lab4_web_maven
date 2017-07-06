package bardzimashvili.ejb;

import javax.ejb.*;
import java.rmi.RemoteException;

public class UsersEJB implements UsersHome
{
    @Override
    public Users create() throws CreateException, RemoteException
    {
        return null;
    }

    @Override
    public Users findUser() throws FinderException, RemoteException
    {
        return null;
    }

    @Override
    public String findByPrimaryKey(String primaryKey) throws RemoteException, FinderException
    {
        return null;
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
