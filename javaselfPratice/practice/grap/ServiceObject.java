package practice.grap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceObject {
	@Autowired
	private RepositoryObject repositoryObject;

	@Transactional
	public void getData() {
		List<EntityObject> all = repositoryObject.findAll();

		customRunable runnable = new customRunable(all);

		Thread thread = new Thread(runnable);
		thread.start();
	}
}

class customRunable implements Runnable {
	List<EntityObject> all;

	public customRunable(List<EntityObject> all) {
		this.all = all;
	}

	@Override
	public void run() {
		all.forEach(e -> {
			System.out.println("-------");
			e.getEntitySubObjects().forEach(e2 -> {
			});
		});
	}
}
