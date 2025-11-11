package unit1.custom_list_view.task1

import android.os.Parcel
import android.os.Parcelable


data class PlayerModel(
    val name: String,
    val rank: String,
    val nationalAnthem: Int,
    val imageResId: Int,
    val info: String,
    val rating: Float
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(rank)
        parcel.writeInt(nationalAnthem)
        parcel.writeInt(imageResId)
        parcel.writeString(info)
        parcel.writeFloat(rating)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<PlayerModel> {
        override fun createFromParcel(parcel: Parcel): PlayerModel {
            return PlayerModel(parcel)
        }

        override fun newArray(size: Int): Array<PlayerModel?> {
            return arrayOfNulls(size)
        }
    }
}