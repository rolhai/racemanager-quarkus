package at.rolhai.rm.championship.db;

import at.rolhai.rm.core.event.db.EventEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "championship_events")
public class ChampionshipEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "championshipId", foreignKey=@ForeignKey(name="fk_championship_events_championshipId"), nullable = false)
    private ChampionshipEntity championship;

    @NotNull
    @OneToOne
    @JoinColumn(name = "eventId", foreignKey=@ForeignKey(name="fk_championship_events_eventId"), nullable = false)
    private EventEntity event;

    /**
     * order number of the event in a season
     *
     * example: 1
     */
    @NotNull
    private Integer orderNumber;
}
