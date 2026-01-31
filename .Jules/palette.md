## 2025-05-14 - Accessibility and Scrollable Detail Layouts
**Learning:** In data-rich detail screens, fixed height containers (like CardViews with `layout_height_percent`) can easily clip content when users have large accessibility fonts enabled or use smaller devices. Additionally, images often lack content descriptions, hindering screen reader users.
**Action:** Always wrap multi-field detail content in a `ScrollView` and provide dynamic `contentDescription` for informative images using string templates.
