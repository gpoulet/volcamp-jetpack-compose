package io.gatling.volcampjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import io.gatling.volcampjetpackcompose.c.viewmodel.DroidViewModel
import io.gatling.volcampjetpackcompose.ui.theme.VolcampJetpackComposeTheme

@Composable
fun AppViewModel(droidViewModel: DroidViewModel = DroidViewModel()) {
    val droids by droidViewModel.droids.observeAsState(listOf())
    LazyColumn {
        items(droids) { droid ->
            DroidCard(
                title = droid.title,
                subtitle = droid.subtitle,
                image = droid.image,
                quantity = droid.quantity,
                increase = {
                    droidViewModel.increase(droid.id)
                },
                decrease = {
                    droidViewModel.decrease(droid.id)
                })
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppViewModelPreview() {
    VolcampJetpackComposeTheme {
        AppViewModel()
    }
}