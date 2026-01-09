
package com.rizky29.spaceman
object StatsCalculator {
    fun avg(data: List<Double>) = if (data.isEmpty()) 0.0 else data.sum() / data.size
    fun lowRate(data: List<Double>) = if (data.isEmpty()) 0 else data.count { it < 2 } * 100 / data.size
    fun lowStreak(data: List<Double>): Int {
        var s = 0
        for (i in data.indices.reversed()) {
            if (data[i] < 2) s++ else break
        }
        return s
    }
}
