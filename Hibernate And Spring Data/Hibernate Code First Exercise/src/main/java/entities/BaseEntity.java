package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
}
