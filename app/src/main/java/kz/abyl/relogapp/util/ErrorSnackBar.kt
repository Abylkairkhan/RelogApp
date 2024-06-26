package kz.abyl.relogapp.util

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kz.abyl.relogapp.R

@Composable
fun ErrorSnackBar(
    message: String,
) {
    Snackbar(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.warning_icon),
                tint = MaterialTheme.colorScheme.error,
                contentDescription = "warning_icon"
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}