package com.aniwallshq.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val wallpapers by viewModel.wallpapers.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val listState = rememberLazyGridState()
    var isSearchVisible by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }

    val isAtEndOfList by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val visibleItemsInfo = layoutInfo.visibleItemsInfo
            if (layoutInfo.totalItemsCount == 0) {
                false
            } else {
                val lastVisibleItem = visibleItemsInfo.last()
                val viewportEndOffset = listState.layoutInfo.viewportEndOffset
                (lastVisibleItem.index + 1 == layoutInfo.totalItemsCount && lastVisibleItem.offset.y + lastVisibleItem.size.height <= viewportEndOffset)
            }
        }
    }

    LaunchedEffect(isAtEndOfList) {
        if (isAtEndOfList) {
            viewModel.fetchWallpapers()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimeWallsHQ") },
                actions = {
                    if (isSearchVisible) {
                        TextField(
                            value = searchQuery,
                            onValueChange = viewModel::onSearchQueryChanged,
                            placeholder = { Text("Search...") },
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                    }
                    IconButton(onClick = { isSearchVisible = !isSearchVisible }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("About") },
                            onClick = {
                                navController.navigate("about")
                                showMenu = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Settings") },
                            onClick = {
                                navController.navigate("settings")
                                showMenu = false
                            }
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            state = listState,
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(wallpapers, key = { it.messageId }) { wallpaper ->
                AsyncImage(
                    model = wallpaper.previewUrl,
                    contentDescription = wallpaper.animeName,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable {
                            navController.navigate("detail/${wallpaper.messageId}")
                        }
                )
            }
        }
    }
}
