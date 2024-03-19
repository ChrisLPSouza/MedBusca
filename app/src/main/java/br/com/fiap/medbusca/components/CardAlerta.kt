package br.com.fiap.medbusca.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardAlerta(textCard: String) {
    Card(
        modifier = Modifier
            .height(110.dp)
            .width(170.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = textCard,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}