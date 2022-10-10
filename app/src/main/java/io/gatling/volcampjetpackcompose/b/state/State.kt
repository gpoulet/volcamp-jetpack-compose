package io.gatling.volcampjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import io.gatling.volcampjetpackcompose.R
import io.gatling.volcampjetpackcompose.a.modifiers.Item
import io.gatling.volcampjetpackcompose.ui.theme.VolcampJetpackComposeTheme

@Composable
fun DroidCardWithState(
    title: String,
    subtitle: String = "",
    @DrawableRes image: Int
) {
    var quantity by rememberSaveable { mutableStateOf(0) }
//    var expanded by remember { mutableStateOf(false) }

    DroidCard(
        title,
        subtitle,
        image,
        quantity,
        increase = { quantity++ },
        decrease = { quantity-- })
}

@Composable
fun DroidCard(
    title: String,
    subtitle: String = "",
    @DrawableRes image: Int,
    quantity: Int = 0,
    increase: () -> Unit,
    decrease: () -> Unit
) {
    Item(
        title = title,
        subtitle = subtitle,
        image = image
    ) {
        Quantity(quantity = quantity, increase = increase, decrease = decrease)
    }

}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DroidCardWithStatePreview() {
    VolcampJetpackComposeTheme {
        DroidCardWithState(
            title = "R2D2",
            "Astromecano",
            R.drawable.r2d2
        )
    }
}