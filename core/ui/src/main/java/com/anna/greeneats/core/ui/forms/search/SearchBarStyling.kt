package com.anna.greeneats.core.ui.forms.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.anna.greeneats.core.ui.R

/**
 * Add search bar styling
 * @return Modifier instance with search bar styling
 */
fun Modifier.greenEatsSearch(modifier: Modifier): Modifier{
  return this.then(
    modifier.fillMaxWidth()
  )
}

/**
 * Add search bar color scheme
 * @return Search bar color scheme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchColorScheme(): SearchBarColors {
  return SearchBarDefaults.colors(
    containerColor = MaterialTheme.colorScheme.surfaceVariant, // TO DO: Fix material colorscheme referencing default colors
    dividerColor = MaterialTheme.colorScheme.onSecondary,
    inputFieldColors = searchInputColorScheme()
  )
}

/**
 * Add search bar's input field color scheme
 * @return Search bar's input field color scheme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun searchInputColorScheme(): TextFieldColors {
  return SearchBarDefaults.inputFieldColors(
    focusedTextColor = MaterialTheme.colorScheme.onSecondary, // TO DO: Fix material colorscheme referencing default colors
    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
    focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
    focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
    cursorColor = MaterialTheme.colorScheme.primary,
    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurface,
    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface,
    disabledLeadingIconColor = MaterialTheme.colorScheme.inverseOnSurface,
    disabledPlaceholderColor = MaterialTheme.colorScheme.inverseOnSurface,
    disabledTrailingIconColor = MaterialTheme.colorScheme.inverseOnSurface
  )
}

/**
 * Search bar leading icon
 */
@Composable
fun SearchLeadingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.search_list),
    contentDescription = stringResource(id = R.string.search_list_icon))
}

/**
 * Search bar trailing icon
 */
@Composable
fun SearchTrailingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.search),
    contentDescription = stringResource(id = R.string.search_icon))
}