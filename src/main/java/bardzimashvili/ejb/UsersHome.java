package bardzimashvili.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface UsersHome extends EJBHome
{
    Users create() throws CreateException, RemoteException;
    Users findUser() throws FinderException, RemoteException;
    String findByPrimaryKey (String primaryKey) throws RemoteException, FinderException;

}
