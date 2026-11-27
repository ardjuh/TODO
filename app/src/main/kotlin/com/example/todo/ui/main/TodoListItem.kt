package com.example.todo.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.ui.draw.clip
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.prettyTeal
import com.google.android.material.color.MaterialColors


@Composable
private fun generatedColorRoles(seedColor: Color) =
    MaterialColors.getColorRoles(seedColor.toArgb(), !isSystemInDarkTheme())

/**
 * A task shown in the main list.
 *
 * @param groupId Group identifier shown in a badge.
 */
data class TodoListItem(
    val title: String,
    val description: String? = null,
    val endDate: String? = null,
    val groupId: String
)

@Composable
internal fun TodoListItemRow(
    item: TodoListItem,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)
    val colorRoles = generatedColorRoles(prettyTeal)
    val accentContainer = Color(colorRoles.accentContainer)
    val onAccentContainer = Color(colorRoles.onAccentContainer)
    ListItem(
        modifier = modifier
            .padding(24.dp)
            .clip(shape)
            .border(
                BorderStroke(1.dp, onAccentContainer),
                shape
            ),
        headlineContent = { Text(item.title) },
        supportingContent = {
            Column {
                item.endDate?.let { endDate ->
                    Text(
                        text = endDate,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
                item.description?.let { description ->
                    Text(description)
                }
            }
        },
        colors = ListItemDefaults.colors(
            containerColor = accentContainer,
            headlineColor = onAccentContainer,
            supportingColor = onAccentContainer
        ),
        trailingContent = {
            Badge(
                containerColor = Color(colorRoles.accent),
                contentColor = Color(colorRoles.onAccent)
            ) {
                Text(
                    text = item.groupId,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    )
}
