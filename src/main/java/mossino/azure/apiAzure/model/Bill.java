package mossino.azure.apiAzure.model;

import java.time.LocalDateTime;

public record Bill(
        Integer id,
        String Name,
        String Number,
        Status status,
        Type contentType,
        LocalDateTime dataCreated,
        LocalDateTime dataUpdate,
        Integer Ammount
){

}
