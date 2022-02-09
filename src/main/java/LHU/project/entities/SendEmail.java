package LHU.project.entities;

import lombok.Data;

@Data
public class SendEmail {
    private String subject;
    private String text;
    private String nameEmail;
}
