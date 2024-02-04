package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.tematihonov.effectivemobiletest.presentation.app_components.BigEllipse
import com.tematihonov.effectivemobiletest.presentation.app_components.SmallEllipse

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPager(images: List<Int>, currentPage: Int, onPageChanged: (Int) -> Unit) {
    val pagerState = rememberPagerState(currentPage)

    LaunchedEffect(pagerState, currentPage) {
        if (pagerState.currentPage != currentPage) {
            pagerState.scrollToPage(currentPage)
            onPageChanged(pagerState.currentPage)
        }
    }

    HorizontalPager(
        state = pagerState,
        count = images.size,
        modifier = Modifier
            .fillMaxSize()
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp),
        )
    }

    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(pagerState.currentPage)
    }
}

@Composable
fun ViewPagerPagination(images: List<Int>, currentPage: Int) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(images.size) { index ->
                if (currentPage == index) {
                    BigEllipse(true)
                } else {
                    BigEllipse(false)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerSmall(images: List<Int>, currentPage: Int, onPageChanged: (Int) -> Unit) {
    val pagerState = rememberPagerState(currentPage)

    LaunchedEffect(pagerState, currentPage) {
        if (pagerState.currentPage != currentPage) {
            pagerState.scrollToPage(currentPage)
            onPageChanged(pagerState.currentPage)
        }
    }

    HorizontalPager(
        state = pagerState,
        count = images.size,
        modifier = Modifier
            .height(120.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
        )
    }

    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(pagerState.currentPage)
    }
}

@Composable
fun ViewPagerPaginationSmall(images: List<Int>, currentPage: Int) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(images.size) { index ->
                if (currentPage == index) {
                    SmallEllipse(true)
                } else {
                    SmallEllipse(false)
                }
            }
        }
    }
}



