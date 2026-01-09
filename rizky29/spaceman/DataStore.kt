
package com.rizky29.spaceman
import android.content.Context
object DataStore {
    private const val PREF = "spaceman_data"
    private const val KEY = "multipliers"
    fun save(context: Context, data: List<Double>) {
        val sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        sp.edit().putString(KEY, data.joinToString(",")).apply()
    }
    fun load(context: Context): List<Double> {
        val raw = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .getString(KEY, "") ?: ""
        return if (raw.isEmpty()) emptyList() else raw.split(",").mapNotNull { it.toDoubleOrNull() }
    }
    fun clear(context: Context) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE).edit().clear().apply()
    }
}
