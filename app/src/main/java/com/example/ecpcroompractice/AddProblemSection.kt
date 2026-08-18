package com.example.ecpcroompractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddProblemSection(
    onAddClick: (String, String) -> Unit
) {
    var problemName by remember { mutableStateOf("") }
    var platform by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = problemName,
            onValueChange = { problemName = it },
            label = { Text("Problem Name (e.g., Watermelon)") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = platform,
            onValueChange = { platform = it },
            label = { Text("Platform (e.g., Codeforces)") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Button(
            onClick = {

                if (problemName.isNotBlank() && platform.isNotBlank()) {
                    onAddClick(problemName, platform)

                    problemName = ""
                    platform = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Problem")
        }
    }
}