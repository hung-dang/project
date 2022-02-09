package LHU.project.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "roles_id",nullable = false)
    private Integer rolesId;

    @Column(name = "roles_name",length = 50,nullable = false)
    private String rolesName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<AccountRoles> accountRoles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Roles roles = (Roles) o;
        return rolesId != null && Objects.equals(rolesId, roles.rolesId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
