## 2025-05-14 - Improving Detail View Responsiveness and Accessibility

**Learning:** When moving views from a `ConstraintLayout` to a `ScrollView`, ensure that the inner `ConstraintLayout` uses `wrap_content` for height. Also, be wary of `0dp` height settings in `ConstraintLayout` that rely on vertical constraints which might be lost or changed during refactoring, leading to invisible elements.

**Action:** Always verify that `layout_height` is set to `wrap_content` for elements inside a `ScrollView` and check for any `0dp` heights that lack sufficient constraints.

## 2025-05-14 - Paging Library Loading State Handling

**Learning:** Using `itemCount` to hide a loading indicator is unreliable and can lead to the indicator staying visible if the load fails or returns zero items. The correct way to handle initial load states with `PagingDataAdapter` is to use `addLoadStateListener` and check `loadState.refresh`.

**Action:** Use `loadState.refresh is LoadState.Loading` to accurately toggle loading indicators in Paging 3.
