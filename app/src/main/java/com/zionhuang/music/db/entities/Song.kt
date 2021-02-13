package com.zionhuang.music.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Relation
import com.zionhuang.music.download.DownloadTask.Companion.STATE_NOT_DOWNLOADED
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Song(
        val id: String,
        var title: String? = null,
        private var artistId: Int = 0,
        @Relation(entity = ArtistEntity::class, parentColumn = "artistId", entityColumn = "id", projection = ["name"])
        var artistName: String = "",
        var channelId: String = "",
        @Relation(entity = ChannelEntity::class, parentColumn = "channelId", entityColumn = "id", projection = ["name"])
        var channelName: String = "",
        var duration: Int = 0, // in seconds
        var liked: Boolean = false,
        @ColumnInfo(name = "download_state") var downloadState: Int = STATE_NOT_DOWNLOADED,
        @ColumnInfo(name = "create_date") var createDate: Date = Date(),
        @ColumnInfo(name = "modify_date") var modifyDate: Date = Date(),
) : Parcelable