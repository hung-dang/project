package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "BasicKnowledge")
public class BasicKnowledge extends BaseEntitiess{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basicId",nullable = false)
    private Integer basicId;

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }
}
