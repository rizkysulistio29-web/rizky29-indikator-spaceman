
package com.rizky29.spaceman.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rizky29.spaceman.StatsCalculator
@Composable
fun DashboardScreen(
    data: List<Double>,
    onAdd: (Double) -> Unit,
    onUndo: () -> Unit,
    onClear: () -> Unit
) {
    Column(Modifier.padding(16.dp)) {
        Text("AVG: ${"%.2f".format(StatsCalculator.avg(data))}x")
        Text("Low Rate: ${StatsCalculator.lowRate(data)}%")
        Text("Low Streak: ${StatsCalculator.lowStreak(data)}")
        Spacer(Modifier.height(12.dp))
        InputPanel(onAdd)
        Spacer(Modifier.height(8.dp))
        Row {
            Button(onClick = onUndo, modifier = Modifier.weight(1f)) { Text("UNDO") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = onClear, modifier = Modifier.weight(1f)) { Text("CLEAR") }
        }
        Spacer(Modifier.height(16.dp))
        ChartView(data)
        Spacer(Modifier.height(16.dp))
        HeatmapView(data)
    }
}
