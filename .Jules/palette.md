## 2025-05-14 - Scrolling Layout Accessibility
**Learning:** When moving TextViews from a fixed-height ConstraintLayout to a ScrollView context, ensure `android:layout_height` is changed from `0dp` to `wrap_content` to prevent the views from having zero height in the scrolling container.
**Action:** Always check for `0dp` height constraints when wrapping layouts in a ScrollView.
