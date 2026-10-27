package ch.zli.m223.dto;

import java.time.LocalDateTime;

import ch.zli.m223.model.Entry;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

public class EntryDto {

    @NotNull(message = "Check-In ist ein Pflichtfeld")
    private LocalDateTime checkIn;

    @NotNull(message = "Check-Out ist ein Pflichtfeld")
    private LocalDateTime checkOut;

    @AssertTrue(message = "Check-In muss vor dem Check-Out sein")
    public boolean isCheckInBeforeCheckOut() {
        if (checkIn == null || checkOut == null) {
            return true;
        }
        return checkIn.isBefore(checkOut);
    }

    public Entry toEntity() {
        Entry entry = new Entry();
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);
        return entry;
    }

    public LocalDateTime getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDateTime checkIn) { this.checkIn = checkIn; }

    public LocalDateTime getCheckOut() { return checkOut; }
    public void setCheckOut(LocalDateTime checkOut) { this.checkOut = checkOut; }
}