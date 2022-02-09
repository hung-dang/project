package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ModelOverview")
public class ModelOverview extends BaseEntitiess{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelId",nullable = false)
    private Integer modelId;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
