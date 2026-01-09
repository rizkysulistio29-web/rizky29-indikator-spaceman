
package com.rizky29.spaceman.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun HeatmapView(data: List<Double>) {
    val recent = data.takeLast(25)
    Column {
        Text("Heatmap (Last 25)")
        Spacer(Modifier.height(8.dp))
        recent.chunked(5).forEach { row ->
            Row {
                row.forEach {
                    Box(Modifier.size(24.dp).background(
                        when {
                            it < 2 -> Color.Red
                            it <= 5 -> Color.Yellow
                            else -> Color.Green
                        }
                    ))
                    Spacer(Modifier.width(4.dp))
                }
            }
            Spacer(Modifier.height(4.dp))
        }
    }
}
