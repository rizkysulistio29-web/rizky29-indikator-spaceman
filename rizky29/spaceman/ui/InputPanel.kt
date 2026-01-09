
package com.rizky29.spaceman.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun InputPanel(onAdd: (Double) -> Unit) {
    var value by remember { mutableStateOf("") }
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(value = value, onValueChange = { value = it }, label = { Text("Multiplier") }, modifier = Modifier.weight(1f))
        Button(onClick = {
            value.toDoubleOrNull()?.let {
                onAdd(it); value = ""
            }
        }) { Text("ADD") }
    }
}
