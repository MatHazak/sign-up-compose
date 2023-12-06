package me.mathazak.signupcompose.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private const val USER_INFO_PREFERENCES_NAME = "user_info_preferences"

private val Context.dataStore by preferencesDataStore(name = USER_INFO_PREFERENCES_NAME)

class SignupRepository(private val context: Context) {
    companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val FIRST_NAME = stringPreferencesKey("first_name")
        val LAST_NAME = stringPreferencesKey("last_name")
        val BIRTH_DATE = stringPreferencesKey("birth_date")
        val NATIONAL_ID = stringPreferencesKey("national_id")
    }

    suspend fun saveUserInfo(userInfo: UserInfo) {
        context.dataStore.edit { pref ->
            pref[IS_LOGGED_IN] = true
            pref[FIRST_NAME] = userInfo.firstName ?: ""
            pref[LAST_NAME] = userInfo.lastName
            pref[BIRTH_DATE] = userInfo.birthDate
            pref[NATIONAL_ID] = userInfo.nationalId
        }

    }

    fun getUserInfo() = context.dataStore.data.map { pref ->
        UserInfo(
            firstName = pref[FIRST_NAME] ?: "",
            lastName = pref[LAST_NAME] ?: "",
            birthDate = pref[BIRTH_DATE] ?: "",
            nationalId = pref[NATIONAL_ID] ?: "",
        )
    }

    suspend fun clearUserInfo() {
        context.dataStore.edit { pref ->
            pref[IS_LOGGED_IN] = false
        }
    }

    fun isLoggedIn() = context.dataStore.data.map { pref ->
        pref[IS_LOGGED_IN]
    }
}