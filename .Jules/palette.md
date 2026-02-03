## 2024-05-22 - [Layout Accessibility & Responsiveness]
**Learning:** In complex detail screens with many fields, a fixed-height container can lead to content truncation. Wrapping the content in a ScrollView is essential for accessibility (large fonts) and smaller screens. Additionally, when switching to a ScrollView context, ensure any views that previously relied on vertical constraints for height (using `0dp`) are changed to `wrap_content`.
**Action:** Always check for `ScrollView` on detail pages and verify view heights (avoid `0dp` without proper vertical constraints in a scrolling context).

## 2024-05-22 - [Image Accessibility Pattern]
**Learning:** This app uses a consistent pattern for image accessibility by setting `contentDescription` dynamically using a formatted string resource that includes the item's name.
**Action:** When adding images, use `getString(R.string.planet_image_content_description, name)` and ensure the corresponding resource exists in `strings.xml`.
