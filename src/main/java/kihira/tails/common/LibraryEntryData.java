package kihira.tails.common;

import com.google.gson.annotations.Expose;

import java.util.Calendar;
import java.util.UUID;

public class LibraryEntryData {
    @Expose public PartsData partsData;
    @Expose public String entryName = "";
    @Expose public String comment = "";
    @Expose public UUID creatorUUID;
    @Expose public boolean favourite;
    @Expose public long creationDate;
    public boolean remoteEntry = false;

    public LibraryEntryData(UUID creatorUUID, String name, PartsData partsData) {
        this(name, partsData);
        this.creatorUUID = creatorUUID;
    }

    public LibraryEntryData(String name, PartsData partsData) {
        this.entryName = name;
        this.partsData = partsData;
        this.creationDate = Calendar.getInstance().getTimeInMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryEntryData data = (LibraryEntryData) o;

        if (creationDate != data.creationDate) return false;
        if (favourite != data.favourite) return false;
        if (comment != null ? !comment.equals(data.comment) : data.comment != null) return false;
        if (!creatorUUID.equals(data.creatorUUID)) return false;
        if (entryName != null ? !entryName.equals(data.entryName) : data.entryName != null) return false;
        if (partsData != null ? !partsData.equals(data.partsData) : data.partsData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partsData != null ? partsData.hashCode() : 0;
        result = 31 * result + (entryName != null ? entryName.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + creatorUUID.hashCode();
        result = 31 * result + (favourite ? 1 : 0);
        result = 31 * result + (int) (creationDate ^ (creationDate >>> 32));
        return result;
    }
}