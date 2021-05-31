package arsensaliev.io.nasaapp.mvp.model.entity

import arsensaliev.io.nasaapp.BuildConfig
import com.google.gson.annotations.SerializedName
import java.util.*


class EarthImages : ArrayList<EarthImages.EarthImageItem>() {
    data class EarthImageItem(
        @SerializedName("attitude_quaternions")
        val attitudeQuaternions: AttitudeQuaternions,
        @SerializedName("caption")
        val caption: String,
        @SerializedName("centroid_coordinates")
        val centroidCoordinates: CentroidCoordinates,
        @SerializedName("coords")
        val coords: Coords,
        @SerializedName("date")
        val date: String,
        @SerializedName("dscovr_j2000_position")
        val dscovrJ2000Position: DscovrJ2000Position,
        @SerializedName("identifier")
        val identifier: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("lunar_j2000_position")
        val lunarJ2000Position: LunarJ2000Position,
        @SerializedName("sun_j2000_position")
        val sunJ2000Position: SunJ2000Position,
        @SerializedName("version")
        val version: String
    ) {
        val dateYYMMDD: String
            get() = date.substring(0, 10).replace("-", "/")

        val fullImagePath: String
            get() = "${BuildConfig.BASE_API_URL}EPIC/archive/natural/$dateYYMMDD/png/$image.png?api_key=${BuildConfig.NASA_API_KEY}"

        data class AttitudeQuaternions(
            @SerializedName("q0")
            val q0: Double,
            @SerializedName("q1")
            val q1: Double,
            @SerializedName("q2")
            val q2: Double,
            @SerializedName("q3")
            val q3: Double
        )

        data class CentroidCoordinates(
            @SerializedName("lat")
            val lat: Double,
            @SerializedName("lon")
            val lon: Double
        )

        data class Coords(
            @SerializedName("attitude_quaternions")
            val attitudeQuaternions: AttitudeQuaternions,
            @SerializedName("centroid_coordinates")
            val centroidCoordinates: CentroidCoordinates,
            @SerializedName("dscovr_j2000_position")
            val dscovrJ2000Position: DscovrJ2000Position,
            @SerializedName("lunar_j2000_position")
            val lunarJ2000Position: LunarJ2000Position,
            @SerializedName("sun_j2000_position")
            val sunJ2000Position: SunJ2000Position
        ) {
            data class AttitudeQuaternions(
                @SerializedName("q0")
                val q0: Double,
                @SerializedName("q1")
                val q1: Double,
                @SerializedName("q2")
                val q2: Double,
                @SerializedName("q3")
                val q3: Double
            )

            data class CentroidCoordinates(
                @SerializedName("lat")
                val lat: Double,
                @SerializedName("lon")
                val lon: Double
            )

            data class DscovrJ2000Position(
                @SerializedName("x")
                val x: Double,
                @SerializedName("y")
                val y: Double,
                @SerializedName("z")
                val z: Double
            )

            data class LunarJ2000Position(
                @SerializedName("x")
                val x: Double,
                @SerializedName("y")
                val y: Double,
                @SerializedName("z")
                val z: Double
            )

            data class SunJ2000Position(
                @SerializedName("x")
                val x: Double,
                @SerializedName("y")
                val y: Double,
                @SerializedName("z")
                val z: Double
            )
        }

        data class DscovrJ2000Position(
            @SerializedName("x")
            val x: Double,
            @SerializedName("y")
            val y: Double,
            @SerializedName("z")
            val z: Double
        )

        data class LunarJ2000Position(
            @SerializedName("x")
            val x: Double,
            @SerializedName("y")
            val y: Double,
            @SerializedName("z")
            val z: Double
        )

        data class SunJ2000Position(
            @SerializedName("x")
            val x: Double,
            @SerializedName("y")
            val y: Double,
            @SerializedName("z")
            val z: Double
        )
    }
}