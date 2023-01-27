package com.kuluruvineeth.expensetracker.presentation.setting_screen.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kuluruvineeth.expensetracker.R
import com.kuluruvineeth.expensetracker.common.Constants
import com.kuluruvineeth.expensetracker.util.spacing

@Composable
fun PrivacySetting() {
    val context = LocalContext.current
    TextButton(
        onClick = {
            val privacyIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.PRIVACY_URL))
            context.startActivity(privacyIntent)
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.small
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.DarkGray.copy(alpha = 0.1f),
            contentColor = MaterialTheme.colors.onSurface
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.medium,
            vertical = 20.dp
        )
    ) {
        Text(
            text = "Privacy Policy",
            style = MaterialTheme.typography.button,
            modifier = Modifier.weight(2f),
            textAlign = TextAlign.Start
        )

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Icon(
                painter = painterResource(R.drawable.edit),
                contentDescription = null,
                modifier = Modifier.then(Modifier.size(16.dp))
            )
        }
    }
}