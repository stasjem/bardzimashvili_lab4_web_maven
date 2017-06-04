package bardzimashvili.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

public interface UsersHome extends EJBHome
{
    String create() throws CreateException, RemoteException;
}
