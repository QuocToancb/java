package practice.grap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "entity")
public class EntityObject {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="val1")
    private String val1;

    @OneToMany(mappedBy = "entityObject", fetch = FetchType.EAGER)
    List<EntitySubObject> entitySubObjects;

    public List<EntitySubObject> getEntitySubObjects() {
        return entitySubObjects;
    }

    public void setEntitySubObjects(List<EntitySubObject> entitySubObjects) {
        this.entitySubObjects = entitySubObjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }
}
