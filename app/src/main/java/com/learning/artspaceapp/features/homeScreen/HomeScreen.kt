package com.learning.artspaceapp.features.homeScreen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.learning.artspaceapp.features.homeScreen.controller.HomeScreenController

class HomeScreen : ComponentActivity() {

    @Composable
    fun HomeScreenApp(
        modifier: Modifier = Modifier,
        viewModel: HomeScreenController = viewModel()
    ) {
        val imagesShow by viewModel.imagesResult.collectAsState()
        val titleShow by viewModel.titleResult.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .padding(20.dp)
                        .shadow(
                            7.dp,
                            shape = RoundedCornerShape(8.dp),
                            ambientColor = Color.LightGray
                        ),

                    ) {
                    Image(
                        painter = painterResource(imagesShow),
                        contentDescription = "",
                        modifier = Modifier.padding(50.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = modifier.background(
                        color = Color.LightGray,
                        RoundedCornerShape(5.dp),
                    ),
                ) {
                    Text(text = titleShow, modifier = modifier.padding(20.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
            Box(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .size(200.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            viewModel.previousPage()
                        },
                    ) {
                        Text(text = "Previous")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = {
                            viewModel.nextPages()
                        }
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}