/* Mula */

package org.mula.finance.sync;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.mula.finance.core.database.Column;
import org.mula.finance.core.database.Table;

@Table(name = "Events")
public class Event
{
    @Nullable
    @Column
    public Long id;

    @NonNull
    @Column(name = "timestamp")
    public Long timestamp;

    @NonNull
    @Column(name = "message")
    public String message;

    @NonNull
    @Column(name = "server_id")
    public String serverId;

    public Event()
    {
        timestamp = 0L;
        message = "";
        serverId = "";
    }

    public Event(@NonNull String serverId, long timestamp, @NonNull String message)
    {
        this.serverId = serverId;
        this.timestamp = timestamp;
        this.message = message;
    }
}
