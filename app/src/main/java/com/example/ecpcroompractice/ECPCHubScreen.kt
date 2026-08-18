package com.example.ecpcroompractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ECPCHubScreen(
    problems: List<ProblemEntity>,
    onAddProblem: (String, String) -> Unit,
    onDeleteProblem: (ProblemEntity) -> Unit
) {
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Text(
                text = "ECPC Practice Hub",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            AddProblemSection(
                onAddClick = { name, platform ->
                    onAddProblem(name, platform)
                }
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(problems) { currentProblem ->
                    ProblemCard(
                        problem = currentProblem,
                        onDeleteClick = {
                            onDeleteProblem(currentProblem)
                        }
                    )
                }
            }
        }
    }
}