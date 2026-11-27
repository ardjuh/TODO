package com.example.todo.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A task shown in the main list.
 *
 * @param groupId Internal grouping identifier. It is not displayed in the UI.
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
    ListItem(
        modifier = modifier
            .padding(24.dp)
            .clip(shape)
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                shape
            ),
        headlineContent = { Text(item.title) },
        supportingContent = item.description?.let { description ->
            { Text(description) }
        },
        colors = ListItemDefaults.colors(containerColor = Color.Blue),
        trailingContent = item.endDate?.let { endDate ->
            {
                Text(
                    text = endDate,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    )
}
