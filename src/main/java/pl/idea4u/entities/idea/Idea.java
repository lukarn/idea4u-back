package pl.idea4u.entities.idea;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "idea")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(insertable = false)
//    private String available;

    //insertable = false, updatable = false
    //@Column(columnDefinition = "integer default 1") <- ni dziala!!!
    @NonNull
    private int category;

    @NonNull
    private String description;

    @Column(insertable = false)
    private int rank;

    @Column(insertable = false)
    private String rank_up;

    @Column(insertable = false)
    private String rank_down;
}
