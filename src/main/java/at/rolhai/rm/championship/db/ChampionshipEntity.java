package at.rolhai.rm.championship.db;

import at.rolhai.rm.core.season.db.SeasonEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "championships")
public class ChampionshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seasonId", foreignKey=@ForeignKey(name="fk_championship_seasonId"), nullable = false)
    private SeasonEntity season;

    @OneToMany(mappedBy = "championship", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ChampionshipEventEntity> events;

    @OneToMany(mappedBy = "championship", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<ChampionshipTeamEntity> teams;
}
