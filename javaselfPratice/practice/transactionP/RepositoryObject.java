package practice.transactionP;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryObject extends JpaRepository<EntityObject, Long>  {
}
