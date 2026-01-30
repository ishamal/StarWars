## 2025-05-14 - [Planet image accessibility]
**Learning:** Accessibility (a11y) in Android can be easily improved by adding `contentDescription` to images. In list/detail patterns, using dynamic data (like the planet name) for these descriptions provides much better context for screen reader users than generic placeholders.
**Action:** Always check for missing `contentDescription` on informative images and prefer dynamic, descriptive values over static ones.
