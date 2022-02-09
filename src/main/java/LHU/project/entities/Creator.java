package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "creator")
public class Creator {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "creatorId",nullable = false)
private Integer creatorId;

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}
