package poc.entity;

import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.annotations.Column;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * melk01
 */
@Table(value = "COMMIT")
public class Commit implements Serializable {

    @PrimaryKeyColumn(name = "ID",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUIDs.timeBased();
    @Column(name = "AUTHER")
    private String auther;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "DATE")
    private Date date;

    public UUID getId() {
        return id;
    }

    public String getAuther() {
        return auther;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id=" + id +
                ", auther='" + auther + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commit commit = (Commit) o;

        if (!id.equals(commit.id)) return false;
        if (!auther.equals(commit.auther)) return false;
        if (!message.equals(commit.message)) return false;
        return date.equals(commit.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + auther.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
