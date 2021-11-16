package practice.transactionP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceObject {
	@Autowired
	private RepositoryObject repositoryObject;

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAuthorName(Long id, String name) {
		System.out.println("REQUIRED");
		EntityObject author = repositoryObject.findById(id).get();
		author.setVal1(name + System.currentTimeMillis());

		repositoryObject.save(author);
		repositoryObject.save(author);
	}

	@Transactional
	public void createTransaction(Long id, String name) {
//		propagationSupport(id, name);
//		propagationMandatory(id, name);
//		propagationNEVER(id, name);
		propagationNOT_SUPPORTED(id, name);
		throw new RuntimeException("no way");
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void propagationSupport(Long id, String name) {
		System.out.println("SUPPORTS");
		EntityObject author = repositoryObject.findById(id).get();
		author.setVal1(name + System.currentTimeMillis());

//		repositoryObject.save(author);

		author.setVal1("222222222");
//		repositoryObject.save(author);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void propagationMandatory(Long id, String name) {
		System.out.println("MANDATORY");
		EntityObject author = repositoryObject.findById(id).get();
		author.setVal1(name + System.currentTimeMillis());
		author.setVal1("33333333");
	}

	@Transactional(propagation = Propagation.NEVER)
	public void propagationNEVER(Long id, String name) {
		System.out.println("NEVER");
		EntityObject author = repositoryObject.findById(4l).get();
		author.setVal1(name + System.currentTimeMillis());
		author.setVal1("33333333");
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void propagationNOT_SUPPORTED(Long id, String name) {
		System.out.println("NOT_SUPPORTED");
		EntityObject author = repositoryObject.findById(4l).get();
		author.setVal1(name + System.currentTimeMillis());
		author.setVal1("vvvvvvvvvvv");
		repositoryObject.save(author);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void propagationREQUIRES_NEW(Long id, String name) {
		System.out.println("REQUIRES_NEW");
		EntityObject author = repositoryObject.findById(4l).get();
		author.setVal1(name + System.currentTimeMillis());
		author.setVal1("3232323232323232");
//		repositoryObject.save(author);
	}
}
