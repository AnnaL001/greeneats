package com.anna.greeneats.core.ui.forms.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreenEatsSearchBar(
  queryState: MutableState<String>,
  activeState: MutableState<Boolean>,
  placeholder: String,
  modifier: Modifier = Modifier,
  content: @Composable (() -> Unit)
){
  SearchBar(
    query = queryState.value,
    modifier = Modifier.greenEatsSearch(modifier),
    onQueryChange = { newValue ->
      queryState.value = newValue
    },
    onSearch = { activeState.value = false } ,
    active = activeState.value,
    onActiveChange = { newActiveValue ->
      activeState.value = newActiveValue
    },
    colors = searchColorScheme(),
    placeholder = { Text(text = placeholder) },
    leadingIcon = { SearchLeadingIcon() },
    trailingIcon = { SearchTrailingIcon() }
    ) {
    content()
  }
}


