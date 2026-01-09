
package com.rizky29.spaceman
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.rizky29.spaceman.ui.DashboardScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var data by remember { mutableStateOf(DataStore.load(this)) }
            DashboardScreen(
                data = data,
                onAdd = {
                    data = data + it
                    DataStore.save(this, data)
                },
                onUndo = {
                    if (data.isNotEmpty()) {
                        data = data.dropLast(1)
                        DataStore.save(this, data)
                    }
                },
                onClear = {
                    data = emptyList()
                    DataStore.clear(this)
                }
            )
        }
    }
}
