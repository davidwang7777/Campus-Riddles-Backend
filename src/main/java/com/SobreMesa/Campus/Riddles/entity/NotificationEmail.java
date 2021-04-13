package com.SobreMesa.Campus.Riddles.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationEmail {
    private String subject;
    private String recipient;
    private String body;
}
