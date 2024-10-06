package sv.edu.ufg.happyfriends.happyfriends.entityConverters;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseConverter {
    private String idRecord;
    private String postResponse;

    public PostResponseConverter(String idRecord, String postResponse) {
        this.idRecord = idRecord;
        this.postResponse = postResponse;
    }
}
