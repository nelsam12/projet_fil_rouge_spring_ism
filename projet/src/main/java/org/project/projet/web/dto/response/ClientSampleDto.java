package org.project.projet.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientSampleDto {
    private String firstName;
    private String lastName;
    private String phone;
}
