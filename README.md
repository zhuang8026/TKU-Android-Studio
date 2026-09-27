# N214410101 - Android 課程專案

淡江大學 資訊工程學系 Android 程式設計課程作業

---

## 專案說明

這是一個 Android 入門練習專案，實作基本的表單介面，包含：

- 姓名、電話、郵件的輸入欄位（EditText）
- 確定、離開按鈕
- 顯示文字大小放大 / 縮小功能
- 支援繁體中文（zh-TW）與日文（ja-JP）多語系

## 開發環境

| 項目 | 版本 |
|------|------|
| 語言 | Java 11 |
| compileSdk | 36 |
| minSdk | 26 (Android 8.0) |
| targetSdk | 36 |
| IDE | Android Studio |

## 專案結構

```
app/src/main/
├── java/com/example/n214410101_tku/
│   └── MainActivity.java      # 主畫面邏輯
└── res/
    ├── layout/
    │   └── activity_main.xml  # 主畫面佈局
    └── values/
        ├── strings.xml        # 英文字串
        ├── values-zh-rTW/     # 繁體中文字串
        └── values-ja-rJP/     # 日文字串
```

## 功能介紹

- **輸入表單**：提供姓名、電話、郵件三個輸入欄位
- **放大 / 縮小**：調整結果文字大小（範圍 12–35）
- **離開**：關閉 App

## 學生資訊

- 學號：N214410101
- 系所：淡江大學 資訊工程學系
