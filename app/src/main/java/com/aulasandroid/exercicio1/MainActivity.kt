package com.aulasandroid.exercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.exercicio1.ui.theme.Exercicio1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Exercicio1Theme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    var idade by remember {
        mutableStateOf(17)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF9F7FF))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é a sua idade?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4B61B8)
        )
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = idade.toString(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.size(20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {

                    if (idade > 0) {
                        idade--
                    }
                },

                modifier = Modifier.size(80.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4B61B8),
                    contentColor = Color.White
                )
            ) {

                Text(
                    text = "-",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = {

                    if (idade < 180) {
                        idade++
                    }
                },

                modifier = Modifier.size(80.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4B61B8),
                    contentColor = Color.White
                )
            ) {

                Text(
                    text = "+",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.size(25.dp)
        )

        if (idade < 18) {

            Text(
                text = "Você é MENOR de idade",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4B61B8)
            )

        } else {

            Text(
                text = "Você é MAIOR de idade",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4B61B8)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicComponentsScreenPreview() {
    Exercicio1Theme {
        BasicComponentsScreen()
    }
}