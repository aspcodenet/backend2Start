package se.systementor.backend2start.events;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.time.LocalDateTime;

public class RoomCleaningFinished extends EventBase {
    public String RoomNo;
    public String CleaningByUser;
}
