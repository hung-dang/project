package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "home")
public class Home extends BaseEntitiess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homeId",nullable = false)
    private Integer homeId;

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }
}
