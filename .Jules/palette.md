## 2026-01-24 - [ScrollView for Detail Views]
**Learning:** For mobile detail views with many data fields, a fixed-height container (like 60% of screen) can easily lead to content truncation on smaller screens. Always wrap such views in a `ScrollView` inside the primary container.
**Action:** Use a `ScrollView` and ensure the inner `ConstraintLayout` has `android:layout_height="wrap_content"`.

## 2026-01-24 - [Accessible Image Content Descriptions]
**Learning:** Screen readers need context for images. For item images, use a formatted string resource to include the item's name.
**Action:** Add a string resource like `Image of %s` and set `contentDescription` dynamically during data binding.
