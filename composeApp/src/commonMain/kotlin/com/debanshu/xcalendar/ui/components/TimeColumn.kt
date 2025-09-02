package com.debanshu.xcalendar.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.debanshu.xcalendar.common.customBorder
import com.debanshu.xcalendar.common.formatHour

/**
 * A reusable time column component that displays hour labels.
 *
 * @param modifier The modifier to be applied to the column
 * @param timeRange The range of hours to display (e.g., 0..23)
 * @param hourHeightDp The height of each hour cell in dp
 * @param scrollState The scroll state to synchronize scrolling with other components
 */
@Composable
fun TimeColumn(
    modifier: Modifier = Modifier,
    timeRange: IntRange = 0..23,
    hourHeightDp: Float = 60f,
    scrollState: ScrollState
) {
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        timeRange.forEach { hour ->
            TimeCell(
                hour = hour,
                hourHeightDp = hourHeightDp
            )
        }
    }
}

/**
 * A single time cell that displays an hour label.
 *
 * @param hour The hour to display (0-23)
 * @param hourHeightDp The height of the cell in dp
 */
@Composable
private fun TimeCell(
    hour: Int,
    hourHeightDp: Float
) {
    Box(
        modifier = Modifier
            .height(hourHeightDp.dp)
            .fillMaxWidth()
            .customBorder(
                thickness = 0.5.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f)
            )
            .padding(end = 16.dp)
    ) {
        Text(
            text = formatHour(hour),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 8.dp)
        )
    }
}