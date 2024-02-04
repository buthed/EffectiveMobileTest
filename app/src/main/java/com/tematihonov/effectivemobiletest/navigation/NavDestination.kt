package com.tematihonov.effectivemobiletest.navigation

import com.tematihonov.effectivemobiletest.R

sealed class Screen(val name: Int, val route: String, val icon: Int) {
    object Main : Screen(name = R.string.nav_main, route = "main", icon = R.drawable.icon_home)
    object Catalog : Screen(name = R.string.nav_catalog, route = "catalog", icon = R.drawable.icon_catalog)
    object Basket : Screen(name = R.string.nav_basket, route = "basket", icon = R.drawable.icon_bag)
    object Promotions : Screen(    name = R.string.nav_promotions, route = "promotions", icon = R.drawable.icon_discount)
    object Profile : Screen(name = R.string.nav_profile, route = "profile", icon = R.drawable.icon_account)
}
