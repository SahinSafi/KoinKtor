package com.safi.koinktor.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.safi.koinktor.core.model.entity.UserEntity
import com.safi.koinktor.ui.customui.NetworkError
import com.safi.koinktor.ui.customui.NetworkImage
import com.safi.koinktor.ui.theme.KoinKtorTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            KoinKtorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text(text = "Koin Ktor") })
                    }
                ) { innerPadding ->

                    val viewModel: MainViewModel by viewModel()
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                    LaunchedEffect(true) {
                        viewModel.loadItems()
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())
                    ) {
                        when(uiState) {
                            is MainUiState.Success -> {
                                LazyColumn(
                                    content = {
                                        items((uiState as MainUiState.Success).data.size) {
                                            UserItem((uiState as MainUiState.Success).data[it])
                                        }
                                    }
                                )
                            }
                            is MainUiState.Loading -> {
                                CircularProgressIndicator()
                            }
                            is MainUiState.Error -> {
                                NetworkError(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                    title = "Network Error",
                                    message = (uiState as MainUiState.Error).message,
                                    retry = {
                                        viewModel.loadItems()
                                    }
                                )
                            }
                        }
                    }



                }
            }
        }
    }
}

@Composable
fun UserItem(user: UserEntity) {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        NetworkImage(
            modifier = Modifier.size(50.dp),
            url = user.avatar_url,
            contentScale = ContentScale.Crop
        )
        Text(
            text = user.description,
            modifier = Modifier
        )
    }
}
