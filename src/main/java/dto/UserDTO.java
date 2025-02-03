package dto;

import com.tn.Entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String password;


    private Set<String> role;


}
