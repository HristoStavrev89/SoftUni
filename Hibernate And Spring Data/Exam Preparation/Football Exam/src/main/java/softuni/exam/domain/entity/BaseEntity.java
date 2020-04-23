package softuni.exam.domain.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
