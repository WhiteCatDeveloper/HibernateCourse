package hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }
}
