## 2025-05-15 - Improving Detail View Accessibility and Robustness
**Learning:** In Android applications, detail views with multiple fields are prone to content truncation on smaller screens or when users increase their system font size. Additionally, image-heavy lists lack context for screen reader users without descriptive content descriptions.
**Action:** Always wrap multi-field detail layouts in a `ScrollView` and ensure every informative image has a `contentDescription` that includes dynamic data (like an item name) to provide context.
