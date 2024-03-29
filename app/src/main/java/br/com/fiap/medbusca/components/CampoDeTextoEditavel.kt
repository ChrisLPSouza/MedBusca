package br.com.fiap.medbusca.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CampoDeTextoEditavel(
    label: String,
    value: String,
    placeHolder: String,
    atualizarTexto: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = atualizarTexto,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        modifier = Modifier
            .padding(top = 2.dp, start = 8.dp, end = 8.dp, bottom = 2.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

}

