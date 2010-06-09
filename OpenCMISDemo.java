import java.util.HashMap;
import java.util.Map;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

public class OpenCMISDemo {
	public static void main() {
		// Default factory implementation of client runtime.
		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
		Map<String, String> parameter = new HashMap<String, String>();

		// User credentials.
		parameter.put(SessionParameter.USER, "admin");
		parameter.put(SessionParameter.PASSWORD, "admin");

		// Connection settings.
		parameter.put(SessionParameter.ATOMPUB_URL, "http://localhost:8080/alfresco/service/cmis");
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		
		// Create session.
		Repository repository = sessionFactory.getRepositories(parameter).get(0);
		Session session = repository.createSession();
		
		// List the root folder.
		Folder folder = session.getRootFolder();
		for (CmisObject object : folder.getChildren()) {
			  System.out.println(object.getName());
		}
	}
}
