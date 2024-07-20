package com.latihan.valorantapp.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AgentModel(
    @SerialName("data")
    val data: List<Data?>,
    @SerialName("status")
    val status: Int?
) {
    @Serializable
    data class Data(
        @SerialName("abilities")
        val abilities: List<Ability?>?,
        @SerialName("assetPath")
        val assetPath: String?,
        @SerialName("background")
        val background: String?,
        @SerialName("backgroundGradientColors")
        val backgroundGradientColors: List<String?>?,
        @SerialName("bustPortrait")
        val bustPortrait: String?,
        @SerialName("characterTags")
        val characterTags: Any?,
        @SerialName("description")
        val description: String?,
        @SerialName("developerName")
        val developerName: String?,
        @SerialName("displayIcon")
        val displayIcon: String?,
        @SerialName("displayIconSmall")
        val displayIconSmall: String?,
        @SerialName("displayName")
        val displayName: String?,
        @SerialName("fullPortrait")
        val fullPortrait: String?,
        @SerialName("fullPortraitV2")
        val fullPortraitV2: String?,
        @SerialName("isAvailableForTest")
        val isAvailableForTest: Boolean?,
        @SerialName("isBaseContent")
        val isBaseContent: Boolean?,
        @SerialName("isFullPortraitRightFacing")
        val isFullPortraitRightFacing: Boolean?,
        @SerialName("isPlayableCharacter")
        val isPlayableCharacter: Boolean?,
        @SerialName("killfeedPortrait")
        val killfeedPortrait: String?,
        @SerialName("recruitmentData")
        val recruitmentData: Any?,
        @SerialName("role")
        val role: Role?,
        @SerialName("uuid")
        val uuid: String?,
        @SerialName("voiceLine")
        val voiceLine: Any?
    ) {
        @Serializable
        data class Ability(
            @SerialName("description")
            val description: String?,
            @SerialName("displayIcon")
            val displayIcon: String?,
            @SerialName("displayName")
            val displayName: String?,
            @SerialName("slot")
            val slot: String?
        )

        @Serializable
        data class Role(
            @SerialName("assetPath")
            val assetPath: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("displayIcon")
            val displayIcon: String?,
            @SerialName("displayName")
            val displayName: String?,
            @SerialName("uuid")
            val uuid: String?
        )
    }
}