package com.example.withingstechnicaltest.ui.common

abstract class BaseUiMapper<DOMAIN, UI> {
    abstract fun toUi(domain: DOMAIN): UI
}