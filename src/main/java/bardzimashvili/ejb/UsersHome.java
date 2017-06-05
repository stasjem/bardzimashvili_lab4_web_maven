package bardzimashvili.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface UsersHome extends EJBHome
{
    public void createUser() throws CreateException, RemoteException;
    public void findUser() throws FinderException, RemoteException;
    public String findByPrimaryKey (String primaryKey) throws RemoteException, FinderException;

}
