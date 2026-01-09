
package com.rizky29.spaceman.ui
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun ChartView(data: List<Double>) {
    val low = data.count { it < 2 }
    val mid = data.count { it in 2.0..5.0 }
    val high = data.count { it > 5 }
    val max = listOf(low, mid, high).maxOrNull()?.coerceAtLeast(1) ?: 1
    Canvas(Modifier.fillMaxWidth().height(120.dp)) {
        val bar = size.width / 5
        drawRect(Color.Red, size = androidx.compose.ui.geometry.Size(bar, size.height * (low.toFloat() / max)))
        drawRect(Color.Yellow, topLeft = androidx.compose.ui.geometry.Offset(bar * 2, 0f),
            size = androidx.compose.ui.geometry.Size(bar, size.height * (mid.toFloat() / max)))
        drawRect(Color.Green, topLeft = androidx.compose.ui.geometry.Offset(bar * 4, 0f),
            size = androidx.compose.ui.geometry.Size(bar, size.height * (high.toFloat() / max)))
    }
}
