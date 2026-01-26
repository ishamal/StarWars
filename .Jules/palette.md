PALETTE'S JOURNAL - CRITICAL LEARNINGS ONLY:

## 2024-07-22 - Improved Loading UX with PagingDataAdapter
**Learning:** When using `PagingDataAdapter`, the correct way to show a loading indicator for the initial load is to use `addLoadStateListener` and check if `loadState.refresh` is an instance of `androidx.paging.LoadState.Loading`. Simply checking `itemCount > 0` is not sufficient as it doesn't handle subsequent refreshes correctly.
**Action:** Always use the `loadState` to determine the visibility of loading indicators in lists that use `PagingDataAdapter`.
