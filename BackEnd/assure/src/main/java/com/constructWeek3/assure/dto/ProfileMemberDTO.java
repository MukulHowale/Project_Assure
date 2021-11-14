package com.constructWeek3.assure.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileMemberDTO {

    private Long member_id;
    private String name;
    private String relation_with_user;
    private String mobile;

}
