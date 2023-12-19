package com.gonzalo.myapplication.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gonzalo.myapplication.R
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.rememberScaffoldState
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalo.myapplication.domain.model.Characters
import com.gonzalo.myapplication.ui.home.components.CharacterItem
import com.gonzalo.myapplication.ui.theme.Dimen160dp
import com.gonzalo.myapplication.ui.theme.Dimen16dp
import com.gonzalo.myapplication.ui.theme.Dimen48dp
import com.gonzalo.myapplication.ui.theme.Dimen4dp
import com.gonzalo.myapplication.ui.theme.Magenta
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    onItemClicked: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when (event) {
                is HomeViewModel.UIEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopBar()
        },
        bottomBar = {
            HomeBottomBar(
                showPrevious = state.showPrevious,
                showNext = state.showNext,
                onPreviousPressed = { viewModel.getCharacters(false) },
                onNextPressed = { viewModel.getCharacters(true) }
            )
        }
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onItemClicked = { onItemClicked(it) },
            isLoading = state.isLoading,
            characters = state.characters
        )
    }
}

@Composable
private fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home_title),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                color = Color.White
            )
        },
        backgroundColor = Magenta
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
    isLoading: Boolean = false,
    characters: List<Characters> = emptyList(),
) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {

        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Adaptive(Dimen160dp),
            contentPadding = PaddingValues(bottom = Dimen16dp),
            content = {
                items(characters.size) { index ->
                    CharacterItem(
                        modifier = Modifier.fillMaxWidth(),
                        item = characters[index],
                        onItemClicked = { onItemClicked(it) }
                    )
                }
            }


        )
        if (isLoading) FullScreenLoading()
    }
}

@Composable
private fun HomeBottomBar(
    showPrevious: Boolean,
    showNext: Boolean,
    onPreviousPressed: () -> Unit,
    onNextPressed: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimen4dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            IconButton(
                onClick = { onPreviousPressed.invoke() },
                enabled = showPrevious,
                modifier = Modifier
                    .weight(1f)
            ) {
                Icon(
                    Icons.Filled.ArrowLeft, contentDescription = "Back", modifier = Modifier.size(Dimen48dp),)
            }

            IconButton(onClick = { onNextPressed.invoke() },
                enabled = showNext,
                modifier = Modifier
                    .weight(1f)) {
                Icon(
                    Icons.Filled.ArrowRight, contentDescription = "Back", modifier = Modifier.size(Dimen48dp),)
            }

        }
    }
}

@Composable
private fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}


